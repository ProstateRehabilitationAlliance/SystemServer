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

    @RequestMapping("/login")
    public String toLogin(){
        return "/login";
    }

    @RequestMapping("/loginOK")
    public String toIndex(){
        return "index";
    }



    //正在服用药品列表
    @RequestMapping("/anamnesis_eating_drug_list")
    public String toEatingDrugList(){
        return "/anamnesisEatingDrug/anamnesis_eating_drug_list";
    }

    //新增正在服用药品
    @RequestMapping("/anamnesis_eating_drug_add")
    public String addEatingDrugList(){
        return "/anamnesisEatingDrug/anamnesis_eating_drug_add";
    }
    //anamnesis_eating_drug_edit

    //修改正在服用药品
    @RequestMapping("/anamnesis_eating_drug_edit")
    public String deleteEatingDrugList(){
        return "/anamnesisEatingDrug/anamnesis_eating_drug_edit";
    }




}
