package com.nanioi.domain

data class AttendStatus(
    val monthAllDay: Int?,
    val monthPrfAttendDayCnt: Int?,
    val lastMonthCrcmAllQty: String?,
    val crcmprfCplQty: Int?,
    val crcmprfCplPersent: Int?,
    val firstAttendDate:String?
)
