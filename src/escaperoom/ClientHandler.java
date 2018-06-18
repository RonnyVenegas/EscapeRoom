package escaperoom;

import javafx.stage.Stage;
import teamManager.Player;

public class ClientHandler extends Thread {
    private LevelGenerator level;
    private Player player;
    
    public ClientHandler(LevelGenerator level, Player player) {
        this.level = level;
        this.player = player;
    }
    
    @Override
    public void run() {
        runScenario();
    }
    
    public void runScenario() {
        this.level.start(new Stage());
    }
}
