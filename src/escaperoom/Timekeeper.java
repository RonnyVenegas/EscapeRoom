package escaperoom;

import alerts.InformationWindow;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import screenManager.Main;

public class Timekeeper {

    private Label lblTimekeeper;
    private Timer timer = new Timer();
    private int seconds = 0;
    private int minutes = 0;

    public Timekeeper(Label label) {
        this.lblTimekeeper = label;
    }

    private class Counter extends TimerTask {

        @Override
        public void run() {
            Platform.runLater(() -> {
                if (minutes == 30) {
                    stopTimer();
                    //LevelGenerator.levelStage.close();
                    InformationWindow.displayInformationWindow("You lose!");
                    Platform.setImplicitExit(false);
                    Platform.exit();
                    new Main().start(new Stage());
                    
                } else {

                    seconds++;
                    if (seconds == 60) {
                        minutes++;
                        lblTimekeeper.setText(minutes + ":" + "0");
                        seconds = 0;
                    } else {
                        lblTimekeeper.setText(minutes + ":" + seconds);
                    }
                }
            });
        }
    }

    public void startTimer() {
        seconds = 0;
        timer = new Timer();
        timer.schedule(new Counter(), 0, 1000);
    }

    public void stopTimer() {
        timer.cancel();
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
