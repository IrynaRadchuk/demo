package com.example.demo.persistence.repository;


import com.example.demo.persistence.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
