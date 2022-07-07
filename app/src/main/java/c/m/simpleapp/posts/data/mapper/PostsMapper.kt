package c.m.simpleapp.posts.data.mapper

import c.m.simpleapp.posts.data.local.entity.PostEntity
import c.m.simpleapp.posts.data.remote.dto.PostDTO
import c.m.simpleapp.posts.domain.model.Post

fun PostDTO.toPostEntity(): PostEntity {
    return PostEntity(
        userId = userId,
        postsId = id,
        title = title,
        body = body,
    )
}

fun PostEntity.toPost(): Post {
    return Post(
        userId = userId,
        id = postsId,
        title = title,
        body = body,
    )
}