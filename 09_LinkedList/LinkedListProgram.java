import java.util.Scanner;

public class LinkedListProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize linked list with some elements
        Node.startIndex = 1;
        Node[] linkedList = {
                new Node(65, 3),
                new Node(15, 2),
                new Node(45, 0),
                new Node(72, -1)
        };

        while (true) {
            // Display menu
            System.out.println("ACTIONS:");
            System.out.println("\t1. Create a new linked list");
            System.out.println("\t2. Add an element to the list");
            System.out.println("\t3. Print all elements");
            System.out.println("\t4. Quit (or type 'quit')");
            System.out.print("\nChoose an action (1-4): ");

            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("1")) {
                // Create new empty list
                linkedList = new Node[0];
                Node.startIndex = -1;
                System.out.println("New empty linked list created.\n");

            } else if (choice.equalsIgnoreCase("2")) {
                // Add new element
                System.out.print("Enter a number: ");
                String input = scanner.nextLine().trim();
                try {
                    float num = Float.parseFloat(input);
                    linkedList = addElement(num, linkedList);
                    System.out.println(num + " added to the list.\n");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Try again.\n");
                }

            } else if (choice.equalsIgnoreCase("3")) {
                // Print list
                printList(linkedList);

            } else if (choice.equalsIgnoreCase("4") || choice.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program...");
                break;

            } else {
                System.out.println("Invalid choice. Please enter 1–4 or 'quit'.\n");
            }
        }

        scanner.close();
    }

    // Print all elements
    public static void printList(Node[] list) {
        System.out.println("\nLinked List:");
        if (list == null || list.length == 0 || Node.startIndex == -1) {
            System.out.println("<empty>\n");
            return;
        }

        int i = Node.startIndex;
        while (i != -1) {
            if (i < 0 || i >= list.length) {
                System.out.println("[error] Invalid node index: " + i);
                break;
            }
            System.out.println(list[i].data);
            i = list[i].nextIndex;
        }
        System.out.println();
    }

    // Add an element to the linked list
    public static Node[] addElement(float newValue, Node[] list) {
        int current = Node.startIndex;
        int previous = Node.startIndex;

        if (list.length == 0) {
            // Empty list → first element
            list = addNode(list, new Node(newValue, -1));
            Node.startIndex = 0;
        } else if (newValue < list[current].data) {
            // Insert at start
            Node.startIndex = list.length;
            list = addNode(list, new Node(newValue, current));
        } else {
            // Insert in sorted order
            while (current != -1 && list[current].data <= newValue) {
                previous = current;
                current = list[current].nextIndex;
            }

            list[previous].nextIndex = list.length;
            list = addNode(list, new Node(newValue, current));
        }

        return list;
    }

    // Append a new node to the list array
    public static Node[] addNode(Node[] list, Node node) {
        Node[] newList = new Node[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        newList[newList.length - 1] = node;
        return newList;
    }
}

// Node class representing each element
class Node {
    static int startIndex;
    float data;
    int nextIndex;

    Node(float data, int nextIndex) {
        this.data = data;
        this.nextIndex = nextIndex;
    }
}
