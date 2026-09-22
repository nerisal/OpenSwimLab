// Laps represent the sets. For example in a 50 x 2 Freestyle Lap you do a 2 pool Lengths, then rest, and then
// you do other 2 pool length.
// So, other than contain a list of lengths, every Lap contains also the summary of that set of Lengths.

package com.nerisal.openswimlab.model

import com.nerisal.openswimlab.model.enums.LapType
import com.nerisal.openswimlab.model.enums.SwimStroke

import java.time.Duration
import java.time.Instant

data class Lap(
    val number: Int, // Number of lap in the workout

    // times
    val startTime: Instant?, // todo
    val duration: Duration?, // fit:

    // distance
    val distance: Int?, // fit: total_distance

    // calories
    val totalCalories: Int?, // fit: total_calories

    // type
    val lapType: LapType?, // tells if is an active lap (swimming) or a rest lap.

    // heart rate
    val avgHeartRate: Int?, // fit: avg_heart_rate
    val maxHeartRate: Int?, // fit: max_hearth_rate
    val minHeartRate: Int?, // fit: min_hearth_rate

    // stroke
    var swimStroke: SwimStroke, // fit: swim_stroke. Average SwimStroke of the lap. Is Medley if there is at least two different strokes.
    var totalStrokes: Int?, // fit: total_strokes
    var avgStrokeDistance: Double?, // fit: avg_stroke_distance

    // swolf
    var avgSwolf: Int?, // to be calculated

    // cadence
    var maxCadence: Int?, // fit: max_cadence
    var avgCadence: Int?, // fit: avg_cadence

    // speed
    var avgSpeed: Double?, // fit: avg_speed
    var maxSpeed: Double?, // fit: max_speed

    // lengths
    var numLengths: Int?, // fit: num_lengths
    val lengths: List<Length>?,
)