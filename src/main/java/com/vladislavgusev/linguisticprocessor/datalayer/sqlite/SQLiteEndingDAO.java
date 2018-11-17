package com.vladislavgusev.linguisticprocessor.datalayer.sqlite;

import com.vladislavgusev.linguisticprocessor.datalayer.EndingsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component("SQLiteEndingDAO")
public class SQLiteEndingDAO implements EndingsDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<String> getAllEndings() {
        String sql = "INSERT INTO Basics (basics) VALUES ('new')";

        jdbcTemplate.update(sql);

        return new ArrayList<>();
    }

    @Override
    public String info() {

        String sql = "SELECT rowid FROM Basics WHERE rowid = 1";

        String name = (String) jdbcTemplate.queryForObject(
                sql, String.class);

        return name;
    }
}
