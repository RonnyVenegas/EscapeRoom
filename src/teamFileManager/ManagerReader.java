package teamFileManager;

import teamManager.Team;
import teamManager.Player;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


public class ManagerReader {

    public void readTeamsFromFile() throws IOException {

        Team team;
        File file;
        FileReader fileReader = null;
        BufferedReader bufferedReader;

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

                EscapeRoomConfigurations.TEAMS_FROM_FILE.add(team);
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

    }

}
