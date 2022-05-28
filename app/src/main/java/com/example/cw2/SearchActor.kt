package com.example.cw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SearchActor : AppCompatActivity() {
    lateinit var search: Button
    lateinit var tv: TextView
    lateinit var searchactor: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_actor)
        search = findViewById(R.id.search)
        tv = findViewById(R.id.tv)
        searchactor = findViewById(R.id.searchactor)

        search.setOnClickListener {
            lateinit var allUser :List<User>
            val userdata:StringBuffer = StringBuffer()
            GlobalScope.launch (Dispatchers.IO) {
                allUser = Userdatabase.getINSTANCE(this@SearchActor).userdao().search(searchactor.text.toString())
                Log.i("here",allUser.toString())
                launch(Dispatchers.Main){
                    allUser.forEach{
                        userdata.append("\n\nActor name "+it.movactor+"\nMovie name "+it.movname)
                    }
                    tv.setText(userdata.toString())
                }
            }
        }

        if (savedInstanceState != null) {
            tv.setText(savedInstanceState.getString("Info"))
            searchactor.setText(savedInstanceState.getString("searchactor"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Info",tv.text.toString())
        outState.putString("searchactor",searchactor.text.toString())
    }
}
// references

// lecture 6 and the lecture recording for Database with Room library
// https://developer.android.com/reference/android/arch/persistence/room/Query
// https://developer.android.com/training/data-storage/room