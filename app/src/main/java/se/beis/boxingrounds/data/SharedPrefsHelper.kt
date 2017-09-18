/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package se.beis.boxingrounds.data

import android.content.Context
import android.content.SharedPreferences

import android.content.Context.MODE_PRIVATE


class SharedPrefsHelper(context: Context) {
    internal var mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = context.getSharedPreferences(PreferenceKeys.MY_PREFERENCES.name, MODE_PRIVATE)
    }

    fun clear() {
        mSharedPreferences.edit().clear().apply()
    }

    fun putNumberOfRounds(numberOfRounds: Int) {
        mSharedPreferences.edit().putInt(PreferenceKeys.NUMBER_OF_ROUNDS.name, numberOfRounds).apply()
    }

    fun putRoundTime(seconds: Int) {
        mSharedPreferences.edit().putInt(PreferenceKeys.ROUND_TIME.name, seconds).apply()
    }

    fun putPrepTime(seconds: Int) {
        mSharedPreferences.edit().putInt(PreferenceKeys.PREP_TIME.name, seconds).apply()
    }

    fun putBreakTime(seconds: Int) {
        mSharedPreferences.edit().putInt(PreferenceKeys.BREAK_TIME.name, seconds).apply()
    }

    enum class PreferenceKeys {
        MY_PREFERENCES,
        NUMBER_OF_ROUNDS,
        ROUND_TIME,
        PREP_TIME,
        BREAK_TIME
    }
}
