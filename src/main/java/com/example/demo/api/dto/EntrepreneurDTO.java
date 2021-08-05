package com.example.demo.api.dto;

import com.example.demo.persistence.entity.Activity;

import java.util.Objects;
import java.util.Set;

public class EntrepreneurDTO {
    private Long id;
    private String name;
    private Set<Activity> activities;

    public EntrepreneurDTO() {
    }

    public EntrepreneurDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntrepreneurDTO)) return false;
        EntrepreneurDTO that = (EntrepreneurDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(activities, that.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, activities);
    }

    @Override
    public String toString() {
        return "EntrepreneurDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
