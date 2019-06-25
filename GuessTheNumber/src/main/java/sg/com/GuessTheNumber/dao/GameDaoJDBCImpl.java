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
import sg.com.GuessTheNumber.dto.Game;

@Repository
public class GameDaoJDBCImpl implements GameDao {
    
    @Autowired
    private JdbcTemplate jdbc; 
    
    private final String INSERT_GAME = "INSERT INTO Game(answer, isFinished) VALUES (?, ?)";
    private final String SELECT_ALL_GAMES = "SELECT gameId, answer, isFinished FROM Game";
    private final String SELECT_GAME_BY_ID = SELECT_ALL_GAMES + " WHERE gameId = ?";
    private final String UPDATE_GAME = "UPDATE Game SET answer = ?, isFinished = ? WHERE gameId = ?";
    private final String DELETE_ROUND_BY_GAME_ID = "DELETE FROM Round WHERE gameId = ?";
    private final String DELETE_GAME = "DELETE FROM Game WHERE gameId = ?";

    @Override
    @Transactional
    public Game createGame(Game game) {
        jdbc.update(INSERT_GAME, game.getAnswer(), game.getIsFinished());
        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setId(id);
        return game;
    }

    @Override
    @Transactional
    public List<Game> readAllGames() {
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    @Transactional
    public Game readGameById(int id) {
        try {
            return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean updateGame(Game game) {
        return jdbc.update(UPDATE_GAME, game.getAnswer(), game.getIsFinished(), game.getId()) > 0;
    }

    @Override
    @Transactional
    public boolean deleteGame(int id) {
        jdbc.update(DELETE_ROUND_BY_GAME_ID, id);
        return jdbc.update(DELETE_GAME, id) > 0;
    }

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setId(rs.getInt("gameId"));
            game.setAnswer(rs.getString("answer"));
            game.setIsFinished(rs.getBoolean("isFinished"));
            return game;
        }

    }
}
