package com.example.newspaper.data.entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.RawValue
import kotlinx.parcelize.Parcelize

private const val INDEX_TITLE = "title"

@Parcelize
@Entity(tableName = "marked_news", indices = [Index(value = [INDEX_TITLE], unique = true)])
data class ArticleBookmark(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "publishedAt") val publishedAt: String,
    @Embedded val source: @RawValue Source,
    @ColumnInfo(name = "picture_path") val urlToImage: String,
    @ColumnInfo(name = "description") val description: String,
     val isMarked: Boolean = false
) : Parcelable