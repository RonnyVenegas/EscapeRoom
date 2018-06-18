package escaperoom;

import alerts.InformationWindow;
import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public abstract class Design extends Application {
    private Timekeeper timekeeper;
    private Stage designStage;
    private Scene designScene ;
    private AnchorPane designContainer;
    private static Label lblTimekeeper;
    private Button lock;
    
    public Design() {
        
    }
    
    public void displayDesign() {
//        new Thread(() -> {
//            Platform.runLater(() -> {
                
//                designStage.show();
//            });
//        }).start();
        
    }
    
    @Override
    public void start(Stage stage) {
        designStage = stage;
        lock = new Button("Lock One");
        designContainer = new AnchorPane();
        lblTimekeeper = new Label("0:0");
        timekeeper = new Timekeeper(lblTimekeeper);
        lblTimekeeper.setTranslateX(10);
        lblTimekeeper.setTranslateY(10);
        lock.setTranslateX(200);
        lock.setTranslateY(200);
        lblTimekeeper.setId("Timekeeper");
        
        lock.setOnAction(event -> {
            new Thread(() -> {
                Platform.runLater(() -> {
                    JOptionPane.showMessageDialog(null, "IT'S OK");
                });
            }).start();
        });
        
        designContainer.getChildren().addAll(lblTimekeeper, lock);
                
        designScene = new Scene(designContainer, 1820, 980);
//        designScene.getStylesheets().add(EscapeRoomConfigurations.CSS_ROOM_SCENARIO);
        
        timekeeper.startTimer();
        
                designStage.setTitle("EscapeRoom - Game");
                designStage.setScene(designScene);
                designStage.setResizable(false);
        
        designStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
