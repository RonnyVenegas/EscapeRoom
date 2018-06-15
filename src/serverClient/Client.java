package serverClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import static javafx.application.Application.launch;
import javax.swing.JOptionPane;

public class Client {

    private DataOutputStream output; // output stream to client
    private DataInputStream input; // input stream from client
    private Socket client; // connection to client
    private final String HOST = "127.0.0.1";
    private final int PORT = 12345;
    private LoginPlayer loginPlayer;

    // connect to server and process messages from server
    public void runClient() {
        try {// connect to server, get streams, process connection
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // connect to server
    private void connectToServer() throws IOException {
        System.out.println("Attempting connection\n");
        // create Socket to make connection to server
        client = new Socket(HOST, PORT);
        // display connection information
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
    }

    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for data
        output = new DataOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information   
        // set up input stream for data
        input = new DataInputStream(client.getInputStream());
    }

    // process connection with server
    private void processConnection() throws IOException {

        String stringMessage;
        boolean continueBuying = true;
        loginPlayer = new LoginPlayer();
        //loginPlayer.displayLoginPlayer();
        
        //add logic to send request to the server here, as it seems it doesnt 
        // have any real logic just send information for the server to process.
        /**
        while (continueBuying) {

            stringMessage = input.readUTF();
            int number = Integer.parseInt(JOptionPane.showInputDialog(stringMessage));
            output.writeInt(number);
            stringMessage = input.readUTF();
            int seatsCount = Integer.parseInt(JOptionPane.showInputDialog(stringMessage));
            output.writeInt(seatsCount);
            for(int i = seatsCount; i > 0; i--){
                stringMessage = input.readUTF();
                String seatSelected = JOptionPane.showInputDialog(stringMessage);
                output.writeUTF(seatSelected);
                boolean taken = input.readBoolean();
                if(!taken){
                    i++;
                }
            }
            
            stringMessage = input.readUTF();
            output.writeInt(Integer.parseInt(JOptionPane.showInputDialog(stringMessage)));
            
            stringMessage = input.readUTF();
            JOptionPane.showMessageDialog(null, stringMessage);
            
            int option = Integer.parseInt(JOptionPane.showInputDialog("would you like to exit?\n 1: Yes \n 2: No"));
            if(option == 1){
                continueBuying = false;
            }
            output.writeBoolean(continueBuying);
        }*/
        
        
    }

    private void closeConnection() {
        System.out.println("\nClosing connection");
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().runClient();
    }
}
