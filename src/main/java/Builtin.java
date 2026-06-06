public class Builtin {

    static void exit() {
        System.exit(0);
    }

    static void echo() {
        String input = Main.command;
        int index = input.indexOf("");

        System.out.println(input.substring(index));
    }
}
