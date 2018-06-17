package screenManager;

import escaperoom.LevelGenerator;
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
import GUITeamManager.GUISignInTeam;
import GUITeamManager.GUISignIn;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import serverClient.Lobby;
import static javafx.application.Application.launch;
import TeamFileManager.ManagerTeamFile;

/**
 *
 * @author Ronny
 */
public class Main extends Application {

    private GUISignInTeam signInTeam = new GUISignInTeam();
    private GUISignIn signIn = new GUISignIn();
    private LevelGenerator Level1 = new LevelGenerator();
    private Lobby lobby = new Lobby();
    private Button gameButton;
    private Button signInButton;
    ManagerTeamFile manager = new ManagerTeamFile();
    ImageView img;

    @Override
    public void start(Stage primaryStage) {

        manager.readTeamsFromFile();
        gameButton = new Button();
        gameButton.setText("Open Game");
        signInButton = new Button();
        signInButton.setText("Open Signin");
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/signInImage.jpg")));

        img.setFitHeight(400.0);
        img.setFitWidth(400.0);

        gameButton.setTranslateX(2);
        gameButton.setTranslateY(120);

        signInButton.setTranslateX(100);
        signInButton.setTranslateY(120);

        gameButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                try {
                    lobby.displayLobby();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        signInButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                signIn.displaySignWindow();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(img, gameButton, signInButton);

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
