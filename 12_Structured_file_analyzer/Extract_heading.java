
import java.util.HashMap;
import java.util.Scanner;

public class Extract_heading {
    public static void main(String[] args) {

        try {
            Scanner read = new Scanner("EVE01Sales.txt");
            String rawHeading = read.nextLine();

            String[] heading = rawHeading.split("\t");

            Scanner readUser = new Scanner(System.in);
            int userChoice = readUser.nextInt();

            for (int i = 0; i < heading.length - 2; i++) {
                System.out.println(i + 1 + ". " + heading[i] + "-wise Sales");
            }
            System.out.println(heading.length - 1 + ".Day-wise Sales");

            HashMap<String, HashMap<String, Integer>> groupSales = new HashMap<>();

            while (read.hasNextLine()) {
                String rawData = read.nextLine();
                String[] data = rawHeading.split("\t");

                int qty = Integer.parseInt(data[data.length - 2]);
                int price = Integer.parseInt(data[data.length - 1]);
                int rowSales = qty * price;

                for (int i = 0; i < heading.length - 2; i++) {
                    String colHead = heading[i];
                    String value = data[i];

                    HashMap<String, Integer> innerHashMap = groupSales.getOrDefault(colHead, new HashMap<>());

                    int initValue = innerHashMap.getOrDefault(value, 0);
                    innerHashMap.put(value, initValue + rowSales);

                    groupSales.put(colHead, innerHashMap);  
                }
            }
            read.close();

            if(userChoice >= 1 && userChoice <= heading.length-2){
                String headChoice = heading[userChoice - 1];
                HashMap<String, Integer> map = groupSales.get(headChoice);
                for (String head : map.keySet()) {
                    System.out.println("The Sale Amount of " + head + " is" + map.get(head));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}