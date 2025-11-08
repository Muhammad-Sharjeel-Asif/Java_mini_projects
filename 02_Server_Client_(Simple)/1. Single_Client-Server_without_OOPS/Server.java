import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) throws IOException {

        // create a server socket on port number 9090
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server is waiting for connection");

        // Accept incoming client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        String recMessage;

        // Setup input and output streams for communication with the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Read message from client
        recMessage = in.readLine();
        System.out.println("Client says: " + recMessage);

        // Send response to the client
        Scanner input = new Scanner(System.in);
        System.out.print("Enter message to send to Client: ");
        String sendMessage = input.nextLine();

        out.println("Server says: " + sendMessage);

        // Close the client socket
        clientSocket.close();
        // Close the server socket
        serverSocket.close();
    }
}