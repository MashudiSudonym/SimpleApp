package c.m.simpleapp.photos.data.mapper

import c.m.simpleapp.photos.data.local.entity.PhotoEntity
import c.m.simpleapp.photos.data.remote.dto.PhotoDTO
import c.m.simpleapp.photos.domain.model.Photo

fun PhotoDTO.toPhotoEntity(): PhotoEntity {
    return PhotoEntity(
        albumId = albumId,
        photoId = id,
        title = title,
        url = url,
        thumbnailUrl = thumbnailUrl
    )
}

fun PhotoEntity.toPhoto(): Photo {
    return Photo(
        albumId = albumId,
        id = photoId,
        title = title,
        url = url,
        thumbnailUrl = thumbnailUrl
    )
}