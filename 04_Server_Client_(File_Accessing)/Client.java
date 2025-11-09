import java.io.*;
import java.util.Scanner;
import serverclientpackage.TCPClient;

public class Client {
    public static void main(String[] args) throws IOException {
        TCPClient client = new TCPClient("127.0.0.1", 9999);
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {

                System.out.println("Available files:");
                String line;
                while (!(line = client.receive()).equals("END_OF_LIST")) {
                    System.out.println(line);
                }
                

                System.out.print("\nEnter filename (or 'quit'): ");
                String fileName = scanner.nextLine();
                client.send(fileName);
                
                if (fileName.equalsIgnoreCase("quit")) {
                    break;
                }
                

                System.out.println("\n--- File Content ---");
                while (!(line = client.receive()).equals("END_OF_FILE")) {
                    System.out.println(line);
                }
                System.out.println("-----------------------------\n");
            }
        } finally {
            client.close();
            scanner.close();
        }
    }
}