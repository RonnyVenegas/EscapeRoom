/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Maricela Ledezma
 */
public class ModifyPlayerIdGUI {
    
     AnchorPane pane;
    Button btnChangeNameTeam;
    Button btnModifyPlayerId;
    Button btnAddPlayer;
    ImageView img;
    Scene scene;
    Stage stage = new Stage();
    
    public void displaySignWindow() {
        //inicializerElements();
        scene = new Scene(pane, 680.0, 380.0);
        stage.setTitle("ModifyTeam");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
