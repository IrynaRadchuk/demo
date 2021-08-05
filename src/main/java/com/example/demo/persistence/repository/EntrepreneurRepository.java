package com.example.demo.persistence.repository;

import com.example.demo.api.dto.EntrepreneurDTO;

import java.util.List;

public interface EntrepreneurRepository {
    List<EntrepreneurDTO> getEntrepreneurs(String header);
}
