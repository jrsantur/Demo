package com.cajapiura.cajapiurasmart.utils;

import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;

/**
 * Created by Junior on 14/12/2016.
 */

public class TransitionUtils{

        public static Transition buildExplodeTransition (Integer... exlcudeIds) {
            Explode explodeTransition = new Explode();
            excludeTransitionIds(explodeTransition, exlcudeIds);
            return  explodeTransition;
        }

        public static Transition buildSlideTransition (int gravity, Integer... excludeIds) {
            Slide explodeTransition = new Slide();
            excludeTransitionIds(explodeTransition, excludeIds);
            return  explodeTransition;
        }

        private static void excludeTransitionIds(Transition transition, Integer[] exlcudeIds) {
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            transition.excludeTarget(android.R.id.navigationBarBackground, true);

            for (Integer exlcudeId : exlcudeIds) {
                transition.excludeTarget(exlcudeId, true);
            }
        }
}
