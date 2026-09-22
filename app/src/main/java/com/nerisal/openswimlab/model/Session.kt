// A session contains the overall metrics of the workout. For example the 'average heart rate' or the 'total length'.

package com.nerisal.openswimlab.model

import com.nerisal.openswimlab.model.enums.SwimStroke
import java.time.Duration
import java.time.Instant

data class Session(
    // times
    val startTime: Instant?, // fit: start_time
    val elapsedTime: Duration?, // fit: total_elapsed_time. Includes pauses
    val movingTime: Duration?, // fit: total_timer_time. Excludes pauses
    val activeTime: Duration?, // fit: active_time. Measures the time of actual swimming, excluding rest. Rest ≠ Pause

    // distance
    val distance: Int?, // fit: total_distance
    val poolLength: Int?, // fit: pool_length (always processed in meters)

    // strokes
    val swimStroke: SwimStroke?, // fit: swim_stroke
    val totalStrokes: Int?, // fit: total_strokes

    // calories
    val calories: Int?, // fit: total_calories

    // heart rate
    val avgHeartRate: Int?, // fit: avg_heart_rate
    val maxHeartRate: Int?, // fit: max_heart_rate
    val minHeartRate: Int?, // fit: min_heart_rate

    // speed
    val avgSpeed: Double?, // fit: avg_speed
    val maxSpeed: Double?, // fit: max_speed

    // cadence
    val avgCadence: Int?, // fit: avg_cadence
    val maxCadence: Int?, // fit: max_cadence
)