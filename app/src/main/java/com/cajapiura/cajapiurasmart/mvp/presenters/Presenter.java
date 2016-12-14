package com.cajapiura.cajapiurasmart.mvp.presenters;

import com.cajapiura.cajapiurasmart.mvp.views.View;

/**
 * Created by Junior on 14/12/2016.
 */

public interface Presenter {

    void onStart();

    void onStop();

    void onPause();

    void attachView (View v);

    void onCreate();
}
