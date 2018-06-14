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
    private Lock1 lockScene = new Lock1();
    private AnchorPane levelContainer;
    private Button lock1;
    private Button lock2;
    private Button lock3;
    private Button lock4;
    private Button btnReturn;
    private Label label;
    //private Image image;
    private ImageView imageLock1;
    private ImageView imageLock2;
    private ImageView imageLock3;
    private ImageView imageLock4;

    public void initializeElements() {
        levelContainer = new AnchorPane();
        lock1 = new Button();
        lock2 = new Button();
        lock3 = new Button();
        lock4 = new Button();
        btnReturn = new Button("Return");
        label = new Label();

        levelContainer.setPadding(new Insets(10));
        btnReturn.setPrefSize(80, 10);
        
        //later it has to recieve this number from the server to display the same
        //to all the players in the same game.
        int randomLevel = (int) Math.floor((Math.random() * 4) + 1);
        randomLevel = 2;
        if (randomLevel == 1) {

            imageLock1 = new ImageView(new Image(getClass().getResourceAsStream("/images/dog1.png")));
            imageLock2 = new ImageView(new Image(getClass().getResourceAsStream("/images/dog2.png")));
            imageLock3 = new ImageView(new Image(getClass().getResourceAsStream("/images/dog3.png")));
            imageLock4 = new ImageView(new Image(getClass().getResourceAsStream("/images/dog4.png")));

            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3.setPrefSize(24, 19);
            lock4.setPrefSize(15, 10);

            imageLock1.setFitHeight(128);
            imageLock1.setFitWidth(116);

            imageLock2.setFitHeight(153);
            imageLock2.setFitWidth(163);

            
            imageLock3.setFitHeight(124);
            imageLock3.setFitWidth(119);

            imageLock4.setFitHeight(115);
            imageLock4.setFitWidth(110);

            lock1.setLayoutX(991);
            lock1.setLayoutY(536);
            imageLock1.setLayoutX(lock1.getLayoutX() - 50);
            imageLock1.setLayoutY(lock1.getLayoutY() - 50);

            lock2.setLayoutX(606);
            lock2.setLayoutY(343);
            imageLock2.setLayoutX(lock2.getLayoutX() - 50);
            imageLock2.setLayoutY(lock2.getLayoutY() - 50);

            lock3.setLayoutX(1528);
            lock3.setLayoutY(549);
            imageLock3.setLayoutX(lock3.getLayoutX() - 50);
            imageLock3.setLayoutY(lock3.getLayoutY() - 50);

            lock4.setLayoutX(941);
            lock4.setLayoutY(123);
            imageLock4.setLayoutX(lock4.getLayoutX() - 50);
            imageLock4.setLayoutY(lock4.getLayoutY() - 50);

        } else if (randomLevel == 2) {

            imageLock1 = new ImageView(new Image(getClass().getResourceAsStream("/images/camAntique.png")));
            imageLock2 = new ImageView(new Image(getClass().getResourceAsStream("/images/camObscura.png")));
            imageLock3 = new ImageView(new Image(getClass().getResourceAsStream("/images/camVintage.png")));
            imageLock4 = new ImageView(new Image(getClass().getResourceAsStream("/images/camPolaroid.png")));

            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3.setPrefSize(24, 19);
            lock4.setPrefSize(15, 10);

            imageLock1.setFitHeight(128);
            imageLock1.setFitWidth(116);

            imageLock2.setFitHeight(153);
            imageLock2.setFitWidth(163);

            
            imageLock3.setFitHeight(124);
            imageLock3.setFitWidth(119);

            imageLock4.setFitHeight(115);
            imageLock4.setFitWidth(110);

            lock1.setLayoutX(991);
            lock1.setLayoutY(536);
            imageLock1.setLayoutX(lock1.getLayoutX() - 50);
            imageLock1.setLayoutY(lock1.getLayoutY() - 50);

            lock2.setLayoutX(606);
            lock2.setLayoutY(343);
            imageLock2.setLayoutX(lock2.getLayoutX() - 50);
            imageLock2.setLayoutY(lock2.getLayoutY() - 50);

            lock3.setLayoutX(1528);
            lock3.setLayoutY(549);
            imageLock3.setLayoutX(lock3.getLayoutX() - 50);
            imageLock3.setLayoutY(lock3.getLayoutY() - 50);

            lock4.setLayoutX(941);
            lock4.setLayoutY(123);
            imageLock4.setLayoutX(lock4.getLayoutX() - 50);
            imageLock4.setLayoutY(lock4.getLayoutY() - 50);

        } else if (randomLevel == 3) {

            imageLock1 = new ImageView(new Image(getClass().getResourceAsStream("/images/bicycleLock.png")));
            imageLock2 = new ImageView(new Image(getClass().getResourceAsStream("/images/bloodSplash.png")));
            imageLock3 = new ImageView(new Image(getClass().getResourceAsStream("/images/bloodHandPrint2.png")));
            imageLock4 = new ImageView(new Image(getClass().getResourceAsStream("/images/bloodHandPrint.png")));

            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3.setPrefSize(24, 19);
            lock4.setPrefSize(15, 10);

            imageLock1.setFitHeight(128);
            imageLock1.setFitWidth(116);

            imageLock2.setFitHeight(153);
            imageLock2.setFitWidth(163);

            
            imageLock3.setFitHeight(124);
            imageLock3.setFitWidth(119);

            imageLock4.setFitHeight(115);
            imageLock4.setFitWidth(110);

            lock1.setLayoutX(991);
            lock1.setLayoutY(536);
            imageLock1.setLayoutX(lock1.getLayoutX() - 50);
            imageLock1.setLayoutY(lock1.getLayoutY() - 50);

            lock2.setLayoutX(606);
            lock2.setLayoutY(343);
            imageLock2.setLayoutX(lock2.getLayoutX() - 50);
            imageLock2.setLayoutY(lock2.getLayoutY() - 50);

            lock3.setLayoutX(1528);
            lock3.setLayoutY(549);
            imageLock3.setLayoutX(lock3.getLayoutX() - 50);
            imageLock3.setLayoutY(lock3.getLayoutY() - 50);

            lock4.setLayoutX(941);
            lock4.setLayoutY(123);
            imageLock4.setLayoutX(lock4.getLayoutX() - 50);
            imageLock4.setLayoutY(lock4.getLayoutY() - 50);

        } else {

            imageLock1 = new ImageView(new Image(getClass().getResourceAsStream("/images/sunDialCompass.png")));
            imageLock2 = new ImageView(new Image(getClass().getResourceAsStream("/images/woodenCompass.png")));
            imageLock3 = new ImageView(new Image(getClass().getResourceAsStream("/images/plasticCompass.png")));
            imageLock4 = new ImageView(new Image(getClass().getResourceAsStream("/images/combinationLock.png")));

            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3.setPrefSize(24, 19);
            lock4.setPrefSize(15, 10);

            imageLock1.setFitHeight(128);
            imageLock1.setFitWidth(116);

            imageLock2.setFitHeight(153);
            imageLock2.setFitWidth(163);

            
            imageLock3.setFitHeight(124);
            imageLock3.setFitWidth(119);

            imageLock4.setFitHeight(115);
            imageLock4.setFitWidth(110);

            lock1.setLayoutX(991);
            lock1.setLayoutY(536);
            imageLock1.setLayoutX(lock1.getLayoutX() - 50);
            imageLock1.setLayoutY(lock1.getLayoutY() - 50);

            lock2.setLayoutX(606);
            lock2.setLayoutY(343);
            imageLock2.setLayoutX(lock2.getLayoutX() - 50);
            imageLock2.setLayoutY(lock2.getLayoutY() - 50);

            lock3.setLayoutX(1528);
            lock3.setLayoutY(549);
            imageLock3.setLayoutX(lock3.getLayoutX() - 50);
            imageLock3.setLayoutY(lock3.getLayoutY() - 50);

            lock4.setLayoutX(941);
            lock4.setLayoutY(123);
            imageLock4.setLayoutX(lock4.getLayoutX() - 50);
            imageLock4.setLayoutY(lock4.getLayoutY() - 50);

        }
        
        //needed to hide the buttons for the image interaction.
        /**lock1.setOpacity(0);
        lock2.setOpacity(0);
        lock3.setOpacity(0);
        lock4.setOpacity(0);*/

        btnReturn.setTranslateX(20);
        btnReturn.setTranslateY(940);

        btnReturn.setOnAction(event -> {
            levelStage.close();
            new Main().start(new Stage());
        });

        lock1.setOnAction(event -> {
            System.out.println("lock1");
            lockScene.setRiddle(1);
            lockScene.displayLock();
            imageLock1.setVisible(false);
        });

        lock2.setOnAction(event -> {
            System.out.println("lock2");
            lockScene.setRiddle(2);
            lockScene.displayLock();
            imageLock2.setVisible(false);
        });

        lock3.setOnAction(event -> {
            System.out.println("lock3");
            lockScene.setRiddle(3);
            lockScene.displayLock();
            imageLock3.setVisible(false);
        });

        lock4.setOnAction(event -> {
            System.out.println("lock4");
            lockScene.setRiddle(4);
            lockScene.displayLock();
            imageLock4.setVisible(false);
        });

        levelContainer.getChildren().addAll(btnReturn, imageLock1, imageLock2, imageLock3, imageLock4, lock1, lock2, lock3, lock4);
    }

    public void displayLevel() {
        initializeElements();
        levelScene = new Scene(levelContainer, 1820, 980);
        String cssPath = new File("src/css/styleLevel1.css").getAbsolutePath().replace("\\", "/");
        levelScene.getStylesheets().add("file:///" + cssPath);
        levelStage.setTitle("Escape Room - Level");
        levelStage.setScene(levelScene);
        levelStage.setResizable(false);
        levelStage.show();
    }

}
