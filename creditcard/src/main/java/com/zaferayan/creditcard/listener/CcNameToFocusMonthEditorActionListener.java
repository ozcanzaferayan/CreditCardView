package com.zaferayan.creditcard.listener;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import static com.zaferayan.creditcard.util.KeyboardUtil.focusKeyboard;

public class CcNameToFocusMonthEditorActionListener implements TextView.OnEditorActionListener {

    private final EditText etCcExpireMonth;

    public CcNameToFocusMonthEditorActionListener(EditText etCcExpireMonth) {
        this.etCcExpireMonth = etCcExpireMonth;
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            focusKeyboard(etCcExpireMonth);
            return true;
        }
        return false;
    }
}
