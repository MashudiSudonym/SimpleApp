package c.m.simpleapp.posts.data.mapper

import c.m.simpleapp.posts.data.local.entity.PostsEntity
import c.m.simpleapp.posts.data.remote.dto.PostsDTO
import c.m.simpleapp.posts.domain.model.Posts

fun PostsDTO.toPostsEntity(): PostsEntity {
    return PostsEntity(
        userId = userId,
        postsId = id,
        title = title,
        body = body,
    )
}

fun PostsEntity.toPosts(): Posts {
    return Posts(
        userId = userId,
        id = postsId,
        title = title,
        body = body,
    )
}