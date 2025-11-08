import serverclientpackage.TCPClient;
import java.io.IOException;;

public class Client {

    public static void main(String[] args) throws IOException {

        TCPClient client = new TCPClient("127.0.0.1", 9999);

        while (true) {

            String sendMessage = client.send();
            System.out.println("Server: " + sendMessage);

            if (sendMessage.equalsIgnoreCase("quit")) {
                break;
            }

            String receivedMessage = client.receive();

            if (sendMessage.equalsIgnoreCase("quit") || receivedMessage.equalsIgnoreCase("quit")) {
                break;
            }
        }

        client.close();
    }
}