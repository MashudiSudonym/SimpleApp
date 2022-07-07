package c.m.simpleapp.posts.data.local

import androidx.room.*
import c.m.simpleapp.posts.data.local.entity.PostEntity

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(postEntity: PostEntity)

    @Query("DELETE FROM tbl_posts WHERE post_id LIKE :postId")
    suspend fun deletePosts(postId: Int)

    @Transaction
    suspend fun updatePosts(postId: Int, postEntity: PostEntity) {
        deletePosts(postId)
        insertPosts(postEntity)
    }

    @Query("SELECT * FROM tbl_posts")
    suspend fun getListPosts(): List<PostEntity>

    @Query("SELECT * FROM tbl_posts WHERE post_id LIKE :postId")
    suspend fun getPostsDetail(postId: Int): PostEntity
}