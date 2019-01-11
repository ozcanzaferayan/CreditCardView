package com.zaferayan.creditcard.listener;

import android.animation.AnimatorSet;
import android.view.View;

public class CcClickListener implements View.OnClickListener {
    private boolean isBackVisible;
    private AnimatorSet setRightOut;
    private AnimatorSet setLeftIn;
    private View cardFrontLayout;
    private View cardBackLayout;

    public CcClickListener(boolean isBackVisible, AnimatorSet setRightOut, AnimatorSet setLeftIn, View cardFrontLayout, View cardBackLayout) {
        this.isBackVisible = isBackVisible;
        this.setRightOut = setRightOut;
        this.setLeftIn = setLeftIn;
        this.cardFrontLayout = cardFrontLayout;
        this.cardBackLayout = cardBackLayout;
    }

    public void triggerClick(){
        onClick(null);
    }

    @Override
    public void onClick(View view) {
        if (!isBackVisible) {
            setRightOut.setTarget(cardFrontLayout);
            setLeftIn.setTarget(cardBackLayout);
            setRightOut.start();
            setLeftIn.start();
            isBackVisible = true;
        } else {
            setRightOut.setTarget(cardBackLayout);
            setLeftIn.setTarget(cardFrontLayout);
            setRightOut.start();
            setLeftIn.start();
            isBackVisible = false;
        }
    }
}
