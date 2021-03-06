[![](https://jitpack.io/v/ozcanzaferayan/CreditCardView.svg)](https://jitpack.io/#ozcanzaferayan/CreditCardView)

# CreditCardView
Android CreditCardView for filling credit card information.

![CreditCardView in action](https://github.com/ozcanzaferayan/CreditCardView/raw/master/screenshots/video.gif "CreditCardView in action")

## Download
### Gradle

1. Add Jitpack to respositories section

```gradle
allprojects {
  repositories {
   ...
   maven { url 'https://jitpack.io' }
  }
 }
```

2. Add the dependency

```gradle
dependencies {
     ...
     implementation 'com.github.ozcanzaferayan:CreditCardView:0.1.0'
     ...
 }
```

## Usage
### XML
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:context=".MainActivity"
        android:orientation="vertical">

    <com.zaferayan.creditcard.view.CreditCardView
            android:id="@+id/ccView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp">

    </com.zaferayan.creditcard.view.CreditCardView>
    <Button
            android:id="@+id/myBtn"
            android:layout_width="match_parent" android:layout_height="wrap_content"
            android:background="@color/colorPrimary"
            android:textColor="@color/md_white_1000"
            android:text="@string/pay_with_credit_card"/>

</LinearLayout>
```
### Kotlin

```kotlin
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
```
## License
```license
MIT License

Copyright (c) 2019 Özcan Zafer AYAN

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
