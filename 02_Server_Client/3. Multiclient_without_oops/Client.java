import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 3000);

        // Send data to the server
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Hello Server!");

        // Receive response from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String response = in.readLine();
        System.out.println("Server says: " + response);

        clientSocket.close();
    }
}
