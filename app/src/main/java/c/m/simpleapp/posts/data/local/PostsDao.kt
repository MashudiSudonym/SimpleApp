package c.m.simpleapp.posts.data.local

import androidx.room.*
import c.m.simpleapp.posts.data.local.entity.PostEntity

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(postEntity: PostEntity)

    @Query("DELETE FROM tbl_posts WHERE posts_id LIKE :postsId")
    suspend fun deletePosts(postsId: Int)

    @Transaction
    suspend fun updatePosts(postsId: Int, postEntity: PostEntity) {
        deletePosts(postsId)
        insertPosts(postEntity)
    }

    @Query("SELECT * FROM tbl_posts")
    suspend fun getListPosts(): List<PostEntity>

    @Query("SELECT * FROM tbl_posts WHERE posts_id LIKE :postsId")
    suspend fun getPostsDetail(postsId: Int): PostEntity
}