import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Extract_Data {
    public static void main(String[] args) {

        try {
            File myFile = new File("EVE01Sales.txt");
            Scanner reader = new Scanner(myFile);

            System.out.println("=== Auto Generated Menu ===");

            String data = reader.nextLine();
            String[] heading = data.split("\t");
            for (int i = 0; i < heading.length - 2; i++) {
                System.out.println(i + 1 + "." + heading[i]);
            }

            int TotalSales = 0;
            HashMap<String, Integer> empSales = new HashMap<>();
            HashMap<String, Integer> prodSales = new HashMap<>();
            HashMap<String, Integer> regSales = new HashMap<>();
            HashMap<String, Integer> MonthSales = new HashMap<>();

            while (reader.hasNextLine()) {
                data = reader.nextLine();

                String[] sepData = data.split("\t");

                String empId = sepData[2];
                String prodId = sepData[3];
                String regId = sepData[1];
                String monthId = sepData[0];

                int qty = Integer.parseInt(sepData[4]);
                int price = Integer.parseInt(sepData[5]);
                int rowPrice = qty * price;

                // Employee-wise Sales Amount
                TotalSales += rowPrice;

                // Employee-wise Sales Amount
                int prevEmpSales = empSales.getOrDefault(empId, 0);
                empSales.put(empId, prevEmpSales + rowPrice);

                // Product-wise Sales Amount
                int prevProdSales = prodSales.getOrDefault(prodId, 0);
                prodSales.put(prodId, prevProdSales + rowPrice);

                // Region-wise Sales Amount
                int previousRegSales = regSales.getOrDefault(regId, 0);
                regSales.put(regId, previousRegSales + rowPrice);

                // Month-wise Sales Amount
                String[] monthArray = monthId.split("-");
                String month = monthArray[1];

                int prevMonthSales = MonthSales.getOrDefault(month, 0);
                MonthSales.put(month, prevMonthSales + rowPrice);
            }

            System.out.println("\n");

            Scanner user = new Scanner(System.in);
            System.out.print("Select to see Sales Data: ");
            int userIn = Integer.parseInt(user.nextLine());
            System.out.println("\n");

            if (userIn == 1) {
                for (String month : MonthSales.keySet()) {
                    System.out.println("The Sales Amount of " + month + " is Rs." +
                            MonthSales.get(month));
                }
            }

            else if (userIn == 2) {
                for (String reg : regSales.keySet()) {
                    System.out.println("The Sales Amount of " + reg + " is Rs." + regSales.get(reg));
                }
            }

            else if (userIn == 3) {
                for (String emp : empSales.keySet()) {
                    System.out.println("The Sales Amount of Employee " + emp + " is Rs." + empSales.get(emp));
                }
            } else if (userIn == 4) {
                for (String product : prodSales.keySet()) {
                    System.out.println("The Sales Amount of " + product + " is Rs." + prodSales.get(product));
                }
            } else {
                System.out.println("The Total Sales Amount is Rs." + TotalSales);
            }

            if (userIn <= 4 && userIn >= 1)
                System.out.println("\n");
            System.out.println("The Total Sales Amount is Rs." + TotalSales);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}