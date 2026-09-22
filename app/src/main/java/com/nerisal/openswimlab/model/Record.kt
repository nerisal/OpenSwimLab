package com.nerisal.openswimlab.model

import java.time.Instant

data class Record(
    val timestamp: Instant?,

    val heartRate: Int?,

    val speed: Double?,
    val enhancedSpeed: Double?,

    val cadence: Double?,

    val temperature: Double?
)