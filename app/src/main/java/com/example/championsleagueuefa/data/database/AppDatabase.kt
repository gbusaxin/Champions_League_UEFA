package com.example.championsleagueuefa.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.championsleagueuefa.data.database.db_model.NewsDbModel

@Database(
    entities = [NewsDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getDao():DbDao

    companion object{
        const val DB_NAME = "database.db"
    }

}