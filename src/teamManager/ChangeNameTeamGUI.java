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
public class ChangeNameTeamGUI {
    
    ImageView img;
    private Scene scene;
    private final Stage stage = new Stage();
    private SignInLogic signInLogic = new SignInLogic();
    public static AnchorPane signContainer;
    public static Label lblNameTeam;
    public static Label lblNewNameTeam;
    private static Label lblTeam;
    public static TextField txtNameTeam;
    public static TextField txtNewNameTeam;
    public static Button btnSave;
    public static Button returnButton;
    public static TextArea textAreaTeam;

    public void initializeElements() {
        signContainer = new AnchorPane();
        lblNameTeam = new Label("Name Team");
        lblNewNameTeam = new Label("New Name Team");
        lblTeam = new Label("Team");
        txtNameTeam = new TextField();
        txtNewNameTeam = new TextField();
        btnSave = new Button("Save");
        returnButton = new Button("Return");
        textAreaTeam = new TextArea();
        img = new ImageView();

        txtNameTeam.setPromptText("Team");
        txtNameTeam.setPrefSize(160, 10);
        txtNameTeam.setTranslateX(130);
        txtNameTeam.setTranslateY(40);
        
        txtNewNameTeam.setPromptText("New Name");
        txtNewNameTeam.setPrefSize(160, 10);
        txtNewNameTeam.setTranslateX(130);
        txtNewNameTeam.setTranslateY(90);

        textAreaTeam.setText("Name Team \n-----------------------------------------------------------");
        textAreaTeam.setPrefSize(300, 100);
        textAreaTeam.setTranslateX(130);
        textAreaTeam.setTranslateY(135);
        textAreaTeam.setEditable(false);

        btnSave.setPrefSize(80, 10);
        btnSave.setTranslateX(100);
        btnSave.setTranslateY(350);
        
        returnButton.setPrefSize(80, 10);
        returnButton.setTranslateX(200);
        returnButton.setTranslateY(350);

        lblNameTeam.setTranslateX(30);
        lblNameTeam.setTranslateY(40);

        lblNewNameTeam.setTranslateX(30);
        lblNewNameTeam.setTranslateY(90);

        lblTeam.setTranslateX(30);
        lblTeam.setTranslateY(130);
        
        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/maze-hr.jpg")));
        
        btnSave.setOnAction(event -> {
//            signInLogic.createTeam();
//            signInLogic.validateTeam();
        });
        returnButton.setOnAction(event -> {
            stage.close();
            new ModifyTeam().displaySignWindow();
        });

        signContainer.getChildren().addAll(img,lblNameTeam, lblNewNameTeam, lblTeam, txtNameTeam, txtNewNameTeam,
                        textAreaTeam,btnSave,returnButton);
    }

    public void displaySignWindow() {
        initializeElements();
        scene = new Scene(signContainer, 600.0, 380.0);
        stage.setTitle("ChangeNameTeam");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
