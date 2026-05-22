# Phân tích

Trong Aspect hiện tại, việc chỉ dùng `System.out.println` trong `@Before` Advice để báo lỗi không thể ngăn chặn phương thức gốc thực thi.

- Bản chất của `@Before` Advice: nó chạy trước khi phương thức mục tiêu được gọi, nhưng không có khả năng chặn luồng nếu chỉ in log.
- Sau khi in ra thông báo, luồng chương trình vẫn tiếp tục và phương thức gốc vẫn chạy bình thường.
- Điều này vi phạm yêu cầu nghiệp vụ: người dùng không có quyền vẫn thêm được dữ liệu.

-> Giải pháp: Nếu phát hiện role không hợp lệ, phải ném ra một Exception (ví dụ RuntimeException hoặc AccessDeniedException) để ngắt ngay luồng thực thi, đảm bảo phương thức gốc không được gọi.
