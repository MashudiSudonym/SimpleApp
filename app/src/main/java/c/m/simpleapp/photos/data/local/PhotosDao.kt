package c.m.simpleapp.photos.data.local

import androidx.room.*
import c.m.simpleapp.photos.data.local.entity.PhotoEntity

@Dao
interface PhotosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photoEntity: PhotoEntity)

    @Query("DELETE FROM tbl_photos WHERE photos_id LIKE :photosId")
    suspend fun deletePhotos(photosId: Int)

    @Transaction
    suspend fun updatePhotos(photosId: Int, photoEntity: PhotoEntity) {
        deletePhotos(photosId)
        insertPhotos(photoEntity)
    }

    @Query("SELECT * FROM tbl_photos")
    suspend fun getListPhotos(): List<PhotoEntity>

    @Query("SELECT * FROM tbl_photos WHERE photos_id LIKE :photosId")
    suspend fun getPhotosDetail(photosId: Int): PhotoEntity
}