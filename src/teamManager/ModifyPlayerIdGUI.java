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
public class ModifyPlayerIdGUI {

    ImageView img;
    private Scene scene;
    private final Stage stage = new Stage();
    private SignInLogic signInLogic = new SignInLogic();
    public static AnchorPane signContainer;
    public static Label lblPlayerId;
    public static Label lblNewPlayerId;
    private static Label lblPlayerList;
    public static TextField txtPlayerID;
    public static TextField txtNewPlayerId;
    public static Button btnSave;
    public static Button returnButton;
    public static TextArea textAreaPlayerList;

    public void initializeElements() {
        signContainer = new AnchorPane();
        lblPlayerId = new Label("Player Id");
        lblNewPlayerId = new Label("New Player Id");
        lblPlayerList = new Label("Player List");
        txtPlayerID = new TextField();
        txtNewPlayerId = new TextField();
        btnSave = new Button("Save");
        returnButton = new Button("Return");
        textAreaPlayerList = new TextArea();
        img = new ImageView();

        txtPlayerID.setPromptText("Player");
        txtPlayerID.setPrefSize(160, 10);
        txtPlayerID.setTranslateX(130);
        txtPlayerID.setTranslateY(40);
        
        txtNewPlayerId.setPromptText("New player");
        txtNewPlayerId.setPrefSize(160, 10);
        txtNewPlayerId.setTranslateX(130);
        txtNewPlayerId.setTranslateY(90);

        textAreaPlayerList.setText("Team players \n-----------------------------------------------------------");
        textAreaPlayerList.setPrefSize(300, 100);
        textAreaPlayerList.setTranslateX(130);
        textAreaPlayerList.setTranslateY(135);
        textAreaPlayerList.setEditable(false);

        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(100);
        btnSave.setTranslateY(350);
        
        returnButton.setPrefSize(80, 10);
        returnButton.setTranslateX(200);
        returnButton.setTranslateY(350);

        lblPlayerId.setTranslateX(30);
        lblPlayerId.setTranslateY(40);

        lblNewPlayerId.setTranslateX(30);
        lblNewPlayerId.setTranslateY(90);

        lblPlayerList.setTranslateX(30);
        lblPlayerList.setTranslateY(130);
        
        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/3d6cdcd6-43e3-40d7-8a99-0e8f01437663.jpg")));
        
        btnSave.setOnAction(event -> {
//            signInLogic.createTeam();
//            signInLogic.validateTeam();
        });

        signContainer.getChildren().addAll(img,lblPlayerId, lblNewPlayerId, lblPlayerList, txtPlayerID, txtNewPlayerId,
                        textAreaPlayerList,btnSave,returnButton);
    }

    public void displaySignWindow() {
        initializeElements();
        scene = new Scene(signContainer, 600.0, 380.0);
        stage.setTitle("ModifyPlayerId");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
