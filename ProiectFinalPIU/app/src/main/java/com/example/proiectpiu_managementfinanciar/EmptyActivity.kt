package com.example.proiectpiu_managementfinanciar

import android.os.Bundle
import android.widget.TextView
import android.widget.LinearLayout
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(Color.WHITE)

        val textView = TextView(this)
        textView.text = "Hello"
        textView.setTextColor(Color.BLACK)
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        layout.addView(textView)

        setContentView(layout)
    }
}
