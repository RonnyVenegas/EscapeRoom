package alerts;

import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InformationWindow {

    
    public static void displayInformationWindow (String header){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Information Window");
        informationAlert.setHeaderText(header);
        informationAlert.setContentText(null);

        Stage stage = (Stage) informationAlert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/images/infoIcon.png"));

        Scene scene = (Scene) informationAlert.getDialogPane().getScene();
        scene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);

        informationAlert.showAndWait();
    }

}
