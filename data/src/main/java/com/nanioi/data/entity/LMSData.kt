package com.nanioi.data.entity

data class LMSData<T>(
    val sccsYn: String,
    val stsCd: String,
    val stsMsg: String,
    val data: T?
)
