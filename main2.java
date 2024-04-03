import java.io.File;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String url = sn.nextLine();
        System.out.print("input url:");
        File file = new File(url);
        file.delete();
        System.out.println("delete!");
    }
}
