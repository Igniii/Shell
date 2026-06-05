import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean loop = true;
        while (loop = true) {
            System.out.print("$ ");

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            // Prints the "<command>: command not found" message
            System.out.println(command + ": command not found");
        }
    }
}
