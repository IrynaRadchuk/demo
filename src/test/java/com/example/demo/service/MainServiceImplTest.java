package com.example.demo.service;

import com.example.demo.api.dto.EntrepreneurDTO;
import com.example.demo.persistence.entity.Activity;
import com.example.demo.persistence.entity.Entrepreneur;
import com.example.demo.persistence.repository.ActivityRepository;
import com.example.demo.persistence.repository.EntrepreneurRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MainServiceImplTest {

    @Autowired
    private MainService service;
    @MockBean
    private ActivityRepository activityRepository;
    @MockBean
    private EntrepreneurRepository entrepreneurRepository;

    @Test
    void getAllActivitiesTest() {
        final List<Activity> activityListExpected = new ArrayList<>();
        final Set<Entrepreneur> entrepreneursJava = new HashSet<>();
        entrepreneursJava.add(new Entrepreneur(4L, "Kate"));
        final Set<Entrepreneur> entrepreneursKotlin = new HashSet<>();
        entrepreneursJava.add(new Entrepreneur(4L, "Kate"));
        entrepreneursKotlin.add(new Entrepreneur(5L, "Rita"));
        activityListExpected.add(new Activity(1L, "java", entrepreneursJava));
        activityListExpected.add(new Activity(2L, "ruby", entrepreneursKotlin));
        Mockito.when(activityRepository.findAll()).thenReturn(activityListExpected);

        List<Activity> activityListActual = service.getAllActivities();

        assertEquals(activityListExpected, activityListActual);
    }

    @Test
    void getAllEntrepreneursTest() {
        final List<EntrepreneurDTO> entrepreneurListExpected = new ArrayList<>();
        final Set<Activity> activityListMary = new HashSet<>();
        activityListMary.add(new Activity(55L, "junit"));
        final Set<Activity> activityListAnn = new HashSet<>();
        activityListAnn.add(new Activity(55L, "junit"));
        activityListAnn.add(new Activity(44L, "mockito"));
        final Set<Activity> activityListJane = new HashSet<>();
        activityListJane.add(new Activity(55L, "junit"));
        activityListJane.add(new Activity(44L, "mockito"));
        activityListJane.add(new Activity(66L, "testing"));
        entrepreneurListExpected.add(new EntrepreneurDTO(11L, "Mary", activityListMary));
        entrepreneurListExpected.add(new EntrepreneurDTO(22L, "Ann", activityListAnn));
        entrepreneurListExpected.add(new EntrepreneurDTO(33L, "Jane", activityListJane));
        Mockito.when(entrepreneurRepository.getEntrepreneurs()).thenReturn(entrepreneurListExpected);

        List<EntrepreneurDTO> entrepreneurListActual = service.getAllEntrepreneurs();

        assertEquals(entrepreneurListExpected, entrepreneurListActual);
    }
    @Test
    void getAllEntrepreneursEmptyList() {
        Mockito.when(entrepreneurRepository.getEntrepreneurs()).thenReturn(Collections.emptyList());
        List<EntrepreneurDTO> entrepreneurListActual = service.getAllEntrepreneurs();
        Assertions.assertTrue(entrepreneurListActual.isEmpty());
    }
    @Test
    void getAllActivitiesEmptyList() {
        Mockito.when(activityRepository.findAll()).thenReturn(Collections.emptyList());
        List<Activity> activityListActual = service.getAllActivities();
        Assertions.assertTrue(activityListActual.isEmpty());
    }
}