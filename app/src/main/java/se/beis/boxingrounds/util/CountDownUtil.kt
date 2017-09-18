package se.beis.boxingrounds.util

import java.util.concurrent.TimeUnit

/**
 *
 */
object CountDownUtil {

    fun timeLeft(millisUntilFinished: Long): String {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(minutes)
        return String.format("%d:%02d", minutes, seconds)
    }
}
