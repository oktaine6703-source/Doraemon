# QA_REPORT

| Hạng mục | Phương pháp kiểm tra | Kết quả | Ghi chú |
|---|---|---|---|
| APK đầu ra | Xác nhận file tồn tại | FAIL | Chưa có APK; môi trường không có Android SDK |
| Package name | Đọc app/build.gradle.kts và Manifest | PASS | `com.doraemon.modv1`, khác APK gốc (kiểm tra trên mã nguồn, không phải APK) |
| Biên dịch | Kiểm tra log build | NOT TESTED | Chưa chạy Gradle; Kotlin chưa được trình biên dịch kiểm tra |
| Cài đặt | Cài trên Android | NOT TESTED | |
| Khởi chạy | Mở app | NOT TESTED | |
| Giao diện | Từng màn hình | NOT TESTED | Các file XML đã được kiểm tra đúng cú pháp |
| Chức năng | Từng tính năng | NOT TESTED | |
| Quyền truy cập | Tìm `uses-permission` trong Manifest | PASS | Không khai báo permission nào (trên mã nguồn) |
| Crash | Chạy thử/log | NOT TESTED | |
