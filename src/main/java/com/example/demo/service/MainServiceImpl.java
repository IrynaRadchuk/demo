package com.example.demo.service;

import com.example.demo.entity.Activity;

import com.example.demo.entity.Entrepreneur;
import com.example.demo.repository.ActivityRepository;

import com.example.demo.repository.EntrepreneurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MainServiceImpl implements MainService{
    @Autowired
    public ActivityRepository activityRepository;
    @Autowired
    public EntrepreneurRepository entrepreneurRepository;
//    @Autowired
//    public EntrepreneurActivityRepository repository;

    @Override
    public List<Activity> activities() {
        return activityRepository.findAll();
    }

    @Override
    public List<Entrepreneur> entrepreneur() {
        return entrepreneurRepository.findAll();
    }
//
//    @Override
//    public List<EntrepreneurActivity> fullList() {
//        return repository.findAll();
//    }

}
