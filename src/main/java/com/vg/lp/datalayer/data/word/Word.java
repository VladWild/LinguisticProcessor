package com.vg.lp.datalayer.data.word;

import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
public class Word {
    private TypeWord typeWord;
    private String word;
    private String basic;
    private String ending;
    private List<Map<String, String>> signs;

    public TypeWord getTypeWord() {
        return typeWord;
    }

    public void setTypeWord(TypeWord typeWord) {
        this.typeWord = typeWord;
    }

    public List<Map<String, String>> getSigns() {
        return signs;
    }

    public void setSigns(List<Map<String, String>> signs) {
        this.signs = signs;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }
}


