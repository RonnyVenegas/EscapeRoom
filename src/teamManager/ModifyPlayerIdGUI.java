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
public class ModifyPlayerIdGUI { // esta clase es diferente

    ImageView img;
    private Scene scene;
    private final Stage stage = new Stage();
    private SignInLogic signInLogic = new SignInLogic();
    public static AnchorPane signContainer;
    public static Label lblPlayerId;
    public static Label lblNewPlayerId;
    public static TextField txtPlayerID;
    public static TextField txtNewPlayerId;
    public static Button btnSave;
    public static Button returnButton;

    public void initializeElements() {
        signContainer = new AnchorPane();
        lblPlayerId = new Label("Player Id");
        lblNewPlayerId = new Label("New Player Id");
        txtPlayerID = new TextField();
        txtNewPlayerId = new TextField();
        btnSave = new Button("Save");
        returnButton = new Button("Return");
        img = new ImageView();

        txtPlayerID.setPromptText("Player Id");
        txtPlayerID.setPrefSize(160, 10);
        txtPlayerID.setTranslateX(180);
        txtPlayerID.setTranslateY(80);
        
        txtNewPlayerId.setPromptText("New player Id");
        txtNewPlayerId.setPrefSize(160, 10);
        txtNewPlayerId.setTranslateX(180);
        txtNewPlayerId.setTranslateY(160);

        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(100);
        btnSave.setTranslateY(350);
        
        returnButton.setPrefSize(80, 10);
        returnButton.setTranslateX(200);
        returnButton.setTranslateY(350);

        lblPlayerId.setTranslateX(40);
        lblPlayerId.setTranslateY(90);

        lblNewPlayerId.setTranslateX(40);
        lblNewPlayerId.setTranslateY(170);
        
        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/maze-hr.jpg")));
        
        btnSave.setOnAction(event -> {
//            if (signInLogic.containsPlayer(txtPlayerID.getText()) == false) {
//             textAreaPlayer.setText("El jugador no existe");
//            }else{
//            //signInLogic.modifyId();
//            }
        });
        returnButton.setOnAction(event -> {
            stage.close();
            new ModifyTeam().displaySignWindow();
        });

        signContainer.getChildren().addAll(img,lblPlayerId, lblNewPlayerId,txtPlayerID, txtNewPlayerId,
                        btnSave,returnButton);
    }

    public void displaySignWindow() {
        initializeElements();
        scene = new Scene(signContainer,500.0, 380.0);
        stage.setTitle("ModifyPlayerId");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
