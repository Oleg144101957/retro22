package com.example.retro22.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retro22.model.Numb

@Database(entities = [Numb::class], version = 1, exportSchema = false)
abstract class HistoryDatabase: RoomDatabase(){

    abstract fun historyDao(): HistoryDao

    companion object {

        @Volatile
        private var INSTANCE : HistoryDatabase? = null

        fun getHistoryDatabase(context: Context): HistoryDatabase {
            val tmp = INSTANCE
            if (tmp != null) return tmp

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HistoryDatabase::class.java,
                    "history_db"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}