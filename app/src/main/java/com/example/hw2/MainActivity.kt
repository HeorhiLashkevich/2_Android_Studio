package com.example.hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button
    private var countOfHello = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.count)
        text = findViewById(R.id.counts)
        editText = findViewById(R.id.editText)
        button.setOnClickListener {
            countOfHello++
            text.text = countOfHello.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, countOfHello)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countOfHello = savedInstanceState.getInt(KEY)
        text.text = countOfHello.toString()
    }

    companion object {
        const val KEY = "KEY"
    }

}
