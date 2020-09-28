package br.com.felipe.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.felipe.desafio.models.Game;
import br.com.felipe.desafio.models.Round;
import br.com.felipe.desafio.repository.GameRepository;
import br.com.felipe.desafio.repository.RoundRepository;

/**
 * GameController
 */
@Controller
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    RoundRepository roundRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("game/index.html");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@Valid Game game){
        List<Round> rounds = roundRepository.findAll();
        Round round = new Round();

        if(rounds.size() > 0){
            if(verifyIfScoreIsHigher(findHigherRound(rounds), game.getScore())){
                round.setMaxSeason(game.getScore());
                round.setMinSeason(findSmallerRound(rounds).getMinSeason());
                round.setCountMax(getHigherRecord(rounds) + 1);
            }
            else{
                round.setMaxSeason(findHigherRound(rounds).getMaxSeason());
                round.setCountMax(getHigherRecord(rounds));
            }

            if(verifyIfScoreIsSmaller(findSmallerRound(rounds), game.getScore())){
                round.setMinSeason(game.getScore());
                round.setMaxSeason(findHigherRound(rounds).getMaxSeason());
                round.setCountMin(getSmallerRecord(rounds) + 1);
            }else{
                round.setMinSeason(findSmallerRound(rounds).getMinSeason());
                round.setCountMin(getSmallerRecord(rounds));
            }

        }else{
            round.setCountMax(0);
            round.setCountMin(0);
            round.setMaxSeason(game.getScore());
            round.setMinSeason(game.getScore());
        }

        round.setGame(game);
        game.setRound(round);

        roundRepository.save(round);
        gameRepository.save(game);
        return "redirect:/";
    }

    private Round findHigherRound(List<Round> rounds){
        int higher = 0;
        int position = 0;

        for (int i = 0; i < rounds.size(); i++) {
            if(rounds.get(i).getMaxSeason() > higher){
                position = i;
            }
        }

        return rounds.get(position);
    }
    private Round findSmallerRound(List<Round> rounds){
        int smaller = Integer.MAX_VALUE;
        int position = 0;

        for (int i = 0; i < rounds.size(); i++) {
            if(rounds.get(i).getMinSeason() < smaller){
                position = i;
            }
        }

        return rounds.get(position);
    }

    private boolean verifyIfScoreIsHigher(Round round, int score){
        return round.getMaxSeason() < score;
    }

    private boolean verifyIfScoreIsSmaller(Round round, int score){
        return round.getMaxSeason() > score;
    }

    private int getHigherRecord(List<Round> rounds){
        int maior = 0;

        for (Round round : rounds) {
            if(round.getCountMax() > maior){
                maior = round.getCountMax();
            }
        }

        return maior;
    }

    private int getSmallerRecord(List<Round> rounds){
        int smaller = 0;

        for (Round round : rounds) {
            if(round.getCountMin() > smaller){
                smaller = round.getCountMin();
            }
        }

        return smaller;
    }
}