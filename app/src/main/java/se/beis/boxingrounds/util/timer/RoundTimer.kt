package se.beis.boxingrounds.util.timer

import android.content.Context
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.widget.TextView

import se.beis.boxingrounds.ui.main.MainActivity
import se.beis.boxingrounds.R
import se.beis.boxingrounds.util.CountDownUtil

/**
 *
 */
class RoundTimer(private val activity: MainActivity,
                 private val context: Context,
                 private val textView: TextView,
                 private var numberOfRounds: Int) :
        CountDownTimer(MILLIS_PER_ROUND, MILLIS_PER_SECOND) {


    override fun onTick(millisUntilFinished: Long) {
        textView.text = CountDownUtil.timeLeft(millisUntilFinished)
    }

    override fun onFinish() {
        val mediaPlayer = MediaPlayer.create(context, R.raw.boxing_bell)
        mediaPlayer.start()
        textView.text = CountDownUtil.timeLeft(0)
        numberOfRounds--
        if (numberOfRounds > 0) {
            BreakTimer(context, textView, this).start()
        } else {
            activity.isRunning = false
        }
    }

    companion object {

        val MILLIS_PER_ROUND: Long = 180000
        val MILLIS_PER_SECOND: Long = 1000
    }
}
