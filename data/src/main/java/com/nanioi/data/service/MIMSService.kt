package com.nanioi.data.service

import com.nanioi.data.entity.LMSData
import com.nanioi.data.entity.ProfileAttendData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MIMSService {

    /**
     * 서버 요청 url
     * http://{MIMS_URL}/cpm/comm/campaign/info
     */

    /**
     * 월정액 캠페인 정보 조회
     */

    @Headers("Accept: application/json")
    @GET("/cpm/comm/campaign/info")
    suspend fun getAttendStatusNActInfo(
        @Header("PROFILE-ID") profileId: String,
        @Path("prfId") prfId: String,
        @Query("schDtt") schDtt: String
    ): Response<LMSData<ProfileAttendData>>
}