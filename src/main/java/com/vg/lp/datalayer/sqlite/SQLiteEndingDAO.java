package com.vg.lp.datalayer.sqlite;

import com.vg.lp.datalayer.EndingsDAO;
import com.vg.lp.utilities.requestmanagers.Manager;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SQLiteEndingDAO implements EndingsDAO {
    private JdbcTemplate jdbcTemplate;
    private Manager rm;

    public SQLiteEndingDAO(JdbcTemplate jdbcTemplate, Manager rm) {
        this.jdbcTemplate = jdbcTemplate;
        this.rm = rm;
    }

    @Override
    public List<String> getAllEndings() {
        return jdbcTemplate.query(rm.getRequest("all_endings"),
                (rs, i) -> rs.getString("endings"));
    }

    @Override
    public int getIdByEndings(String ending) {
        return jdbcTemplate.queryForObject(rm.getRequest("id_ending"), new Object[]{ending}, Integer.class);
    }
}


