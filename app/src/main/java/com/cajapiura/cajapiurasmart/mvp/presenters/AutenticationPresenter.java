package com.cajapiura.cajapiurasmart.mvp.presenters;

import com.cajapiura.cajapiurasmart.mvp.views.AutenticacionView;
import com.cajapiura.cajapiurasmart.mvp.views.View;
import com.cajapiura.domain.GetTramaUsecase;
import com.cajapiura.model.entity.TramaEntity;
import rx.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Junior on 16/12/2016.
 */

public class AutenticationPresenter  implements Presenter {

    private final GetTramaUsecase getTramaUsecase;
    private boolean mIsTheTramaRequestRunning;
    private Subscription mTramaSubscription;
    private TramaEntity tramaEntities = new TramaEntity();
    private AutenticacionView autenticacionView;

    @Inject
    public AutenticationPresenter(GetTramaUsecase getTramaUsecase){
        this.getTramaUsecase = getTramaUsecase;
    }

    @Override
    public void onCreate() {
        askForTrama();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {
        autenticacionView.hideEmptyIndicator();
        mTramaSubscription.unsubscribe();
        mIsTheTramaRequestRunning = false;
    }

    @Override
    public void attachView(View v) {

    }

    public void askForTrama(){
        mIsTheTramaRequestRunning = true;
        autenticacionView.hideErrorView();
        autenticacionView.showLoadingView();

        mTramaSubscription = (Subscription) getTramaUsecase.execute().subscribe(this::onTramaRecived , this::showErrorView);
    }


    public void onTramaRecived(TramaEntity trama){
        trama = trama ;
        autenticacionView.bindCharacterList(trama);
        autenticacionView.showFragmentCoordenadas();
        autenticacionView.hideEmptyIndicator();
        mIsTheTramaRequestRunning = false;
    }

    public void showErrorView(Throwable error){
        autenticacionView.showUknownErrorMessage();
        autenticacionView.hideEmptyIndicator();
    }
    public void showGenericError() {
        autenticacionView.hideLoadingIndicator();
        autenticacionView.showLightError();
    }

    public void onErrorRetryRequest() {
        if (tramaEntities.getTrama().isEmpty() )
            askForTrama();
    }



}
