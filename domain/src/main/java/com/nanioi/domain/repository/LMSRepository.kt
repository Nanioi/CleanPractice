package com.nanioi.domain.repository

import com.nanioi.domain.AttendStatus
import com.nanioi.domain.ProfileMenuWatchTimeData
import kotlinx.coroutines.flow.Flow


interface LMSRepository {
    suspend fun getAttendStatus(profileId : String , schDtt : String) : Flow<AttendStatus?>
    suspend fun getMenuWatchTimeGraphData(profileId : String , schDtt : String) : Flow<ProfileMenuWatchTimeData?>
}