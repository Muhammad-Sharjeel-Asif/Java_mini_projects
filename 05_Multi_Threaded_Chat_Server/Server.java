import java.io.IOException;
import serverclientpackage.TCPServer;

public class Server {
    public static void main(String[] args) throws IOException {
        TCPServer server = new TCPServer(9999);
        server.start(); // Starts accepting multiple clients
    }
}
