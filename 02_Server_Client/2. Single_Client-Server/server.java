import java.io.IOException;
import serverclientpackage.TCPServer;

class server{
    public static void main(String arg[]) throws IOException {
        TCPServer server = new TCPServer(9090);

        String message = server.receive();

        System.out.println(message);

        server.send("Hi from Server");

        server.close();
    }
}