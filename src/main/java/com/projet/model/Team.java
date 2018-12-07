/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author vanessa
 */
@Entity
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;
    
    private String name;
    
    private Integer rankingPosition;
    
    private Integer points;
    
    private String logo;
    
    private Integer play;
    
    private Integer win;
    
    private Integer draw;
    
    private Integer lose;
    
    private Integer goalsFor;
    
    private Integer goalsAgainst;
    
    private Integer goalsDiff;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "teams")
    private List<Fixture> fixtures;
    
    @ManyToOne
    private Ranking ranking;

    public Team() {
    }

    public Team(Long teamId, String name, Integer rankingPosition, Integer points, String logo, Integer play, Integer win, Integer draw, Integer lose, Integer goalsFor, Integer goalsAgainst, Integer goalsDiff, List<Fixture> fixtures, Ranking ranking) {
        this.teamId = teamId;
        this.name = name;
        this.ranking = ranking;
        this.points = points;
        this.logo = logo;
        this.play = play;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDiff = goalsDiff;
        this.fixtures = fixtures;
        this.ranking = ranking;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRankingPosition() {
        return rankingPosition;
    }

    public void setRankingPosition(Integer rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getPlay() {
        return play;
    }

    public void setPlay(Integer play) {
        this.play = play;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(Integer goalsFor) {
        this.goalsFor = goalsFor;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(Integer goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    
    
}
