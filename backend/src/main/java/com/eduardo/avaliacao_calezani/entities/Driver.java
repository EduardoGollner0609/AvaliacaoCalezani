package com.eduardo.avaliacao_calezani.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "driver")
    private List<Assessment> assessments = new ArrayList<>();

    public Driver() {
    }

    public Driver(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addAssesment(Assessment assessment) {
        this.assessments.add(assessment);
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }
}
