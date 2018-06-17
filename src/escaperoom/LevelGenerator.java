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
import javafx.stage.Stage;
import screenManager.Main;

public class LevelGenerator {

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

    int level = 2;

    private Button padlock1;//Code
    private Button padlock2;//Note
    private Button padlock3;//Eliza
    private Button clue1_1;//Board
    private Button clue1_2;//Radiography
    private Button clue1_3;//Title
    private Button clue2_1;//Books/keys
    private Button clue2_2;//Armchair/image
    private Button clue2_3;//Floor/Image
    private Button clue2_4;//Stop
    private Button clue3_1;//Phone
    private Button clue3_2;//Table/Flower
    private Button clue3_3;//Chair
    private Button clue3_4;//Statue
    private Button clue3_5;//BookOrange
    private ImageView imageClue1;
    private ImageView imageClue2;
    private ImageView imageClue3;
    private ImageView imageClue4;

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
        //int randomLevel = (int) Math.floor((Math.random() * 4) + 1);
        //randomLevel = 2;
        if (level == 1) {

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

            //needed to hide the buttons for the image interaction.
            /**
             * lock1.setOpacity(0); lock2.setOpacity(0); lock3.setOpacity(0);
             * lock4.setOpacity(0);
             */
            btnReturn.setTranslateX(
                    20);
            btnReturn.setTranslateY(
                    940);

            btnReturn.setOnAction(event
                    -> {
                levelStage.close();
                new Main().start(new Stage());
            }
            );
            levelStage.setOnCloseRequest(event -> {
                levelStage.close();
                new Main().start(new Stage());
            });
            lock1.setOnAction(event
                    -> {
                System.out.println("lock1");
                lockScene.setRiddle(1);
                lockScene.displayLock();
                imageLock1.setVisible(false);
            }
            );

            lock2.setOnAction(event
                    -> {
                System.out.println("lock2");
                lockScene.setRiddle(2);
                lockScene.displayLock();
                imageLock2.setVisible(false);
            }
            );

            lock3.setOnAction(event
                    -> {
                System.out.println("lock3");
                lockScene.setRiddle(3);
                lockScene.displayLock();
                imageLock3.setVisible(false);
            }
            );

            lock4.setOnAction(event
                    -> {
                System.out.println("lock4");
                lockScene.setRiddle(4);
                lockScene.displayLock();
                imageLock4.setVisible(false);
            }
            );

            levelContainer.getChildren()
                    .addAll(btnReturn, imageLock1, imageLock2, imageLock3, imageLock4, lock1, lock2, lock3, lock4);

        } else if (level == 2) {

            padlock1 = new Button();
            padlock2 = new Button();
            padlock3 = new Button();
            clue1_1 = new Button();
            clue1_2 = new Button();
            clue1_3 = new Button();
            clue2_1 = new Button();
            clue2_2 = new Button();
            clue2_3 = new Button();
            clue2_4 = new Button();
            clue3_1 = new Button();
            clue3_2 = new Button();
            clue3_3 = new Button();
            clue3_4 = new Button();
            clue3_5 = new Button();
            //img = new ImageView(new Image(getClass().getResourceAsStream("/images/RoomC.jpg")));

            //img.setFitHeight(1820.0);
            //img.setFitWidth(980.0);
            levelContainer.setPadding(new Insets(10));

            imageClue1 = new ImageView(new Image(getClass().getResourceAsStream("/images/keys.jpg")));
            imageClue2 = new ImageView(new Image(getClass().getResourceAsStream("/images/rosa.png")));
            imageClue3 = new ImageView(new Image(getClass().getResourceAsStream("/images/rosa.png")));
            imageClue4 = new ImageView(new Image(getClass().getResourceAsStream("/images/rosa.png")));

            padlock1.setPrefSize(28, 16);
            padlock2.setPrefSize(53, 63);
            padlock3.setPrefSize(24, 19);
            clue1_1.setPrefSize(15, 10);
            clue1_2.setPrefSize(15, 10);
            clue1_3.setPrefSize(15, 10);
            clue2_1.setPrefSize(15, 10);
            clue2_2.setPrefSize(15, 10);
            clue2_3.setPrefSize(15, 10);
            clue2_4.setPrefSize(15, 10);
            clue3_1.setPrefSize(15, 10);
            clue3_2.setPrefSize(15, 10);
            clue3_3.setPrefSize(15, 10);
            clue3_4.setPrefSize(15, 10);
            clue3_5.setPrefSize(15, 10);

            imageClue1.setFitHeight(128);
            imageClue1.setFitWidth(116);

            imageClue2.setFitHeight(153);
            imageClue2.setFitWidth(163);

            imageClue3.setFitHeight(124);
            imageClue3.setFitWidth(119);

            imageClue4.setFitHeight(115);
            imageClue4.setFitWidth(110);

            padlock1.setTranslateX(1143.0);
            padlock1.setTranslateY(882.0);

            padlock2.setTranslateX(14.0);
            padlock2.setTranslateY(475.0);

            padlock3.setTranslateX(990.0);
            padlock3.setTranslateY(379.0);

            clue1_1.setTranslateX(651.0);
            clue1_1.setTranslateY(659.0);

            clue1_2.setTranslateX(28.0);
            clue1_2.setTranslateY(323.0);

            clue1_3.setTranslateX(175.0);
            clue1_3.setTranslateY(247.0);

            clue2_1.setTranslateX(806.0);
            clue2_1.setTranslateY(625.0);
            imageClue1.setLayoutX(clue2_1.getTranslateX() - 50);
            imageClue1.setLayoutY(clue2_1.getTranslateY() - 50);

            clue2_2.setTranslateX(1514.0);
            clue2_2.setTranslateY(638.0);
            imageClue2.setLayoutX(clue2_2.getTranslateX() - 50);
            imageClue2.setLayoutY(clue2_2.getTranslateY() - 50);

            clue2_3.setTranslateX(1016.0);
            clue2_3.setTranslateY(715.0);
            imageClue3.setLayoutX(clue2_3.getTranslateX() - 50);
            imageClue3.setLayoutY(clue2_3.getTranslateY() - 50);

            clue2_4.setTranslateX(1404.0);
            clue2_4.setTranslateY(336.0);

            clue3_1.setTranslateX(558.0);
            clue3_1.setTranslateY(820.0);

            clue3_2.setTranslateX(1601.0);
            clue3_2.setTranslateY(882.0);
            imageClue4.setLayoutX(clue3_2.getTranslateX() - 50);
            imageClue4.setLayoutY(clue3_2.getTranslateY() - 50);

            clue3_3.setTranslateX(754.0);
            clue3_3.setTranslateY(500.0);

            clue3_4.setTranslateX(1540.0);
            clue3_4.setTranslateY(418.0);

            clue3_5.setTranslateX(1395.0);
            clue3_5.setTranslateY(802.0);

            clue1_1.setOnAction(event -> {
                System.out.println("clue1_1");
                System.out.println("search image\n num 1");
            });

            clue1_2.setOnAction(event -> {
                System.out.println("clue1_2");
                System.out.println("look for recognition \n num 3");
            });

            clue1_3.setOnAction(event -> {
                System.out.println("clue1_2");
                System.out.println("look for the code on the floor\num 2");
            });

            padlock1.setOnAction(event -> {
                System.out.println("padlock1");
                System.out.println("padlock1\n clave 132");
            });

            levelContainer.getChildren().addAll(imageClue1, imageClue2,
                    imageClue3, imageClue4, padlock1, padlock2, padlock3, clue1_1, clue1_2, clue1_3, clue2_1,
                    clue2_2, clue2_3, clue2_4, clue3_1, clue3_2, clue3_3, clue3_4, clue3_5);

        } else if (level == 3) {

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

    }

    public void displayLevel() {
        initializeElements();
        levelScene = new Scene(levelContainer, 1820, 980);

        String cssPath = "";
        if (level == 1) {
            cssPath = new File("src/css/styleLevel1.css").getAbsolutePath().replace("\\", "/");
            levelStage.setTitle("Sherlock Holmes - Level");
        } else if (level == 2) {
            cssPath = new File("src/css/styleLevel2.css").getAbsolutePath().replace("\\", "/");
            levelStage.setTitle("Escape Room - Level");
        } else {
            cssPath = new File("src/css/styleLevel3.css").getAbsolutePath().replace("\\", "/");
            levelStage.setTitle("Escape Room - Level");
        }

        levelScene.getStylesheets().add("file:///" + cssPath);
        levelStage.setScene(levelScene);
        levelStage.setResizable(false);
        levelStage.show();
    }

}
