/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamFileManager {

    WriterManager writer = new WriterManager();
    ReaderManager reader = new ReaderManager();

    public void createOpenTeamFile() {
        try {
            reader.open(escapeRoomFiles.ScapeRoomConfigurations.getTEAM_FILE_ROUTE());
            writer.write(SignInLogic.getTeam());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TeamFileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void readTeamFile(){
        try {
            reader.open(escapeRoomFiles.ScapeRoomConfigurations.getTEAM_FILE_ROUTE());
            
        } catch (IOException ex) {
            Logger.getLogger(TeamFileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
