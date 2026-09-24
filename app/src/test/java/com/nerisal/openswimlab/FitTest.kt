package com.nerisal.openswimlab

import com.garmin.fit.Sport
import com.garmin.fit.SubSport
import com.nerisal.openswimlab.fit.FitParser
import org.junit.Test
import java.io.File

class FitParserTest {

    @Test
    fun parseDeviceId() {
        val resource = javaClass.classLoader
            .getResource("test.fit")

        requireNotNull(resource) {
            "test.fit not found in test resources"
        }

        val file = File(resource.toURI())

        val parser = FitParser()

        val rawFitWorkout = parser.parse(file)

        val session = rawFitWorkout.sessions.firstOrNull { it.sport == Sport.SWIMMING && it.subSport == SubSport.LAP_SWIMMING }

        val totaleElapsedSec = session?.totalElapsedTime

        println("Total elapsed time: $totaleElapsedSec")
    }
}