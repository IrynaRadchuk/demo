package com.example.demo.service;

import com.example.demo.api.dto.EntrepreneurDTO;
import com.example.demo.persistence.entity.Activity;
import com.example.demo.persistence.entity.Entrepreneur;

import java.util.List;
import java.util.Set;

public interface MainService {
    List<Activity> getAllActivities();
    List<EntrepreneurDTO> getAllEntrepreneurs();
    //Set<Entrepreneur> getEntrepreneursJDBC();
}
