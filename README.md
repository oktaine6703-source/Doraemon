# Doraemon MOD v1

Ứng dụng Android độc lập (Kotlin, View + Material 3), package `com.doraemon.modv1`.
Không dùng mã, tài nguyên hay logic của APK gốc. Không khai báo permission nào, không gửi dữ liệu ra ngoài.

## Build trên điện thoại (không cần máy tính)
1. Tạo repo GitHub (dùng app GitHub hoặc trình duyệt trên điện thoại) và tải toàn bộ nội dung thư mục dự án lên.
2. Vào tab **Actions** -> workflow **Build APK** -> **Run workflow**.
3. Khi chạy xong, mở lần chạy đó, tải artifact `Doraemon_MOD_v1_debug_apk`, giải nén ra `app-debug.apk` rồi cài.
   (Cần bật "Cài ứng dụng không rõ nguồn" cho trình duyệt/trình quản lý file.)

## Build trên máy có Android Studio
Mở thư mục dự án, chạy `gradle assembleDebug` (Gradle 8.9, JDK 17). APK ở `app/build/outputs/apk/debug/`.

## Cấu trúc
- `Features.kt` – danh sách tính năng và trạng thái (khớp `FEATURE_STATUS.md`)
- `MainActivity.kt` – điều hướng và 4 màn hình: Trang chính, Tính năng, Cài đặt, Thông tin
- `ShizukuCheck.kt` – kiểm tra Shizuku đã cài chưa
- `Prefs.kt` – lưu cài đặt cục bộ

## Trạng thái
Mã nguồn **chưa được biên dịch hay chạy thử**. Xem `QA_REPORT.md` và `FEATURE_STATUS.md`.
