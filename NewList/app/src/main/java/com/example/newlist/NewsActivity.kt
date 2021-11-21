package com.example.newlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setTitle(getLocalClassName())


    val details = findViewById<Button>(R.id.buttond)
    val logout = findViewById<Button>(R.id.buttonout)
    val about = findViewById<Button>(R.id.buttonurl)
    val intent1 = Intent(this, DetailsActivity::class.java)
    val intent2 = Intent(this, LoginActivity::class.java)
    val nomaff = findViewById<TextView>(R.id.texteview)
    val intent3 = getIntent()



           if (intent3.hasExtra("log")) {
                val logg = intent3.getStringExtra("log")
                nomaff.text = "Bonjour"+" " +logg }


    details.setOnClickListener {

        startActivity(intent1)
    }

    logout.setOnClickListener {

            startActivity(intent2)

        }
    about.setOnClickListener{

        val url = "https://news.google.com/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }


    }


    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        //TODO
    }



}

