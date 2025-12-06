package utils;
import java.util.*;
public class Utils {

    private static final Scanner scanner = new Scanner(System.in);


    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\u001b[H\u001b[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // ignore
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // reset interrupt status
            System.out.println("Delay interrupted!");
        }
    }

    public static void enter(){
        System.out.print("\nPress Enter to Return.");
        String enter = scanner.nextLine();
        if(enter.isEmpty() || enter != null) return;
    }
}