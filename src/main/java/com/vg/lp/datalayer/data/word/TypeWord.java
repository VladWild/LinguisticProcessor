package com.vg.lp.datalayer.data.word;

import java.util.HashMap;
import java.util.Map;

public enum TypeWord {
    NOUN("сущ");

    private String type;

    private static final Map<String, TypeWord> map;
    static {
        map = new HashMap<String,TypeWord>();
        for (TypeWord v : TypeWord.values()) {
            map.put(v.type, v);
        }
    }

    public static TypeWord findByKey(String key) {
        return map.get(key);
    }

    TypeWord(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
