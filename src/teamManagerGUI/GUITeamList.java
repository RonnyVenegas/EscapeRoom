package teamManagerGUI;

import escapeRoomFiles.EscapeRoomConfigurations;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import teamManagerLogic.LogicTeamList;

public class GUITeamList {
    private LogicTeamList logicClass;
    public static final Stage teamListStage = new Stage();
    public static Scene teamListScene;
    public static AnchorPane container;
    public static Button btnSortByName;
    public static Button btnSortByDate;
    public static Button btnSortByTime;
    public static Label lblSorterType;
    public static ScrollPane scrollPaneTeamList;
    public static TextArea textAreaTeamList;
    public static Button btnReturn;
 
    public void initializeElements() {
        logicClass = new LogicTeamList();
        container = new AnchorPane();
        lblSorterType = new Label("Sort types");

        btnSortByDate = new Button("Sort by date");
        btnSortByName = new Button("Sort by name");
        btnSortByTime = new Button("Sort by time");
        btnReturn = new Button("Return");
        

        scrollPaneTeamList = new ScrollPane();
        textAreaTeamList = new TextArea();

        container.setPadding(new Insets(20));
        scrollPaneTeamList.setTranslateX(200);
        scrollPaneTeamList.setTranslateY(80);
        textAreaTeamList.setText("Teams list \n-----------------------------------------------------------");
        
        btnSortByDate.setPrefSize(120, 10);
        btnSortByName.setPrefSize(120, 10);
        btnSortByTime.setPrefSize(120, 10);
        
        lblSorterType.setTranslateX(60);
        lblSorterType.setTranslateY(40);
        
        textAreaTeamList.setPrefSize(300, 200);
        
        btnSortByDate.setTranslateX(40);
        btnSortByDate.setTranslateY(80);
        btnSortByName.setTranslateX(40);
        btnSortByName.setTranslateY(120);
        btnSortByTime.setTranslateX(40);
        btnSortByTime.setTranslateY(160);
        btnReturn.setTranslateX(430);
        btnReturn.setTranslateY(320);
        
        textAreaTeamList.setEditable(false);
        scrollPaneTeamList.setContent(textAreaTeamList);
        
        btnSortByName.setOnAction(event -> {
            logicClass.sortByName();
        });
        btnSortByDate.setOnAction(event ->{
            logicClass.sortByDate();
        });
        btnReturn.setOnAction(event -> {
            teamListStage.close();
            new GUISignIn().displaySignWindow();
        });
        teamListStage.setOnCloseRequest(event ->{
            teamListStage.close();
            new GUISignIn().displaySignWindow();
        });
        container.getChildren().addAll(lblSorterType, btnSortByDate, btnSortByName, btnSortByTime, btnReturn, scrollPaneTeamList);
    }

    public void displaySignTeamWindow() {
        initializeElements();
        teamListScene = new Scene(container, 500, 350);
        teamListScene.getStylesheets().add(EscapeRoomConfigurations.CSS_PATH);
        teamListStage.setTitle("Teams List");
        teamListStage.setScene(teamListScene);
        teamListStage.setResizable(false);
        teamListStage.show();
        
    }
    
}
