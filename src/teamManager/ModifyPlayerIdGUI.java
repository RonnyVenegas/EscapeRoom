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
    public static Label lblTeam;
    public static Label lblPlayerId;
    public static Label lblNewPlayerId;
    public static TextField txtTeam;
    public static TextField txtPlayerID;
    public static TextField txtNewPlayerId;
    public static Button btnSave;
    public static Button returnButton;

    public void initializeElements() {
        signContainer = new AnchorPane();
        lblTeam = new Label("Team");
        lblPlayerId = new Label("Player Id");
        lblNewPlayerId = new Label("New Player Id");
        txtTeam = new TextField();
        txtPlayerID = new TextField();
        txtNewPlayerId = new TextField();
        btnSave = new Button("Save");
        returnButton = new Button("Return");
        img = new ImageView();

        txtTeam.setPromptText("Team");
        txtTeam.setPrefSize(160, 10);
        txtTeam.setTranslateX(180);
        txtTeam.setTranslateY(40);
        
        txtPlayerID.setPromptText("Player Id");
        txtPlayerID.setPrefSize(160, 10);
        txtPlayerID.setTranslateX(180);
        txtPlayerID.setTranslateY(120);
        
        txtNewPlayerId.setPromptText("New player Id");
        txtNewPlayerId.setPrefSize(160, 10);
        txtNewPlayerId.setTranslateX(180);
        txtNewPlayerId.setTranslateY(200);

        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(100);
        btnSave.setTranslateY(350);
        
        returnButton.setPrefSize(80, 10);
        returnButton.setTranslateX(200);
        returnButton.setTranslateY(350);

        lblTeam.setTranslateX(40);
        lblTeam.setTranslateY(50);

        lblPlayerId.setTranslateX(40);
        lblPlayerId.setTranslateY(130);
        
        lblNewPlayerId.setTranslateX(40);
        lblNewPlayerId.setTranslateY(210);
        
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

        signContainer.getChildren().addAll(img,lblTeam,lblPlayerId,lblNewPlayerId,txtTeam,txtPlayerID,txtNewPlayerId,
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
