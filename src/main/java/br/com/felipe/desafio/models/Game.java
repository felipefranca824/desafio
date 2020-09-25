package br.com.felipe.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int score;
    private int maximumScore;
    private int minimumScore;
    private int countRecordMaximum;
    private int countRecordMinimum;
    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;
    
    public Season getSeason() {
        return season;
    }
    public void setSeason(Season season) {
        this.season = season;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaximumScore() {
        return maximumScore;
    }

    public void setMaximumScore(int maximumScore) {
        this.maximumScore = maximumScore;
    }

    public int getMinimumScore() {
        return minimumScore;
    }

    public void setMinimumScore(int minimumScore) {
        this.minimumScore = minimumScore;
    }

    public int getCountRecordMaximum() {
        return countRecordMaximum;
    }

    public void setCountRecordMaximum(int countRecordMaximum) {
        this.countRecordMaximum = countRecordMaximum;
    }

    public int getCountRecordMinimum() {
        return countRecordMinimum;
    }

    public void setCountRecordMinimum(int countRecordMinimum) {
        this.countRecordMinimum = countRecordMinimum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
