package com.vg.lp.datalayer;

import java.util.List;

public interface EndingsDAO {
    List<String> getAllEndings();
    int getIdByEndings(String ending);
}
