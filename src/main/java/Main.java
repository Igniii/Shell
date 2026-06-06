import java.util.Scanner;

public class Main {

    public static String command;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Implementando un bucle REPL para que el shell se ejecute constantemente
        while (true) {
            System.out.print("$ ");
            command = scanner.nextLine();
            // Lógica para implementar el comando builtin "exit". Usamos equals para comparar
            // dos Strings y el builtin exit para salir del programa.
            if (command.equals("exit")) {
                Builtin.exit();
            } else if (command.startsWith("echo ")) {
                Builtin.echo();
            } else {
                System.out.println(command + ": command not found");
            }
        }
    }
}
