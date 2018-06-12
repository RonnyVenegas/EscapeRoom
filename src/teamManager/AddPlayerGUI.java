/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Maricela Ledezma
 */
public class AddPlayerGUI {
  
    AnchorPane pane;
    ImageView img;
    Scene scene;
    Stage stage = new Stage();
    public Label lblPlayerId;
    public Label lblNewPlayerId;
    public static TextField txtTeamName;
    public static Button btnSave;
    SignInLogic signInLogic = new SignInLogic();
    
    public void initializerElements() {//agregar campos de texto
       pane = new AnchorPane();
        lblPlayerId = new Label("Player id"); 
        lblNewPlayerId = new Label("New player id"); 
        txtTeamName = new TextField();
        btnSave = new Button("Save");
        
        pane.setPadding(new Insets(20));
        lblPlayerId.setTranslateX(30);
        lblPlayerId.setTranslateY(20);
        lblNewPlayerId.setTranslateX(30);
        lblNewPlayerId.setTranslateY(40);
        
        txtTeamName.setPromptText("Id player");
        txtTeamName.setPrefSize(160, 10);
        txtTeamName.setTranslateX(130);
        txtTeamName.setTranslateY(20);
        
        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(30);
        btnSave.setTranslateY(330);
        btnSave.setOnAction(event -> {
            //metodo verificar id existe
            signInLogic.validatePlayerID(lblNewPlayerId.getText());
            signInLogic.addPlayerToMap();
        });
        
        pane.getChildren().addAll(lblPlayerId,lblNewPlayerId,txtTeamName,btnSave);
    }
    
    public void displaySignWindow() {
        initializerElements();
        scene = new Scene(pane, 680.0, 380.0);
        stage.setTitle("ModifyTeam");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
