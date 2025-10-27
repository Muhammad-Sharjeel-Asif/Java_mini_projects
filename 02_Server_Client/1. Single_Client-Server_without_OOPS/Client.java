import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 3000);
        // Setup output stream to send data to the server
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("");

        // Setup input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        // Receive response from the server
        String response = in.readLine();
        System.out.println("Server says: " + response);
        // Close the socket
        clientSocket.close();
    }
}