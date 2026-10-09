package com.doraemon.modv1

enum class Status(val label: String) {
    IMPLEMENTED("Đã triển khai"),
    PLANNED("Chưa triển khai"),
    UNVERIFIED("Không thể xác minh")
}

data class Feature(val name: String, val description: String, val status: Status)

/** Danh sách này phải khớp với FEATURE_STATUS.md. */
val FEATURES = listOf(
    Feature("Kiểm tra Shizuku", "Cho biết ứng dụng Shizuku đã cài trên máy chưa và mở nhanh Shizuku.", Status.IMPLEMENTED),
    Feature("Giữ màn hình sáng", "Giữ màn hình của chính app này luôn sáng (bật/tắt trong Cài đặt).", Status.IMPLEMENTED),
    Feature("Thao tác với ứng dụng đích", "Cần xác định rõ game/ứng dụng đích và việc cần làm trước khi triển khai.", Status.PLANNED),
    Feature("Chức năng mod của APK gốc", "Mã gốc bị làm rối và mã hóa, không khôi phục được.", Status.UNVERIFIED)
)
