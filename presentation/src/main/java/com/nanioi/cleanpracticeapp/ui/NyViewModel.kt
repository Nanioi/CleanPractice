package com.nanioi.cleanpracticeapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nanioi.domain.AttendStatus
import com.nanioi.domain.usecase.GetAttendStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NyViewModel @Inject constructor(
    private val attendStatusUseCase: GetAttendStatusUseCase,
) : ViewModel() {

    /**
     * 출석률 데이터
     * recyclerview data
     */

    private var _attendStatusLiveData = MutableLiveData<AttendStatus>()
    val attendStatusLiveData : LiveData<AttendStatus> = _attendStatusLiveData


    fun getAttendStatus(profileId : String, schDtt : String) = viewModelScope.launch{
       attendStatusUseCase(profileId,schDtt).collectLatest { data ->
           _attendStatusLiveData.postValue(data)
       }
    }

}