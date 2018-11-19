package com.vg.lp.datalayer.data.word;

public enum TypeWord {
    NOUN("сущ");

    private String type;

    TypeWord(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
