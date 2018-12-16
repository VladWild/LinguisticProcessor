package com.vg.lp.datalayer.data.getting;

import lombok.Data;

@Data
public class Teams {
    private String team1;
    private String team2;

    @Override
    public String toString() {
        return team1 + ", " + team2 + ", ";
    }
}
