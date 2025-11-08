import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 9999);

        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        pw.println("Hi from client");

        String message = br.readLine();
        System.out.println(message);
    }
}
