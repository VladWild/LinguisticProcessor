package com.vg.lp.datalayer.data.word;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Word {
    private TypeWord typeWord;
    private String word;
    private String basic;
    private String ending;
    private List<Map<String, String>> signs;
}


