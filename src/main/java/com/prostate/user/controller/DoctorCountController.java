package com.prostate.user.controller;

import com.prostate.user.service.ClickCountDoctorService;
import com.prostate.user.service.FocusCountDoctorService;
import com.prostate.user.service.InquriyCountDoctorService;
import com.prostate.user.vo.CountDoctorVO;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/8/10 16:23
 * @Todo:   医生数据统计
 */
@Controller
@RequestMapping("/user/countDoctor")
public class DoctorCountController {

    /**
     * 问诊服务
     */
    @Autowired
    private InquriyCountDoctorService inquriyCountDoctorService;

    /**
     * 关注服务
     */
    @Autowired
    private FocusCountDoctorService focusCountDoctorService;


    /**
     * 点击服务
     */
    @Autowired
    private ClickCountDoctorService clickCountDoctorService;
    @GetMapping()
    @RequiresPermissions("user:countDoctor:countDoctor")
    String CountDoctor(){
        return "user/countDoctor/countDoctor";
    }


    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("user:countDoctor:countDoctor")
    public PageUtils list(@RequestParam Map<String, Object> params){
                Query query = new Query(params);
        List<CountDoctorVO> countDoctorList = new ArrayList<>();
        int total = 10;   //=================================================total应该是所有的医生人数

        /**
         * 医生id怎么获取？
         */

        String doctorId = "1fa034c2955a11e8a09b68cc6e5c9c77";
        CountDoctorVO countDoctorVO01 = new CountDoctorVO();
        countDoctorVO01.setClickCount(clickCountDoctorService.countByDoctorId(doctorId));
        countDoctorVO01.setFocusCount(focusCountDoctorService.countByDoctorId(doctorId));
        countDoctorVO01.setInquriyCount(inquriyCountDoctorService.countByDoctorId(doctorId));
        countDoctorVO01.setDoctorName("刘德华");
        countDoctorVO01.setDoctorId(doctorId);
        countDoctorList.add(countDoctorVO01);
        PageUtils pageUtils = new PageUtils(countDoctorList, total);

        return pageUtils;

    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/8/10 16:50
     *@Description:  查看医生数据详情=============默认显示一周数据
     *@param:
    */
    @GetMapping("/details/{doctorId}")
    @RequiresPermissions("user:countDoctor:details")
    String edit(@PathVariable("doctorId") String doctorId, Model model){
        System.out.println("=====================显示这个医生本周的数据信息========================");
        System.out.println("==============当前医生id"+doctorId);
        /**
         * 此处分别获取本周的三种统计数据
         */
        int click = clickCountDoctorService.countThisWeek(doctorId);
        int focus = focusCountDoctorService.countThisWeek(doctorId);
        int inquriy = inquriyCountDoctorService.countThisWeek(doctorId);
       // ClickCountDoctorDO clickCountDoctor = clickCountDoctorService.get(doctorId);
       // model.addAttribute("countDoctor", countDoctor);
        return "user/countDoctor/details";
    }
}
