package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screenManager.Main;


public class GUISignIn {

    AnchorPane pane;
    Button btnEnrollTeam;
    Button btnModifyTeam;
    Button btnShowTeamList;
    Button btnReturn;
    ImageView imageSignIn;
    Scene scene;
    Stage stage = new Stage();
    GUIModifyTeam modify = new GUIModifyTeam();
    GUISignInTeam signInTeam = new GUISignInTeam();
    GUITeamList teamList = new GUITeamList();

    public void inicializerElements() {
        pane = new AnchorPane();
        btnEnrollTeam = new Button("Register Team");
        btnModifyTeam = new Button("Modify Team");
        btnShowTeamList = new Button("Teams List ");
        btnReturn = new Button("Return");

        imageSignIn = new ImageView(new Image(getClass().getResourceAsStream("/images/signInImage.jpg")));

        btnEnrollTeam.setPrefSize(115.0, 25.0);
        btnEnrollTeam.setTranslateX(60.0);
        btnEnrollTeam.setTranslateY(80.0);
        btnEnrollTeam.setOnAction(event -> {
            signInTeam.displaySignTeamWindow();
            stage.close();
        });

        btnModifyTeam.setPrefSize(115.0, 25.0);
        btnModifyTeam.setTranslateX(60.0);
        btnModifyTeam.setTranslateY(140.0);
        btnModifyTeam.setOnAction(event -> {
            modify.displaySignWindow();
            stage.close();
        });
        btnShowTeamList.setPrefSize(115.0, 25.0);
        btnShowTeamList.setTranslateX(60);
        btnShowTeamList.setTranslateY(200);
        btnShowTeamList.setOnAction(event ->{
            teamList.displaySignTeamWindow();
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

        pane.getChildren().addAll(imageSignIn,btnEnrollTeam, btnModifyTeam, btnShowTeamList,btnReturn);
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
