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
    @RequestMapping("/haha")
    public String test(){
        return "index";
    }
}
