package com.example.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "entrepreneur")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Entrepreneur {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "entrepreneurs",fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value="entrepreneurs")
    private Set<Activity> activities;

    public Entrepreneur() {
    }

    public Entrepreneur(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Entrepreneur(Long id, String name, Set<Activity> activities) {
        this.id = id;
        this.name = name;
        this.activities = activities;
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
        if (!(o instanceof Entrepreneur)) return false;
        Entrepreneur that = (Entrepreneur) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Entrepreneur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activities=" + activities +
                '}';
    }
}
