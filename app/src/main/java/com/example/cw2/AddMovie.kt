package com.example.cw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AddMovie : AppCompatActivity() {
    lateinit var movname: EditText
    lateinit var movyear: EditText
    lateinit var movrate: EditText
    lateinit var movreleased: EditText
    lateinit var movruntime: EditText
    lateinit var movgenre: EditText
    lateinit var movdirector: EditText
    lateinit var movwriter: EditText
    lateinit var movactor: EditText
    lateinit var movplot: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        movname = findViewById(R.id.movname)
        movyear = findViewById(R.id.movyear)
        movrate = findViewById(R.id.movrate)
        movreleased = findViewById(R.id.movreleased)
        movruntime = findViewById(R.id.movruntime)
        movgenre = findViewById(R.id.movgenre)
        movdirector = findViewById(R.id.movdirector)
        movwriter = findViewById(R.id.movwriter)
        movactor = findViewById(R.id.movactor)
        movplot = findViewById(R.id.movplot)

        val insert = findViewById<Button>(R.id.insertmov)

        insert.setOnClickListener{
            if(!movname.text.isEmpty() && !movyear.text.isEmpty() && !movrate.text.isEmpty() && !movreleased.text.isEmpty() && !movruntime.text.isEmpty() && !movgenre.text.isEmpty() && !movdirector.text.isEmpty() && !movwriter.text.isEmpty()&& !movactor.text.isEmpty()&& !movplot.text.isEmpty()){
                val userinfo = User(null,movname.text.toString(),movyear.text.toString(),movrate.text.toString(),movreleased.text.toString(),movruntime.text.toString(),movgenre.text.toString(),movdirector.text.toString(),movwriter.text.toString(),movactor.text.toString(),movplot.text.toString())
                runBlocking {
                    launch(Dispatchers.IO) {
                        Userdatabase.getINSTANCE(this@AddMovie).userdao().insert(userinfo)
                    }
                }
                    Toast.makeText(this,"Save Insert data", Toast.LENGTH_SHORT).show()
            }else{
                    Toast.makeText(this,"Insert data", Toast.LENGTH_SHORT).show()
            }
        }

        if (savedInstanceState != null) {
            movname.setText(savedInstanceState.getString("name"))
            movyear.setText(savedInstanceState.getString("year"))
            movrate.setText(savedInstanceState.getString("rate"))
            movreleased.setText(savedInstanceState.getString("released"))
            movruntime.setText(savedInstanceState.getString("runtime"))
            movgenre.setText(savedInstanceState.getString("genre"))
            movdirector.setText(savedInstanceState.getString("director"))
            movwriter.setText(savedInstanceState.getString("writer"))
            movactor.setText(savedInstanceState.getString("actor"))
            movplot.setText(savedInstanceState.getString("plot"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name",movname.toString())
        outState.putString("year",movyear.toString())
        outState.putString("rate",movrate.toString())
        outState.putString("released",movreleased.toString())
        outState.putString("runtime",movruntime.toString())
        outState.putString("genre",movgenre.toString())
        outState.putString("director",movdirector.toString())
        outState.putString("writer",movwriter.toString())
        outState.putString("actor",movactor.toString())
        outState.putString("plot",movplot.toString())
    }
}

// references

// https://youtu.be/bhfB6rgMf0g
// lecture 6 and the lecture recording for Database with Room library