package com.cajapiura.model.repository.wrappers;

import com.cajapiura.model.entity.TramaEntity;

import java.util.List;

/**
 * Created by Junior on 16/12/2016.
 */

public class TramaDataWrapper {
    private int count;
    private List<TramaEntity> results;

    public int getCount() {

        return count;
    }

    public List<TramaEntity> getResults() {

        return results;
    }
}
