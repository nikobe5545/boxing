package se.beis.boxingrounds.util.timer

import android.content.Context
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.widget.TextView

import se.beis.boxingrounds.R
import se.beis.boxingrounds.util.CountDownUtil

/**
 *
 */
class BreakTimer(private val context: Context, private val textView: TextView, private val roundTimer: RoundTimer) : CountDownTimer(MILLIS_PER_BREAK, RoundTimer.MILLIS_PER_SECOND) {

    override fun onTick(millisUntilFinished: Long) {
        textView.text = CountDownUtil.timeLeft(millisUntilFinished)
    }

    override fun onFinish() {
        val mediaPlayer = MediaPlayer.create(context, R.raw.boxing_bell)
        mediaPlayer.start()
        this.roundTimer.start()
    }

    companion object {

        private val MILLIS_PER_BREAK: Long = 60000
    }
}
