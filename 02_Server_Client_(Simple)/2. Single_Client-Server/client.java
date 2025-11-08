import java.io.IOException;
import serverclientpackage.*;

public class client {

    public static void main(String arg[]) throws IOException {
        TCPClient client = new TCPClient("127.0.0.1", 9090);

        client.send();

        String message = client.receive();

        System.out.println("Server: " + message);

        client.close();
    }
}
