// Laps represent the sets. For example in a 50 x 2 Freestyle Lap you do a 2 pool Lengths, then rest, and then
// you do other 2 pool length.
// So, other than contain a list of lengths, every Lap contains also the summary of that set of Lengths.

package com.nerisal.openswimlab.model


import com.garmin.fit.EventType
import com.garmin.fit.SwimStroke

data class Lap(
    val index: Int, // Number of lap in the workout

    // times
    val startTime: Long?, // fit:
    val timestamp: Long?, // fit:
    val elapsedTime: Float?,
    val timerTime: Float?,
    val activeTime: Float?,

    // distance
    val distance: Float?, // fit: total_distance

    // calories
    val totalCalories: Int?, // fit: total_calories

    // type
    val lapType: EventType?, // tells if is an active lap (swimming) or a rest lap.EventType

    // heart rate lengths: List<LengthMesg>
    val avgHeartRate: Int?, // fit: avg_heart_rate
    val maxHeartRate: Int?, // fit: max_hearth_rate
    val minHeartRate: Int?, // fit: min_hearth_rate

    // stroke
    val swimStroke: SwimStroke, // fit: swim_stroke. Average SwimStroke of the lap. Is Medley if there is at least two different strokes.
    val totalStrokes: Int?, // fit: total_strokes
    val avgStrokeDistance: Float?, // fit: avg_stroke_distance

    // swolf
    val avgSwolf: Int? = null, // to be calculated

    // cadence
    val maxCadence: Int?, // fit: max_cadence
    val avgCadence: Int?, // fit: avg_cadence

    // speed
    val avgSpeed: Float?, // fit: avg_speed
    val maxSpeed: Float?, // fit: max_speed

    // lengths
    val numLengths: Int?, // fit: num_lengths
    val numActiveLengths: Int?,
    )