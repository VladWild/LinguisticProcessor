package com.vladislavgusev.linguisticprocessor.datalayer;

import java.util.List;

public interface EndingsDAO {
    List<String> getAllEndings();
    String info();
}
