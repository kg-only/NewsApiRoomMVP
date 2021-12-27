package com.example.newsapi.main.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapi.main.db.dao.Dao
import com.example.newsapi.main.db.dbmodels.ArticlesEntity

@Database(entities = [ArticlesEntity::class], version = 1)
abstract class NewsDataBase : RoomDatabase() {
    abstract fun resultDao(): Dao
}