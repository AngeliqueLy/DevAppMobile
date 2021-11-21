package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.button1)

        val text1 = findViewById<TextView>(R.id.textView1)
        val text2 = findViewById<TextView>(R.id.textView2)

        val text3 = findViewById<EditText>(R.id.edittext)


        rollButton.setOnClickListener {

            val nbfacetext = text3.getText().toString() //on récupère ce que l'utilisateur a tapé
            try {
                val nbface = nbfacetext.toInt()
                // on transforme le string en int
                val rand1 = (1..nbface).random() // On prend un nombre compris entre 1 et 6
                val random1 = rand1.toString() // on le convertit en string
                text1.setText(random1) // On change le texte de textview pour afficher le nombre tiré
                // Idem pour le deuxième lancé
                val rand2 = (1..nbface).random()
                val random2 = rand2.toString()
                text2.setText(random2)
            }
            //Si l'utilisateur n'a pas entré un nombre dans le champ
            catch (e: Exception) {
                Toast.makeText(applicationContext, "Veuillez remplir correctement le champ", Toast.LENGTH_SHORT).show()
            }



        }

    }
}