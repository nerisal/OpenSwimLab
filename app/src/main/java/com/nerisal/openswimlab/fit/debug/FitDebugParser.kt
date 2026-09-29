package com.nerisal.openswimlab.fit.debug

import com.garmin.fit.Decode
import com.garmin.fit.Mesg
import com.garmin.fit.MesgBroadcaster
import java.io.InputStream

data class FitDebugField(val name: String, val displayValue: String)
data class FitDebugMessage(val name: String, val fields: List<FitDebugField>)

class FitDebugParser {

    // Automatically create a new list for every message type inside the .fit file
    fun dump(input: InputStream): Map<String, List<FitDebugMessage>> {
        val byType = mutableMapOf<String, MutableList<FitDebugMessage>>()

        val decode = Decode()
        val broadcaster = MesgBroadcaster(decode)

        broadcaster.addListener { mesg: Mesg ->
            // Creating the map
            val fields = mesg.fields
                .filter { it.isValid }
                .map { field ->
                    val units = field.units?.takeIf { it.isNotBlank() }?.let { " $it" } ?: ""
                    FitDebugField(field.name, "${formatValue(field.value)}$units")
                }

            byType.getOrPut(mesg.name) {
                mutableListOf()
            }.add(FitDebugMessage(mesg.name, fields))
        }
        decode.read(input, broadcaster)

        return byType
    }


    private fun formatValue(raw: Any?): String = when (raw) {
        null -> "-"
        is ShortArray -> raw.joinToString()
        is IntArray -> raw.joinToString()
        is FloatArray -> raw.joinToString()
        is LongArray -> raw.joinToString()
        is DoubleArray -> raw.joinToString()
        is ByteArray -> raw.joinToString()
        is Array<*> -> raw.joinToString()
        else -> raw.toString()
    }
}
