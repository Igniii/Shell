import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // REPL loop, read-evaluate-print loop
        while (true) {
            System.out.print("$ ");

            String command = scanner.nextLine();
            // Prints the "<command>: command not found" message
            System.out.println(command + ": command not found");
        }
    }
}
