package com.example.retro22.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retro22.model.Numb

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history_table")
    fun readAllHistory(): LiveData<List<Numb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNumber(numb: Numb)

}