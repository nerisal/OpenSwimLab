package com.nerisal.openswimlab.fit

import com.garmin.fit.ActivityMesg
import com.garmin.fit.DeviceInfoMesg
import com.garmin.fit.GarminProduct
import com.garmin.fit.LapMesg
import com.garmin.fit.LengthMesg
import com.garmin.fit.Manufacturer
import com.garmin.fit.RecordMesg
import com.garmin.fit.SessionMesg
import com.garmin.fit.Sport
import com.garmin.fit.SubSport

import com.nerisal.openswimlab.model.*
import java.util.UUID

class FitMapper {

    fun toWorkout(raw: RawFitWorkout): Workout? {
        val session = raw.sessions.firstOrNull {
            it.sport == Sport.SWIMMING && it.subSport == SubSport.LAP_SWIMMING
        } ?: return null

        val workout = Workout(
            id = UUID.randomUUID().toString(),
            name = "",
            activity = mapActivity(raw.activity),
            devices = raw.deviceInfo.map { mapDeviceInfo(it) },
            sessions = raw.sessions.map { mapSession(it)},
            records = raw.records.map { mapRecord(it)},
            laps = raw.laps.map { mapLap(it) },
            lengths = raw.lengths.map { mapLength(it) },
        )

        return workout
    }

    private fun mapSession(s: SessionMesg): Session = Session(
        startTime = s.startTime?.date?.time,
        elapsedTime = s.totalElapsedTime,
        timerTime = s.totalTimerTime,
        activeTime = s.activeTime,

        distance = s.totalDistance,
        poolLength = s.poolLength,

        swimStroke = s.swimStroke,
        totalStrokes = s.totalStrokes,

        calories = s.totalCalories,

        avgHeartRate = s.avgHeartRate?.toInt(),
        maxHeartRate = s.maxHeartRate?.toInt(),
        minHeartRate = s.minHeartRate?.toInt(),

        avgSpeed = s.avgSpeed,
        maxSpeed = s.maxSpeed,

        avgCadence = s.avgCadence?.toInt(),
        maxCadence = s.maxCadence?.toInt(),

        avgTemperature = s.avgTemperature?.toFloat(),
        maxTemperature = s.maxTemperature?.toFloat(),
    )

    private fun mapActivity(a: ActivityMesg?): Activity? {
        a ?: return null

        return Activity(
            timestamp = a.timestamp?.date?.time,
            timerTime = a.totalTimerTime,
            localTimestamp = a.localTimestamp,

            localSecondOffset = if (a.timestamp != null && a.localTimestamp != null) {
                a.localTimestamp - a.timestamp.timestamp
            } else null,
        )
    }


    private fun mapLap(lap: LapMesg): Lap = Lap(
        index = lap.messageIndex,

        startTime = lap.startTime?.date?.time,
        timestamp = lap.timestamp?.date?.time,
        elapsedTime = lap.totalElapsedTime,
        timerTime = lap.totalTimerTime,
        activeTime = lap.activeTime,

        distance = lap.totalDistance,

        totalCalories = lap.totalCalories,

        lapType = lap.eventType,

        avgHeartRate = lap.avgHeartRate?.toInt(),
        maxHeartRate = lap.maxHeartRate?.toInt(),
        minHeartRate = lap.minHeartRate?.toInt(),

        swimStroke = lap.swimStroke,
        totalStrokes = lap.numStrokeCount,
        avgStrokeDistance = lap.avgStrokeDistance,

        avgCadence = lap.avgCadence?.toInt(),
        maxCadence = lap.maxCadence?.toInt(),

        avgSpeed = lap.avgSpeed,
        maxSpeed = lap.maxSpeed,

        numLengths = lap.numLengths,
        numActiveLengths = lap.numActiveLengths,
        )

    private fun mapLength(len: LengthMesg): Length = Length(
        startTime = len.startTime?.date?.time,
        timestamp = len.timestamp?.date?.time,
        elapsedTime = len.totalElapsedTime,
        totalTimerTime = len.totalTimerTime,

        lengthType = len.lengthType,

        avgCadence = len.avgSwimmingCadence?.toInt(),

        swimStroke = len.swimStroke,
        totalNumStrokes = len.numStrokeCount,
    )

    private fun mapRecord(r: RecordMesg): Record = Record(
        timestamp = r.timestamp?.date?.time,

        heartRate = r.heartRate?.toInt(),

        speed = r.speed,
        enhancedSpeed = r.enhancedSpeed,

        cadence = r.cadence?.toInt(),
        temperature = r.temperature?.toFloat()
    )

    private fun mapDeviceInfo(d: DeviceInfoMesg): DeviceInfo{
        val detectedName = d.productName ?: run{
            if (d.manufacturer == Manufacturer.GARMIN) {
                d.product?.let { GarminProduct.getStringFromValue(it) }
            } else null
        }

        return DeviceInfo(
            manufacturer = d.manufacturer,
            product = d.product,

            serialNumber = d.serialNumber,
            productName = detectedName,
        )
    }
}

