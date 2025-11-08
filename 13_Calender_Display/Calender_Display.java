import java.time.LocalDate;
import java.util.Scanner;

class Calender_Display {
    public static void main(String[] args) {
        try (Scanner getDate = new Scanner(System.in)) {
            System.out.print("Enter the Year: ");
            int year = getDate.nextInt();

            System.out.print("Enter the month: ");
            int month = getDate.nextInt();

            LocalDate date = LocalDate.of(year, month, 1);

            // System.out.println(date);

            int startDay = (date.getDayOfWeek()).getValue();
            // System.out.println(startDay);

            int monthLength = date.lengthOfMonth();
            // System.out.println(monthLength);

            System.out.println("M\tT\tW\tT\tF\tS\tS");

            for (int i = 1, day = 1; day <= monthLength; i++, day++) {
                if (startDay > 1) {
                    System.out.print("\t");
                    day--;
                    startDay--;
                } else {
                    System.out.print(day + "\t");
                    if (i % 7 == 0) {
                        System.out.print("\n");
                    }
                }
            }
        }
    }
}