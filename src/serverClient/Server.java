package serverClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //private DataOutputStream output; // output stream to client
    //private DataInputStream input; // input stream from client
    private ServerSocket server; // server socket
    private Socket connection; // connection to client
    private final int PORT = 12345;
    private ClientHandler clientHandler;

    // set up and run server
    public void runServer() throws IOException {
        server = new ServerSocket(PORT);
        while (true) {
            try {
                // create ServerSocket
                clientHandler = new ClientHandler(server.accept());
                clientHandler.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Delete later: wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException {
        System.out.println("Waiting for connection...\n");
        System.out.println("Connection received from: " + connection.getInetAddress().getHostName());
    }

    public static void main(String[] args) throws IOException {
        try {
            new Server().runServer();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
