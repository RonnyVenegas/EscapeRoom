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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private int riddle;
    private String lockStringClue;

    public void initializeElements() {
        lockContainer = new AnchorPane();
        lock1 = new Button("Unlock");
        btnReturn = new Button("Return");
        label = new Label();
        txtLock1 = new TextField();
        txtLock2 = new TextField();
        txtLock3 = new TextField();
        txtLock4 = new TextField();
        
        //dummy data for test.
        lockStringClue = "Math question for the win... \nbla bla bla";
        
        lockContainer.setPadding(new Insets(10));
        lock1.setPrefSize(100, 40);
        btnReturn.setPrefSize(80, 10);

        lock1.setTranslateX(250);
        lock1.setTranslateY(300);

        label.setPrefSize(480, 150);
        label.setTranslateX(20);
        label.setTranslateY(20);

        txtLock1.setPrefSize(50, 50);
        txtLock2.setPrefSize(50, 50);
        txtLock3.setPrefSize(50, 50);
        txtLock4.setPrefSize(50, 50);

        txtLock1.setTranslateX(40);
        txtLock1.setTranslateY(200);

        txtLock2.setTranslateX(110);
        txtLock2.setTranslateY(200);

        txtLock3.setTranslateX(180);
        txtLock3.setTranslateY(200);

        txtLock4.setTranslateX(250);
        txtLock4.setTranslateY(200);

        btnReturn.setTranslateX(20);
        btnReturn.setTranslateY(400);

        btnReturn.setOnAction(event -> {
            lockStage.close();
        });
        
        

        lock1.setOnAction(event -> {
            System.out.println("lock " + riddle);
            label.setText(lockStringClue);
            String strLock1 = txtLock1.getText();
            String strLock2 = txtLock2.getText();
            String strLock3 = txtLock3.getText();
            String strLock4 = txtLock4.getText();
            System.out.println(strLock1);
            System.out.println(strLock2);
            System.out.println(strLock3);
            System.out.println(strLock4);
            //Better a Switch
            if (riddle == 1) {
                System.out.println("riddle 1");
                if(strLock1.equals("1") && strLock2.equals("1") 
                        && strLock3.equals("1")  && strLock4.equals("1") ){
                    System.out.println("unlocked");
                    lockStage.close();
                }
                
            } else if (riddle == 2) {
                System.out.println("riddle 2");
                if(strLock1.equals("1")  && strLock2.equals("1")  
                        && strLock3.equals("1")  && strLock4.equals("1") ){
                    System.out.println("unlocked");
                    lockStage.close();
                }
            } else if (riddle == 3) {
                System.out.println("riddle 3");
                if(strLock1.equals("1")  && strLock2.equals("1")  
                        && strLock3.equals("1")  && strLock4.equals("1") ){
                    System.out.println("unlocked");
                    lockStage.close();
                }
            } else if (riddle == 4) {
                System.out.println("riddle 4");
                if(strLock1.equals("1")  && strLock2.equals("1")  
                        && strLock3.equals("1")  && strLock4.equals("1") ){
                    System.out.println("unlocked");
                    lockStage.close();
                }
            }
        });

        lockContainer.getChildren().addAll(btnReturn, lock1, txtLock1, txtLock2, txtLock3, txtLock4, label);
    }

    public void displayLock() {
        initializeElements();
        lockScene = new Scene(lockContainer, 500, 500);
        String cssPath = new File("src/css/styleLock.css").getAbsolutePath().replace("\\", "/");
        lockScene.getStylesheets().add("file:///" + cssPath);
        lockStage.setTitle("Escape Room - Lock");
        lockStage.setScene(lockScene);
        lockStage.setResizable(false);
        lockStage.show();
    }

    public int getRiddle() {
        return riddle;
    }

    public void setRiddle(int riddle) {
        this.riddle = riddle;
    }

    public String getLockStringClue() {
        return lockStringClue;
    }

    public void setLockStringClue(String lockStringClue) {
        this.lockStringClue = lockStringClue;
    }
    
}
