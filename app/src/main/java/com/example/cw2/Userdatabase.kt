package com.example.cw2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class Userdatabase: RoomDatabase(){
    abstract fun userdao():Userdao
    companion object{
        var INSTANCE:Userdatabase?=null
        fun getINSTANCE(context: Context):Userdatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    Userdatabase::class.java,
                    "AddMovie.db").build()
            }
            return INSTANCE!!
        }
    }
}

// references

// lecture 6 and the lecture recording for Database with Room library
// https://developer.android.com/training/data-storage/room