package com.lyb.note

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


fun getMonthTime(date: Date): String {//可根据需要自行截取数据显示
    Log.d("getTime()", "choice date millis: " + date.getTime())

    val format = SimpleDateFormat("MM月")
    return format.format(date)


}
fun getYearTime(date: Date): String {//可根据需要自行截取数据显示
    Log.d("getTime()", "choice date millis: " + date.getTime())

    val format = SimpleDateFormat("yyyy年")
    return format.format(date)


}



