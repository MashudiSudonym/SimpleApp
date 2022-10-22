package c.m.simpleapp.photos.presentation.view_model

import androidx.lifecycle.ViewModel
import c.m.simpleapp.photos.domain.use_case.get_list_photos_use_case.GetListPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getListPhotosUseCase: GetListPhotosUseCase,
) : ViewModel()