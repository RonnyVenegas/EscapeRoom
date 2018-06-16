/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Maricela Ledezma
 */
public class ChangeNameTeamGUI {
    
    ImageView img;
    private Scene scene;
    private final Stage stage = new Stage();
    private ModifyTeamLogic modifyTeamLogic = new ModifyTeamLogic();
    public static AnchorPane signContainer;
    public static Label lblNameTeam;
    public static Label lblNewNameTeam;
    public static TextField txtNameTeam;
    public static TextField txtNewNameTeam;
    public static Button btnSave;
    public static Button returnButton;

    public void initializeElements() {
        signContainer = new AnchorPane();
        lblNameTeam = new Label("Name Team");
        lblNewNameTeam = new Label("New Name Team");
        txtNameTeam = new TextField();
        txtNewNameTeam = new TextField();
        btnSave = new Button("Save");
        returnButton = new Button("Return");
        img = new ImageView();

        txtNameTeam.setPromptText("Team");
        txtNameTeam.setPrefSize(160, 10);
        txtNameTeam.setTranslateX(180);
        txtNameTeam.setTranslateY(80);
        
        txtNewNameTeam.setPromptText("New Name");
        txtNewNameTeam.setPrefSize(160, 10);
        txtNewNameTeam.setTranslateX(180);
        txtNewNameTeam.setTranslateY(160);

        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(100);
        btnSave.setTranslateY(350);
        
        returnButton.setPrefSize(80, 10);
        returnButton.setTranslateX(200);
        returnButton.setTranslateY(350);

        lblNameTeam.setTranslateX(40);
        lblNameTeam.setTranslateY(90);

        lblNewNameTeam.setTranslateX(40);
        lblNewNameTeam.setTranslateY(170);
        
        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/maze-hr.jpg")));
        
        btnSave.setOnAction(event -> {
            modifyTeamLogic.changeNameTeam();
        });
        returnButton.setOnAction(event -> {
            stage.close();
            new ModifyTeam().displaySignWindow();
        });

        signContainer.getChildren().addAll(img,lblNameTeam, lblNewNameTeam,txtNameTeam, txtNewNameTeam,
                  btnSave,returnButton);
    }

    public void displaySignWindow() {
        initializeElements();
        scene = new Scene(signContainer, 500.0, 380.0);
        stage.setTitle("ChangeNameTeam");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
