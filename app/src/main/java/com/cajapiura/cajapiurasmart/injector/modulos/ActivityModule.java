package com.cajapiura.cajapiurasmart.injector.modulos;

import android.content.Context;

import com.cajapiura.cajapiurasmart.injector.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Junior on 14/12/2016.
 */

@Module
public class ActivityModule {
    private final Context mContext;

    public ActivityModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides @Activity
    Context provideActivityContext() {
        return mContext;
    }
}
