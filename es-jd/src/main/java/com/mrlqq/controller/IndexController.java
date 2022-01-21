package com.mrlqq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 2022/1/21 19:15
 * @Created by LQQ
 */
@Controller
public class IndexController {

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
