package com.nanioi.domain.repository

import com.nanioi.domain.AttendStatus
import kotlinx.coroutines.flow.Flow


interface LMSRepository {
    suspend fun getAttendStatus(profileId : String , schDtt : String) : Flow<AttendStatus?>
}