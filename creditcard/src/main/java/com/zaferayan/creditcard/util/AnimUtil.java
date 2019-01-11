package com.zaferayan.creditcard.util;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import com.zaferayan.creditcard.config.Constants;

public class AnimUtil {
    public static void changeCameraDistance(View cardFrontLayout, View cardBackLayout) {
        int distance = Constants.ANIM_DISTANCE;
        DisplayMetrics displayMetrics = cardFrontLayout.getResources().getDisplayMetrics();
        float scale = displayMetrics.density * distance;
        cardFrontLayout.setCameraDistance(scale);
        cardBackLayout.setCameraDistance(scale);
    }

    public static AnimatorSet createAnimator(Context context, int resAnimation) {
        return (AnimatorSet) AnimatorInflater.loadAnimator(context, resAnimation);
    }
}
