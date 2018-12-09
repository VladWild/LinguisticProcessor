package com.vg.lp.datalayer.sqlite;

import com.vg.lp.datalayer.MorphologicalDAO;
import com.vg.lp.utilities.requestmanagers.RequestManager;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQLiteMorphologicalDAO implements MorphologicalDAO {
    private JdbcTemplate jdbcTemplate;
    private RequestManager rm;

    public SQLiteMorphologicalDAO(JdbcTemplate jdbcTemplate, RequestManager rm) {
        this.jdbcTemplate = jdbcTemplate;
        this.rm = rm;
    }

    @Override
    public String getMorphologicalInfo(int numberBasic, int numberEnding) {
        String ending = jdbcTemplate.query(rm.getRequest("get_ending"), new Object[]{numberEnding},
                (rs, i) -> rs.getString("endings")).get(0);
        return jdbcTemplate.query(rm.getRequest("morpho_info"), new Object[]{numberBasic},
                (rs, i) -> rs.getString(ending)).get(0);
    }
}


