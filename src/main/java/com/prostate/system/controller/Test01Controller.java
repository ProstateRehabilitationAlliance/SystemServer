package com.prostate.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 13:15 2018/4/26
 */
@Controller

public class Test01Controller {
    @RequestMapping("/index01")
    public String test(){
        return "index";
    }

    @RequestMapping("/login")
    public String test04(){
        return "/city/cityList";
    }
    @RequestMapping("/anamnesis-type-list")
    public String test01(){
        return "/anamnesistype/anamnesis-type-list";
    }
    @RequestMapping("/anamnesis-type-add")
    public String test02(){
        return "/anamnesistype/anamnesis-type-add";
    }
    @RequestMapping("anamnesis-type-edit")
    public String test03(){
        return "/anamnesistype/anamnesis-type-edit";
    }





}
