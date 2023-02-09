package com.nanioi.data

import com.nanioi.domain.AttendStatus
import com.nanioi.domain.repository.LMSRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LMSRepositoryImpl(
    private val service: APIService
) : LMSRepository {
    override suspend fun getAttendStatus(profileId : String,schDtt: String): Flow<AttendStatus?> = flow {
        val response = service.getAttendStatusNActInfo(profileId,profileId,schDtt)
        val result = if (response.isSuccessful){
            val data = response.body()?.data
            AttendStatus(
                data?.attattendInfoVo?.monthAllDay ?: 30,
                data?.attattendInfoVo?.monthPrfAttendDayCnt ?:0,
                data?.actInfo?.lastMonthCrcmAllQty ?: "0",
                data?.actInfo?.crcmprfCplQty ?:0,
                data?.actInfo?.crcmprfCplPersent ?:0,
                data?.firstAttendDate ?: ""
            )
        }else{
            null
        }
        emit(result)
    }

}