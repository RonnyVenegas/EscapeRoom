/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Maricela Ledezma
 */
public class ModifyTeam {

    AnchorPane pane;
    Button btnChangeNameTeam;
    Button btnModifyPlayerId;
    Button btnAddPlayer;
    Button btnReturn;
    ImageView img;
    Scene scene;
    Stage stage = new Stage();
    ChangeNameTeamGUI nameTeam = new ChangeNameTeamGUI();
    ModifyPlayerIdGUI playerId = new ModifyPlayerIdGUI();
    AddPlayerGUI addPlayer = new AddPlayerGUI();

    public void inicializerElements() {
        pane = new AnchorPane();
        btnChangeNameTeam = new Button("Cambiar Nombre de Equipo");
        btnModifyPlayerId = new Button("Modificar Jugador");
        btnAddPlayer = new Button("Agregar Jugador");
        btnReturn = new Button("Retun");
        img = new ImageView();

        btnChangeNameTeam.setPrefSize(110.0, 25.0);
        btnChangeNameTeam.setTranslateX(82.0);
        btnChangeNameTeam.setTranslateY(100.0);
        btnChangeNameTeam.setOnAction(event -> {
            nameTeam.displaySignWindow();
        });

        btnModifyPlayerId.setPrefSize(110.0, 25.0);
        btnModifyPlayerId.setTranslateX(82.0);
        btnModifyPlayerId.setTranslateY(150.0);
        btnModifyPlayerId.setOnAction(event -> {
            playerId.displaySignWindow();
        });

        btnAddPlayer.setPrefSize(110.0, 25.0);
        btnAddPlayer.setTranslateX(82.0);
        btnAddPlayer.setTranslateY(200.0);
        btnAddPlayer.setOnAction(event -> {
            addPlayer.displaySignWindow();
        });

        btnReturn.setPrefSize(90.0, 25.0);
        btnReturn.setTranslateX(500);
        btnReturn.setTranslateY(350);
        btnReturn.setOnAction(event -> {
            stage.close();
            new SignIn().displaySignWindow();
        });
//        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/3d6cdcd6-43e3-40d7-8a99-0e8f01437663.jpg")));

        pane.getChildren().addAll(img, btnChangeNameTeam, btnModifyPlayerId, btnAddPlayer,btnReturn);
    }

    public void displaySignWindow() {
        inicializerElements();
        scene = new Scene(pane, 600.0, 380.0);
        stage.setTitle("ModifyTeam");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
