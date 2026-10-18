package com.nerisal.openswimlab.model

// Workout.kt contains the data-structure of the whole workout. It aggregates the Session, the Laps and the Records

// This structure is fine for now. Take in consideration again if there are more sessions in a single .fit file
data class Workout(
    val id: String,

    val activity: Activity?,
    val devices: List<DeviceInfo>?,
    val sessions: List<Session>?,
    val records: List<Record>?,
    val laps: List<Lap>?,
    val lengths: List<Length>?,
)