package com.prostate.base.controller;

import java.util.List;
import java.util.Map;

import com.prostate.base.service.BranchService;
import com.prostate.base.service.DoctorTitleService;
import com.prostate.base.service.HospitalService;
import com.prostate.base.util.HttpUtil;
import com.prostate.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prostate.base.domain.DoctorSignDO;
import com.prostate.base.service.DoctorSignService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 医生认证信息表
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-07 10:26:55
 */

@Controller
@RequestMapping("/base/doctorSign")
public class DoctorSignController {
	@Autowired
	private DoctorSignService signService;


	@Autowired
	private DoctorTitleService doctorTitleService;   //职称信息

	@Autowired
	private HospitalService hospitalService;   //医院信息

	@Autowired
	private BranchService branchService;   //科室信息



	@GetMapping()
	@RequiresPermissions("base:doctorSign:doctorSign")
	String Sign(){
	    return "base/doctorSign/doctorSign";
	}


	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:doctorSign:doctorSign")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//此处查询的都是未处理的订单信息
		//查询列表数据
        Query query = new Query(params);
		List<DoctorSignDO> signList = signService.list(query);
		for (DoctorSignDO doctorSignDO: signList) {   //=================================可能会报空指针
//			//此处还应该查询查询医生信息
			doctorSignDO.setDoctorId("医生姓名+"+doctorSignDO.getDoctorId());
			//查询职称信息
			doctorSignDO.setTitleId(doctorTitleService.get(doctorSignDO.getTitleId()).getDoctorTitleName());
			//查询医院信息
			doctorSignDO.setHospitalId(hospitalService.get(doctorSignDO.getHospitalId()).getHospitalName());
			//查询科室信息
			doctorSignDO.setBranchId(branchService.get(doctorSignDO.getBranchId()).getBranchName());

		}
		int total = signService.count(query);
		PageUtils pageUtils = new PageUtils(signList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("base:doctorSign:add")
	String add(){
	    return "base/doctorSign/add";
	}



	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:doctorSign:edit")
	String edit(@PathVariable("id") String id,Model model){
		DoctorSignDO sign = signService.get(id);
		model.addAttribute("doctorSign", sign);
	    return "base/doctorSign/edit";
	}


	@GetMapping("/details/{id}")
	@RequiresPermissions("base:doctorSign:details")
	String details(@PathVariable("id") String id,Model model){

		DoctorSignDO doctorSignDO = signService.get(id);
		if (doctorSignDO.getApproveStatus().equalsIgnoreCase("2")){
			doctorSignDO.setApproveStatus("认证中");
		}
		model.addAttribute("doctorSign", doctorSignDO);
		model.addAttribute("doctorId","此处显示医生姓名");
		model.addAttribute("hospitalId",hospitalService.get(doctorSignDO.getHospitalId()).getHospitalName());
		model.addAttribute("branchId",branchService.get(doctorSignDO.getBranchId()).getBranchName());
		model.addAttribute("titleId",doctorTitleService.get(doctorSignDO.getTitleId()).getDoctorTitleName());
		return "base/doctorSign/details";
	}



	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:doctorSign:add")
	public R save( DoctorSignDO sign){
		if(signService.save(sign)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 *@Author:      ykbian
	 *@date_time:   2018/8/7 13:24
	 *@Description:  认证成功，改状态码，发送短信
	 *@param:
	*/
	@ResponseBody
	@RequestMapping("/pass")
	@RequiresPermissions("base:doctorSign:edit")
	public R pass( DoctorSignDO sign,String token){

		//获取当前用户的token信息
		String userToken = ShiroUtils.getUserId().toString();

		sign.setApproveStatus("1");
		sign.setUpdateUser(userToken);
		signService.update(sign);
//			暂时先不发送短信
//			String url = "http://192.168.0.222:8806/sms/sendProveSuccess";
//			//获取医生电话信息=============================？doctorservice
//			String phoneNumber = "17777835985";
			//HttpUtil.sendSMS(phoneNumber,url);
			return R.ok();

	}



	/**
	 *@Author:      ykbian
	 *@date_time:   2018/8/7 13:51
	 *@Description:   拒绝医生认证信息
	 *@param:
	*/
	@ResponseBody
	@RequestMapping("/refuse")
	@RequiresPermissions("base:doctorSign:edit")
	public R refuse( DoctorSignDO sign,String token){
		//获取当前用户的token信息
		String userToken = ShiroUtils.getUserId().toString();
		sign.setUpdateUser(userToken);
		sign.setApproveStatus("0");
		if (signService.update(sign) > 0){
			return R.ok();
		}else {
			return R.error(20001,"操作失败");
		}
//			暂时先不发送短信
//			String url = "http://192.168.0.222:8806/sms/sendProveSuccess";
//			//获取医生电话信息=============================？doctorservice
//			String phoneNumber = "17777835985";
			//HttpUtil.sendSMS(phoneNumber,url);



	}


	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:doctorSign:remove")
	public R remove( String id){
		if(signService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:doctorSign:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		signService.batchRemove(ids);
		return R.ok();
	}

}
