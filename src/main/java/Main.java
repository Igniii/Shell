import java.util.Scanner;

public class Main {

    public static String command;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Implementando un bucle REPL para que el shell se ejecute constantemente
        while (true) {
            System.out.print("$ ");
            command = scanner.nextLine();
            // Lógica temporal (elsif anidados kekw) para usar los builtins del shell, con el que invocamos
            // los métodos de la clase Builtin ;) Probablemente hay que hacer algún cambio porque si esto escala
            // a futuro es una liada
            if (command.equals("exit")) {
                Builtin.exit();
            } else if (command.startsWith("echo ")) {
                Builtin.echo();
            } else if (command.startsWith("type ")) {
                Builtin.type();
            } else {
                System.out.println(command + ": command not found");
            }
        }
    }
}
