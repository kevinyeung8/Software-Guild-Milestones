/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.GuessTheNumber.dao;

import java.util.List;
import sg.com.GuessTheNumber.dto.Round;


/**
 *
 * @author kevinyeung
 */
public interface RoundDao {

    //CRRUD
    public Round createRound(Round round);

    public List<Round> readAllRounds();

    public Round readRoundById(int id);

    public List<Round> readAllRoundsByGameId(int id);

    public boolean deleteRound(int id);
}
