package com.vg.lp.datalayer;

import com.vg.lp.datalayer.data.getting.Teams;

import java.util.List;

public interface DataDAO {
    //1 тип
    Object getResultMatch(List<String> teams);

    //3 тип
    List<Teams> getTeams(String stage);

    //5 тип
    int getCountMatches(String team);
}
