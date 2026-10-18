package com.nerisal.openswimlab.model

import com.garmin.fit.LengthType
import com.garmin.fit.SwimStroke


data class Length (
    // times
    val startTime: Long?,
    val timestamp: Long?,
    val elapsedTime: Float?,
    val totalTimerTime: Float?,

    // type
    val lengthType: LengthType?, // fit: length_type

    // cadence
    val avgCadence: Int?, // fit: to be derived

    // stroke
    val swimStroke: SwimStroke?, // fit: swim_stroke
    val totalNumStrokes: Int?, // fit: swim_stroke
)