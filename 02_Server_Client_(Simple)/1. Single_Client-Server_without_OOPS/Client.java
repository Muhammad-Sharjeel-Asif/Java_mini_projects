import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 3000);
        // Setup output stream to send data to the server
        Scanner input = new Scanner(System.in);
        System.out.print("Enter message to send Server: ");
        String sendMessage = input.nextLine();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Client says: " + sendMessage);

        // Setup input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String recMessage = in.readLine();
        System.out.println("Server says: " + recMessage);

        // Close the socket
        clientSocket.close();
    }
}