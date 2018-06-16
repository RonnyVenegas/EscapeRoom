/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerTeamFile {

    ManagerWriter writer = new ManagerWriter();
    ManagerReader reader = new ManagerReader();

    public void saveTeamsOnFile() {
        writer.writeTeams();
    }
//    
//    public void createOpenTeamFile() {
//        try {
//            writer.open(escapeRoomFiles.EscapeRoomConfigurations.TEAM_FILE_ROUTE);
//            writer.write(SignInTeamLogic.getTeam());
//            writer.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ManagerTeamFile.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void readTeamsFromFile(){
        try {
            reader.readTeamsFromFile();
        } catch (IOException ex) {
            Logger.getLogger(ManagerTeamFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void readTeamFile(){
//        try {
//            reader.open(escapeRoomFiles.EscapeRoomConfigurations.TEAM_FILE_ROUTE);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(ManagerTeamFile.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
