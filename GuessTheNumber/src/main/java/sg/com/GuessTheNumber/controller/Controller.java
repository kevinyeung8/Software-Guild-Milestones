/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.GuessTheNumber.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sg.com.GuessTheNumber.dto.Round;
import sg.com.GuessTheNumber.dto.Game;
import sg.com.GuessTheNumber.dto.UserInput;
import sg.com.GuessTheNumber.service.GuessTheNumberService;

/**
 *
 * @author kevinyeung
 */

@RestController
@RequestMapping("/api")
public class Controller {

    private final GuessTheNumberService guessTheNumberService;

    public Controller(GuessTheNumberService guessTheNumberService) {
        this.guessTheNumberService = guessTheNumberService;
    }

   @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int beginGame() {
        Game game = guessTheNumberService.beginGame();
        return game.getId();
    }

    @PostMapping("/guess")
    public Round evaluateGuess(@RequestBody UserInput input) {
        Round round = guessTheNumberService.evaluateGuess(input.getGuess(), input.getId());
        if (!round.getGame().getIsFinished()) {
            round.getGame().setAnswer("Incorrect!");
        }
        return round;
    }

    @GetMapping("/game")
    public List<Game> getAllGames() {
        List<Game> games = guessTheNumberService.getAllGames();
        for (Game game : games) {
            if (!game.getIsFinished()) {
                game.setAnswer("Incorrect!");
            }
        }
        return games;
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGameByI(@PathVariable int gameId) {
        Game game = guessTheNumberService.getGameById(gameId);
        if (game == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        if (!game.getIsFinished()) {
            game.setAnswer("Incorrect!");
        }
        return ResponseEntity.ok(game);
    }

    @GetMapping("/rounds/{gameId}")
    public List<Round> getAllRoundsById(@PathVariable int gameId) {
        List<Round> rounds = guessTheNumberService.getAllRoundsByGameId(gameId);

        for (Round round : rounds) {
            if (!round.getGame().getIsFinished()) {
                round.getGame().setAnswer("Still not solved!");
            }
        }
        return rounds;
    }
}
