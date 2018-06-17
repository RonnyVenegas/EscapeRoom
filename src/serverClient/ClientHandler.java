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
/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package serverClient;

import escapeRoomFiles.EscapeRoomConfigurations;
import static escapeRoomFiles.EscapeRoomConfigurations.TEAMS_FROM_FILE;
import escaperoom.Level1;
import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import screenManager.Main;
import teamManager.ManagerReader;
import static escapeRoomFiles.EscapeRoomConfigurations.TEAM_FILE_ROUTE;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import teamManager.Player;
import teamManager.Team;


 *
 * @author Ronny

public class Lobby extends Thread{

    public static final Stage lobbyStage = new Stage();
    public static Scene lobbyScene;
    public static AnchorPane lobbyContainer;
    public static Label lblTeamName;
    public static Label lblGameType;
    private static Label lblPlayerList;
    public static ComboBox teamCombo;
    public static ComboBox gameTypeCombo;
    public static ComboBox playerCombo;
    public static Button btnAddPlayer;
    public static Button play;
    public static ScrollPane scrollPanePlayerList;
    public static TextArea textAreaPlayerList;
    public static Button returnButton;

    public int numberOfPlayers = 0;

    private Level1 Level1 = new Level1();

    String txt = "";

    public void initializeElements() throws FileNotFoundException, IOException {

        lobbyContainer = new AnchorPane();
        lblTeamName = new Label("Team name");
        lblGameType = new Label("Game Type");
        lblPlayerList = new Label("Player ID");
        
        

        teamCombo = new ComboBox();
        gameTypeCombo = new ComboBox();
        playerCombo = new ComboBox();

        //dummy data for combo boxes
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE){
            for(int i = 0; i < team.getTeamPlayers().size(); i++){
                playerCombo.getItems().add(team.getTeamPlayers().get(i).getID());
            }
        }
        
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE){
            teamCombo.getItems().add(team.getTeamName());
        }
        
        gameTypeCombo.getItems().addAll("Indiviaul", "Equipos");

        btnAddPlayer = new Button("+");
        play = new Button("Play");

        returnButton = new Button("Retun");

        scrollPanePlayerList = new ScrollPane();
        textAreaPlayerList = new TextArea();

        lobbyContainer.setPadding(new Insets(20));
        scrollPanePlayerList.setTranslateX(30);
        scrollPanePlayerList.setTranslateY(120);

        teamCombo.setPromptText("Team name");
        playerCombo.setPromptText("New player");
        textAreaPlayerList.setText("Team players \n-----------------------------------------------------------");
        btnAddPlayer.setPrefSize(30, 10);
        play.setPrefSize(80, 10);
        teamCombo.setPrefSize(160, 10);
        gameTypeCombo.setPrefSize(160, 10);
        playerCombo.setPrefSize(160, 10);

        lblTeamName.setTranslateX(30);
        lblTeamName.setTranslateY(20);
        lblGameType.setTranslateX(30);
        lblGameType.setTranslateY(50);
        lblPlayerList.setTranslateX(30);
        lblPlayerList.setTranslateY(80);
        textAreaPlayerList.setPrefSize(300, 200);
        teamCombo.setTranslateX(130);
        teamCombo.setTranslateY(20);
        playerCombo.setTranslateX(130);
        playerCombo.setTranslateY(80);
        gameTypeCombo.setTranslateX(130);
        gameTypeCombo.setTranslateY(50);
        btnAddPlayer.setTranslateX(300);
        btnAddPlayer.setTranslateY(80);

        play.setTranslateX(150);
        play.setTranslateY(325);

        returnButton.setTranslateX(300);
        returnButton.setTranslateY(325);
        textAreaPlayerList.setEditable(false);
        gameTypeCombo.setPromptText("Game type");
        scrollPanePlayerList.setContent(textAreaPlayerList);

        play.setOnAction(event -> {

            lobbyStage.close();
            Level1.displayLevel();
            //recieve the sockets and start the game with N players all with the same game intance.

        });

        btnAddPlayer.setOnAction(event -> {
            numberOfPlayers++;
            /**
             * boolean invalidName =
             * signInLogic.validatePlayerID(txtPlayerID.getText());
             *
             * if (invalidName) { JOptionPane.showMessageDialog(null, "Invalid
             * player name"); } else { signInLogic.addPlayerToMap(); txt +=
             * "\n"+txtPlayerID.getText(); textAreaPlayerList.setText(txt);            
            }
        });

        returnButton.setOnAction(event -> {
            lobbyStage.close();
            new Main().start(new Stage());
        });
        lobbyContainer.getChildren().addAll(lblGameType, lblPlayerList, lblTeamName, gameTypeCombo, teamCombo, playerCombo, btnAddPlayer,
                play, scrollPanePlayerList, returnButton);
    }

    public void displayLobby() throws IOException {
        initializeElements();
        lobbyScene = new Scene(lobbyContainer, 350, 350);
        String cssPath = new File("src/css/styles.css").getAbsolutePath().replace("\\", "/");
        lobbyScene.getStylesheets().add("file:///" + cssPath);
        lobbyStage.setTitle("Escape Room - Lobby");
        lobbyStage.setScene(lobbyScene);
        lobbyStage.setResizable(false);
        lobbyStage.show();
    }
}

 * 
 */