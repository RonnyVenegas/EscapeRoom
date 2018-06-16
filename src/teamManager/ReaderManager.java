package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author San
 */
public class ReaderManager {

    private BufferedReader reader;
<<<<<<< HEAD
//
//    public void open(String fileName) throws FileNotFoundException {
//        if(reader == null){
//        reader = new BufferedReader(new FileReader(fileName));
//        }
//    }

//    public Team read() throws IOException {
//        Team team = null;
//        String line = reader.readLine();
//        String datos[];
//        if (line != null) {
//            try {
//                team = new Team();
//                datos = line.split("-");
//                team.setTeamName(datos[0]);
//                team.setSignInDate(EscapeRoomConfigurations.DATE_FORMAT.parse(datos[1]));
//                for(int i = 2; i < datos.length; i++) {
//                    Player player = new Player(datos[i]);
//                    team.addPlayerToArray(player);
//                }
//
//            } catch (ParseException ex) {
//                Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return team;
//    }
    
    public void readTeamsFromFile() {
        //TreeSet<Team> teamPlayers = new TreeSet<>();
=======
    TreeSet<Team> teamPlayers = new TreeSet<>();

    public void open(String fileName) throws FileNotFoundException {
        if (reader == null) {
            reader = new BufferedReader(new FileReader(fileName));
        }
    }

    public Team read() throws IOException {
        Team team = null;
        String line = reader.readLine();
        String datos[];
        if (line != null) {
            try {
                team = new Team();
                datos = line.split("-");
                team.setTeamName(datos[0]);
                team.setSignInDate(EscapeRoomConfigurations.DATE_FORMAT.parse(datos[1]));
                for (int i = 2; i < datos.length; i++) {
                    Player player = new Player(datos[i]);
                    team.addPlayerToArray(player);
                }

            } catch (ParseException ex) {
                Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return team;
    }

    public TreeSet readTeamsFromFile() throws IOException {
        open(EscapeRoomConfigurations.TEAM_FILE_ROUTE);
        read();
>>>>>>> 32758026187322c3e0f2061b78a034c29cd10bcb
        Team team = null;
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            file = new File(EscapeRoomConfigurations.TEAM_FILE_ROUTE);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String fileLine;

            while ((fileLine = bufferedReader.readLine()) != null) {
                team = new Team();
                String[] teamData = fileLine.split("-");

                team.setTeamName(teamData[0]);
                team.setSignInDate(EscapeRoomConfigurations.DATE_FORMAT.parse(teamData[1]));
                for (int i = 2; i < teamData.length; i++) {
                    Player player = new Player(teamData[i]);
                    team.addPlayerToArray(player);
                }
<<<<<<< HEAD
                
                EscapeRoomConfigurations.TEAMS_FROM_FILE.add(team);
=======

                teamPlayers.add(team);
>>>>>>> 32758026187322c3e0f2061b78a034c29cd10bcb
            }
        } catch (IOException | ParseException e) {

        } finally {
            try {
                if (null != fileReader) {
                    fileReader.close();
                }
            } catch (IOException ex) {

            }
        }
<<<<<<< HEAD
        
        //return teamPlayers;
=======

        return teamPlayers;
>>>>>>> 32758026187322c3e0f2061b78a034c29cd10bcb
    }

//    public void close() throws IOException {
//        reader.close();
//    }
}
