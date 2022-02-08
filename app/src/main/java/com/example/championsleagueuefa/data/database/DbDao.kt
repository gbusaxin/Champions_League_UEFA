package com.example.championsleagueuefa.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.championsleagueuefa.data.database.db_model.FixturesDbModel
import com.example.championsleagueuefa.data.database.db_model.GroupDbModel
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

    @Query("DELETE FROM fixtures_table")
    suspend fun deleteAllFixtures()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: List<FixturesDbModel>)

    @Query("SELECT * FROM groups_table")
    fun getGroups(): LiveData<List<GroupDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroups(groups: List<GroupDbModel>)

}