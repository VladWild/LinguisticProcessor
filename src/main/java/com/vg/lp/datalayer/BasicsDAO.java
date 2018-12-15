package com.vg.lp.datalayer;

import java.util.List;

public interface BasicsDAO {
    List<String> getAllBasics();
    int getIdByBasic(String ending);
    String getMetkaById(int id);
}


