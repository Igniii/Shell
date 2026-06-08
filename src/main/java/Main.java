import java.util.Scanner;

public class Main {

    public static String command;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            command = scanner.nextLine();

            if (command.equals("exit")) {
                Builtin.exit();
            } else if (command.equals("echo") || command.startsWith("echo ")) {
                Builtin.echo();
            } else if (command.startsWith("type ")) {
                Builtin.type();
            } else {
                Builtin builtin = new Builtin();
                if (!builtin.run(Main.command)) {
                    System.out.println(command + ": command not found");
                }
            }
        }
    }
}
