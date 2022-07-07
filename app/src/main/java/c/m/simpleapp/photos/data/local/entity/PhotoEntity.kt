package c.m.simpleapp.photos.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_photos")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Long = 0L,
    @ColumnInfo(name = "album_id")
    val albumId: Int = 0,
    @ColumnInfo(name = "photo_id")
    val photoId: Int = 0,
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "url")
    val url: String = "",
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String = "",
)
