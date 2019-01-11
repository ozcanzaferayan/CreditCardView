package com.zaferayan.creditcard.listener;

import android.content.Context;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.zaferayan.creditcard.R;
import com.zaferayan.creditcard.drawable.TileDrawable;

public class CcDetectorTextWatcher implements TextWatcher {

    private final ImageView imgFrontBackground;
    private final ImageView imgBackBackground;
    private final ImageView imgCardLogo;

    public CcDetectorTextWatcher(ImageView imgFrontBackground, ImageView imgBackBackground, ImageView imgCcLogo) {
        this.imgFrontBackground = imgFrontBackground;
        this.imgBackBackground = imgBackBackground;
        this.imgCardLogo = imgCcLogo;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editable.toString();
        Context context = imgCardLogo.getContext();
        Drawable drawableCard;
        int cardResId;
        int cardLogoResId;
        if (text.startsWith("97")) {
            cardLogoResId = R.drawable.ic_cc_troy;
            cardResId = R.drawable.pattern_troy;
        } else if (text.matches("^(5[1-5]|677189).*|^(222[1-9]|2[3-6]\\d{2}|27[0-1]\\d|2720).*")) {
            cardLogoResId = R.drawable.ic_cc_mastercard;
            cardResId = R.drawable.pattern_mastercard;
        } else if (text.startsWith("4")) {
            cardLogoResId = R.drawable.ic_cc_visa;
            cardResId = R.drawable.pattern_visa;
        } else {
            cardLogoResId = R.color.transparent;
            cardResId = R.drawable.pattern_empty_cc;
        }
        drawableCard = ContextCompat.getDrawable(context, cardResId);
        imgFrontBackground.setImageDrawable(new TileDrawable(drawableCard, Shader.TileMode.REPEAT));
        imgBackBackground.setImageDrawable(new TileDrawable(drawableCard, Shader.TileMode.REPEAT));
        imgCardLogo.setImageResource(cardLogoResId);
    }
}
