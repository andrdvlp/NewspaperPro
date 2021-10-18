package com.example.newspaper.data.Entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.RawValue
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cashed_news", indices = [Index(value = ["title"], unique = true)])
data class Article(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "publishedAt") val publishedAt: String,
    @Embedded val source: @RawValue Source,
    @ColumnInfo(name = "picture_path") val urlToImage: String,
    @ColumnInfo (name = "description") val description: String,
    var isInFavorites: Boolean = false
    //val author: String,
    //val content: String,
//    val publishedAt: String,
 //   val source: Source,
 //   val title: String,
    //val url: String,
  //  val urlToImage: String
) : Parcelable