/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.GuessTheNumber.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.GuessTheNumber.dao.GameDao;
import sg.com.GuessTheNumber.dao.RoundDao;
import sg.com.GuessTheNumber.dto.Game;
import sg.com.GuessTheNumber.dto.Round;

/**
 *
 * @author kevinyeung
 */
@Service
public class GuessTheNumberServiceJDBCImpl implements GuessTheNumberService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private RoundDao roundDao;

    @Override
    public Game beginGame() {
        Game game = new Game();
        game.setAnswer(createRandomNumber());
        game.setIsFinished(false);

        return gameDao.createGame(game);
    }

    @Override
    public Round evaluateGuess(String guess, int id) {
        Game game = gameDao.readGameById(id);

        if (game == null) {
            return null;
        }

        Round round = new Round();
        round.setGame(game);
        round.setGuess(guess);
        round.setGuessTime(LocalDateTime.now());
        round.setResult(calculateResults(guess, game.getAnswer()));
        roundDao.createRound(round);

        if (round.getResult().equalsIgnoreCase("e:4:p:0")) {
            game.setIsFinished(true); 
            gameDao.updateGame(game);
        }
        
        
//        if (game.gameResult().equalsIgnoreCase("10")) {
//            game.setIsFinished(true);
//             gameDao.updateGame(game);
//       
//        }
//        
 

        return roundDao.readRoundById(round.getId());
    }

    @Override
    public List<Game> getAllGames() {
        return gameDao.readAllGames();
    }

    @Override
    public Game getGameById(int id) {
        return gameDao.readGameById(id);
    }

    @Override
    public List<Round> getAllRoundsByGameId(int gameId) {
        return roundDao.readAllRoundsByGameId(gameId);
    }

    private String createRandomNumber() {
        String randomNum = "";
        Random random = new Random();
        boolean keepGoing = true;
        int nextNum, removeNum;
//        LinkedHashMap<Integer,Integer> poolOfNumbers = new LinkedHashMap<>();
        ArrayList<Integer> poolOfNums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            poolOfNums.add(i);
        }

        for (int i = 0; i < 4; i++) {
            do {
                nextNum = random.nextInt(10);
                if (poolOfNums.contains(nextNum)) {
                    randomNum += nextNum;
                    removeNum = poolOfNums.indexOf(nextNum);
                    poolOfNums.remove(removeNum);
                    keepGoing = false;
                } else {
                    keepGoing = true;
                }
            } while (keepGoing);
        }
        return randomNum;
    }

    private String calculateResults(String guess, String answer) {
        int exactMatches = 0,
                partialMatches = 0;
        String result;

        if (guess.length() != 4) {
            result = "e:" + exactMatches + ":p:" + partialMatches;
            return result;
        }

        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == answer.charAt(i)) {
                exactMatches++;
            } else if (answer.contains(guess.subSequence(i, i + 1))) {
                partialMatches++;
            }
        }

        result = "e:" + exactMatches + ":p:" + partialMatches;
        return result;
    }

}
