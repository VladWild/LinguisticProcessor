package com.vg.lp.persers.text;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleParser implements Parser {
    private static final String SEPARATOR = ",";

    @Override
    public List<String> getList(String text) {
        return Arrays.stream(text.split(SEPARATOR)).collect(Collectors.toList());
    }
}
