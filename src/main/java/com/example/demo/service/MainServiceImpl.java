package com.example.demo.service;


import com.example.demo.api.dto.EntrepreneurDTO;
import com.example.demo.persistence.repository.EntrepreneurRepository;
import com.example.demo.persistence.repository.JDBCEntrepreneurRepository;
import com.example.demo.persistence.entity.Activity;
import com.example.demo.persistence.entity.Entrepreneur;
import com.example.demo.persistence.repository.ActivityRepository;
import com.example.demo.persistence.repository.JPAEntrepreneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MainServiceImpl implements MainService{
    @Autowired
    public ActivityRepository activityRepository;
    @Autowired
    public EntrepreneurRepository entrepreneurRepository;
//    @Autowired
//    public JPAEntrepreneurRepository JPAEntrepreneurRepository;
//    @Autowired
//    private JDBCEntrepreneurRepository JDBCEntrepreneurRepository;

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public List<EntrepreneurDTO> getAllEntrepreneurs() {
        return entrepreneurRepository.getEntrepreneurs();
    }

//    @Override
//    public Set<Entrepreneur> getEntrepreneursJDBC() {
//        return JDBCEntrepreneurRepository.getGroupedActivities();
//    }
}
