package com.cajapiura.cajapiurasmart.mvp.views;

import com.cajapiura.model.entity.TramaEntity;

import java.util.List;

/**
 * Created by Junior on 14/12/2016.
 */

@SuppressWarnings("unused")
public interface AutenticacionView extends View {

    void bindCharacterList(TramaEntity trama);

    void showLoadingView();

    void hideLoadingView();

    void hideLoadingIndicator();

    void showEmptyIndicator();

    void hideEmptyIndicator();

    void showConnectionErrorMessage();

    void showLightError();

    void hideErrorView();

    void showUknownErrorMessage();

    void showFragmentCoordenadas();

    void showCuentasScreen(String trama);

    void sendTrama(String trama);

}
