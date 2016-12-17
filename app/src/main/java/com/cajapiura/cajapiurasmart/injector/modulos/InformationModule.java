package com.cajapiura.cajapiurasmart.injector.modulos;



import com.cajapiura.cajapiurasmart.injector.Activity;
import com.cajapiura.domain.GetTramaUsecase;
import com.cajapiura.model.repository.Repository;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by Junior on 16/12/2016.
 */
@Module
public class InformationModule {
    private final String trama;

    public InformationModule(String trama){
        this.trama = trama;
    }
    @Provides @Activity public GetTramaUsecase providerGetTramaUsecase(Repository repository,
                                            @Named("ui_thread") Scheduler uiThread,
                                            @Named("executor_thread") Scheduler executorThread){
        return new GetTramaUsecase(trama, repository , uiThread, executorThread );

    }
}
