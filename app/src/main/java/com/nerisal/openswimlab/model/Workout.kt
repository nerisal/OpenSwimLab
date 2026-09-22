package com.nerisal.openswimlab.model

import com.nerisal.openswimlab.model.enums.DeviceInfo

import java.time.Instant

// Workout.kt contains the data-structure of the whole workout. It aggregates the Session, the Laps and the Records

data class Workout(
    val id: Long?,

    val startTime: Instant?,

    val sessions: List<Session>,

    val device: DeviceInfo?
)