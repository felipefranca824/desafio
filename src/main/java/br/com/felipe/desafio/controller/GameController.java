package br.com.felipe.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.felipe.desafio.models.Game;
import br.com.felipe.desafio.repository.GameRepository;

@Controller
public class GameController {

    @Autowired
    private GameRepository repository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "game/index.html";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(Game game){
        game.setCountRecordMaximum(0);
        game.setMaximumScore(0);
        game.setMinimumScore(0);
        game.setCountRecordMinimum(0);
        repository.save(game);

        return "redirect:/";
    }
}
