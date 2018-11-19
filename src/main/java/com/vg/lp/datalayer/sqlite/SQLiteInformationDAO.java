package com.vg.lp.datalayer.sqlite;

import com.vg.lp.datalayer.InformationDAO;
import com.vg.lp.datalayer.data.Specifications;
import com.vg.lp.utilities.requestmanagers.RequestManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SQLiteInformationDAO implements InformationDAO {
    private JdbcTemplate jdbcTemplate;
    private RequestManager rm;

    public SQLiteInformationDAO(JdbcTemplate jdbcTemplate, RequestManager rm) {
        this.jdbcTemplate = jdbcTemplate;
        this.rm = rm;
    }

    @Override
    public List<Specifications> getSpecifications(List<Integer> ids) {
        return jdbcTemplate.query(rm.getRequest("info"),
                (resultSet, i) -> {
                    if (ids.contains(i + 1)) {
                        Specifications sp = new Specifications();
                        sp.setChR(resultSet.getString("ChR"));
                        sp.setOd(resultSet.getString("Od"));
                        sp.setChislo(resultSet.getString("Chislo"));
                        sp.setRod(resultSet.getString("Rod"));
                        sp.setPadezh(resultSet.getString("Padezh"));
                        return sp;
                    } else {
                        return null;
                    }
                }).stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}

