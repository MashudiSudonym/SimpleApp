package c.m.simpleapp.photos.presentation.view_model

import androidx.lifecycle.ViewModel
import c.m.simpleapp.photos.domain.use_case.get_list_photos_use_case.GetListPhotosUseCase
import c.m.simpleapp.photos.domain.use_case.get_photo_detail_use_case.GetPhotoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getListPhotosUseCase: GetListPhotosUseCase,
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase,
) : ViewModel()