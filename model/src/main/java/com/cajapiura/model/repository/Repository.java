package com.cajapiura.model.repository;

import com.cajapiura.model.entity.TramaEntity;

import rx.Observable;

/**
 * Created by Junior on 16/12/2016.
 */

public interface Repository {
    Observable<TramaEntity> getTrama (final String trama);
}
