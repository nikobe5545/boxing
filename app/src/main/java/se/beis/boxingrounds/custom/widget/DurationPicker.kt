package se.beis.boxingrounds.custom.widget

import android.content.Context
import android.widget.TimePicker
import android.widget.NumberPicker



/**
 * A picker that treats hours as minutes and minutes as seconds. The resulting
 * behaviour is that you can pick a duration based on minutes and seconds.
 */
class DurationPicker (context : Context) : TimePicker(context) {

    val maxMinutes = 99

    init {
        val clazz = this::class.java
        val minuteField = clazz.getField("hour")
        val minuteSpinner = this.findViewById(minuteField.getInt(null)) as NumberPicker
        minuteSpinner.maxValue = maxMinutes

        val displayedValues = ArrayList<String>()
        for (i in 0..maxMinutes) {
            displayedValues.add(String.format("%d", i))
        }

        minuteSpinner.displayedValues = displayedValues.toTypedArray()
        minuteSpinner.value = 3
    }
}