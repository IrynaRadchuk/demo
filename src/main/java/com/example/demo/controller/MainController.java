package com.example.demo.controller;

import com.example.demo.model.entity.Activity;
import com.example.demo.model.entity.Entrepreneur;
import com.example.demo.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper mapper = new ObjectMapper();
        try {
            String activitiesString = mapper.writeValueAsString(activities);
            String entrepreneursString = mapper.writeValueAsString(entrepreneurs);
            model.addAttribute("activities", activitiesString);
            model.addAttribute("entrepreneurs", entrepreneursString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "index";
    }

}
