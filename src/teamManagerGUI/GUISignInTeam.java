package teamManagerGUI;

import alerts.ErrorWindow;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.Date;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import teamManagerLogic.LogicSignInTeam;


public class GUISignInTeam {

    public static final Stage signStage = new Stage();
    public static Scene signScene;
    public static AnchorPane signContainer;
    public static Label lblTeamName;
    public static Label lblDate;
    private static Label lblPlayerList;
    public static TextField txtTeamName;
    public static TextField txtDate;
    public static TextField txtPlayerID;
    public static Button btnAddPlayer;
    public static Button btnSave;
    public static ScrollPane scrollPanePlayerList;
    public static TextArea textAreaPlayerList;
    public static Button returnButton;
    private LogicSignInTeam signInLogic = new LogicSignInTeam();

    public void initializeElements() {
         
        signContainer = new AnchorPane();
        lblTeamName = new Label("Team name");
        lblDate = new Label("Date");
        lblPlayerList = new Label("Player ID");

        txtTeamName = new TextField();
        txtDate = new TextField();
        txtPlayerID = new TextField();

        btnAddPlayer = new Button("+");
        btnSave = new Button("Save");
  
        returnButton = new Button("Return");
        

        scrollPanePlayerList = new ScrollPane();
        textAreaPlayerList = new TextArea();

        signContainer.setPadding(new Insets(20));
        scrollPanePlayerList.setTranslateX(30);
        scrollPanePlayerList.setTranslateY(120);

        txtTeamName.setPromptText("Team name");
        txtPlayerID.setPromptText("New player");
        textAreaPlayerList.setText("Team players \n-----------------------------------------------------------");
        btnAddPlayer.setPrefSize(30, 10);
        btnSave.setPrefSize(80, 10);
        txtTeamName.setPrefSize(160, 10);
        txtDate.setPrefSize(160, 10);
        txtPlayerID.setPrefSize(160, 10);
        
        lblTeamName.setTranslateX(30);
        lblTeamName.setTranslateY(20);
        lblDate.setTranslateX(30);
        lblDate.setTranslateY(50);
        lblPlayerList.setTranslateX(30);
        lblPlayerList.setTranslateY(80);
        textAreaPlayerList.setPrefSize(300, 200);
        txtTeamName.setTranslateX(130);
        txtTeamName.setTranslateY(20);
        txtPlayerID.setTranslateX(130);
        txtPlayerID.setTranslateY(80);
        txtDate.setTranslateX(130);
        txtDate.setTranslateY(50);
        btnAddPlayer.setTranslateX(300);
        btnAddPlayer.setTranslateY(80);
        btnSave.setTranslateX(30);
        btnSave.setTranslateY(325);
        returnButton.setTranslateX(300);
        returnButton.setTranslateY(325);
        txtDate.setEditable(false);
        textAreaPlayerList.setEditable(false);
        txtDate.setText(EscapeRoomConfigurations.DATE_FORMAT.format(new Date()));
        scrollPanePlayerList.setContent(textAreaPlayerList);
        
        btnSave.setOnAction(event -> {
            signInLogic.createTeam();
        });
        
        btnAddPlayer.setOnAction(event -> {
            boolean invalidName = signInLogic.validatePlayerID(txtPlayerID.getText());
            
            if (invalidName) {
                ErrorWindow.displayErrorWindow("Invalid player name", "Player name must have only letters or numbers"
                    + "\nTeam name length must be between 2 and 8 characters");
            } else {        
                signInLogic.addPlayerToTreeSet(txtPlayerID.getText());           
            }
        });
        
        returnButton.setOnAction(event -> {
            signStage.close();
            new GUISignIn().displaySignWindow();
        });
        signStage.setOnCloseRequest(event ->{
            signStage.close();
            new GUISignIn().displaySignWindow();
        });
        signContainer.getChildren().addAll(lblDate, lblPlayerList, lblTeamName, txtDate, txtTeamName, txtPlayerID, btnAddPlayer,
          btnSave, scrollPanePlayerList, returnButton);
    }

    public void displaySignTeamWindow() {
        initializeElements();
        signScene = new Scene(signContainer, 350, 350);
        signScene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);
        signStage.setTitle("Team Builder - Sign In");
        signStage.setScene(signScene);
        signStage.setResizable(false);
        signStage.show();
        
    }
}
