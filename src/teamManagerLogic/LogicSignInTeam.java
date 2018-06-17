package teamManagerLogic;

import teamManagerGUI.GUIModifyPlayerId;
import teamManagerGUI.GUISignIn;
import teamManagerGUI.GUISignInTeam;
import alerts.ErrorWindow;
import alerts.InformationWindow;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import teamManager.BuilderAbstract;
import teamManager.BuilderTeam;
import exceptions.ExceptionInformationRequired;
import teamFileManager.ManagerTeamFile;
import teamFileManager.ManagerWriter;
import teamManager.Player;
import teamManager.Team;
/**
 * This class manage the validations of new teams
 */
public class LogicSignInTeam {

    private final String REG_EXP = "[A-Za-z0-9]";
    private final int minLength = 2;
    private final int maxLength = 8;
    public static final TreeSet<Player> playersList = new TreeSet<>();
    private static Team team;
    private ManagerTeamFile manager = new ManagerTeamFile();
    ManagerWriter managerWriter = new ManagerWriter();

    /**
     * Check if the new team already exist in the TreeSet
     * @param team
     * @return boolean
     */
    public boolean checkTeamDuplicated(Team team) {
        return EscapeRoomConfigurations.TEAMS_FROM_FILE.contains(team);
    }//End method

    /**
     * Validate if the list saved on the treeSet complies with the parameters
     * if it complies the list of player is added to de Array of players 
     * in the Team class
     * @return boolean if the list was succesfully added
     */
    public boolean validateTeamPlayers() {
        boolean completeTeam = false;
        if (!playersList.isEmpty() && playersList.size() >= 3) {
            for (Player p : playersList) {
                team.addPlayerToArray(p);
                System.out.println(p.getID());
            }
            managerWriter.writeTeams();
            System.out.println("Player add to array");
            completeTeam = true;

        }
        return completeTeam;
    }//End method
<<<<<<< HEAD
=======

>>>>>>> c2a63d230b3482bf8176c0a2ca916da1f97b66ae
    /**
     * It adds the player list from the treeSet to the Array in the team class
     * @param team 
     */
    public void addToArray(Team team){
        for (Player p : playersList) {
            System.out.println(team.getTeamPlayersList());
                team.addPlayerToArray(p);
                System.out.println(p.getID());
            }
            managerWriter.writeTeams();
            System.out.println("Player add to array");
    }//End method
    
    /**
     * Use a builder to create a new Team, validating duplicated teams and saving 
     * valid teams in the file
     */
    public void createTeam() {
        try {
            BuilderAbstract builder = new BuilderTeam();
            builder.buildTeam();
            builder.buildTeamName(GUISignInTeam.txtTeamName.getText());
            builder.buildDate();
            team = builder.getTeam();

            boolean duplicatedTeam = checkTeamDuplicated(team);

            if (duplicatedTeam) {
                ErrorWindow.displayErrorWindow("Team duplicated", "Can not exists two team with same names");
            } else {
                boolean completeTeam = validateTeamPlayers();

                if (completeTeam) {
                    GUISignInTeam.signStage.close();
                    EscapeRoomConfigurations.TEAMS_FROM_FILE.add(team);
                    manager.writeTeamsOnFile();
                    InformationWindow.displayInformationWindow("Team saved");
                    new GUISignIn().displaySignWindow();
                } else {
                    completeTeam = false;
                    ErrorWindow.displayErrorWindow("Can not save Team", "Team must have at least 3 players");
                }
            }
        } catch (ExceptionInformationRequired ex) {
            ErrorWindow.displayErrorWindow(ex.getMessage(), "Team name must have only letters and spaces"
                    + "\nTeam name length must be between 2 and 10 characters");
        }
    }//End method

    /**
     * Adds new players to the treeSet if it does not already exist
     * @param playerID player identifier
     */
    public void addPlayerToTreeSet(String playerID) {
        Player player = new Player(playerID);
        boolean addPlayer = playersList.add(player);
        if (addPlayer == false) {
            ErrorWindow.displayErrorWindow("Can not add player", "Can not repeat player IDs");
        } else {
            GUISignInTeam.textAreaPlayerList.setText(GUISignInTeam.textAreaPlayerList.getText() + "\n" + playerID);
        }
    }//End method

     /**
     * Adds new players to the treeSet if it does not already exist
     * @param playerID player identifier
     */
    public void addPlayerToTree(String playerID) {
        Player player = new Player(playerID);
        boolean addPlayer = playersList.add(player);
        if (addPlayer == false) {
            ErrorWindow.displayErrorWindow("Can not add player", "Can not repeat player IDs");
        } 
    }
    /**
     * Check if the identifier complies with requirements
     * using regular expresions
     * @param value player identifier
     * @return boolean if the identifier is invalid
     */
    public boolean validatePlayerID(String value) {
        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher;
        boolean nombreInvalido = false;

        if (value.length() > minLength && value.length() <= maxLength) {
            for (char c : value.toCharArray()) {
                matcher = pattern.matcher("" + c);
                if (!matcher.find()) {
                    nombreInvalido = true;
                    break;
                }
            }
        } else {
            nombreInvalido = true;
        }

        return nombreInvalido;
    }//End method

    public static Team getTeam() {
        return team;
    }

    public static TreeSet getTree() {
        return playersList;
    }
    
    /**
     * Removes a team pleyer from the treeSet 
     * @param data player identifier
     * @return boolean if player was removed succesfully
     */
    public boolean removePlayer(String data) {
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            if (team.getTeamName().equals(GUIModifyPlayerId.txtTeam.getText())) {
                System.out.println("Remove team found");
                for (int i = 0; i < team.getTeamPlayers().size(); i++) {
                    if (team.getTeamPlayers().get(i).getID().equals(data)) {
                        System.out.println("player remove list");
                        team.getTeamPlayers().remove(i);
                        validateTeamPlayers();
                        return true;
                    }
                }
                for (Player p : playersList) {
                    if (p.getID().equals(data)) {
                        return playersList.remove(p);
                    }
                }
            }
        }
        System.out.println("player not found");
        return false;
//        for (Player p : playersList) {
//            if (p.getID().equals(data)) {
//               return playersList.remove(p);  
//            }           
//        }
//        return false;
    }//End method
}//End class
