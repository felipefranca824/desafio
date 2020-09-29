package br.com.felipe.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   
    @Min(0)
    @Max(1000)
    private int score;
    @OneToOne
    @JoinColumn(name = "round_id")
    private Round round;
    
    public Round getRound() {
        return round;
    }
    public void setRound(Round round) {
        this.round = round;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        System.out.println(score);
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
