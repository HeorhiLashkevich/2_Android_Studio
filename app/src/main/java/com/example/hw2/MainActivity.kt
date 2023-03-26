package com.example.hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var button: Button
    private var countOfHello = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        val b = Bundle()
        val i = Intent(this@MainActivity, HelloActivity::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.hello_counts)
        button = findViewById(R.id.say_hello)
        button.setOnClickListener {
            countOfHello++
            b.putString("helloCount", countOfHello.toString())
            i.putExtras(b)
            startActivity(i)
            text.text = countOfHello.toString()
        }
    }
}