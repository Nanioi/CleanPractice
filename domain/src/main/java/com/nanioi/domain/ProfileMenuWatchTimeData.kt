package com.nanioi.domain

data class ProfileMenuWatchTimeData(
    val grapAvg: Int,
    val grapList: List<MenuWatchTimeGraphData>,
    var watchTopList: List<WatchTimeTopData>?
){
    data class MenuWatchTimeGraphData(
        val mnuNm: String,
        val watchStm: Int,
        val weekNum: Int
    )

    data class WatchTimeTopData(
        val mnuNm: String,
        val watchStm: Int
    )
}