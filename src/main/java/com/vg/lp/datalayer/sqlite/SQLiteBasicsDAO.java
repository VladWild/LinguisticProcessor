package com.vg.lp.datalayer.sqlite;

import com.vg.lp.datalayer.BasicsDAO;
import com.vg.lp.utilities.requestmanagers.RequestManager;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SQLiteBasicsDAO implements BasicsDAO {
    private JdbcTemplate jdbcTemplate;
    private RequestManager rm;

    public SQLiteBasicsDAO(JdbcTemplate jdbcTemplate, RequestManager rm) {
        this.jdbcTemplate = jdbcTemplate;
        this.rm = rm;
    }

    @Override
    public List<String> getAllBasics() {
        return jdbcTemplate.query(rm.getRequest("all_basics"),
                (rs, i) -> rs.getString("basics"));
    }

    @Override
    public int getIdByBasic(String ending) {
        return jdbcTemplate.queryForObject(rm.getRequest("id_basic"), new Object[]{ending}, Integer.class);
    }
}

