package com.nerisal.openswimlab.model

import com.nerisal.openswimlab.model.enums.LapType
import com.nerisal.openswimlab.model.enums.SwimStroke
import java.time.Duration


data class Length (
    // times
    val duration: Duration?,

    // type
    val lengthType: LapType?, // fit: length_type

    // cadence
    val avgCadence: Int?, // fit: to be derived

    // stroke
    val swimStroke: SwimStroke?, // fit: swim_stroke
    val totalStrokes: Int?, // fit: swim_stroke
)