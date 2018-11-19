package com.vg.lp.persers.specifications;

import com.vg.lp.datalayer.data.Specifications;
import com.vg.lp.datalayer.data.word.TypeWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleParserSps implements ParserSps {
    @Override
    public List<Map<String, String>> getSpes(List<Specifications> sps) {
        List<Map<String, String>> spes = new ArrayList<>();

        sps.forEach(specifications -> {
            Map<String, String> sp = new HashMap<>();
            sp.put("од/неод", specifications.getOd());
            sp.put("число", specifications.getChislo());
            sp.put("род", specifications.getRod());
            sp.put("падеж", specifications.getPadezh());

            spes.add(sp);
        });

        return spes;
    }

    @Override
    public TypeWord getTypeWord(List<Specifications> sps) {
        return TypeWord.findByKey(sps.get(0).getChR());
    }
}
