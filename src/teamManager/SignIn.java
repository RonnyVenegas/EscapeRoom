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
        btnEnrollTeam.setTranslateY(133.0);
        btnEnrollTeam.setOnAction(event -> {
            System.out.println("btnEnrollTeam");
            signInTeam.displaySignTeamWindow();
            stage.close();
        });

        btnModifyTeam.setPrefSize(107.0, 25.0);
        btnModifyTeam.setTranslateX(82.0);
        btnModifyTeam.setTranslateY(209.0);
        btnModifyTeam.setOnAction(event -> {
            System.out.println("btnModifyTeam");
            modify.displaySignWindow();
            stage.close();
        });
        
        imageSignIn.setFitHeight(474.0);
        imageSignIn.setFitWidth(335.0);
        imageSignIn.setLayoutX(249.0);
        imageSignIn.setLayoutY(18.0);
        imageSignIn.setOpacity(0.74);

        pane.getChildren().addAll(btnEnrollTeam, btnModifyTeam, imageSignIn);
    }

    public void displaySignWindow() {
        inicializerElements();
        scene = new Scene(pane, 680.0, 380.0);
        stage.setTitle("SingIn");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
