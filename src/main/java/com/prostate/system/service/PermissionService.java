package com.prostate.system.service;

import com.prostate.system.entity.Permission;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: bianyakun
 * @Date: 2018/4/20 14:31
 * @Todo:   权限的服务接口
 */

@Transactional
@Service
public interface PermissionService extends  BaseService<Permission>{

    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 14:13
     * @todo:  根据权限id查询相应的权限
     * @param:   * @param null
     */
    Permission findPermissionById(String permissionId);
}
