package com.example.demo.controller;

import com.example.demo.api.dto.EntrepreneurDTO;
import com.example.demo.persistence.entity.Activity;
import com.example.demo.persistence.entity.Entrepreneur;
import com.example.demo.service.MainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MainController {
    @Autowired
    private MainService service;

    @GetMapping("/activity")
    public List<Activity> activityReturn() {
        List<Activity> activities = service.getAllActivities();
        return activities;
    }

    @GetMapping(value = "/entrepreneur")
    public List<EntrepreneurDTO> entrepreneurReturn() {
        List<EntrepreneurDTO> entrepreneurs = service.getAllEntrepreneurs();
        return entrepreneurs;
    }

//    @GetMapping("/entrepreneurjdbc")
//    public Set<Entrepreneur> getEntrepreneurs() {
//        return service.getEntrepreneursJDBC();
//    }
//
//    @RequestMapping(value = "/run", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Entrepreneur> getWithHeader2() {
//        return service.getAllEntrepreneurs();
//    }
//
//    @RequestMapping(value = "/run", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public Set<Entrepreneur> getWithHeader1() {
//        return service.getEntrepreneursJDBC();
//    }
//
//    @GetMapping("/new")
//    public Collection<Entrepreneur> getNumber(@RequestHeader Map<String, String> headers) {
//
//        if (Optional.ofNullable(headers.get("jpa")).isPresent()) {
//            return service.getAllEntrepreneurs();
//        } else if (Optional.ofNullable(headers.get("jdbc")).isPresent()) {
//            return service.getEntrepreneursJDBC();
//        }
//        throw new RuntimeException("Input not received from header!");
//    }
}
