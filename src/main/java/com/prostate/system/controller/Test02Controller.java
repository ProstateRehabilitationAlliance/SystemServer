package com.prostate.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 13:43 2018/5/3
 */
@Controller
public class Test02Controller {

    @RequestMapping("/anamnesis-allergy-drug-list")
    public String test01(){
        return "/anamnesis-allergy-drug/anamnesis-allergy-drug-list";
    }
    @RequestMapping("/anamnesis-allergy-drug-add")
    public String test02(){
        return "/anamnesis-allergy-drug/anamnesis-allergy-drug-add";
    }
    @RequestMapping("/anamnesis-allergy-drug-edit")
    public String test03(){
        return "/anamnesis-allergy-drug/anamnesis-allergy-drug-edit";
    }

    @RequestMapping("/citylist")
    public String test04(){
        return "/city/cityList";
    }
    @RequestMapping("/anamnesis-type-list")
    public String test05(){
        return "/anamnesistype/anamnesis-type-list";
    }
    @RequestMapping("/anamnesis-type-add")
    public String test06(){
        return "/anamnesistype/anamnesis-type-add";
    }
    @RequestMapping("anamnesis-type-edit")
    public String test07(){
        return "/anamnesistype/anamnesis-type-edit";
    }


}