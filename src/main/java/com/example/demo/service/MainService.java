package com.example.demo.service;

import com.example.demo.entity.Activity;
import com.example.demo.entity.Entrepreneur;


import java.util.List;

public interface MainService {
    List<Activity> activities();
    List<Entrepreneur> entrepreneur();
//    List<EntrepreneurActivity> fullList();
}
