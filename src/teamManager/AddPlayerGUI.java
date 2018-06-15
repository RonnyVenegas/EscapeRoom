/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Maricela Ledezma
 */
public class AddPlayerGUI {
  
    ImageView img;
    private Scene scene;
    private final Stage stage = new Stage();
    private SignInLogic signInLogic = new SignInLogic();
    public static AnchorPane signContainer;
    public static Label lblTeam;
    public static Label lblNewPlayerId;
    private static Label lblPlayer;
    public static TextField txtTeam;
    public static TextField txtNewPlayerId;
    public static Button btnSave;
    public static Button returnButton;
    public static TextArea textAreaAddPlayer;

    public void initializeElements() {
        signContainer = new AnchorPane();
        lblTeam = new Label("Name Team");
        lblNewPlayerId = new Label("New Player Id");
        lblPlayer = new Label("Player");
        txtTeam = new TextField();
        txtNewPlayerId = new TextField();
        btnSave = new Button("Save");
        returnButton = new Button("Return");
        textAreaAddPlayer = new TextArea();
        img = new ImageView();

        txtTeam.setPromptText("Team");
        txtTeam.setPrefSize(160, 10);
        txtTeam.setTranslateX(130);
        txtTeam.setTranslateY(40);
        
        txtNewPlayerId.setPromptText("New player");
        txtNewPlayerId.setPrefSize(160, 10);
        txtNewPlayerId.setTranslateX(130);
        txtNewPlayerId.setTranslateY(90);

        textAreaAddPlayer.setText("Add Player \n-----------------------------------------------------------");
        textAreaAddPlayer.setPrefSize(300, 100);
        textAreaAddPlayer.setTranslateX(130);
        textAreaAddPlayer.setTranslateY(135);
        textAreaAddPlayer.setEditable(false);

        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(100);
        btnSave.setTranslateY(350);
        
        returnButton.setPrefSize(80, 10);
        returnButton.setTranslateX(200);
        returnButton.setTranslateY(350);

        lblTeam.setTranslateX(30);
        lblTeam.setTranslateY(40);

        lblNewPlayerId.setTranslateX(30);
        lblNewPlayerId.setTranslateY(90);

        lblPlayer.setTranslateX(30);
        lblPlayer.setTranslateY(130);
        
        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/maze-hr.jpg")));
        
        btnSave.setOnAction(event -> {
//            signInLogic.createTeam();
//            signInLogic.validateTeamPlayers();
        });
        returnButton.setOnAction(event -> {
            stage.close();
            new ModifyTeam().displaySignWindow();
        });

        signContainer.getChildren().addAll(img,lblTeam, lblNewPlayerId, lblPlayer, txtTeam, txtNewPlayerId,
                        textAreaAddPlayer,btnSave,returnButton);
    }

    public void displaySignWindow() {
        initializeElements();
        scene = new Scene(signContainer, 600.0, 380.0);
        stage.setTitle("AddPlayer");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
