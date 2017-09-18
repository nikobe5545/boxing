package se.beis.boxingrounds.custom.preference

import android.content.res.TypedArray
import android.content.Context
import android.preference.DialogPreference
import android.util.AttributeSet
import se.beis.boxingrounds.R
import android.widget.NumberPicker
import android.view.View
import android.widget.FrameLayout
import android.view.Gravity
import android.view.ViewGroup






class TimePreference @JvmOverloads constructor(ctxt: Context,
                                               attrs: AttributeSet? = null,
                                               defStyle: Int = android.R.attr.dialogPreferenceStyle) :
        DialogPreference(ctxt, attrs, defStyle) {

    var minutePicker : NumberPicker
    var secondPicker : NumberPicker

    // enable or disable the 'circular behavior'
    val WRAP_SELECTOR_WHEEL = true
    private var value: Int = 0

    init {
        setPositiveButtonText(R.string.set)
        setNegativeButtonText(R.string.cancel)

        minutePicker = NumberPicker(ctxt)
        minutePicker.maxValue = 99
        minutePicker.minValue = 0
        minutePicker.value = 3
        minutePicker.wrapSelectorWheel = WRAP_SELECTOR_WHEEL

        secondPicker = NumberPicker(ctxt)
        secondPicker.maxValue = 59
        secondPicker.minValue = 0
        secondPicker.value = 0
        secondPicker.wrapSelectorWheel = WRAP_SELECTOR_WHEEL
    }

    override fun onCreateDialogView(): View {
        val minutePickerLayoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        minutePickerLayoutParams.gravity = Gravity.START

        val secondPickerLayoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        minutePickerLayoutParams.gravity = Gravity.END

        minutePicker.layoutParams = minutePickerLayoutParams
        secondPicker.layoutParams = secondPickerLayoutParams

        val dialogView = FrameLayout(context)
        dialogView.addView(minutePicker)
        dialogView.addView(secondPicker)

        return dialogView
    }

    override fun onBindDialogView(view: View) {
        super.onBindDialogView(view)
        //picker!!.minValue = MIN_VALUE
        //picker!!.maxValue = MAX_VALUE
        //picker!!.wrapSelectorWheel = WRAP_SELECTOR_WHEEL
        //picker!!.value = getValue()
    }

    override fun onDialogClosed(positiveResult: Boolean) {
        if (positiveResult) {
            minutePicker.clearFocus()
            secondPicker.clearFocus()
            val newValue = minutePicker.value
            if (callChangeListener(newValue)) {
                setValue(newValue)
            }
        }
    }

    override fun onGetDefaultValue(a: TypedArray, index: Int): Any = a.getInt(index, 1)

    override fun onSetInitialValue(restorePersistedValue: Boolean, defaultValue: Any) {
        setValue(if (restorePersistedValue) getPersistedInt(1) else defaultValue as Int)
    }

    override fun getSummary(): CharSequence = String.format("%02d:%02d",
            this.minutePicker.value, this.secondPicker.value)

    fun setValue(value: Int) {
        this.value = value
        persistInt(this.value)
    }

}