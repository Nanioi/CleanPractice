package com.nanioi.data

import com.nanioi.data.entity.LMSData
import com.nanioi.data.entity.ProfileAttendData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    /**
     * 서버 요청 url
     * {{base_url}}/api/v1/lms/parents-letter/{{PROFILE-ID}}/reward-status?schDtt={{schDtt}}&terDevNm
     */

    /**
     * 출석률 그래프 및 미션 활동 현황 조회
     * @param schDtt : 검색년월 (yyyyMM)
     */

    @GET("api/v1/lms/parents-letter/{prfId}/attend-status")
    suspend fun getAttendStatusNActInfo(
        @Header("PROFILE-ID") profileId: String,
        @Path("prfId") prfId: String,
        @Query("schDtt") schDtt: String
    ): Response<LMSData<ProfileAttendData>>
}