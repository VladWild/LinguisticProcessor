package com.vg.lp.datalayer;

import com.vg.lp.datalayer.data.Specifications;

import java.util.List;

public interface InformationDAO {
    List<Specifications> getSpecifications(List<Integer> ids);
}
