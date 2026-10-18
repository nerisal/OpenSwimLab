package com.nerisal.openswimlab.model

data class Record(
    val timestamp: Long?,

    val heartRate: Int?,

    val speed: Float?,
    val enhancedSpeed: Float?,

    val cadence: Int?,

    val temperature: Float?
)