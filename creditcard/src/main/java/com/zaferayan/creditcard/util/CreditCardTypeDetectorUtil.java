package com.zaferayan.creditcard.util;

import android.widget.EditText;
import android.widget.ImageView;
import com.zaferayan.creditcard.listener.CcDetectorTextWatcher;

public class CreditCardTypeDetectorUtil {
    public static void detectCardType(EditText etCcNumber, ImageView imgCcFrontBackground, ImageView imgCcBackBackground, ImageView imgCcLogo) {
        CcDetectorTextWatcher watcher = new CcDetectorTextWatcher(imgCcFrontBackground, imgCcBackBackground, imgCcLogo);
        etCcNumber.addTextChangedListener(watcher);
    }
}
