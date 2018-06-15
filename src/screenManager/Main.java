package screenManager;

import escaperoom.Level1;
import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import teamManager.SignInTeam;
import teamManager.SignIn;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import serverClient.Lobby;

/**
 *
 * @author Ronny
 */
public class Main extends Application {

    private SignInTeam signInTeam = new SignInTeam();
    private SignIn signIn = new SignIn();
    private Level1 Level1 = new Level1();
    private Lobby lobby = new Lobby();
    private Button gameButton;
    private Button signInButton;
    ImageView img;

    @Override
    public void start(Stage primaryStage) {

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
                lobby.displayLobby();
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
        root.getChildren().addAll(img,gameButton, signInButton);

        Scene scene = new Scene(root, 400, 400);
        String cssPath = new File("src/css/styles.css").getAbsolutePath().replace("\\", "/");
        scene.getStylesheets().add("file:///" + cssPath);
        primaryStage.setTitle("Escape Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
