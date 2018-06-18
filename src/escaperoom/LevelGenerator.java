package escaperoom;

import java.io.File;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import screenManager.Main;

public class LevelGenerator extends Application {

    public static Stage levelStage;
    private Scene levelScene;
    private Lock lockScene = new Lock();
    private ClueMessage clueMessage = new ClueMessage();
    private AnchorPane levelContainer;

    private static Label lblTimekeeper;
    private Timekeeper timekeeper;

    //Level 1 objects
    private Button lock1;
    private Button lock2;
    private Button lock3_1;
    private Button lock3_2;
    private Button lock3_3;
    private Button lock3_4;
    private Button lock4;
    private Button btnReturn;
    private Label label;
    private ImageView imageLock1;
    private ImageView imageLock2;
    private ImageView imageLock3;
    private ImageView imageLock4;

    private int scenarioRandom;
    int lock3Level1Riddle = 1;

    private Button padlock1;//Code
    private Button padlock2;//Note
    private Button padlock3;//Eliza
    private Button clue1_1;//Board
    private Button clue1_2;//Radiography
    private Button clue1_3;//Title
    private Button clue1_4;//Title
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

    public LevelGenerator() {
        Random random = new Random();
        scenarioRandom = random.nextInt(3 - 1 + 1) + 1;

    }

    public void initializeElements(Stage stage) {
        levelStage = stage;
        levelContainer = new AnchorPane();
        lblTimekeeper = new Label("0:0");
        timekeeper = new Timekeeper(lblTimekeeper);
        lblTimekeeper.setId("Timekeeper");
        lock1 = new Button();
        lock2 = new Button();
        lock3_1 = new Button();
        lock3_2 = new Button();
        lock3_3 = new Button();
        lock3_4 = new Button();
        lock4 = new Button();
        btnReturn = new Button("Return");
        label = new Label();

        lblTimekeeper.setTranslateX(10);
        lblTimekeeper.setTranslateY(10);

        levelContainer.getChildren().add(lblTimekeeper);

        timekeeper.startTimer();

        levelContainer.setPadding(new Insets(10));
        btnReturn.setPrefSize(80, 10);

        //later it has to recieve this number from the server to display the same
        //to all the players in the same game.
        //int randomLevel = (int) Math.floor((Math.random() * 4) + 1);
        //randomLevel = 2;
        lockScene.setEscapeRoomLevel(1);
        lockScene.setRoomVariant(1);
        scenarioRandom = 1;
        if (scenarioRandom == 1) {

            imageLock1 = new ImageView(new Image(getClass().getResourceAsStream("/images/exclamationLock3Level1.png")));
            imageLock2 = new ImageView(new Image(getClass().getResourceAsStream("/images/sherlockPortrait.jpg")));
            imageLock3 = new ImageView(new Image(getClass().getResourceAsStream("/images/exclamationLock3Level1.png")));
            imageLock4 = new ImageView(new Image(getClass().getResourceAsStream("/images/exclamationLock3Level1.png")));

            clue1_1 = new Button();
            clue1_2 = new Button();
            clue1_3 = new Button();
            clue1_4 = new Button();

            clue1_1.setOnAction(event -> {
                clueMessage.setMessageClue("Clue 1.1: fish and ...?");
                clueMessage.displayClue();
            });

            clue1_2.setOnAction(event -> {
                clueMessage.setMessageClue("Clue 1.2: Fancy a cup of...?");
                clueMessage.displayClue();
            });

            clue1_3.setOnAction(event -> {
                clueMessage.setMessageClue("Clue 1.3: Do you have some \n ... for my fries?");
                clueMessage.displayClue();
            });

            clue1_4.setOnAction(event -> {
                clueMessage.setMessageClue("Clue 1.4: Just ring the bell...");
                imageLock1.setVisible(true);
                clueMessage.displayClue();
            });

            clue1_1.setTranslateX(100);
            clue1_1.setTranslateY(100);
            clue1_2.setTranslateX(200);
            clue1_2.setTranslateY(200);

            clue1_3.setTranslateX(300);
            clue1_3.setTranslateY(300);

            clue1_4.setTranslateX(400);
            clue1_4.setTranslateY(400);

            imageLock1.setFitHeight(128);
            imageLock1.setFitWidth(116);

            imageLock2.setFitHeight(108);
            imageLock2.setFitWidth(80);

            imageLock3.setFitHeight(124);
            imageLock3.setFitWidth(119);

            imageLock4.setFitHeight(115);
            imageLock4.setFitWidth(110);

            imageLock1.setVisible(false);
            imageLock4.setVisible(false);

            lock1.setPrefSize(24, 64);
            lock2.setPrefSize(80, 108);
            lock3_1.setPrefSize(58, 54);
            lock3_2.setPrefSize(58, 54);
            lock3_3.setPrefSize(58, 54);
            lock3_4.setPrefSize(58, 54);
            lock4.setPrefSize(33, 40);

            lock1.setTranslateX(519);
            lock1.setTranslateY(171);
            imageLock1.setTranslateX(lock1.getTranslateX() - 25);
            imageLock1.setTranslateY(lock1.getTranslateY() - 60);

            lock2.setTranslateX(746);
            lock2.setTranslateY(106);
            imageLock2.setTranslateX(lock2.getTranslateX());
            imageLock2.setTranslateY(lock2.getTranslateY());

            lock3_1.setTranslateX(1500.0);
            lock3_1.setTranslateY(46.0);
            lock3_2.setTranslateX(1719.0);
            lock3_2.setTranslateY(64.0);
            lock3_3.setTranslateX(1605.0);
            lock3_3.setTranslateY(46.0);
            lock3_4.setTranslateX(1379.0);
            lock3_4.setTranslateY(46.0);

            imageLock3.setTranslateX(lock3_4.getTranslateX() - 25);
            imageLock3.setTranslateY(lock3_4.getTranslateY() - 60);
            imageLock3.setVisible(false);

            lock4.setTranslateX(340);
            lock4.setTranslateY(426);
            imageLock4.setTranslateX(lock4.getTranslateX() - 50);
            imageLock4.setTranslateY(lock4.getTranslateY() - 50);

            //needed to hide the buttons for the image interaction.
            lock1.setOpacity(0);
            lock4.setOpacity(0);

            lock2.setOpacity(0);
            //imageLock2.setVisible(false);
            lock3_1.setOpacity(0);
            lock3_2.setOpacity(0);
            lock3_3.setOpacity(0);
            lock3_4.setOpacity(0);

            btnReturn.setTranslateX(20);
            btnReturn.setTranslateY(940);

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
                clueMessage.setMessageClue("100100200200300300400400");
                clueMessage.displayClue();
                lockScene.setLockStringClue("Fancy something to eat?");
                lockScene.displayLock();
                imageLock1.setVisible(false);
            }
            );

            lock2.setOnAction(event
                    -> {
                System.out.println("lock2");
                lockScene.setRiddle(2);
                lockScene.setLockStringClue("If you want to be like me \nfirst take a look of yourself.");
                lockScene.displayLock();

                imageLock2.setVisible(false);
                clueMessage.setMessageClue("2 find the way 4 lock \n3 follow the l1ght!");
                clueMessage.displayClue();
            }
            );

            lock3_1.setOnAction(event
                    -> {
                if (lock3Level1Riddle == 1) {
                    lock3Level1Riddle = 2;
                }
            }
            );

            lock3_2.setOnAction(event
                    -> {
                if (lock3Level1Riddle == 2) {
                    lock3Level1Riddle = 3;
                } else {
                    lock3Level1Riddle = 1;
                }
            }
            );

            lock3_3.setOnAction(event
                    -> {
                if (lock3Level1Riddle == 3) {
                    lock3Level1Riddle = 4;
                    imageLock3.setVisible(true);
                } else {
                    lock3Level1Riddle = 1;
                }
            }
            );

            lock3_4.setOnAction(event
                    -> {
                if (lock3Level1Riddle == 4) {
                    lockScene.setRiddle(3);
                    lockScene.setLockStringClue("how do you get here?");
                    lockScene.displayLock();
                } else {
                    lock3Level1Riddle = 1;
                }
            }
            );

            lock4.setOnAction(event
                    -> {
                System.out.println("lock4");
                lockScene.setRiddle(4);
                lockScene.setLockStringClue("Just ask me what you want... 4 words?");
                lockScene.displayLock();
                imageLock4.setVisible(false);
            }
            );

            levelContainer.getChildren().addAll(btnReturn, imageLock1, imageLock2, imageLock3, imageLock4, lock1, lock2, lock3_1,
                    lock3_2, lock3_3, lock3_4, lock4, clue1_1, clue1_2, clue1_3, clue1_4);

        } else if (scenarioRandom == 2) {

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

            imageClue1 = new ImageView(new Image(getClass().getResourceAsStream("/images/appleWatch.png")));
            imageClue2 = new ImageView(new Image(getClass().getResourceAsStream("/images/bloodHandPrint.png")));
            imageClue3 = new ImageView(new Image(getClass().getResourceAsStream("/images/camObscura.png")));
            imageClue4 = new ImageView(new Image(getClass().getResourceAsStream("/images/rosa.png")));

            padlock1.setPrefSize(28, 16);
            padlock2.setPrefSize(53, 63);
            padlock3.setPrefSize(24, 19);
            clue1_1.setPrefSize(20, 15);
            clue1_2.setPrefSize(20, 15);
            clue1_3.setPrefSize(20, 15);
            clue2_1.setPrefSize(20, 15);
            clue2_2.setPrefSize(20, 15);
            clue2_3.setPrefSize(20, 15);
            clue2_4.setPrefSize(20, 15);
            clue3_1.setPrefSize(20, 15);
            clue3_2.setPrefSize(20, 15);
            clue3_3.setPrefSize(20, 15);
            clue3_4.setPrefSize(20, 15);
            clue3_5.setPrefSize(20, 15);

            imageClue1.setFitHeight(50);
            imageClue1.setFitWidth(50);

            imageClue2.setFitHeight(153);
            imageClue2.setFitWidth(163);

            imageClue3.setFitHeight(100);
            imageClue3.setFitWidth(100);

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
                clueMessage.setMessageClue("search image\n num 1");
                clueMessage.displayClue();
            });
            clue1_2.setOnAction(event -> {
                System.out.println("clue1_2");
                System.out.println("look for recognition \n num 3");
                clueMessage.setMessageClue("look for recognition \n num 3");
                clueMessage.displayClue();
            });
            clue1_3.setOnAction(event -> {
                System.out.println("clue1_2");
                System.out.println("look for the code on the floor\num 2");
                clueMessage.setMessageClue("look for the code on the floor\num 2");
                clueMessage.displayClue();
            });
            padlock1.setOnAction(event -> {
                System.out.println("padlock1");
                System.out.println("key 132");
                lockScene.setLockStringClue("padlock1\n Decipher the code");
            });

            clue2_1.setOnAction(event -> {
                System.out.println("clue2_1");
                System.out.println("sit down\n num 3");
                clueMessage.setMessageClue("sit down\n num 3");
                clueMessage.displayClue();
            });
            clue2_2.setOnAction(event -> {
                System.out.println("clue2_2");
                System.out.println("look down");
                clueMessage.setMessageClue("look down");
                clueMessage.displayClue();
            });
            clue2_3.setOnAction(event -> {
                System.out.println("clue2_3");
                System.out.println("stop a moment\n num 5");
                clueMessage.setMessageClue("stop a moment\n num 5");
                clueMessage.displayClue();
            });
            clue2_4.setOnAction(event -> {
                System.out.println("clue2_4");
                System.out.println("now take note\n num 8");
                clueMessage.setMessageClue("now take note\n num 8");
                clueMessage.displayClue();
            });
            padlock2.setOnAction(event -> {
                System.out.println("padlock2");
                System.out.println("key 583");
                lockScene.setLockStringClue("padlock2\n Decipher the code");
            });

            clue3_1.setOnAction(event -> {
                System.out.println("clue3_1");
                System.out.println("Good smell\n num 0");
                clueMessage.setMessageClue("Good smell\n num 0");
                clueMessage.displayClue();
            });

            clue3_2.setOnAction(event -> {
                System.out.println("clue3_2");
                System.out.println("Rest");
                clueMessage.setMessageClue("Rest");
                clueMessage.displayClue();
            });
            clue3_3.setOnAction(event -> {
                System.out.println("clue3_3");
                System.out.println("Motionless\n num 9");
                clueMessage.setMessageClue("Motionless\n num 9");
                clueMessage.displayClue();
            });
            clue3_4.setOnAction(event -> {
                System.out.println("clue3_4");
                System.out.println("Register it in your diary");
                clueMessage.setMessageClue("Register it in your diary");
                clueMessage.displayClue();
            });
            clue3_5.setOnAction(event -> {
                System.out.println("clue3_5");
                System.out.println("Look for her\n num 7");
                clueMessage.setMessageClue("Look for her\n num 7");
                clueMessage.displayClue();
            });
            padlock3.setOnAction(event -> {
                System.out.println("padlock3");
                System.out.println("key 790");
                lockScene.setLockStringClue("padlock3\n Decipher the code");
            });

            levelContainer.getChildren().addAll(imageClue1, imageClue2,
                    imageClue3, imageClue4, padlock1, padlock2, padlock3, clue1_1, clue1_2, clue1_3, clue2_1,
                    clue2_2, clue2_3, clue2_4, clue3_1, clue3_2, clue3_3, clue3_4, clue3_5);

        } else if (scenarioRandom == 3) {

            imageLock1 = new ImageView(new Image(getClass().getResourceAsStream("/images/bicycleLock.png")));
            imageLock2 = new ImageView(new Image(getClass().getResourceAsStream("/images/bloodSplash.png")));
            imageLock3 = new ImageView(new Image(getClass().getResourceAsStream("/images/bloodHandPrint2.png")));
            imageLock4 = new ImageView(new Image(getClass().getResourceAsStream("/images/bloodHandPrint.png")));

            lock1.setPrefSize(28, 16);
            lock2.setPrefSize(53, 63);
            lock3_4.setPrefSize(24, 19);
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

            lock3_4.setLayoutX(1528);
            lock3_4.setLayoutY(549);
            imageLock3.setLayoutX(lock3_4.getLayoutX() - 50);
            imageLock3.setLayoutY(lock3_4.getLayoutY() - 50);

            lock4.setLayoutX(941);
            lock4.setLayoutY(123);
            imageLock4.setLayoutX(lock4.getLayoutX() - 50);
            imageLock4.setLayoutY(lock4.getLayoutY() - 50);

        }
    }

    public void displayLevel() {
        levelScene = new Scene(levelContainer, 1820, 980);

        String cssPath = "";
        if (scenarioRandom == 1) {
            cssPath = new File("src/css/styleLevel1.css").getAbsolutePath().replace("\\", "/");
            levelStage.setTitle("Sherlock Holmes - Use your eyes");
        } else if (scenarioRandom == 2) {
            cssPath = new File("src/css/styleLevel2.css").getAbsolutePath().replace("\\", "/");
            levelStage.setTitle("Escape Room - Level 2");
        } else {
            cssPath = new File("src/css/styleLevel3.css").getAbsolutePath().replace("\\", "/");
            levelStage.setTitle("Escape Room - Level 3");
        }

        levelScene.getStylesheets().add("file:///" + cssPath);
        levelStage.setScene(levelScene);
        levelStage.setResizable(false);
        levelStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        initializeElements(primaryStage);
        displayLevel();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public int getLock3Level1Riddle() {
        return lock3Level1Riddle;
    }

    public void setLock3Level1Riddle(int lock3Level1Riddle) {
        this.lock3Level1Riddle = lock3Level1Riddle;
    }

    public ImageView getImageLock3() {
        return imageLock3;
    }

    public void setImageLock3(ImageView imageLock3) {
        this.imageLock3 = imageLock3;
    }

}
