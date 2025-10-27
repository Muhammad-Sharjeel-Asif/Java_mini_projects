import java.io.File;
import java.util.Scanner;

public class Extract_Data {
    public static void main(String[] args) {

        try {
            File myFile = new File("EVE01Sales.txt");
            Scanner reader = new Scanner(myFile);

            int row = 0, Total = 0, E011 = 0, E012 = 0, E013 = 0, E014 = 0, ProductA = 0, ProductB = 0, ProductC = 0,
                    ProductD = 0;

            String data = reader.nextLine();

            // Now data is saved in form of array
            String[] sepData = data.split("\t");

            while (reader.hasNextLine()) {
                data = reader.nextLine();

                sepData = data.split("\t");

                int qty = Integer.parseInt(sepData[4]);
                int price = Integer.parseInt(sepData[5]);

                // Total Sales Amount
                int rowTotal = qty * price;
                Total += rowTotal;

                // Employee-wise Sales Amount:

                // Employee E011
                if (sepData[2].equals("E011")) {
                    rowTotal = qty * price;
                    E011 += rowTotal;
                }
                // Employee E012
                else if (sepData[2].equals("E012")) {
                    rowTotal = qty * price;

                    E012 += rowTotal;
                }
                // Employee E013
                else if (sepData[2].equals("E013")) {
                    rowTotal = qty * price;
                    E013 += rowTotal;
                }
                // Employee E014
                else if (sepData[2].equals("E014")) {
                    rowTotal = qty * price;
                    E014 += rowTotal;
                }

                // Product-Wise Sales Amount:

                // Product A
                if (sepData[3].equals("Product A")) {
                    rowTotal = qty * price;
                    ProductA += rowTotal;
                }
                // Product B
                else if (sepData[3].equals("Product B")) {
                    rowTotal = qty * price;
                    ProductB += rowTotal;
                }
                // Product C
                else if (sepData[3].equals("Product C")) {
                    rowTotal = qty * price;
                    ProductC += rowTotal;
                }
                // Product D
                else if (sepData[3].equals("Product D")) {
                    rowTotal = qty * price;
                    ProductD += rowTotal;
                }
            }
            System.out.println("The Sales Total Amount is Rs." + Total);

            System.out.println("\n");
            System.out.println("The Sales Amount is Employee E011 is Rs." + E011);
            System.out.println("The Sales Amount is Employee E012 is Rs." + E012);
            System.out.println("The Sales Amount is Employee E013 is Rs." + E013);
            System.out.println("The Sales Amount is Employee E014 is Rs." + E014);
            System.out.println("\n");

            System.out.println("The Sales Amount is Employee Product A is Rs." + ProductA);
            System.out.println("The Sales Amount is Employee Product B is Rs." + ProductB);
            System.out.println("The Sales Amount is Employee Product C is Rs." + ProductC);
            System.out.println("The Sales Amount is Employee Product D is Rs." + ProductD);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}