package com.vg.lp.services;

import com.vg.lp.datalayer.data.word.Word;
import com.vg.lp.utilities.groups.GroupsWords;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j
public class ServiceSentence {
    private List<List<List<String>>> keys;

    private Map<Integer, Integer> map = new HashMap<>();

    public ServiceSentence(GroupsWords groups) {
        this.keys = groups.keys;
    }

    private List<String> getChange(List<Word> words){
        return words.stream().map(Word::getMetka).collect(Collectors.toList());
    }

    public String getListGroups(List<Word> words){

        List<String> change = getChange(words);
        String string = change.stream().reduce("", (ac, el) -> ac + el);

        for (int i = 0; i < keys.size(); i++){
            map.put(i, 0);
            for (int j = 0; j < keys.get(i).size(); j++){
                if (string.contains(keys.get(i).get(j)
                        .stream()
                        .reduce("", (ac, el) -> ac + el))) {
                    map.put(i, 1);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < map.size(); i++){
            str.append(map.get(i));
        }

        log.info("Номера групп, которые присутствуют в вопросе: ");
        for(int i = 0; i < map.size(); i++){
            if (map.get(i) == 1){
                log.info("группа  - " + (i + 1) + ";");
            }
        }

        return str.toString();
    }
}
