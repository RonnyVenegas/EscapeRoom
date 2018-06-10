package screenManager;

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginGUI {
    private final Stage loginStage = new Stage();
    private Scene loginScene;
    private AnchorPane loginContainer;
    private Label lblTitle;
    private TextField txtName;
    private PasswordField txtPassword;
    private Button btnLogin;
    private Button btnReturn;
    
    public void initializeElements() {
        loginContainer = new AnchorPane();
        lblTitle = new Label("LOGIN");
        txtName = new TextField();
        txtPassword = new PasswordField();
        btnLogin = new Button("Login");
        btnReturn = new Button("Return");
        
        loginContainer.setPadding(new Insets(20));
        txtName.setPromptText("Username");
        txtPassword.setPromptText("Password");
        btnLogin.setPrefSize(80, 10);
        btnReturn.setPrefSize(80, 10);
        
        lblTitle.setTranslateX(90);
        lblTitle.setTranslateY(10);
        txtName.setTranslateX(90);
        txtName.setTranslateY(40);
        txtPassword.setTranslateX(90);
        txtPassword.setTranslateY(70);
        btnLogin.setTranslateX(90);
        btnLogin.setTranslateY(105);
        btnReturn.setTranslateX(90);
        btnReturn.setTranslateY(140);
        
        btnReturn.setOnAction(event -> {
            //level1.displayLevel();
            loginStage.close();
            new Main().start(new Stage());
        });
        
        loginContainer.getChildren().addAll(lblTitle, txtName, txtPassword, btnLogin, btnReturn);
    }
    
    public void displayLoginWindow() {
        initializeElements();
        loginScene = new Scene(loginContainer, 300, 200);
        String cssPath = new File("src/css/styles.css").getAbsolutePath().replace("\\", "/");
        loginScene.getStylesheets().add("file:///" + cssPath);
        loginStage.setTitle("Escape Room - Login");
        loginStage.setScene(loginScene);
        loginStage.setResizable(false);
        loginStage.show();
    }
    
}
