package com.zaferayan.creditcard.listener;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.zaferayan.creditcard.R;

public class CcKeyListener implements View.OnKeyListener {

    private final View beforeView;
    private final View afterView;
    private final CcClickListener ccClickListener;

    public CcKeyListener(View beforeView, View afterView, CcClickListener listener) {
        this.beforeView = beforeView;
        this.afterView = afterView;
        this.ccClickListener = listener;
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (!(view instanceof EditText)) return false;
        EditText editText = (EditText) view;
        Context context = editText.getContext();
        int charCount = editText.length();
        int editTextId = editText.getId();
        if (editTextId == R.id.etCcExpireYear && charCount == 2) {
            ccClickListener.triggerClick();
        }
        if (editTextId == R.id.etCcCvv && charCount == 3) {
            ccClickListener.triggerClick();
            hideKeyboard(afterView);
        }

        if (charCount == 0 && keyCode == KeyEvent.KEYCODE_DEL) {
            beforeView.requestFocus();
        } else if ((editTextId == R.id.etCcExpireMonth || editTextId == R.id.etCcExpireYear) && charCount == 2){
            afterView.requestFocus();
        } else if (editTextId == R.id.etCcCvv && charCount == 3){
            afterView.requestFocus();
        } else if (charCount == 4 && keyCode != KeyEvent.KEYCODE_DEL && editTextId != R.id.etCcName) {
            afterView.requestFocus();
        }
        return false;
    }


    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
