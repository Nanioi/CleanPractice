package com.nanioi.domain.usecase

import com.nanioi.domain.AttendStatus
import com.nanioi.domain.repository.LMSRepository
import kotlinx.coroutines.flow.Flow

class GetAttendStatusUseCase (private val repository : LMSRepository){
    suspend operator fun invoke(profileId : String, schDtt : String) : Flow<AttendStatus?> {
        return repository.getAttendStatus(profileId,schDtt)
    }
}