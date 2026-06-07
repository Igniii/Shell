import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Builtin {

    static void exit() {
        System.exit(0);
    }

    static void echo() {
        int index = Main.command.indexOf(" ");
        System.out.println(Main.command.substring(index + 1));
    }

    static void type() {
        if (Main.command.equals("type echo")) {
            System.out.println("echo is a shell builtin");
            return;
        }

        if (Main.command.equals("type exit")) {
            System.out.println("exit is a shell builtin");
            return;
        }

        if (Main.command.equals("type type")) {
            System.out.println("type is a shell builtin");
            return;
        }

        String commandName = Main.command.substring(5);
        String pathEnv = System.getenv("PATH");
        String separator = System.getProperty("path.separator");

        for (String dir : pathEnv.split(
            java.util.regex.Pattern.quote(separator)
        )) {
            Path executable = Paths.get(dir, commandName);

            if (Files.exists(executable) && Files.isExecutable(executable)) {
                System.out.println(
                    commandName + " is " + executable.toAbsolutePath()
                );
                return;
            }
        }

        System.out.println(commandName + ": not found");
    }
}
