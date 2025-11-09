import java.io.IOException;
import serverclientpackage.TCPClient;

public class Client {
    public static void main(String[] args) throws IOException {
        TCPClient client = new TCPClient("127.0.0.1", 9999);

        while (true) {
            String sendMessage = client.send();

            if (sendMessage.equalsIgnoreCase("quit")) {
                break;
            }

            String receivedMessage = client.receive();
            System.out.println("Server: " + receivedMessage);

            if (receivedMessage.equalsIgnoreCase("quit")) {
                break;
            }
        }

        client.close();
    }
}
