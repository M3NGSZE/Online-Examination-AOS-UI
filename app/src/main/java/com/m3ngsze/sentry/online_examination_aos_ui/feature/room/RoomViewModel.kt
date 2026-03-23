package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.AppResult
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ListResponse
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.ListDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Room
import com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase.RoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val roomUseCase: RoomUseCase
): ViewModel() {
    var roomState by mutableStateOf<ListDTO<Room>?>(null)

    var errorState by mutableStateOf<String?>(null)
        private set

    fun getAllUserRooms(page: Int, size: Int, search: String?, sort: String?, room: String?){
        viewModelScope.launch {
            errorState = null
            when(val result = roomUseCase.getAllUserRooms(page, size, search, sort, room)){
                is AppResult.Success -> roomState = result.data
                is AppResult.Error -> errorState = result.message
            }
        }
    }
}