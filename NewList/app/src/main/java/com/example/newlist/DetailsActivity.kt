package com.example.newlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.os.FileUtils;
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setTitle(getLocalClassName());

        val ok = findViewById<Button>(R.id.buttonok)
        val intent3 = Intent(this, NewsActivity::class.java)
        val app = (applicationContext as NewsListApplication)
        val nomaffd = findViewById<TextView>(R.id.texteviewd)
        nomaffd.setText("Bienvenue"+ " " +app.login)
        ok.setOnClickListener{

        startActivity(intent3)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        //TODO
    }
}