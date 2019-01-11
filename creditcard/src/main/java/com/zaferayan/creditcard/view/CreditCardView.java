package com.zaferayan.creditcard.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zaferayan.creditcard.R;
import com.zaferayan.creditcard.listener.CcClickListener;
import com.zaferayan.creditcard.listener.CcKeyListener;
import com.zaferayan.creditcard.listener.CcNameToFocusMonthEditorActionListener;
import com.zaferayan.creditcard.model.CreditCard;

import static com.zaferayan.creditcard.util.AnimUtil.changeCameraDistance;
import static com.zaferayan.creditcard.util.AnimUtil.createAnimator;
import static com.zaferayan.creditcard.util.CreditCardBackgroundUtil.setCreditCardBackground;
import static com.zaferayan.creditcard.util.CreditCardTypeDetectorUtil.detectCardType;
import static com.zaferayan.creditcard.util.KeyboardUtil.focusKeyboard;

public class CreditCardView extends FrameLayout {
    public EditText etCcNumber1;
    public EditText etCcNumber2;
    public EditText etCcNumber3;
    public EditText etCcNumber4;
    public EditText etCcName;
    public EditText etCcExpireMonth;
    public EditText etCcExpireYear;
    public EditText etCvv;
    ImageView imgCcLogo;
    ImageView imgCcFrontBackground;
    ImageView imgCcBackBackground;
    LinearLayout cardFront;
    LinearLayout cardBack;
    View flControlCreditCard;
    CcClickListener ccClickListener;
    private AnimatorSet setRightOut;
    private AnimatorSet setLeftIn;
    private boolean isBackVisible = false;
    private View cardFrontLayout;
    private View cardBackLayout;

    public CreditCardView(Context context) {
        super(context);
    }

    public CreditCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
    }

    public CreditCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context, attrs);
    }

    public CreditCard getCreditCardInfo() {
        String number = etCcNumber1.getText().toString()
                + etCcNumber2.getText().toString()
                + etCcNumber3.getText().toString()
                + etCcNumber4.getText().toString();
        String name = etCcName.getText().toString();
        String expirationMonth = etCcExpireMonth.getText().toString();
        String expirationYear = etCcExpireYear.getText().toString();
        String cvv = etCvv.getText().toString();
        return new CreditCard(number, name, expirationMonth, expirationYear, cvv);
    }

    private void initControl(Context context, AttributeSet attrs) {

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.control_credit_card, this);
        bindViews();
        loadAnimations();
        ccClickListener = new CcClickListener(isBackVisible, setRightOut, setLeftIn, cardFrontLayout, cardBackLayout);
        changeCameraDistance(cardFrontLayout, cardBackLayout);
        focusKeyboard(etCcNumber1);
        setCreditCardBackground(imgCcFrontBackground, imgCcBackBackground);
        setCcNumberListeners();
    }

    private void setCcNumberListeners() {
        etCcNumber1.setOnKeyListener(new CcKeyListener(etCcNumber1, etCcNumber2, ccClickListener));
        etCcNumber2.setOnKeyListener(new CcKeyListener(etCcNumber1, etCcNumber3, ccClickListener));
        etCcNumber3.setOnKeyListener(new CcKeyListener(etCcNumber2, etCcNumber4, ccClickListener));
        etCcNumber4.setOnKeyListener(new CcKeyListener(etCcNumber3, etCcName, ccClickListener));
        etCcName.setOnKeyListener(new CcKeyListener(etCcNumber4, etCcName, ccClickListener));
        etCcExpireMonth.setOnKeyListener(new CcKeyListener(etCcName, etCcExpireYear, ccClickListener));
        etCcExpireYear.setOnKeyListener(new CcKeyListener(etCcExpireMonth, etCvv, ccClickListener));
        etCvv.setOnKeyListener(new CcKeyListener(etCcExpireYear, new View(getContext()), ccClickListener));
        etCcName.setOnEditorActionListener(new CcNameToFocusMonthEditorActionListener(etCcExpireMonth));
        detectCardType(etCcNumber1, imgCcFrontBackground, imgCcBackBackground, imgCcLogo);
    }

    private void loadAnimations() {
        setRightOut = createAnimator(getContext(), R.animator.out_animation);
        setLeftIn = createAnimator(getContext(), R.animator.in_animation);
    }

    private void bindViews() {
        flControlCreditCard = findViewById(R.id.flControlCreditCard);
        cardBackLayout = findViewById(R.id.card_back);
        cardFrontLayout = findViewById(R.id.card_front);
        etCcNumber1 = findViewById(R.id.etCcNumber1);
        etCcNumber2 = findViewById(R.id.etCcNumber2);
        etCcNumber3 = findViewById(R.id.etCcNumber3);
        etCcNumber4 = findViewById(R.id.etCcNumber4);
        etCcName = findViewById(R.id.etCcName);
        etCcExpireMonth = findViewById(R.id.etCcExpireMonth);
        etCcExpireYear = findViewById(R.id.etCcExpireYear);
        etCvv = findViewById(R.id.etCcCvv);
        imgCcLogo = findViewById(R.id.imgCcLogo);
        imgCcFrontBackground = findViewById(R.id.imgCcFrontBackground);
        imgCcBackBackground = findViewById(R.id.imgCcBackBackground);
        cardFront = findViewById(R.id.ll_cc_front);
        cardBack = findViewById(R.id.ll_cc_back);
        flControlCreditCard.setOnClickListener(ccClickListener);
    }

}
