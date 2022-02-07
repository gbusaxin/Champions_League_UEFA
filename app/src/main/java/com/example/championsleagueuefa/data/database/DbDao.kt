package com.example.championsleagueuefa.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.championsleagueuefa.data.database.db_model.FixturesDbModel
import com.example.championsleagueuefa.data.database.db_model.NewsDbModel
import com.example.championsleagueuefa.data.database.db_model.ResultDbModel

@Dao
interface DbDao {

    @Query("SELECT * FROM news_table")
    fun getNews(): LiveData<List<NewsDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsDbModel>)

    @Query("SELECT * FROM results_table")
    fun getResults(): LiveData<List<ResultDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResults(result: List<ResultDbModel>)

    @Query("SELECT * FROM fixtures_table")
    fun getFixtures(): LiveData<List<FixturesDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<FixturesDbModel>)
}