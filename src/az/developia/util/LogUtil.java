package az.developia.util;

public class LogUtil {
    public static void printWithThread(String log) {
        System.out.println(Thread.currentThread().getName() + " || " + log);
    }
}
