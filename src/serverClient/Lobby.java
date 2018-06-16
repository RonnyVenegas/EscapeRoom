/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverClient;

import escapeRoomFiles.EscapeRoomConfigurations;
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

/**
 *
 * @author Ronny
 */
public class Lobby {

    public static final Stage lobbyStage = new Stage();
    private ManagerReader reader;
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
    private Team team;
    private ArrayList<Player> playerArray;

    public int numberOfPlayers = 0;
    //private SignInLogic signInLogic = new SignInLogic();

    private Level1 Level1 = new Level1();

    String txt = "";

    public void initializeElements() throws FileNotFoundException, IOException {

        lobbyContainer = new AnchorPane();
        lblTeamName = new Label("Team name");
        lblGameType = new Label("Game Type");
        lblPlayerList = new Label("Player ID");
        
        //EscapeRoomConfigurations.TEAMS_FROM_FILE = new ReaderManager().readTeamsFromFile();
        /**reader.open(EscapeRoomConfigurations.TEAM_FILE_ROUTE);
        team = reader.read();
        playerArray = team.getTeamPlayers();
        reader.close();*/

        teamCombo = new ComboBox();
        gameTypeCombo = new ComboBox();
        playerCombo = new ComboBox();

        //dummy data for combo boxes
        /**teamCombo.getItems().addAll(team.getTeamName());
        gameTypeCombo.getItems().addAll("Indiviaul", "Equipos");
        for(int i = 0; i < playerArray.size(); i++){
            playerCombo.getItems().add(playerArray.get(i).getID());
        }*/

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
        gameTypeCombo.setPromptText("Level");
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
             */
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
