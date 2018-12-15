package com.vg.lp.persers.world;

import com.vg.lp.datalayer.data.word.Word;

import java.util.List;

public interface ParserWord {
    List<Word> getList(List<String> words);
}
