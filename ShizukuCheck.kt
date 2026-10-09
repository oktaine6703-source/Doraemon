package com.doraemon.modv1

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

/** Chỉ kiểm tra ứng dụng Shizuku đã cài chưa; chưa kết nối hay dùng quyền Shizuku. */
object ShizukuCheck {
    const val PACKAGE = "moe.shizuku.privileged.api"

    @Suppress("DEPRECATION")
    fun isInstalled(c: Context): Boolean = try {
        c.packageManager.getPackageInfo(PACKAGE, 0)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }

    fun launchIntent(c: Context): Intent? = c.packageManager.getLaunchIntentForPackage(PACKAGE)
}
