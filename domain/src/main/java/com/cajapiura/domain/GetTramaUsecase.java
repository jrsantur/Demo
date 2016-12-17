package com.cajapiura.domain;

import com.cajapiura.model.entity.TramaEntity;
import com.cajapiura.model.repository.Repository;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Junior on 16/12/2016.
 */

public class GetTramaUsecase  extends Usecase<TramaEntity> {
    public final static int DEFAULT_TRAMA_LIMIT = 20;
    private int mTramaLimit = DEFAULT_TRAMA_LIMIT;
    private final Repository mRepository;
    private String mTrama;

    //String trama = trama;

    private final Scheduler mUiThread;
    private final Scheduler mExecutorThread;

    @Inject
    public GetTramaUsecase(String trama,
                           Repository repository,
                           @Named("ui_thread") Scheduler uiThread,
                           @Named("executor_thread") Scheduler executorThread) {
        mTrama = trama;
        mRepository = repository;
        mUiThread = uiThread;
        mExecutorThread = executorThread;
    }


    @Override
    public Observable<TramaEntity> buildObservable() {
        return mRepository.getTrama(mTrama)
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread);
    }
}
