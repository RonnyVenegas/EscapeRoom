package escaperoom;

import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import screenManager.Main;

public class GUIGameModeSelection {
    public static Stage gameModeSelectionStage = new Stage();
    public static Scene gameModeSelectionScene;
    public static AnchorPane gameModeSelectionContainer;
    public static Label lblSubtitle;
    public static Button individualModeButton;
    public static Button teamsModeButton;
    public static Button returnButton;
    
    public void initializeElements() {
        lblSubtitle = new Label("Select Game Mode:");
        individualModeButton = new Button("Invidual Mode");
        teamsModeButton = new Button("Teams Mode");
        returnButton = new Button("Return");
        gameModeSelectionContainer = new AnchorPane();
        
        lblSubtitle.setTranslateX(120);
        lblSubtitle.setTranslateY(50);
        individualModeButton.setTranslateX(130);
        individualModeButton.setTranslateY(100);
        teamsModeButton.setTranslateX(135);
        teamsModeButton.setTranslateY(160);
        returnButton.setTranslateX(10);
        returnButton.setTranslateY(320);
        
        individualModeButton.setOnAction(event -> {
            gameModeSelectionStage.close();
            new GUIIndividualModeLobby().displayLobby();
        });
        
        returnButton.setOnAction(event -> {
            gameModeSelectionStage.close();
            new Main().start(new Stage());
        });
        gameModeSelectionContainer.getChildren().addAll(lblSubtitle, individualModeButton, teamsModeButton, returnButton);
    }

    public void displayGameModeSelectionWindow() {
        initializeElements();
        gameModeSelectionScene = new Scene(gameModeSelectionContainer, 350, 350);
        gameModeSelectionScene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);
        gameModeSelectionStage.setTitle("Game - Select Game Mode");
        gameModeSelectionStage.setScene(gameModeSelectionScene);
        gameModeSelectionStage.setResizable(false);
        gameModeSelectionStage.show();
        
    }
}
