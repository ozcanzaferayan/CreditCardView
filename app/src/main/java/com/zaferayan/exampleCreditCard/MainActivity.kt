package com.zaferayan.exampleCreditCard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zaferayan.creditcard.view.CreditCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.myBtn);
        var creditCardView = findViewById<CreditCardView>(R.id.ccView)
        btn.setOnClickListener({ v ->
            var creditCard = creditCardView.creditCardInfo
        })
    }
}
