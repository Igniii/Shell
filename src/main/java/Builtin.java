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
        } else if (Main.command.equals("type exit")) {
            System.out.println("exit is a shell builtin");
        } else if (Main.command.equals("type type")) {
            System.out.println("type is a shell builtin");
        } else {
            System.out.println(Main.command.substring(5) + ": not found");
        }
    }
}
