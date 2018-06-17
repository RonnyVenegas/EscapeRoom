package teamFileManager;

import teamManager.Team;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Manage action of writing in file
public class ManagerWriter {

    
    //Write from memory structure to file
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
    }//End method
    
}//End class
