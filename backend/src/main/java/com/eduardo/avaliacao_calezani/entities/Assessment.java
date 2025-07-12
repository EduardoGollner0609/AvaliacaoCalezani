package com.eduardo.avaliacao_calezani.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_assessment")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;
    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Assessment() {
    }

    public Assessment(Long id, int score, String comment, Driver driver) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.driver = driver;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
