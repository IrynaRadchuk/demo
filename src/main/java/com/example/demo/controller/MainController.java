package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.entity.Activity;
import com.example.demo.model.entity.Entrepreneur;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
@Autowired
private MainService service;

    @GetMapping("/")
    public String index(Model model) {
        List<Activity> activities = service.getAllActivities();
        List<Entrepreneur> entrepreneurs = service.getAllEntrepreneurs();
        String json = JSON.toJSONString(activities);
        model.addAttribute("activities", activities);
        model.addAttribute("entrepreneurs", entrepreneurs);
        return "index";
    }

}
