package se.beis.boxingrounds.ui.main

import android.content.Context
import android.content.Intent
import se.beis.boxingrounds.R
import se.beis.boxingrounds.util.timer.RoundTimer
import se.beis.boxingrounds.util.CountDownUtil

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import se.beis.boxingrounds.ui.base.BaseActivity
import se.beis.boxingrounds.ui.settings.SettingsActivity

class MainActivity : BaseActivity(), MainMvpView {

    private var roundTimer: CountDownTimer? = null
    private var running: Boolean? = false

    lateinit var startButton : Button
    lateinit var textView : TextView
    lateinit var settingsButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.start_button) as Button
        startButton.setOnClickListener { startBoxing() }

        textView = findViewById(R.id.fullscreen_content) as TextView

        settingsButton = findViewById(R.id.settings_button) as Button
        settingsButton.setOnClickListener { openSettings() }

        //val spinner = findViewById(R.id.no_of_rounds_spinner) as Spinner
        //val adapter = ArrayAdapter(applicationContext,
        //        android.R.layout.simple_spinner_dropdown_item,
        //        arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
        //spinner.adapter = adapter
        //spinner.setSelection(4)
    }

    override fun startBoxing() {

        if (running!!) {
            running = false
            textView.text = CountDownUtil.timeLeft(RoundTimer.MILLIS_PER_ROUND)
            startButton.setText(R.string.start_button)
            roundTimer!!.cancel()

        } else {
            running = true
            startButton.setText(R.string.stop_button)
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.boxing_bell)
            mediaPlayer.start()

            //val spinner = findViewById(R.id.no_of_rounds_spinner) as Spinner
            roundTimer = RoundTimer(this, applicationContext, textView, 5)
            roundTimer!!.start()
        }

    }

    var isRunning: Boolean?
        get() = running
        set(running) {
            this.running = running
            val button = findViewById(R.id.start_button) as Button
            if (running!!) {
                button.setText(R.string.stop_button)
            } else {
                button.setText(R.string.start_button)
            }

        }

    override fun openSettings() {
        val intent = SettingsActivity.getSettingsIntent(this)
        startActivity(intent)
        finish()
    }

    companion object {

        fun getStartIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }
}
