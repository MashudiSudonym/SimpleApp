package c.m.simpleapp.photos.data.local

import androidx.room.*
import c.m.simpleapp.photos.data.local.entity.PhotoEntity

@Dao
interface PhotosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photoEntity: PhotoEntity)

    @Query("DELETE FROM tbl_photos WHERE photo_id LIKE :photoId")
    suspend fun deletePhotos(photoId: Int)

    @Transaction
    suspend fun updatePhotos(photoId: Int, photoEntity: PhotoEntity) {
        deletePhotos(photoId)
        insertPhotos(photoEntity)
    }

    @Query("SELECT * FROM tbl_photos")
    suspend fun getListPhotos(): List<PhotoEntity>

    @Query("SELECT * FROM tbl_photos WHERE photo_id LIKE :photoId")
    suspend fun getPhotosDetail(photoId: Int): PhotoEntity
}