package Controller;

class MyThread extends Thread {
    private String message;

    public MyThread(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(message);
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Hello from thread 1");
        MyThread thread2 = new MyThread("Hello from thread 2");

        thread1.start();
        thread2.start();
    }
}
