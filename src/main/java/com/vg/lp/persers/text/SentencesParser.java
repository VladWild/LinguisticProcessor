package com.vg.lp.persers.text;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentencesParser implements Parser {
    private static final String SEPARATOR = " ";

    private String getSentWOQМ(String sentence){
        return sentence.substring(0, sentence.length()-1);
    }

    @Override
    public List<String> getList(String sentence) {
        return Arrays.stream(getSentWOQМ(sentence).split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
