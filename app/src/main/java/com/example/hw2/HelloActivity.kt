package com.example.hw2

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hw2.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        text = findViewById(R.id.count)
        val extras = intent.extras
        val countFromBundle = extras?.getString("helloCount")
        text.text = countFromBundle.toString()

    }
}