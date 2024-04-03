import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn file: ");
        String filePath = scanner.nextLine();

        long fileSize = getFileSize(filePath);
        if (fileSize != -1) {
            System.out.println("Độ lớn của file là: " + formatFileSize(fileSize));
        } else {
            System.out.println("Không thể tìm thấy file hoặc có lỗi xảy ra khi đọc file.");
        }

        scanner.close();
    }

    private static long getFileSize(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            return file.length();
        } else {
            return -1;
        }
    }

    private static String formatFileSize(long fileSize) {
        if (fileSize < 1024) {
            return fileSize + " Bytes";
        } else if (fileSize < 1024 * 1024) {
            return String.format("%.2f KB", fileSize / 1024.0);
        } else if (fileSize < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", fileSize / (1024.0 * 1024));
        } else {
            return String.format("%.2f GB", fileSize / (1024.0 * 1024 * 1024));
        }
    }
}
