package com.example.demo.service;

import com.example.demo.model.entity.Activity;
import com.example.demo.model.entity.Entrepreneur;


import java.util.List;

public interface MainService {
    List<Activity> getAllActivities();
    List<Entrepreneur> getAllEntrepreneurs();
}
