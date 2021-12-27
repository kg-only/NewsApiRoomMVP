package com.example.newsapi.main.db.dbmodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.newsapi.main.db.convertors.RoomConvertor
import com.example.newsapi.responsemodel.Source

@Entity(tableName = "resultDao")
@TypeConverters(RoomConvertor::class)
data class ArticlesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "source")
    var source: String? = Source().name,

    @ColumnInfo(name = "author")
    var author: String? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "url")
    var url: String? = null,

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String? = null,

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String? = null,
//    @ColumnInfo(name = "content") var content: String? = null,
)