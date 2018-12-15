package com.vg.lp.services;

import com.vg.lp.datalayer.data.word.Word;
import com.vg.lp.utilities.groups.GroupsWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceSentence {
    private List<List<List<String>>> keys;

    private Map<Integer, Boolean> map = new HashMap<>();

    public ServiceSentence(GroupsWords groups) {
        this.keys = groups.keys;
    }

    private List<String> getChange(List<Word> words){
        return words.stream().map(Word::getMetka).collect(Collectors.toList());
    }

    public List<Boolean> getListGroups(List<Word> words){

        List<String> change = getChange(words);
        String string = change.stream().reduce("", (ac, el) -> ac + el);

        for (int i = 0; i < keys.size(); i++){
            map.put(i, false);
            for (int j = 0; j < keys.get(i).size(); j++){
                if (string.contains(keys.get(i).get(j)
                        .stream()
                        .reduce("", (ac, el) -> ac + el))) {
                    map.put(i, true);
                }
            }
        }

        System.out.println(map);

        return null;
    }
}
