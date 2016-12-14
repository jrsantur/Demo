package com.cajapiura.cajapiurasmart.utils;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by Junior on 14/12/2016.
 */

public class DatabindingUtils {
    @BindingAdapter({"app:onClick"})
    public static void bindOnClick(View view, final Runnable runnable) {
        view.setOnClickListener(v -> runnable.run());
    }
}
