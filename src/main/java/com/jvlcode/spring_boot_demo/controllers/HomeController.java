package com.jvlcode.spring_boot_demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {
    @GetMapping
    public String getHome(){
        return "Welcome to home";
    }

    @GetMapping("/dashboard")
    public String getDashBoardPage(){
        return "login Successful";
    }

    @GetMapping("/Admin")
    public  String getAdminPage(){
        return "Welcome back admin";
    }
}
