/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.GuessTheNumber.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sg.com.GuessTheNumber.dao.GameDaoJDBCImpl.GameMapper;
import sg.com.GuessTheNumber.dto.Game;
import sg.com.GuessTheNumber.dto.Round;

@Repository
public class RoundDaoJDBCImpl implements RoundDao {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_ROUND = "INSERT INTO Round(guess, guessTime, result, gameId) VALUES (?, ?, ?, ?)",
            SELECT_ALL_ROUNDS = "SELECT roundId, guess, guessTime, result, gameId FROM Round",
            SELECT_ROUND_BY_ID = SELECT_ALL_ROUNDS + " WHERE roundId = ?",
            SELECT_ALL_ROUNDS_BY_GAME_ID = SELECT_ALL_ROUNDS + " WHERE gameId = ? "+ "ORDER BY guessTime ASC",
            UPDATE_ROUND = "UPDATE Round SET guess = ?, guessTime = ?, result = ?, gameId = ? WHERE roundId = ?",
            DELETE_ROUND_BY_GAME_ID = "DELETE FROM Round WHERE gameId = ?",
            DELETE_ROUND = "DELETE FROM Round WHERE roundId = ?",
            SELECT_GAME_FOR_ROUND = "SELECT g.* FROM Game g JOIN Round r ON g.gameId = r.gameId WHERE r.roundId = ?";

    @Override
    @Transactional
    public Round createRound(Round round) {
        jdbc.update(INSERT_ROUND, round.getGuess(), round.getGuessTime(), round.getResult(), round.getGame().getId());
        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setId(id);
        return round;
    }

    @Override
    @Transactional
    public List<Round> readAllRounds() {
        List<Round> rounds = jdbc.query(SELECT_ALL_ROUNDS, new RoundMapper());
        getGamesForRounds(rounds);
        return rounds;
    }

    @Override
    @Transactional
    public Round readRoundById(int id) {
        try {
            Round round = jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), id);
            round.setGame(getGameForRound(round));
            return round;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<Round> readAllRoundsByGameId(int id) {
        List<Round> rounds = jdbc.query(SELECT_ALL_ROUNDS_BY_GAME_ID, new RoundMapper(), id);
        getGamesForRounds(rounds);
        return rounds;
    }

    @Override
    @Transactional
    public boolean deleteRound(int id) {
        return jdbc.update  (DELETE_ROUND, id) > 0;
    }

    private Game getGameForRound(Round round) {
        return jdbc.queryForObject(SELECT_GAME_FOR_ROUND, new GameMapper(), round.getId());
    }

    private void getGamesForRounds(List<Round> rounds) {
        for (Round round : rounds) {
            round.setGame(getGameForRound(round));
        }
    }


    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();

            round.setId(rs.getInt("roundId"));
            round.setGuess(rs.getString("guess"));
            round.setGuessTime(rs.getTimestamp("guessTime").toLocalDateTime());
            round.setResult(rs.getString("result"));
            
            return round;
        }

    }
}