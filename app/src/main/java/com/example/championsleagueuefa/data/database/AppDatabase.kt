package com.example.championsleagueuefa.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.championsleagueuefa.data.database.db_model.FixturesDbModel
import com.example.championsleagueuefa.data.database.db_model.GroupDbModel
import com.example.championsleagueuefa.data.database.db_model.NewsDbModel
import com.example.championsleagueuefa.data.database.db_model.ResultDbModel

@Database(
    entities = [
        NewsDbModel::class,
        ResultDbModel::class,
        FixturesDbModel::class,
        GroupDbModel::class
    ],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDao(): DbDao

    companion object {
        const val DB_NAME = "database.db"
    }

}