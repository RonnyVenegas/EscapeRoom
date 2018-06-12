/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaperoom;

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import screenManager.Main;

public class Lock1 {

    private final Stage lockStage = new Stage();
    private Scene lockScene;
    private AnchorPane lockContainer;
    private Button lock1;
    private Label label;
    private TextField txtLock1;
    private TextField txtLock2;
    private TextField txtLock3;
    private TextField txtLock4;
    private Button btnReturn;
    private ImageView imageLock1;

    public void initializeElements() {
        lockContainer = new AnchorPane();
        lock1 = new Button("Unlock");
        btnReturn = new Button("Return");
        label = new Label("Math question for the win...");
        txtLock1 = new TextField();
        txtLock2 = new TextField();
        txtLock3 = new TextField();
        txtLock4 = new TextField();
        
        lockContainer.setPadding(new Insets(10));
        lock1.setPrefSize(40, 40);
        btnReturn.setPrefSize(80, 10);
        
        lock1.setTranslateX(160);
        lock1.setTranslateY(200);
        
        label.setPrefSize(150, 150);
        label.setTranslateX(20);
        label.setTranslateY(100);
        
        txtLock1.setPrefSize(30, 30);
        txtLock2.setPrefSize(30, 30);
        txtLock3.setPrefSize(30, 30);
        txtLock4.setPrefSize(30, 30);

        txtLock1.setTranslateX(20);
        txtLock1.setTranslateY(200);
        
        txtLock2.setTranslateX(50);
        txtLock2.setTranslateY(200);
        
        txtLock3.setTranslateX(80);
        txtLock3.setTranslateY(200);
        
        txtLock4.setTranslateX(110);
        txtLock4.setTranslateY(200);
        
        btnReturn.setTranslateX(20);
        btnReturn.setTranslateY(260);

        btnReturn.setOnAction(event -> {
            lockStage.close();
        });

        lock1.setOnAction(event -> {
            System.out.println("lock1");
            lockStage.close();
        });
        
        lockContainer.getChildren().addAll(btnReturn, lock1, txtLock1,txtLock2, txtLock3, txtLock4, label);
    }

    public void displayLock() {
        initializeElements();
        lockScene = new Scene(lockContainer, 300, 300);
        String cssPath = new File("src/css/styleLevel1.css").getAbsolutePath().replace("\\", "/");
        lockScene.getStylesheets().add("file:///" + cssPath);
        lockStage.setTitle("Escape Room - Level 1 Test");
        lockStage.setScene(lockScene);
        lockStage.setResizable(false);
        lockStage.show();
    }

}

