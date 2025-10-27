import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) throws IOException {
        String message = "";

        // create a server socket on port number 9090
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server is waiting for connection");

        // Accept incoming client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        while (!message.equals("quit")) {
            // Setup input and output streams for communication with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read message from client
            message = in.readLine();
            System.out.println("Client says: " + message);

            // Send response to the client
            out.println(message);

        }
        // Close the client socket
        clientSocket.close();
        // Close the server socket
        serverSocket.close();
    }
}