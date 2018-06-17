package alerts;

import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ErrorWindow {


    public static void displayErrorWindow (String header, String content){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Error Window");
        errorAlert.setHeaderText(header);
        errorAlert.setContentText(content);
        ((Button)errorAlert.getDialogPane().lookupButton(ButtonType.OK)).setText("Accept");

        Stage stage = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/images/alertIcon.png"));

        Scene scene = (Scene) errorAlert.getDialogPane().getScene();
        scene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);

        errorAlert.showAndWait();
    }

}
