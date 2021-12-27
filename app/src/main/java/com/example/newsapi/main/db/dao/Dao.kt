package com.example.newsapi.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapi.main.db.dbmodels.ArticlesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM resultDao")
    fun getAll(): Flow<List<ArticlesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(resultInsert: List<ArticlesEntity>)

}