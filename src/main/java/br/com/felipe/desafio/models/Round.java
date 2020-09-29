package br.com.felipe.desafio.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "round", cascade = CascadeType.ALL)
    private Game game;

    @Min(0)
    @Max(1000)
    private int minSeason;

    @Min(0)
    @Max(1000)
    private int maxSeason;

    @Min(0)
    @Max(1000)
    private int countMax;

    @Min(0)
    @Max(1000)
    private int countMin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getMinSeason() {
        return minSeason;
    }

    public void setMinSeason(int minSeason) {
        this.minSeason = minSeason;
    }

    public int getMaxSeason() {
        return maxSeason;
    }

    public void setMaxSeason(int maxSeason) {
        this.maxSeason = maxSeason;
    }

    public int getCountMax() {
        return countMax;
    }

    public void setCountMax(int countMax) {
        this.countMax = countMax;
    }

    public int getCountMin() {
        return countMin;
    }

    public void setCountMin(int countMin) {
        this.countMin = countMin;
    }
}
