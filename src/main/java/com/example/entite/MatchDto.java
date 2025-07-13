package com.example.entite;

import java.time.LocalDate;

public class MatchDto {
    private String id;
    private String equipe1Id;
    private String equipe2Id;
    private String score;
    private LocalDate date;

    // Getters et setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipe1Id() {
        return equipe1Id;
    }

    public void setEquipe1Id(String equipe1Id) {
        this.equipe1Id = equipe1Id;
    }

    public String getEquipe2Id() {
        return equipe2Id;
    }

    public void setEquipe2Id(String equipe2Id) {
        this.equipe2Id = equipe2Id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
