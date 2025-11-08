import serverclientpackage.TCPServer;
import java.io.IOException;;

public class Server {
    public static void main(String[] args) throws IOException {

        TCPServer server = new TCPServer(9999);

        while (true) {

            String recievedMessage = server.receive();
            System.out.println("Client: " + recievedMessage);

            String sendMessage = server.send();

            if (recievedMessage.equalsIgnoreCase("quit") || sendMessage.equalsIgnoreCase("quit")) {
                break;
            }

        }
        server.close();
    }
}
