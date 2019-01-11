package com.zaferayan.creditcard.util;

import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import com.zaferayan.creditcard.R;
import com.zaferayan.creditcard.drawable.TileDrawable;

public class CreditCardBackgroundUtil {
    public static void setCreditCardBackground(ImageView imgCcFrontBackground, ImageView imgCcBackBackground) {
        Drawable d = ContextCompat.getDrawable(imgCcBackBackground.getContext(), R.drawable.pattern_empty_cc);
        imgCcFrontBackground.setImageDrawable(new TileDrawable(d, Shader.TileMode.REPEAT));
        imgCcBackBackground.setImageDrawable(new TileDrawable(d, Shader.TileMode.REPEAT));
    }
}
