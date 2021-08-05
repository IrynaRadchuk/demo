package com.example.demo.persistence.repository;

import com.example.demo.api.dto.EntrepreneurDTO;
import com.example.demo.persistence.entity.Entrepreneur;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class EntrepreneurRepositoryStrategy implements EntrepreneurRepository {

    @Autowired
    private JPAEntrepreneurRepository jpaEntrepreneurRepository;
    @Autowired
    private JDBCEntrepreneurRepository jdbcEntrepreneurRepository;
    @Autowired
    private ModelMapper modelMapper;

    public EntrepreneurDTO convertToDto(Entrepreneur entrepreneur) {
        EntrepreneurDTO entrepreneurDTO = modelMapper.map(entrepreneur, EntrepreneurDTO.class);
        return entrepreneurDTO;
    }

    @Override
    public List<EntrepreneurDTO> getEntrepreneurs(String header) {
        List<Entrepreneur> entrepreneurs;
        if (header.equals("jpa")) {
            entrepreneurs = jpaEntrepreneurRepository.findAll();
        } else if (header.equals("jdbc")){
            Set<Entrepreneur> groupedActivities = jdbcEntrepreneurRepository.getGroupedActivities();
            entrepreneurs = new ArrayList<>(groupedActivities);
        } else {
            throw new RuntimeException("Wrong header");
        }
        List<EntrepreneurDTO> dtoList = new ArrayList<>();
        for (Entrepreneur entrepreneur: entrepreneurs) {
            EntrepreneurDTO entrepreneurDTO = convertToDto(entrepreneur);
            dtoList.add(entrepreneurDTO);
        }
        return dtoList;
//        return entrepreneurs.stream().
//                map(entrepreneur -> mapper.entityToDto(entrepreneur)).collect(Collectors.toList());
    }
}
