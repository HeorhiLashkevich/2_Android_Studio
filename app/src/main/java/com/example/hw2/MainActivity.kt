package com.example.hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat


class MainActivity : AppCompatActivity() {
    private lateinit var editWebsite: EditText
    private lateinit var buttonWebsite: Button
    private lateinit var editLocation: EditText
    private lateinit var buttonLocation: Button
    private lateinit var editShare: EditText
    private lateinit var buttonShare: Button
    private lateinit var buttonTakeAPicture: Button

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editWebsite = findViewById(R.id.websiteEditText)
        editLocation = findViewById(R.id.openLocationEditText)
        editShare = findViewById(R.id.shareThisTextEditText)
        buttonLocation = findViewById(R.id.openLocation)
        buttonShare = findViewById(R.id.shareThisText)
        buttonTakeAPicture = findViewById(R.id.takeAPicture)
        buttonWebsite = findViewById(R.id.openWebsite)

        buttonWebsite.setOnClickListener {

            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(editWebsite.text.toString())
            startActivity(openURL)
        }
        buttonLocation.setOnClickListener {
            val location = editLocation.text.toString()
            val locationUri = Uri.parse("geo:0,0?q=$location")
            val intentLocation = Intent(Intent.ACTION_VIEW, locationUri)
            if (intentLocation.resolveActivity(packageManager) != null) {
                startActivity(intentLocation);
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!");
            }
        }
        buttonShare.setOnClickListener {

            val txt = editShare.text.toString()
            val mimeType = "text/plain";
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(getString(R.string.share_this_text_with))
                .setText(txt)
                .startChooser();
        }



    }
}




