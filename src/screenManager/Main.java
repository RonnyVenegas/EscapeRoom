package screenManager;

import escaperoom.LevelGenerator;
import escaperoom.GUIGameModeSelection;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import teamManagerGUI.GUISignInTeam;
import teamManagerGUI.GUISignIn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import serverClient.Lobby;
import teamFileManager.ManagerTeamFile;
import static javafx.application.Application.launch;

/**
 *
 * @author Ronny
 */
public class Main extends Application {

    private GUIGameModeSelection gameMode = new GUIGameModeSelection();
    private GUISignInTeam signInTeam = new GUISignInTeam();
    private GUISignIn signIn = new GUISignIn();
    private LevelGenerator Level1 = new LevelGenerator();
    private Lobby lobby = new Lobby();
    private Button gameButton;
    private Button signInButton;
    private Button btnExit;
    ManagerTeamFile manager = new ManagerTeamFile();
    ImageView img;

    @Override
    public void start(Stage primaryStage) {

        manager.readTeamsFromFile();
        gameButton = new Button();
        gameButton.setText("Open Game");
        signInButton = new Button();
        signInButton.setText("Open Signin");
        btnExit = new Button("Exit game");
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/signInImage.jpg")));

        img.setFitHeight(400.0);
        img.setFitWidth(400.0);
        
        signInButton.setTranslateX(-100);
        signInButton.setTranslateY(120);

        gameButton.setTranslateX(0);
        gameButton.setTranslateY(120);
        
        btnExit.setTranslateX(100);
        btnExit.setTranslateY(120);

        gameButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                gameMode.displayGameModeSelectionWindow();
            }
        });

        signInButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                signIn.displaySignWindow();
            }
        });
        
        btnExit.setOnAction(event -> {
            primaryStage.close();
        });
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.close();
        });
        StackPane root = new StackPane();
        root.getChildren().addAll(img, gameButton, signInButton, btnExit);

        Scene scene = new Scene(root, 400, 400);
        String cssPath = new File("src/css/styles.css").getAbsolutePath().replace("\\", "/");
        scene.getStylesheets().add("file:///" + cssPath);
        primaryStage.setTitle("Escape Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
