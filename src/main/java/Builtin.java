public class Builtin {

    static String input = Main.command;

    static void exit() {
        System.exit(0);
    }

    static void echo() {
        int index = input.indexOf(" ");
        System.out.println(input.substring(index + 1));
    }
}
