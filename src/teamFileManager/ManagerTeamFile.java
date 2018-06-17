
package teamFileManager;

import java.io.IOException;

//Manage read and write accions of teams file
public class ManagerTeamFile {

    ManagerWriter writer = new ManagerWriter();
    ManagerReader reader = new ManagerReader();

    
    public void writeTeamsOnFile() {
        writer.writeTeams();
    }

    public void readTeamsFromFile(){
        try {
            reader.readTeamsFromFile();
        } catch (IOException ex) {
            alerts.ErrorWindow.displayErrorWindow("Error while reading file", ex.getMessage());
        }
    }


}//End class
