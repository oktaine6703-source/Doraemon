package com.doraemon.modv1

import android.content.Context

/** Lưu cài đặt cục bộ trên máy, không gửi ra ngoài. */
object Prefs {
    private fun sp(c: Context) = c.getSharedPreferences("doraemon", Context.MODE_PRIVATE)

    fun keepScreenOn(c: Context): Boolean = sp(c).getBoolean("keep_screen_on", false)

    fun setKeepScreenOn(c: Context, value: Boolean) {
        sp(c).edit().putBoolean("keep_screen_on", value).apply()
    }
}
