package Controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Time {

    public static void main(String[] args) {

        // Chọn múi giờ bằng số (Ví dụ: +07:00)
        ZoneOffset zoneOffset = ZoneOffset.ofHours(1);

        // Lấy thời gian hiện tại theo múi giờ đã chọn
        LocalDateTime currentTime = LocalDateTime.now(zoneOffset);

        // Định dạng thời gian sử dụng DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Hiển thị thời gian theo múi giờ đã chọn
        System.out.println("Thời gian theo múi giờ " + zoneOffset + ": " + currentTime.format(formatter));
    }
}
