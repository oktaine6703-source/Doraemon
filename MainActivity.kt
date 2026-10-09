package com.doraemon.modv1

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav = findViewById<BottomNavigationView>(R.id.nav)
        nav.setOnItemSelectedListener { item ->
            val page: Fragment = when (item.itemId) {
                R.id.nav_features -> FeaturesFragment()
                R.id.nav_settings -> SettingsFragment()
                R.id.nav_about -> AboutFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.container, page).commit()
            true
        }
        if (savedInstanceState == null) nav.selectedItemId = R.id.nav_home
        applyKeepScreenOn()
    }

    fun applyKeepScreenOn() {
        if (Prefs.keepScreenOn(this)) {
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }
}

class HomeFragment : PageFragment() {
    override fun render(ctx: Context, col: LinearLayout) {
        col.addView(ctx.label("Doraemon MOD v1", 24f, true))
        col.addView(ctx.label("Trạng thái hệ thống", 18f, true))
        col.addView(ctx.label("Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})"))

        val installed = ShizukuCheck.isInstalled(ctx)
        col.addView(ctx.label(if (installed) "Shizuku: đã cài" else "Shizuku: chưa cài"))
        col.addView(
            ctx.label(
                if (installed) "Chưa kết nối quyền Shizuku (tính năng này chưa triển khai)."
                else "Cài Shizuku từ nguồn chính thống nếu bạn cần các tính năng nâng cao sau này."
            )
        )

        val open = MaterialButton(ctx).apply {
            text = "Mở Shizuku"
            isEnabled = installed
            setOnClickListener {
                val intent = ShizukuCheck.launchIntent(ctx)
                if (intent == null) {
                    Toast.makeText(ctx, "Không mở được Shizuku.", Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(intent)
                }
            }
        }
        col.addView(open, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    }
}

class FeaturesFragment : PageFragment() {
    override fun render(ctx: Context, col: LinearLayout) {
        col.addView(ctx.label("Danh sách tính năng", 20f, true))
        for (f in FEATURES) {
            col.addView(ctx.label("${f.name} — ${f.status.label}", 16f, true).apply { setPadding(0, ctx.dp(12), 0, 0) })
            col.addView(ctx.label(f.description, 14f))
        }
    }
}

class SettingsFragment : PageFragment() {
    override fun render(ctx: Context, col: LinearLayout) {
        col.addView(ctx.label("Cài đặt", 20f, true))
        val sw = SwitchCompat(ctx).apply {
            text = "Giữ màn hình sáng khi đang dùng app"
            isChecked = Prefs.keepScreenOn(ctx)
            setOnCheckedChangeListener { _, checked ->
                Prefs.setKeepScreenOn(ctx, checked)
                (activity as? MainActivity)?.applyKeepScreenOn()
            }
        }
        col.addView(sw)
    }
}

class AboutFragment : PageFragment() {
    @Suppress("DEPRECATION")
    override fun render(ctx: Context, col: LinearLayout) {
        val version = try {
            ctx.packageManager.getPackageInfo(ctx.packageName, 0).versionName
        } catch (e: PackageManager.NameNotFoundException) {
            "?"
        }
        col.addView(ctx.label("Doraemon MOD v1", 22f, true))
        col.addView(ctx.label("Phiên bản: $version"))
        col.addView(ctx.label("Package: ${ctx.packageName}"))
        col.addView(ctx.label("Ứng dụng độc lập, không dùng mã của APK gốc. Không yêu cầu quyền Android nào và không gửi dữ liệu ra ngoài."))
    }
}
