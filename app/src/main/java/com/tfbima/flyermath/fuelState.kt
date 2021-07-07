package com.tfbima.flyermath

import java.time.LocalDateTime
import java.time.ZoneOffset

class FuelState {
    // property (data member)
    var initialWeight: Double = 0.0
    var finalWeight: Double = 0.0
    var diffWeight: Double = 0.0

    var initialTime: LocalDateTime? = LocalDateTime.now()
    var finalTime: LocalDateTime? = LocalDateTime.now()

    var initialTimeLong: Long? =0
    var finalTimeLong: Long? =0
    var diffTimeLong: Long? = 0

    fun makeTimeToLong(a: LocalDateTime): Long {
        return a.toEpochSecond(ZoneOffset.UTC)
    }

    // member function
    fun mathTime() {
      diffTimeLong = finalTimeLong?.minus(initialTimeLong!!)
    }

    // member function
    fun mathWeight() {
        diffWeight = finalWeight - initialWeight
    }
}