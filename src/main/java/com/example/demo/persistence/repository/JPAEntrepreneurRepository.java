package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Entrepreneur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAEntrepreneurRepository extends JpaRepository<Entrepreneur, Long>{
}
