package com.nanioi.data.entity


data class ProfileAttendData(
    val attattendInfoVo: AttattendData,
    val actInfo: ActInfoData,
    val firstAttendDate: String?
) {
    data class AttattendData(
        val monthAllDay: Int,
        val monthPrfAttendDayCnt: Int
    )

    data class ActInfoData(
        val lastMonthCrcmAllQty: String,
        val crcmprfCplQty: Int,
        val crcmprfCplPersent: Int
    )
}
