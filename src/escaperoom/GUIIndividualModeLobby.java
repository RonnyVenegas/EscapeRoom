package escaperoom;

import serverClient.*;
import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GUIIndividualModeLobby extends Thread {

    private Stage lobbyStage = new Stage();
    private LogicIndividualModeLobby logicClass;
    public static AnchorPane lobbyContainer;
    public static ScrollPane scrollPanePlayerList;
    public static TextArea textAreaPlayerList;
    public static Label lblTeamName;
    public static Label lblPlayerList;
    public static ComboBox teamCombo;
    public static ComboBox playerCombo;
    public static Button btnAddPlayer;
    public static Button play;
    public static Button returnButton;
    public static Scene lobbyScene;

    String txt = "";
    
    Server server;

    public void initializeElements() {
        logicClass = new LogicIndividualModeLobby();
        lobbyContainer = new AnchorPane();
        lblTeamName = new Label("Team name");
        lblPlayerList = new Label("Player ID");
        teamCombo = new ComboBox();
        playerCombo = new ComboBox();
        btnAddPlayer = new Button("+");
        play = new Button("Play");
        returnButton = new Button("Retun");
        scrollPanePlayerList = new ScrollPane();
        textAreaPlayerList = new TextArea();
        lobbyContainer.setPadding(new Insets(20));
        scrollPanePlayerList.setTranslateX(30);
        scrollPanePlayerList.setTranslateY(120);

        teamCombo.setPromptText("Select Team");
        playerCombo.setPromptText("Select Player");
        textAreaPlayerList.setText("Team players \n-----------------------------------------------------------");
        btnAddPlayer.setPrefSize(30, 10);
        play.setPrefSize(80, 10);
        teamCombo.setPrefSize(160, 10);
        playerCombo.setPrefSize(160, 10);

        lblTeamName.setTranslateX(30);
        lblTeamName.setTranslateY(20);
        lblPlayerList.setTranslateX(30);
        lblPlayerList.setTranslateY(80);
        textAreaPlayerList.setPrefSize(300, 200);
        teamCombo.setTranslateX(130);
        teamCombo.setTranslateY(20);
        playerCombo.setTranslateX(130);
        playerCombo.setTranslateY(80);
        btnAddPlayer.setTranslateX(300);
        btnAddPlayer.setTranslateY(80);

        play.setTranslateX(150);
        play.setTranslateY(325);

        returnButton.setTranslateX(10);
        returnButton.setTranslateY(325);
        textAreaPlayerList.setEditable(false);
        scrollPanePlayerList.setContent(textAreaPlayerList);

        logicClass.fillTeamsComboBox();
        
        teamCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                logicClass.fillPlayersComboBox(newValue.toString());
            }
        });
        
        play.setOnAction(event -> {
            lobbyStage.close();
            logicClass.startGame();
//            lobbyStage.close();
//            Level1.displayLevel();
            //recieve the sockets and start the game with N players all with the same game intance.

        });

        btnAddPlayer.setOnAction(event -> {
            logicClass.addPlayer(playerCombo.getSelectionModel().selectedItemProperty().getValue().toString());
        });

        returnButton.setOnAction(event -> {
            lobbyStage.close();
            new GUIGameModeSelection().displayGameModeSelectionWindow();
        });
        lobbyContainer.getChildren().addAll(lblPlayerList, lblTeamName, teamCombo, playerCombo, btnAddPlayer,
                play, scrollPanePlayerList, returnButton);
    }

    public void displayLobby() {
        initializeElements();
        lobbyScene = new Scene(lobbyContainer, 350, 353);
        lobbyScene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);
        lobbyStage.setTitle("Escape Room - Lobby");
        lobbyStage.setScene(lobbyScene);
        lobbyStage.setResizable(false);
        lobbyStage.show();
    }
}
