package com.nanioi.cleanpracticeapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nanioi.domain.AttendStatus
import com.nanioi.domain.ProfileMenuWatchTimeData
import com.nanioi.domain.usecase.GetAttendStatusUseCase
import com.nanioi.domain.usecase.GetMenuWatchTimeGraphUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NyViewModel @Inject constructor(
    private val attendStatusUseCase: GetAttendStatusUseCase,
    private val menuWatchTimeGraphUseCase: GetMenuWatchTimeGraphUseCase
) : ViewModel() {

    /**
     * 출석률 데이터
     * recyclerview data
     */

    private var _attendStatusLiveData = MutableLiveData<AttendStatus>()
    val attendStatusLiveData : LiveData<AttendStatus> = _attendStatusLiveData
    private var _menuGraphLiveData = MutableLiveData<List<ProfileMenuWatchTimeData.MenuWatchTimeGraphData>>()
    val menuGraphLiveData : LiveData<List<ProfileMenuWatchTimeData.MenuWatchTimeGraphData>> = _menuGraphLiveData
    private var _top3LiveData = MutableLiveData<List<ProfileMenuWatchTimeData.WatchTimeTopData>?>()
    val top3LiveData : LiveData<List<ProfileMenuWatchTimeData.WatchTimeTopData>?> = _top3LiveData


    fun getAttendStatus(profileId : String, schDtt : String) = viewModelScope.launch{
       attendStatusUseCase(profileId,schDtt).collectLatest { data ->
           _attendStatusLiveData.postValue(data)
       }
    }

    fun getMenuWatchTimeGraph(profileId : String, schDtt : String) = viewModelScope.launch {
        menuWatchTimeGraphUseCase(profileId,schDtt).collectLatest { data ->
            _menuGraphLiveData.postValue(data?.grapList)
            _top3LiveData.postValue(data?.watchTopList)
        }
    }
}