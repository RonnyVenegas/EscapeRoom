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
    
    public static TreeSet<Team> TEAMS_FROM_FILE = new TreeSet<>();
=======
<<<<<<< HEAD

    public static TreeSet<Team> TEAMS_FROM_FILE = new TreeSet<>();
=======
    public static TreeSet<Team> TEAMS_FROM_FILE = new TreeSet<>();

>>>>>>> 9ba1a3345ae68bd8e42acfe2ce0c83c46249ee48
>>>>>>> 9b484f253a4ad3e782d8f6059f21afa12101e09d
    
}
