package c.m.simpleapp.posts.data.repository

import c.m.simpleapp.R
import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.common.util.UIText
import c.m.simpleapp.posts.data.local.PostsDao
import c.m.simpleapp.posts.data.mapper.toPost
import c.m.simpleapp.posts.data.mapper.toPostEntity
import c.m.simpleapp.posts.data.remote.PostsAPI
import c.m.simpleapp.posts.domain.model.Post
import c.m.simpleapp.posts.domain.repository.PostsRepository
import coil.network.HttpException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val postsAPI: PostsAPI,
    private val postsDao: PostsDao,
) :
    PostsRepository {
    override suspend fun getListPosts(): Flow<Resource<List<Post>>> {
        return flow {
            emit(Resource.Loading())

            val listPostFromLocal = postsDao.getListPosts().map { it.toPost() }

            emit(Resource.Loading(listPostFromLocal))

            try {
                val listPostDataFromRemote = postsAPI.getListPosts()

                listPostDataFromRemote.forEach { post ->
                    postsDao.updatePosts(post.id, post.toPostEntity())
                }

                val newListPostDataFromLocal = postsDao.getListPosts().map { it.toPost() }

                emit(Resource.Success(newListPostDataFromLocal))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem),
                        data = listPostFromLocal)
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem),
                        data = listPostFromLocal)
                )
            } catch (e: UnknownHostException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_unknown),
                        data = listPostFromLocal)
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getPost(postId: Int): Flow<Resource<Post>> {
        return flow {
            val postDetailData = postsDao.getPostsDetail(postId).toPost()

            emit(Resource.Loading(postDetailData))

            try {
                emit(Resource.Success(postDetailData))
            } catch (e: IOException) {
                emit(
                    Resource.Error(message = UIText.DynamicString(e.toString()),
                        data = postDetailData)
                )
            } catch (e: Exception) {
                emit(
                    Resource.Error(message = UIText.DynamicString(e.toString()),
                        data = postDetailData)
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}