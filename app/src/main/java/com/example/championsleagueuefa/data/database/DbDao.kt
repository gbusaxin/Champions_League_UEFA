package com.example.championsleagueuefa.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.championsleagueuefa.data.database.db_model.NewsDbModel

@Dao
interface DbDao {

    @Query("SELECT * FROM news_table")
    fun getNews(): LiveData<List<NewsDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsDbModel>)
}