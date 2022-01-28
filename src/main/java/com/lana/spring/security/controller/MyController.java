package com.lana.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps() {
        return "info";
    }

    @GetMapping("/hr")
    public String getInfoForHR() {
        return "hr";
    }

    @GetMapping("/manager")
    public String getInfoForManagers() {
        return "manager";
    }
}
