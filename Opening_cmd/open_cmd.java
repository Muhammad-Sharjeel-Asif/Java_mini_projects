import java.util.Scanner;

public class open_cmd {
    public static void main(String[] args) {
        try {
            System.out.println("What do you want to open cmd or notepad");
            Scanner input = new Scanner(System.in);
            String command = input.next().toLowerCase();

            if (command.equals("cmd") | command.equals("command prompt"))
                Runtime.getRuntime().exec(new String[] { "cmd", "/K", "Start" });
            else if (command.equals("notepad"))
                Runtime.getRuntime().exec(new String[] { "notepad" });
            else {
                System.out.println("Thanks for using this program!");
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}