package com.vg.lp.datalayer.sqlite;

import com.vg.lp.datalayer.EndingsDAO;
import com.vg.lp.utilities.requestmanagers.RequestManager;
import com.vg.lp.utilities.requestmanagers.SimpleRequestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("SQLiteEndingDAO")
public class SQLiteEndingDAO implements EndingsDAO {
    private JdbcTemplate jdbcTemplate;
    private RequestManager rm;

    public SQLiteEndingDAO(JdbcTemplate jdbcTemplate, RequestManager rm) {
        this.jdbcTemplate = jdbcTemplate;
        this.rm = rm;
    }

    @Override
    public List<String> getAllEndings() {
        return jdbcTemplate.query(rm.getRequest("all_endings"),
                (rs, i) -> rs.getString("endings"));
    }
}


