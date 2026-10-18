// A session contains the overall metrics of the workout. For example the 'average heart rate' or the 'total length'.

package com.nerisal.openswimlab.model

import com.garmin.fit.SwimStroke

data class Session(
    // times
    val startTime: Long?, // fit: start_time
    val elapsedTime: Float?, // fit: total_elapsed_time. Includes pauses. Seconds with decimals
    val timerTime: Float?, // fit: total_timer_time. Excludes pauses. Seconds with decimals
    val activeTime: Float?, // fit: active_time. Measures the time of actual swimming, excluding rest. Rest ≠ Pause. Seconds with decimals

    // distance
    val distance: Float?, // fit: total_distance
    val poolLength: Float?, // fit: pool_length (always processed in meters)

    // strokes
    val swimStroke: SwimStroke?, // fit: swim_stroke
    val totalStrokes: Long?, // fit: total_strokes

    // calories
    val calories: Int?, // fit: total_caloriesLong

    // heart rate
    val avgHeartRate: Int?, // fit: avg_heart_rate
    val maxHeartRate: Int?, // fit: max_heart_rate
    val minHeartRate: Int?, // fit: min_heart_rate

    // speed
    val avgSpeed: Float?, // fit: avg_speed
    val maxSpeed: Float?, // fit: max_speed

    // cadence
    val avgCadence: Int?, // fit: avg_cadence
    val maxCadence: Int?, // fit: max_cadence

    // temperature
    val avgTemperature: Float?, // fit: avg_temperature
    val maxTemperature: Float?, // fit: max_temperature
)