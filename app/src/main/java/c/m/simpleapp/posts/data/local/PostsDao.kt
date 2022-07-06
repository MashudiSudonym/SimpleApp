package c.m.simpleapp.posts.data.local

import androidx.room.*
import c.m.simpleapp.posts.data.local.entity.PostsEntity

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(postsEntity: PostsEntity)

    @Query("DELETE FROM tbl_posts WHERE posts_id LIKE :postsId")
    suspend fun deletePosts(postsId: Int)

    @Transaction
    suspend fun updatePosts(postsId: Int, postsEntity: PostsEntity) {
        deletePosts(postsId)
        insertPosts(postsEntity)
    }

    @Query("SELECT * FROM tbl_posts")
    suspend fun getListPosts(): List<PostsEntity>

    @Query("SELECT * FROM tbl_posts WHERE posts_id LIKE :postsId")
    suspend fun getPostsDetail(postsId: Int): PostsEntity
}