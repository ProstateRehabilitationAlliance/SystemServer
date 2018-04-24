package com.prostate.system.shiro;

import com.prostate.system.entity.User;
import com.prostate.system.entity.UserRole;
import com.prostate.system.service.PermissionService;
import com.prostate.system.service.RoleService;
import com.prostate.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by lenovo on  三月
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    /**
     * 提供用户信息，返回权限信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("---------------------------->授权认证：");
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        String userName=(String) principals.getPrimaryPrincipal();
        String userId=userService.findUserIdByName(userName).get(0);
        List<UserRole> roleIdSet=userService.findRoleIdByUid( userId);

        //服务类传递的是list集合,但是此处为set集合,
        List<String>  roleSet=new ArrayList<String>();
        Set<String>  roleSetResult=new HashSet<>(roleSet);

        Set<String>  pemissionSet=new HashSet<>();
        List<String>  pemissionIdSet=new ArrayList<>();

        for(UserRole roleInfo : roleIdSet) {
              String roleId=roleInfo.getRoleId();

               roleSet.add( roleService.findRoleByRoleId( roleId  ) );
               //将拥有角色的所有权限放进Set里面，也就是求Set集合的并集
               //由于我这边的数据表设计得不太好，所以提取set集合比较麻烦

            //数据库中的roleId是string,但是此处需要一个integer类型的集合,
              pemissionIdSet.addAll( roleService.findPermissionIdByRoleId(  roleId ));
        }
        for(String permissionId : pemissionIdSet) {
            String permission= permissionService.findPermissionById(permissionId).getPermissionName() ;
            pemissionSet.add(  permission );
        }
         // 将角色名称组成的Set提供给授权info
        authorizationInfo.setRoles( roleSetResult );
        // 将权限名称组成的Set提供给info
        authorizationInfo.setStringPermissions(pemissionSet);

        return authorizationInfo;
    }

    /**
     * 提供帐户信息，返回认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("---------------------------->登陆验证:");
        String userName=(String)authenticationToken.getPrincipal();
        User user=userService.findUserWihtUserName(userName).get(0);
        if(user==null) {
            //用户不存在就抛出异常
            throw new UnknownAccountException();
        }
//        if( State.LOCKED.equals( user.getState() )  ) {
//           //用户被锁定就抛异常
//           throw new  LockedAccountException();
//        }
        //密码可以通过SimpleHash加密，然后保存进数据库。
        //此处是获取数据库内的账号、密码、盐值，保存到登陆信息info中
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()+user.getSalt())   ,
                getName());                   //realm name

        return authenticationInfo;
    }
}