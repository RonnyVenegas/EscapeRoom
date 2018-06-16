package escapeRoomFiles;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.TreeSet;
import teamManager.Team;

public class EscapeRoomConfigurations {
    public static final String TEAM_FILE_ROUTE = "src/escapeRoomFiles/teamFile.txt";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static final String CSS_PATH = "file:///" + new File("src/css/styles.css").getAbsolutePath().replace("\\", "/");
<<<<<<< HEAD
=======
    public static TreeSet<Team> TEAMS_FROM_FILE = new TreeSet<>();
>>>>>>> 99e78e7ca7687aced42db721b46a11eee3d08b39
    
}
