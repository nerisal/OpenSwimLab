package com.nerisal.openswimlab.fit

import android.util.Log
import com.garmin.fit.ActivityMesg
import com.garmin.fit.ActivityMesgListener
import com.garmin.fit.Decode
import com.garmin.fit.DeviceInfoMesg
import com.garmin.fit.DeviceInfoMesgListener
import com.garmin.fit.LapMesg
import com.garmin.fit.LapMesgListener
import com.garmin.fit.LengthMesg
import com.garmin.fit.LengthMesgListener
import com.garmin.fit.MesgBroadcaster
import com.garmin.fit.RecordMesg
import com.garmin.fit.RecordMesgListener
import com.garmin.fit.SessionMesg
import com.garmin.fit.SessionMesgListener
import java.io.InputStream

class FitParser {

    fun parse(input: InputStream): RawFitWorkout {

        var activity: ActivityMesg? = null

        val sessions = mutableListOf<SessionMesg>()
        val laps = mutableListOf<LapMesg>()
        val lengths = mutableListOf<LengthMesg>()
        val records = mutableListOf<RecordMesg>()
        val deviceInfo = mutableListOf<DeviceInfoMesg>()

        val decode = Decode()
        val broadcaster = MesgBroadcaster(decode)

        broadcaster.addListener(ActivityMesgListener { activity = it })

        broadcaster.addListener(SessionMesgListener { sessions.add(it) })
        broadcaster.addListener(LapMesgListener { laps.add(it) })
        broadcaster.addListener(LengthMesgListener { lengths.add(it) })
        broadcaster.addListener(RecordMesgListener { records.add(it) })
        broadcaster.addListener(DeviceInfoMesgListener { deviceInfo.add(it) })

        decode.read(input, broadcaster)

        return RawFitWorkout(activity, sessions, laps, lengths, records, deviceInfo)
    }
}

data class RawFitWorkout(
    val activity: ActivityMesg?,

    val sessions: List<SessionMesg>,
    val laps: List<LapMesg>,
    val lengths: List<LengthMesg>,
    val records: List<RecordMesg>,
    val deviceInfo: List<DeviceInfoMesg>
)