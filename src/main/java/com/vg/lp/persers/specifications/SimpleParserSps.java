package com.vg.lp.persers.specifications;

import com.vg.lp.datalayer.data.Specifications;
import com.vg.lp.datalayer.data.word.TypeWord;

import java.util.*;

public class SimpleParserSps implements ParserSps {

    private boolean isSpecNull(String spec){
        return Objects.isNull(spec);
    }

    private void addSpec(String key, String spec, Map<String, String> sp){
        if (!isSpecNull(spec)){
            sp.put(key, spec);
        }
    }

    @Override
    public List<Map<String, String>> getSpes(List<Specifications> sps) {
        List<Map<String, String>> spes = new ArrayList<>();

        sps.forEach(specification -> {
            Map<String, String> sp = new HashMap<>();

            addSpec("од/неод", specification.getOd(), sp);
            addSpec("число", specification.getChislo(), sp);
            addSpec("род", specification.getRod(), sp);
            addSpec("падеж", specification.getPadezh(), sp);
            addSpec("форма", specification.getForma(), sp);
            addSpec("вид", specification.getVid(), sp);
            addSpec("время", specification.getTime(), sp);

            spes.add(sp);
        });

        return spes;
    }

    @Override
    public TypeWord getTypeWord(List<Specifications> sps) {
        return TypeWord.findByKey(sps.get(0).getChR());
    }
}
