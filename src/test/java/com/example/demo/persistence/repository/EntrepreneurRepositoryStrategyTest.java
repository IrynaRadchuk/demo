package com.example.demo.persistence.repository;

import com.example.demo.api.dto.EntrepreneurDTO;
import com.example.demo.persistence.entity.Activity;
import com.example.demo.persistence.entity.Entrepreneur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EntrepreneurRepositoryStrategyTest {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntrepreneurRepositoryStrategy entrepreneurRepositoryStrategy;
    @MockBean
    private JPAEntrepreneurRepository jpaEntrepreneurRepository;
    @MockBean
    private JDBCEntrepreneurRepository jdbcEntrepreneurRepository;

    private List<Entrepreneur> entrepreneurList = new ArrayList<>();
    private List<EntrepreneurDTO> entrepreneurListExpected = new ArrayList<>();

    @BeforeEach
    public void setEntrepreneurList() {
        Set<Activity> activityListMary = new HashSet<>();
        Set<Activity> activityListAnn = new HashSet<>();
        Set<Activity> activityListJane = new HashSet<>();
        activityListMary.add(new Activity(55L, "junit"));
        activityListAnn.add(new Activity(55L, "junit"));
        activityListAnn.add(new Activity(44L, "mockito"));
        activityListJane.add(new Activity(55L, "junit"));
        activityListJane.add(new Activity(44L, "mockito"));
        activityListJane.add(new Activity(66L, "testing"));
        entrepreneurList.add(new Entrepreneur(11L, "Mary", activityListMary));
        entrepreneurList.add(new Entrepreneur(22L, "Ann", activityListAnn));
        entrepreneurList.add(new Entrepreneur(33L, "Jane", activityListJane));
        entrepreneurListExpected.add(new EntrepreneurDTO(11L, "Mary", activityListMary));
        entrepreneurListExpected.add(new EntrepreneurDTO(22L, "Ann", activityListAnn));
        entrepreneurListExpected.add(new EntrepreneurDTO(33L, "Jane", activityListJane));
    }

    @Test
    void getEntrepreneursJpaTest() {
        Mockito.when(jpaEntrepreneurRepository.findAll()).thenReturn(entrepreneurList);
        List<EntrepreneurDTO> entrepreneurListActual = entrepreneurRepositoryStrategy.getEntrepreneurs();
        assertEquals(entrepreneurListExpected, entrepreneurListActual);
    }
    @Test
    void getEntrepreneursJdbcTest() {
        Mockito.when(jdbcEntrepreneurRepository.getGroupedActivities()).thenReturn(new HashSet<>(entrepreneurList));
        List<EntrepreneurDTO> entrepreneurListActual = entrepreneurRepositoryStrategy.getEntrepreneurs();
        assertEquals(entrepreneurListExpected, entrepreneurListActual);
    }
    @Test
    void getEntrepreneursJdbcEmptyList() {
        Mockito.when(jdbcEntrepreneurRepository.getGroupedActivities()).thenReturn(Collections.emptySet());
        List<EntrepreneurDTO> entrepreneurListActual = entrepreneurRepositoryStrategy.getEntrepreneurs();
        Assertions.assertTrue(entrepreneurListActual.isEmpty());
    }

    @Test
    void getEntrepreneursJpaEmptyList() {
        Mockito.when(jpaEntrepreneurRepository.findAll()).thenReturn(Collections.emptyList());
        List<EntrepreneurDTO> entrepreneurListActual = entrepreneurRepositoryStrategy.getEntrepreneurs();
        Assertions.assertTrue(entrepreneurListActual.isEmpty());
    }
    @Test
    void getEntrepreneursException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            entrepreneurRepositoryStrategy.getEntrepreneurs();
        });
    }
}