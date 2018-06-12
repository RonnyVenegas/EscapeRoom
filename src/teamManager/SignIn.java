/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Maricela Ledezma
 */
public class SignIn {

    AnchorPane pane;
    Button btnEnrollTeam;
    Button btnModifyTeam;
    ImageView imageSignIn;
    Scene scene;
    Stage stage = new Stage();
    ModifyTeam modify = new ModifyTeam();
    SignInTeam signInTeam = new SignInTeam();

    public void inicializerElements() {
        pane = new AnchorPane();
        btnEnrollTeam = new Button("Inscribir Equipo");
        btnModifyTeam = new Button("Modificar Equipo");

        imageSignIn = new ImageView(new Image(getClass().getResourceAsStream("/images/signInImage.jpg")));

        btnEnrollTeam.setPrefSize(107.0, 25.0);
        btnEnrollTeam.setTranslateX(82.0);
        btnEnrollTeam.setTranslateY(120.0);
        btnEnrollTeam.setOnAction(event -> {
            System.out.println("btnEnrollTeam");
            signInTeam.displaySignTeamWindow();
            stage.close();
        });

        btnModifyTeam.setPrefSize(107.0, 25.0);
        btnModifyTeam.setTranslateX(82.0);
        btnModifyTeam.setTranslateY(190.0);
        btnModifyTeam.setOnAction(event -> {
            System.out.println("btnModifyTeam");
            modify.displaySignWindow();
            stage.close();
        });
        
        imageSignIn.setFitHeight(435.0);
        imageSignIn.setFitWidth(450.0);
        imageSignIn.setTranslateX(220);
        imageSignIn.setTranslateY(5);

        pane.getChildren().addAll(btnEnrollTeam, btnModifyTeam, imageSignIn);
    }

    public void displaySignWindow() {
        inicializerElements();
        scene = new Scene(pane, 680.0, 440.0);
        stage.setTitle("SingIn");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
