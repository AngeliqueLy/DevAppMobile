package com.example.newlist
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        setTitle(getLocalClassName())

        val login = findViewById<Button>(R.id.button1)

        val logname = findViewById<EditText>(R.id.text1)






        // Au click du bouton login on va à l'activité NewsActivity puis on détruit l'activité
        login.setOnClickListener {
            val app = (applicationContext as NewsListApplication)
            app.login = logname.getText().toString()
            val name = app.login

            val intent = Intent(this, NewsActivity::class.java)
            intent.putExtra("log", name)
            startActivity(intent)

        }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        //TODO
    }

    }



