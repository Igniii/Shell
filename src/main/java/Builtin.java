import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Builtin {

    static void exit() {
        System.exit(0);
    }

    static void echo() {
        int index = Main.command.indexOf(" ");
        if (index == -1) {
            System.out.println();
        } else {
            System.out.println(Main.command.substring(index + 1));
        }
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

        String cmd = Main.command.substring(5).trim().split(" ")[0];
        String pathEnv = System.getenv("PATH");
        String separator = System.getProperty("path.separator");

        for (String dir : pathEnv.split(
            java.util.regex.Pattern.quote(separator)
        )) {
            Path executable = Paths.get(dir, cmd);
            if (Files.exists(executable) && Files.isExecutable(executable)) {
                System.out.println(
                    cmd + " is " + executable.toAbsolutePath()
                );
                return;
            }
        }

        System.out.println(cmd + ": not found");
    }

    boolean run(String commandLine) throws Exception {
        String[] parts = commandLine.split(" ");
        String program = parts[0];
        String pathEnv = System.getenv("PATH");
        String separator = System.getProperty("path.separator");

        for (String dir : pathEnv.split(
            java.util.regex.Pattern.quote(separator)
        )) {
            Path executable = Paths.get(dir, program);
            if (Files.isExecutable(executable)) {
                ProcessBuilder pb = new ProcessBuilder(parts);
                pb.inheritIO();
                Process process = pb.start();
                process.waitFor();
                return true;
            }
        }
        return false;
    }
}
