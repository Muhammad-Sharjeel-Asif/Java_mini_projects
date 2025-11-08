import java.util.Scanner;

public class Eqn_bisection_method {
    public static void main(String[] args) {

        while (true) {

            Scanner input = new Scanner(System.in);

            System.out.print("Enter Lower Limit: ");
            double a = input.nextDouble();

            System.out.print("Enter Upper Limit: ");
            double b = input.nextDouble();

            // double a = -10, b = -5;

            if (condChecker(a, b)) {
                double solution = solveEqn(a, b);
                System.out.println("The solution of equation is: " + solution);
                break;
            } else {
                System.out.println("The solution does not lie between given limits");
                break;
            }
        }
    }

    public static double f(double x) {
        return 3 * (x * x * x) - 24;
    }

    public static boolean condChecker(double a, double b) {
        return (f(a) * f(b)) < 0;
    }

    public static double solveEqn(double a, double b) {
        while (true) {
            double c = (a + b) / 2;
            if (f(c) < 0) {
                a = c;
            } else if (f(c) > 0) {
                b = c;
            } else {
                return c;
            }
        }
    }
}
