package com.vg.lp.persers.world;

import com.vg.lp.datalayer.data.word.Word;
import com.vg.lp.services.ServiceWord;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleParserWord implements ParserWord {
    private ServiceWord sw;

    public SimpleParserWord(ServiceWord sw){
        this.sw = sw;
    }

    @Override
    public List<Word> getList(List<String> words) {
        return words.stream().map(sw::getWord)
                .collect(Collectors.toList());
    }
}
