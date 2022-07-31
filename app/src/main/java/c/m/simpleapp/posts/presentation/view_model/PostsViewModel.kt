package c.m.simpleapp.posts.presentation.view_model

import androidx.lifecycle.ViewModel
import c.m.simpleapp.photos.domain.use_case.get_photo_detail_use_case.GetPhotoDetailUseCase
import c.m.simpleapp.posts.domain.use_case.get_list_posts_use_case.GetListPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getListPostsUseCase: GetListPostsUseCase,
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase,
) : ViewModel()