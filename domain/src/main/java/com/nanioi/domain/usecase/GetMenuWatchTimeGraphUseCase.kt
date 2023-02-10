package com.nanioi.domain.usecase

import com.nanioi.domain.ProfileMenuWatchTimeData
import com.nanioi.domain.repository.LMSRepository
import kotlinx.coroutines.flow.Flow

class GetMenuWatchTimeGraphUseCase (private val repository : LMSRepository) {
    suspend operator fun invoke(profileId: String, schDtt: String): Flow<ProfileMenuWatchTimeData?> {
        return repository.getMenuWatchTimeGraphData(profileId, schDtt)
    }
}