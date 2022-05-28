package com.example.cw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addmovie = findViewById<Button>(R.id.addtodata)
        addmovie.setOnClickListener{
            val Intent = Intent(this,AddMovie::class.java)
            startActivity(Intent)
        }

        val searchmovie = findViewById<Button>(R.id.search)
        searchmovie.setOnClickListener{
            val Intent = Intent(this,SearchMovie::class.java)
            startActivity(Intent)
        }

        val sactor = findViewById<Button>(R.id.sactor)
        sactor.setOnClickListener{
            val Intent = Intent(this,SearchActor::class.java)
            startActivity(Intent)
        }
    }
}