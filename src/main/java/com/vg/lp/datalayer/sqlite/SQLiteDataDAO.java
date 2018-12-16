package com.vg.lp.datalayer.sqlite;

import com.vg.lp.datalayer.DataDAO;
import com.vg.lp.datalayer.data.getting.ResultMatch;
import com.vg.lp.datalayer.data.getting.Teams;
import com.vg.lp.utilities.requestmanagers.Manager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLiteDataDAO implements DataDAO {
    private JdbcTemplate jdbcTemplate;
    private Manager rm;

    public SQLiteDataDAO(JdbcTemplate jdbcTemplate, Manager rm) {
        this.jdbcTemplate = jdbcTemplate;
        this.rm = rm;
    }

    @Override
    public Object getResultMatch(List<String> teams) {
        //rm.getRequest("result")
        return jdbcTemplate.queryForObject("SELECT Team1Goals, Team2Goals, Team1PenaltyGoals, Team2PenaltyGoals\n" +
                "FROM Data\n" +
                "WHERE Team1 LIKE ? \n" +
                "      AND Team2 LIKE ?", new Object[]{teams.get(0) + "%", teams.get(1) + "%"}, new ResultMatchRowMapper());
    }

    @Override
    public List<Teams> getTeams(String stage) {
        List<Teams> teams = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(rm.getRequest("stage"), new Object[]{stage});

        for (Map row : rows){
            Teams team = new Teams();

            team.setTeam1((String)(row.get("Team1")));
            team.setTeam2((String)(row.get("Team2")));

            teams.add(team);
        }

        return teams;
    }

    @Override
    public int getCountMatches(String team) {
        List<Map<String, Object>> home = jdbcTemplate.queryForList("SELECT *\n" +
                "FROM Data\n" +
                "WHERE Team1 LIKE ?", new Object[]{team + "%"});
        List<Map<String, Object>> visit = jdbcTemplate.queryForList("SELECT *\n" +
                "FROM Data\n" +
                "WHERE Team2 LIKE ?", new Object[]{team + "%"});
        return home.size() + visit.size();
    }

    private class ResultMatchRowMapper implements RowMapper{
        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            ResultMatch rm = new ResultMatch();

            rm.setTeam1Goals(rs.getInt("Team1Goals"));
            rm.setTeam2Goals(rs.getInt("Team2Goals"));

            return rm;
        }
    }
}
