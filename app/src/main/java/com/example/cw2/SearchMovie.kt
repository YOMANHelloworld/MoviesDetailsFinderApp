package com.example.cw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SearchMovie : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var searchmov: EditText
    lateinit var search: Button
    lateinit var savemoviedb: Button
    lateinit var str:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)
        tv = findViewById(R.id.tv)
        searchmov = findViewById(R.id.searchmov)
        savemoviedb = findViewById(R.id.savemoviedb)
        search = findViewById(R.id.search)
        val target = " "

        search.setOnClickListener {
            if (!searchmov.text.isEmpty()) {
                str = searchmov.text.toString()
                str = str.replace(target, "+")

                parseJSON(str)
            }else {
                Toast.makeText(this, "Please Insert data", Toast.LENGTH_SHORT).show()
            }
        }

        savemoviedb.setOnClickListener{
            if (!searchmov.text.isEmpty()) {
                str = searchmov.text.toString()
                str = str.replace(target, "+")

                parseJSONADD(str)
            }else {
                Toast.makeText(this, "Please Insert data", Toast.LENGTH_SHORT).show()
            }
        }

        if (savedInstanceState != null) {
            tv.setText(savedInstanceState.getString("Info"))
            searchmov.setText(savedInstanceState.getString("searchmov"))
        }
    }

    fun parseJSON(s1: String) {

        var stb = StringBuilder()
        val url_string = "https://www.omdbapi.com/?t=${s1}&apikey=d4d6c03a";
        Log.i("test link work",url_string)
        val url = URL(url_string)
        val con: HttpURLConnection = url.openConnection() as HttpURLConnection
        runBlocking {
            launch {
                withContext(Dispatchers.IO) {
                    var bf = BufferedReader(InputStreamReader(con.inputStream))
                    var line: String? = bf.readLine()
                    while (line != null) {
                        stb.append(line + "\n")
                        line = bf.readLine()
                    }
                }
            }
        }

        val json = JSONObject(stb.toString())

        var movies = java.lang.StringBuilder()

        val Title = json.getString("Title")
        val Year = json.getString("Year")
        val Rated = json.getString("Rated")
        val Released = json.getString("Released")
        val Runtime = json.getString("Runtime")
        val Genre = json.getString("Genre")
        val Director = json.getString("Director")
        val Writer = json.getString("Writer")
        val Actors = json.getString("Actors")
        val Plot = json.getString("Plot")

        movies.append("${"Title"} :\"$Title\" ")
        movies.append("\n${"Year"} :\"$Year\" ")
        movies.append("\n${"Rated"} :\"$Rated\" ")
        movies.append("\n${"Released"} :\"$Released\" ")
        movies.append("\n${"Runtime"} :\"$Runtime\" ")
        movies.append("\n${"Genre"} :\"$Genre\" ")
        movies.append("\n${"Director"} :\"$Director\" ")
        movies.append("\n${"Writer"} :\"$Writer\" ")
        movies.append("\n${"Actors"} :\"$Actors\" ")
        movies.append("\n${"Plot"} :\"$Plot\" ")

        tv.setText(movies)
        Log.i("test string works",tv.text.toString())
    }

    fun parseJSONADD(s1: String) {

        var stb = StringBuilder()
        val url_string = "https://www.omdbapi.com/?t=${s1}&apikey=d4d6c03a";
        Log.i("test link work",url_string)
        val url = URL(url_string)
        val con: HttpURLConnection = url.openConnection() as HttpURLConnection
        runBlocking {
            launch {
                withContext(Dispatchers.IO) {
                    var bf = BufferedReader(InputStreamReader(con.inputStream))
                    var line: String? = bf.readLine()
                    while (line != null) {
                        stb.append(line + "\n")
                        line = bf.readLine()
                    }
                }
            }
        }

        val json = JSONObject(stb.toString())

        val Title = json.getString("Title")
        val Year = json.getString("Year")
        val Rated = json.getString("Rated")
        val Released = json.getString("Released")
        val Runtime = json.getString("Runtime")
        val Genre = json.getString("Genre")
        val Director = json.getString("Director")
        val Writer = json.getString("Writer")
        val Actors = json.getString("Actors")
        val Plot = json.getString("Plot")

        val userinfo = User(null,Title,Year,Rated,Released,Runtime,Genre,Director,Writer,Actors,Plot)
        runBlocking {
            launch(Dispatchers.IO) {
                Userdatabase.getINSTANCE(this@SearchMovie).userdao().insert(userinfo)
            }
        }
        Toast.makeText(this,"Save Insert data", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Info",tv.text.toString())
        outState.putString("searchmov",searchmov.text.toString())
    }
}

// references

// lecture 7 and the lecture recording for Network Connectivity and Background Tasks
