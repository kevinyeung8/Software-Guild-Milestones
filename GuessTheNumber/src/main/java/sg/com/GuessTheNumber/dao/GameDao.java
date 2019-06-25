/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.GuessTheNumber.dao;

import java.util.List;
import sg.com.GuessTheNumber.dto.Game;


/**
 *
 * @author kevinyeung
 */
public interface GameDao {

    //CRRUD
    public Game createGame(Game game);

    public List<Game> readAllGames();

    public Game readGameById(int id);

    public boolean updateGame(Game game);

    public boolean deleteGame(int id);
}
