package com.cajapiura.cajapiurasmart.injector;

/**
 * Created by Junior on 14/12/2016.
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Scope @Retention(RUNTIME)
public @interface Activity {
}
