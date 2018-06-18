/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaperoom;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Ronny
 */
public class ClueMessage {
    
    private final Stage messageStage = new Stage();
    Label clueM;
    Button okButton;
    private Scene messageScene;
    private AnchorPane messageContainer;
    private String messageClue;
    
    public void initializeElements() {
        messageContainer = new AnchorPane();
        clueM = new Label();
        okButton = new Button("OK");
        clueM.setText(messageClue);
        okButton.setPrefSize(40, 40);
        okButton.setTranslateX(450);
        okButton.setTranslateY(55);
        
        okButton.setOnAction(event -> {
            messageStage.close();
        });
        
        messageContainer.getChildren().addAll(clueM, okButton);
    }
    
    
    public void displayClue() {
        initializeElements();
        messageScene = new Scene(messageContainer, 500, 100);
        String cssPath = new File("src/css/styleLock.css").getAbsolutePath().replace("\\", "/");
        messageScene.getStylesheets().add("file:///" + cssPath);
        messageStage.setTitle("Escape Room - Lock");
        messageStage.setScene(messageScene);
        messageStage.setResizable(false);
        messageStage.show();
    }

    public String getMessageClue() {
        return messageClue;
    }

    public void setMessageClue(String messageClue) {
        this.messageClue = messageClue;
    }
    
}
