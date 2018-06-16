package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterManager {

    private BufferedWriter writer;

    public void writeTeams() {
        File file = null;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        
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
    
//    public void open(String fileName) throws IOException {
//        if(writer == null){
//            writer = new BufferedWriter(new FileWriter(fileName));
//        }         
//    }
//
//    public void write(Team team) throws IOException {
//        writer.write(team.toFileString() + "\n");
//    }
//
//    public void close() throws IOException {
//        writer.close();
//    }
}
