package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screenManager.Main;

/**
 *
 * @author Maricela Ledezma
 */
public class SignIn {

    AnchorPane pane;
    Button btnEnrollTeam;
    Button btnModifyTeam;
    Button btnReturn;
    ImageView imageSignIn;
    Scene scene;
    Stage stage = new Stage();
    ModifyTeam modify = new ModifyTeam();
    SignInTeamGUI signInTeam = new SignInTeamGUI();

    public void inicializerElements() {
        pane = new AnchorPane();
        btnEnrollTeam = new Button("Inscribir Equipo");
        btnModifyTeam = new Button("Modificar Equipo");
        btnReturn = new Button("Return");

        imageSignIn = new ImageView(new Image(getClass().getResourceAsStream("/images/signInImage.jpg")));

        btnEnrollTeam.setPrefSize(107.0, 25.0);
        btnEnrollTeam.setTranslateX(60.0);
        btnEnrollTeam.setTranslateY(170.0);
        btnEnrollTeam.setOnAction(event -> {
            signInTeam.displaySignTeamWindow();
            stage.close();
        });

        btnModifyTeam.setPrefSize(107.0, 25.0);
        btnModifyTeam.setTranslateX(60.0);
        btnModifyTeam.setTranslateY(250.0);
        btnModifyTeam.setOnAction(event -> {
            modify.displaySignWindow();
            stage.close();
        });
        
        btnReturn.setPrefSize(60.0, 25.0);
        btnReturn.setTranslateX(20);
        btnReturn.setTranslateY(400);
        btnReturn.setOnAction(event -> {
            stage.close();
            new Main().start(new Stage());
        });
        
        imageSignIn.setFitHeight(435.0);
        imageSignIn.setFitWidth(450.0);
        imageSignIn.setTranslateX(220);
        imageSignIn.setTranslateY(5);

        pane.getChildren().addAll(imageSignIn,btnEnrollTeam, btnModifyTeam,btnReturn);
    }

    public void displaySignWindow() {
        inicializerElements();
        scene = new Scene(pane, 680.0, 440.0);
        scene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);
        stage.setTitle("SingIn");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
