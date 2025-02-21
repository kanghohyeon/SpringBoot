package com.sist.bbs_0220.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String requestMethodName() {
        return "index";
    }
    
}
