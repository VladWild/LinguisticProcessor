package com.vg.lp.persers.specifications;

import com.vg.lp.datalayer.data.Specifications;
import com.vg.lp.datalayer.data.word.TypeWord;

import java.util.List;
import java.util.Map;

public interface ParserSps {
    List<Map<String, String>> getSpes(List<Specifications> sps);
    TypeWord getTypeWord(List<Specifications> sps);
}
