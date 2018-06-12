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
        img = new ImageView();

        btnChangeNameTeam.setPrefSize(107.0, 25.0);
        btnChangeNameTeam.setTranslateX(82.0);
        btnChangeNameTeam.setTranslateY(100.0);
        btnChangeNameTeam.setOnAction(event -> {
            System.out.println("lock4");
            nameTeam.displaySignWindow();
        });

        btnModifyPlayerId.setPrefSize(107.0, 25.0);
        btnModifyPlayerId.setTranslateX(82.0);
        btnModifyPlayerId.setTranslateY(150.0);
        btnModifyPlayerId.setOnAction(event -> {
            System.out.println("lock4");
            playerId.displaySignWindow();
        });

        btnAddPlayer.setPrefSize(107.0, 25.0);
        btnAddPlayer.setTranslateX(82.0);
        btnAddPlayer.setTranslateY(200.0);
        btnAddPlayer.setOnAction(event -> {
            System.out.println("lock4");
            addPlayer.displaySignWindow();
        });

        img.setFitHeight(474.0);
        img.setFitWidth(335.0);
        img.setLayoutX(249.0);
        img.setLayoutY(18.0);
        img.setOpacity(0.74);
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/3d6cdcd6-43e3-40d7-8a99-0e8f01437663.jpg")));

        pane.getChildren().addAll(img, btnChangeNameTeam, btnModifyPlayerId, btnAddPlayer );
    }

    public void displaySignWindow() {
        inicializerElements();
        scene = new Scene(pane, 680.0, 380.0);
        stage.setTitle("ModifyTeam");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
