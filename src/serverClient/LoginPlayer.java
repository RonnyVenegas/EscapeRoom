package serverClient;

import escaperoom.Level1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import teamManagerGUI.GUISignIn;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import screenManager.Main;

/**
 *
 * @author Ronny
 */
public class LoginPlayer extends Application {

    private GUISignIn signIn = new GUISignIn();
    private Level1 Level1 = new Level1();
    //private Lobby lobby = new Lobby();
    ImageView img;
    
    public static final Stage lobbyStage = new Stage();
    public static Scene lobbyScene;
    public static AnchorPane lobbyContainer;
    public static Label lblTeamName;
    private static Label lblPlayerList;
    public static ComboBox teamcombo;
    public static TextField txtPlayer;
    public static Button play;
    public static ScrollPane scrollPanePlayerList;
    public static TextArea textAreaPlayerList;
    public static Button returnButton;
    
    public int numberOfPlayers = 0;
    
    String txt = "";

    @Override
    public void start(Stage primaryStage) {

        lobbyContainer = new AnchorPane();
        lblTeamName = new Label("Team name");
        lblPlayerList = new Label("Player ID");

        teamcombo = new ComboBox();
        txtPlayer = new TextField();
        play = new Button("Play");
        
        
        returnButton = new Button("Retun");

        scrollPanePlayerList = new ScrollPane();
        textAreaPlayerList = new TextArea();

        lobbyContainer.setPadding(new Insets(20));
        scrollPanePlayerList.setTranslateX(30);
        scrollPanePlayerList.setTranslateY(120);

        teamcombo.setPromptText("Team name");
        txtPlayer.setPromptText("New player");
        textAreaPlayerList.setText("players \n-----------------------------------------------------------");
        play.setPrefSize(80, 10);
        teamcombo.setPrefSize(160, 10);
        txtPlayer.setPrefSize(160, 10);
        
        lblTeamName.setTranslateX(30);
        lblTeamName.setTranslateY(20);
        lblPlayerList.setTranslateX(30);
        lblPlayerList.setTranslateY(50);
        textAreaPlayerList.setPrefSize(300, 200);
        teamcombo.setTranslateX(130);
        teamcombo.setTranslateY(20);
        txtPlayer.setTranslateX(130);
        txtPlayer.setTranslateY(50);
        
        play.setTranslateX(150);
        play.setTranslateY(325);
        
        returnButton.setTranslateX(300);
        returnButton.setTranslateY(325);
        textAreaPlayerList.setEditable(false);
        scrollPanePlayerList.setContent(textAreaPlayerList);
        
        play.setOnAction(event -> {
            
            lobbyStage.close();
            Level1.displayLevel();
            //recieve the sockets and start the game with N players all with the same game intance.

        });
        
        returnButton.setOnAction(event -> {
            lobbyStage.close();
            new Main().start(new Stage());
        });
        
        lobbyContainer.getChildren().addAll(lblPlayerList, lblTeamName, teamcombo, txtPlayer,
          play, scrollPanePlayerList, returnButton);

        Scene scene = new Scene(lobbyContainer, 350, 350);
        String cssPath = new File("src/css/styles.css").getAbsolutePath().replace("\\", "/");
        scene.getStylesheets().add("file:///" + cssPath);
        primaryStage.setTitle("Escape Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        new LoginPlayer().runClient();
    }
    
    private DataOutputStream output; // output stream to client
    private DataInputStream input; // input stream from client
    private Socket client; // connection to client
    private final String HOST = "127.0.0.1";
    private final int PORT = 12345;

    // connect to server and process messages from server
    public void runClient() {
        try {// connect to server, get streams, process connection
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // connect to server
    private void connectToServer() throws IOException {
        System.out.println("Attempting connection\n");
        // create Socket to make connection to server
        client = new Socket(HOST, PORT);
        // display connection information
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
    }

    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for data
        output = new DataOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information   
        // set up input stream for data
        input = new DataInputStream(client.getInputStream());
    }

    // process connection with server
    private void processConnection() throws IOException {

        String stringMessage;
        boolean continueBuying = true;
        
        //add logic to send request to the server here, as it seems it doesnt 
        // have any real logic just send information for the server to process.
        /**
        while (continueBuying) {

            stringMessage = input.readUTF();
            int number = Integer.parseInt(JOptionPane.showInputDialog(stringMessage));
            output.writeInt(number);
            stringMessage = input.readUTF();
            int seatsCount = Integer.parseInt(JOptionPane.showInputDialog(stringMessage));
            output.writeInt(seatsCount);
            for(int i = seatsCount; i > 0; i--){
                stringMessage = input.readUTF();
                String seatSelected = JOptionPane.showInputDialog(stringMessage);
                output.writeUTF(seatSelected);
                boolean taken = input.readBoolean();
                if(!taken){
                    i++;
                }
            }
            
            stringMessage = input.readUTF();
            output.writeInt(Integer.parseInt(JOptionPane.showInputDialog(stringMessage)));
            
            stringMessage = input.readUTF();
            JOptionPane.showMessageDialog(null, stringMessage);
            
            int option = Integer.parseInt(JOptionPane.showInputDialog("would you like to exit?\n 1: Yes \n 2: No"));
            if(option == 1){
                continueBuying = false;
            }
            output.writeBoolean(continueBuying);
        }*/
        
        
    }

    private void closeConnection() {
        System.out.println("\nClosing connection");
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
