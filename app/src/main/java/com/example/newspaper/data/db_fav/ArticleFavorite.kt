package com.example.newspaper.data.db_fav

import android.os.Parcelable
import androidx.room.*
import com.example.newspaper.data.db_first.entity.Source

import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
@Entity(tableName = "fav_news", indices = [Index(value = ["title"], unique = true)])

data class ArticleFavorite (
        @PrimaryKey(autoGenerate = true) override var id: Int = 0,
        @ColumnInfo(name = "date") override var publishedAt: String,
        @ColumnInfo(name = "desc") override var description: String,
        @Embedded override var source: @RawValue Source,
        @ColumnInfo(name = "title") override var title: String,
        @ColumnInfo(name = "url") override var url: String,
        @ColumnInfo(name = "picture_path") override var urlToImage: String,
        @ColumnInfo(name = "favorite") override var isInFavorites: Boolean = false,
        @ColumnInfo(name = "author") override var author: String
) : ArticleAbstract(), Parcelable
