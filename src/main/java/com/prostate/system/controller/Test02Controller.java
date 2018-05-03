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
    public String anamnesisAllergyDrugList(){
        return "/anamnesis-allergy-drug/anamnesis-allergy-drug-list";
    }
    @RequestMapping("/anamnesis-allergy-drug-add")
    public String anamnesisAllergyDrugAdd(){
        return "/anamnesis-allergy-drug/anamnesis-allergy-drug-add";
    }
    @RequestMapping("/anamnesis-allergy-drug-edit")
    public String anamnesisAllergyDrugEdit(){
        return "/anamnesis-allergy-drug/anamnesis-allergy-drug-edit";
    }

    @RequestMapping("/citylist")
    public String cityList(){
        return "/city/cityList";
    }
    @RequestMapping("/anamnesis-type-list")
    public String anamnesisTypeList(){
        return "/anamnesistype/anamnesis-type-list";
    }
    @RequestMapping("/anamnesis-type-add")
    public String anamnesisTypeAdd(){
        return "/anamnesistype/anamnesis-type-add";
    }
    @RequestMapping("anamnesis-type-edit")
    public String anamnesisTypeEdit(){
        return "/anamnesistype/anamnesis-type-edit";
    }


}
