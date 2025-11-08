import java.lang.Math;
import java.util.Scanner;

public class Number_Guessing_Game {
    public static void main(String[] args) {
        int sysNum = (int) (Math.random() * 100);
        System.out.println(sysNum);

        Scanner sc = new Scanner(System.in);
        int userNum = 0;

        do {
            System.out.print("Guess a number between 1 and 100: ");
            userNum = sc.nextInt();

            if (userNum == sysNum) {
                System.out.println("Congratulations! you have guessed the corect number");
                break;
            } else if (sysNum > userNum)
                System.out.println("Enter a higher number \n");
            else if (sysNum < userNum)
                System.out.println("Enter a lower number \n");
        } while (userNum > 0);
    }
}