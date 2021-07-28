package com.example.demo.service;


import com.example.demo.model.entity.Activity;
import com.example.demo.model.entity.Entrepreneur;
import com.example.demo.repository.ActivityRepository;

import com.example.demo.repository.EntrepreneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MainServiceImpl implements MainService{
    @Autowired
    public ActivityRepository activityRepository;
    @Autowired
    public EntrepreneurRepository entrepreneurRepository;

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public List<Entrepreneur> getAllEntrepreneurs() {
        return entrepreneurRepository.findAll();
    }
}
