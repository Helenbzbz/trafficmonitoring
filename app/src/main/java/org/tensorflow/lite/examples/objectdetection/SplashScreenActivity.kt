package org.tensorflow.lite.examples.objectdetection

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val textView: TextView = findViewById(R.id.splash_text)
        val spannableString = SpannableString(textView.text)

        val whiteSpan = ForegroundColorSpan(Color.WHITE)
        val magentaSpan = ForegroundColorSpan(Color.MAGENTA)

// Apply white color to "Panda"
        spannableString.setSpan(whiteSpan, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
// Apply magenta color to "Cam"
        spannableString.setSpan(magentaSpan, 5, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)

        textView.text = spannableString

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_SCREEN_TIME_OUT)
    }

    companion object{
        private const val SPLASH_SCREEN_TIME_OUT = 3000L
    }
}