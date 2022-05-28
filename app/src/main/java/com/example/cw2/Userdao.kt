package com.example.cw2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Userdao {
    @Insert
    suspend fun insert(user:User)
    @Query("Select * from user")
    suspend fun display(): List<User>
    @Query("Select * from user Where movactor LIKE '%'||:movactor||'%'")
    suspend fun search(movactor:String): List<User>
}
// references

// https://developer.android.com/reference/android/arch/persistence/room/Query
// https://developer.android.com/training/data-storage/room
// https://stackoverflow.com/questions/50198569/like-case-sensitive-in-room-persistence-library this link helped me to do search actor part (in this link the asked the question on how to make is case sensitive. I just reversed the answer)
