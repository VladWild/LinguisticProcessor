package com.vg.lp.datalayer.sqlite;

import com.vg.lp.datalayer.InformationDAO;
import com.vg.lp.datalayer.data.Specifications;
import com.vg.lp.utilities.requestmanagers.Manager;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SQLiteInformationDAO implements InformationDAO {
    private JdbcTemplate jdbcTemplate;
    private Manager rm;

    public SQLiteInformationDAO(JdbcTemplate jdbcTemplate, Manager rm) {
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
                        sp.setForma(resultSet.getString("Forma"));
                        sp.setVid(resultSet.getString("Vid"));
                        sp.setTime(resultSet.getString("Time"));
                        return sp;
                    } else {
                        return null;
                    }
                }).stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}

