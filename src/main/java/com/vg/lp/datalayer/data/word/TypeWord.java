package com.vg.lp.datalayer.data.word;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum TypeWord {
    NOUN("сущ"), VEB("гл"), NUM("числ"), ADVERB("нар");

    private String type;

    private static final Map<String, TypeWord> map;
    static {
        map = new HashMap<String,TypeWord>();
        Arrays.stream(TypeWord.values()).forEach(typeWord ->
                map.put(typeWord.type, typeWord));
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
