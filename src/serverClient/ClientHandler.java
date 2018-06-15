/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverClient;

import escaperoom.Level1;
import escaperoom.Lock1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler extends Thread {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket client;
    Server server;
    Level1 level;

    // Constructor
    public ClientHandler(Socket client) throws IOException {
        this.level = new Level1();
        this.client = client;
        getStreams(client);
    }

    // get streams to send and receive data
    private void getStreams(Socket client) throws IOException {
        // set up output stream for data
        output = new DataOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information   
        // set up input stream for data
        input = new DataInputStream(client.getInputStream());
    }

    @Override
    public void run() {
        
        boolean continueThead = true;
        //add the logic to control the game.
        // this method has to recieve information from the client, lock and level.
        /**
        String movies = cinema.getMoviesString();
        String selectedMovie = "";

        while (continueThead) {
            String stringMessage = "Welcome to Sockets Cinemas:\n"
                    + "please select your movie or 0 to exit:\n" + movies;
            try {
                output.writeUTF(stringMessage);
                int result = input.readInt();
                selectedMovie = cinema.getMovie(result - 1).getDescription();
                if(movieMethods == null){
                    movieMethods = new Movie(cinema.getMovie(result - 1).getDescription(), 5, 5);
                }
                output.writeUTF("You selected:\n" + selectedMovie + "\n" + "Seats:\n" + movieMethods.getSeatsString()
                        + "\nHow many seats would you like to buy?");
                int seatsTobuy = input.readInt();

                for (int i = seatsTobuy; i > 0; i--) {
                    output.writeUTF("You selected:\n" + selectedMovie + "\n" + "Seats:\n" + movieMethods.getSeatsString());
                    String seat = input.readUTF();
                    String[] seatSplit = seat.split("-");
                    int row = Integer.parseInt(seatSplit[0]);
                    int column = Integer.parseInt(seatSplit[1]);
                    boolean taken = movieMethods.setSeat(row, column);
                    output.writeBoolean(taken);
                    if(!taken){
                        i++;
                    }

                }

                stringMessage = "Are you sure you want to buy this tickets?\n 1: Yes \n2: No";
                output.writeUTF(stringMessage);
                int yesNo = input.readInt();
                if (yesNo == 1) {
                    movieMethods.saveSeatsSelection();
                    stringMessage = "Thank you, the seats are yours." + "\nYour total cost is: " + seatsTobuy * 2500;
                    output.writeUTF(stringMessage);
                } else {
                    movieMethods.undoSeatsSelection();
                    stringMessage = "Ok, no problem";
                    output.writeUTF(stringMessage);
                }

                continueThead = input.readBoolean();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CinemaException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/

    }
}
