package com.example.cw2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    val id :Int?,
    val movname:String?,
    val movyear:String?,
    val movrate:String?,
    val movreleased:String?,
    val movruntime:String?,
    val movgenre:String?,
    val movdirector:String?,
    val movwriter:String?,
    val movactor:String?,
    val movplot:String
)
// references

// lecture 6 and the lecture recording for Database with Room library
// https://developer.android.com/training/data-storage/room