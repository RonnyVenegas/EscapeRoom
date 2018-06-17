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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Maricela Ledezma
 */
public class Level2 {

    private final Stage levelStage = new Stage();
    private Scene levelScene;
    private AnchorPane levelContainer;
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
    ImageView img;

    public void initializeElements() {
        levelContainer = new AnchorPane();
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
        img = new ImageView(new Image(getClass().getResourceAsStream("/images/RoomC.jpg")));

        img.setFitHeight(1820.0);
        img.setFitWidth(980.0);

        levelContainer.setPadding(new Insets(10));

        //int randomLevel = (int) Math.floor((Math.random() * 4) + 1);
        int randomLevel =1;
        if (randomLevel == 1) {
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
        }
    levelContainer.getChildren().addAll(img,padlock1,padlock2,padlock3,clue1_1,clue1_2,clue1_3,clue2_1,
            clue2_2,clue2_3,clue2_4,clue3_1,clue3_2,clue3_3,clue3_4,clue3_5,imageClue1,imageClue2,
            imageClue3,imageClue4);
    }

    public void displayLeve2() {
        initializeElements();
        levelScene = new Scene(levelContainer, 1820, 980);
        String cssPath = new File("src/css/styleLevel1.css").getAbsolutePath().replace("\\", "/");
        levelScene.getStylesheets().add("file:///" + cssPath);
        levelStage.setTitle("Escape Room - Leve2");
        levelStage.setScene(levelScene);
        levelStage.setResizable(false);
        levelStage.show();
    }
}
