/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManagerGUI;

import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import teamManagerLogic.LogicModifyTeam;


public class GUIAddPlayer {
  
    ImageView img;
    private Scene scene;
    private final Stage stage = new Stage();
    private LogicModifyTeam modifyTeamLogic = new LogicModifyTeam();
    public static AnchorPane signContainer;
    public static Label lblTeam;
    public static Label lblNewPlayerId;
    public static TextField txtTeam;
    public static TextField txtNewPlayerId;
    public static Button btnSave;
    public static Button returnButton;

    public void initializeElements() {
        signContainer = new AnchorPane();
        lblTeam = new Label("Name Team");
        lblNewPlayerId = new Label("New Player Id");
        txtTeam = new TextField();
        txtNewPlayerId = new TextField();
        btnSave = new Button("Save");
        returnButton = new Button("Return");
        img = new ImageView();

        txtTeam.setPromptText("Team");
        txtTeam.setPrefSize(160, 10);
        txtTeam.setTranslateX(180);
        txtTeam.setTranslateY(80);
        
        txtNewPlayerId.setPromptText("New player");
        txtNewPlayerId.setPrefSize(160, 10);
        txtNewPlayerId.setTranslateX(180);
        txtNewPlayerId.setTranslateY(160);

        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(100);
        btnSave.setTranslateY(350);
        
        returnButton.setPrefSize(80, 10);
        returnButton.setTranslateX(200);
        returnButton.setTranslateY(350);

        lblTeam.setTranslateX(40);
        lblTeam.setTranslateY(90);

        lblNewPlayerId.setTranslateX(40);
        lblNewPlayerId.setTranslateY(170);
        
        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/maze-hr.jpg")));
        
        btnSave.setOnAction(event -> {
            modifyTeamLogic.addPlayer();
        });
        returnButton.setOnAction(event -> {
            stage.close();
            new GUIModifyTeam().displaySignWindow();
        });
        stage.setOnCloseRequest(event -> {
            stage.close();
            new GUIModifyTeam().displaySignWindow();
        });
        signContainer.getChildren().addAll(img,lblTeam, lblNewPlayerId,txtTeam, txtNewPlayerId,
                        btnSave,returnButton);
    }

    public void displaySignWindow() {
        initializeElements();
        scene = new Scene(signContainer,500.0, 380.0);
        scene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);
        stage.setTitle("Add player");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
