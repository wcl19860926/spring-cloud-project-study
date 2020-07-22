package com.study.gateway.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        mmap.put("userName" ,"王成林");


        return "index";
    }



    // 系统首页
    @GetMapping("/error")
    public String error(ModelMap mmap) {


        return "error/error";
    }


    @GetMapping("/welcome")
    public String welcome(ModelMap mmap) {


        return "welcome";
    }
}
