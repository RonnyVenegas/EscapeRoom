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

/**
 *
 * @author Ronny
 */
public class Main extends Application {
    private SignInTeam signInTeam = new SignInTeam();
    private SignIn signIn = new SignIn();
    private Level1 Level1 = new Level1();
    private Button btn;
    private Button gameButton;
    private Button signInButton;
    
    @Override
    public void start(Stage primaryStage) {
        
        btn = new Button();
        btn.setText("Open Sign Team");
        gameButton = new Button();
        gameButton.setText("Open Game");
        signInButton = new Button();
        signInButton.setText("Open Signin");
        
        /**
        btn.setLayoutX(50);
        btn.setLayoutY(50);*/
        btn.setTranslateX(0);
        btn.setTranslateY(0);
        /**
        gameButton.setLayoutX(200);
        gameButton.setLayoutY(200);*/
        
        gameButton.setTranslateX(0);
        gameButton.setTranslateY(30);
        
        signInButton.setTranslateX(0);
        signInButton.setTranslateY(60);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                signInTeam.displaySignTeamWindow();
            }
        });
        
        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                Level1.displayLevel();
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
        root.getChildren().addAll(btn, gameButton, signInButton);
        
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
