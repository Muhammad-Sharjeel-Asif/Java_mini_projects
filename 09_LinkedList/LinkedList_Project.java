import java.util.LinkedList;
import java.io.IOException;
import java.util.Scanner;

public class LinkedList_Project {

    public static void addLinkedList(LinkedList<Integer> numList) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number to add (type 'x' to stop): ");

            if (input.hasNextInt()) {
                int num = input.nextInt();
                numList.add(num);
            } else {
                String stopVar = input.next();
                if (stopVar.matches("[a-zA-Z+]")) {
                    break;
                }
            }
        }
        System.out.println("Updated List: " + numList);
    }

    public static void sortLinkedList(LinkedList<Integer> numList) {

        // bubble sort
        for (int i = 0; i < numList.size() - 1; i++) {
            for (int j = 0; j < numList.size() - i - 1; j++) {
                if (numList.get(j) > numList.get(j + 1)) {
                    int temp = numList.get(j);
                    numList.set(j, numList.get(j + 1));
                    numList.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> numList = new LinkedList<Integer>();
        numList.add(8);
        numList.add(5);
        numList.add(1);
        numList.add(0);
        numList.add(6);
        numList.add(9);

        System.out.println("The current list is: " + numList + "\n");

        System.out.println("1. Add new item to the list");
        System.out.println("2. Create new list");
        System.out.println("3. Sort the given list \n");

        System.out.print("Select the operation to perform: ");
        Scanner input = new Scanner(System.in);

        int userInput = input.nextInt();

        // Option 1
        if (userInput == 1) {
            addLinkedList(numList);

            // Sort new list
            System.out.print("Do you want to sort the new List (y/n): ");
            String newSortInp = input.next();

            if (newSortInp.equals("y")) {
                sortLinkedList(numList);
                System.out.println("The new sorted listed is: " + numList);
            }
        }

        // Option 2
        else if (userInput == 2) {
            numList.clear();
            addLinkedList(numList);

            // Sort list
            System.out.print("Do you want to sort the new List (y/n): ");
            String newSortInp = input.next();

            if (newSortInp.equals("y")) {
                sortLinkedList(numList);
                System.out.println("The new sorted listed is: " + numList);
            }
        }

        // Option 3
        else if (userInput == 3) {
            sortLinkedList(numList);
            System.out.println("The sorted listed is: " + numList);
        }

        else {
            System.out.println("Please select a valid option!");
        }
    }
}