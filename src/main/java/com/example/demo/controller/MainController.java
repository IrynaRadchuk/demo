package com.example.demo.controller;

import com.example.demo.model.dao.EntrepreneurDao;
import com.example.demo.model.entity.Activity;
import com.example.demo.model.entity.Entrepreneur;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    @Autowired
    private MainService service;
    @Autowired
    private EntrepreneurDao entrepreneurDao;

    @GetMapping("/activity")
    public List<Activity> activityReturn() {
        List<Activity> activities = service.getAllActivities();
        return activities;
    }

    @GetMapping("/entrepreneur")
    public List<Entrepreneur> entrepreneurReturn() {
        List<Entrepreneur> entrepreneurs = service.getAllEntrepreneurs();
        return entrepreneurs;
    }

//    @GetMapping("/entrepreneurjdbc")
//    public List<Entrepreneur> entrepreneurJdbc() {
//        List<Entrepreneur> entrepreneurs = entrepreneurDao.index();
//        return entrepreneurs;
//    }
    @GetMapping("/entrepreneurjdbc")
    public Map<Entrepreneur, List<String>> getEntrepreneurs() {
        return entrepreneurDao.getGroupedActivities();
    }
}
