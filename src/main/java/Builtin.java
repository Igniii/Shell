public class Builtin {

    static void exit() {
        System.exit(0);
    }

    static void echo() {
        int index = Main.command.indexOf(" ");
        System.out.println(Main.command.substring(index + 1));
    }
}
