package TeamFileManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerWriter {

    public void writeTeams() {
        File file;
        FileWriter fileWriter = null;
        PrintWriter printWriter;
        
        try {
            file = new File(EscapeRoomConfigurations.TEAM_FILE_ROUTE);
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
            
            for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
                printWriter.println(team.toFileString());
            }
        } catch (IOException ex) {
        
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                    
            }
        }
    }
    
}
