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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import screenManager.Main;

public class Level1 {

    private final Stage levelStage = new Stage();
    private Scene levelScene;
    private AnchorPane levelContainer;
    private Button lock1;
    private Button lock2;
    private Button lock3;
    private Button lock4;
    private Button btnReturn;
    private Label label;
    //private Image image;
    private ImageView dog1;
    private ImageView dog2;
    private ImageView dog3;
    private ImageView dog4;
    private ImageView dog5;

    public void initializeElements() {
        levelContainer = new AnchorPane();
        lock1 = new Button();
        lock2 = new Button();
        lock3 = new Button();
        lock4 = new Button();
        btnReturn = new Button("Return");
        label = new Label();
        //image = new Image("/css/level1Room.jpg", 1820, 980, true, true);
        dog1 = new ImageView(new Image(getClass().getResourceAsStream("/css/dog1.png")));
        dog2 = new ImageView(new Image(getClass().getResourceAsStream("/css/dog2.png")));
        dog3 = new ImageView(new Image(getClass().getResourceAsStream("/css/dog3.png")));
        dog4 = new ImageView(new Image(getClass().getResourceAsStream("/css/dog4.png")));
        dog5 = new ImageView(new Image(getClass().getResourceAsStream("/css/dog5.png")));

        levelContainer.setPadding(new Insets(20));
        btnReturn.setPrefSize(80, 10);
        
        //later it has to recieve this number from the server to display the same
        //to all the players in the same game.
        int randomLevel = (int) Math.floor((Math.random() * 4) + 1);
        randomLevel = 1;
        if (randomLevel == 1) {
            
            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3.setPrefSize(24, 19);
            lock4.setPrefSize(15, 10);
            
            lock1.setTranslateX(991);
            lock1.setTranslateY(536);
            dog1.setTranslateX(991);
            dog1.setTranslateY(536);

            lock2.setTranslateX(606);
            lock2.setTranslateY(343);
            dog2.setTranslateX(606);
            dog2.setTranslateY(343);

            lock3.setTranslateX(1528);
            lock3.setTranslateY(549);
            dog3.setTranslateX(1528);
            dog3.setTranslateY(549);

            lock4.setTranslateX(941);
            lock4.setTranslateY(123);
            dog4.setTranslateX(941);
            dog4.setTranslateY(123);
            
            dog5.setTranslateX(40);
            dog5.setTranslateY(740);
            
        } else if (randomLevel == 2) {
            
            lock1.setPrefSize(128, 116);
            lock2.setPrefSize(153, 163);
            lock3.setPrefSize(118, 125);
            lock4.setPrefSize(115, 110);

            lock1.setTranslateX(954);
            lock1.setTranslateY(635);

            lock2.setTranslateX(621);
            lock2.setTranslateY(442);

            lock3.setTranslateX(1219);
            lock3.setTranslateY(648);

            lock4.setTranslateX(512);
            lock4.setTranslateY(219);

        } else if (randomLevel == 3) {
            
            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3.setPrefSize(18, 25);
            lock4.setPrefSize(15, 10);

            lock1.setTranslateX(854);
            lock1.setTranslateY(535);

            lock2.setTranslateX(521);
            lock2.setTranslateY(342);

            lock3.setTranslateX(1319);
            lock3.setTranslateY(548);

            lock4.setTranslateX(812);
            lock4.setTranslateY(119);

        } else {
            
            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3.setPrefSize(18, 25);
            lock4.setPrefSize(15, 10);

            lock1.setTranslateX(854);
            lock1.setTranslateY(535);

            lock2.setTranslateX(521);
            lock2.setTranslateY(342);

            lock3.setTranslateX(1319);
            lock3.setTranslateY(548);

            lock4.setTranslateX(812);
            lock4.setTranslateY(119);

        }
        /** needed to hide the buttons for the image interaction.
        lock1.setOpacity(0);
        lock2.setOpacity(0);
        lock3.setOpacity(0);
        lock4.setOpacity(0);
        */
        btnReturn.setTranslateX(20);
        btnReturn.setTranslateY(940);

        btnReturn.setOnAction(event -> {
            levelStage.close();
            new Main().start(new Stage());
        });
        levelContainer.getChildren().addAll(lock1, lock2, lock3, lock4, btnReturn, dog1, dog2, dog3, dog4, dog5);
    }

    public void displayLevel() {
        initializeElements();
        levelScene = new Scene(levelContainer, 1820, 980);
        String cssPath = new File("src/css/styleLevel1.css").getAbsolutePath().replace("\\", "/");
        levelScene.getStylesheets().add("file:///" + cssPath);
        levelStage.setTitle("Escape Room - Level 1 Test");
        levelStage.setScene(levelScene);
        levelStage.setResizable(false);
        levelStage.show();
    }

}
