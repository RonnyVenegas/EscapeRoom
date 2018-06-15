package escapeRoomFiles;

import java.io.File;
import java.text.SimpleDateFormat;

public class EscapeRoomConfigurations {
    private static final String TEAM_FILE_ROUTE = "src/escapeRoomFiles/teamFile.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final String CSS_PATH = "file:///" + new File("src/css/styles.css").getAbsolutePath().replace("\\", "/");
    
    public static String getTEAM_FILE_ROUTE() {
        return TEAM_FILE_ROUTE;
    }
    
    public static SimpleDateFormat getDATE_FORMAT() {
        return DATE_FORMAT;
    }
    
    public static String getCSS_PATH() {
        return CSS_PATH;
    }
}
