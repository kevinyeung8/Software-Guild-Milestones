/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.GuessTheNumber.service;

import java.util.List;
import sg.com.GuessTheNumber.dto.Game;
import sg.com.GuessTheNumber.dto.Round;

/**
 *
 * @author kevinyeung
 */
public interface GuessTheNumberService {

    public Game beginGame();

    public Round evaluateGuess(String guess, int id);

    public List<Game> getAllGames();

    public Game getGameById(int id);

    public List<Round> getAllRoundsByGameId(int gameId);
}