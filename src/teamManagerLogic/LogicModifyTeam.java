
package teamManagerLogic;

import teamManagerGUI.GUIModifyPlayerId;
import teamManagerGUI.GUIChangeNameTeam;
import teamManagerGUI.GUIAddPlayer;
import alerts.ErrorWindow;
import alerts.InformationWindow;
import escapeRoomFiles.EscapeRoomConfigurations;
import teamManager.BuilderTeam;
import teamFileManager.ManagerWriter;
import teamManager.Team;


public class LogicModifyTeam {

    private final String REG_EXP_1 = "[A-Za-z ]";
    private final int minLength1 = 2;
    private final int maxLength1 = 10;
    LogicSignInTeam signInLogic = new LogicSignInTeam();
    BuilderTeam teamBuilder = new BuilderTeam();
    ManagerWriter managerWriter = new ManagerWriter();
    Team team2;

    /**
     * Searches in TreeSet a team by name 
     * @param team1 team name
     * @param value player identifier 
     * @return boolean if player exist
     */
    public boolean containsPlayer(String team1, String value) {
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            if (team.getTeamName().equals(team1)) {
                System.out.println("team found");
                for (int i = 0; i < team.getTeamPlayers().size(); i++) {
                    if (team.getTeamPlayers().get(i).getID().equals(value)) {
                        System.out.println("player found");
                        team2 = team;
                        return true;
                    }
                }
            }
        }
        System.out.println("player not found");
        return false;
    }//End method

    /**
     * Modifies the player identifier if the new new one is valid 
     */
    public void modifyId() {
        if (verifyTeam(GUIModifyPlayerId.txtTeam.getText()) == false) {
            ErrorWindow.displayErrorWindow("Can´t modify the player", "Team doesn´t exist");
        } else if (containsPlayer(GUIModifyPlayerId.txtTeam.getText(), GUIModifyPlayerId.txtPlayerID.getText()) == false) {
            ErrorWindow.displayErrorWindow("Can´t modify the player", "Player doesn´t exist");
        } else if (containsPlayer(GUIModifyPlayerId.txtTeam.getText(), GUIModifyPlayerId.txtNewPlayerId.getText()) == true) {
            ErrorWindow.displayErrorWindow("Can´t modify the player", "Duplicate ID");
        } else {
            signInLogic.removePlayer(GUIModifyPlayerId.txtPlayerID.getText());
            signInLogic.validateTeamPlayers();
            signInLogic.addPlayerToTree(GUIModifyPlayerId.txtNewPlayerId.getText());            
            signInLogic.addToArray(team2);
            //LogicSignInTeam.getTeam().getTeamPlayers().get(i).setID(GUIModifyPlayerId.txtNewPlayerId.getText());
            InformationWindow.displayInformationWindow("Id modified");
 
        }
    }//End method

    /**
     * Verifies if team exist
     * @param team team name
     * @return boolean if exist
     */
    public boolean verifyTeam(String team) {
        for (Team t : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            if (t.getTeamName().equals(team)) {
                return true;
            }
        }
        return false;
    }//End Method

    /**
     * Adds a new player to Array on team class if valid
     */
    public void addPlayer() {
        if (verifyTeam(GUIAddPlayer.txtTeam.getText()) == false) {
            ErrorWindow.displayErrorWindow("Can´t add the player", "Team doesn´t exist");
        } else {
            for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
                if (team.getTeamName().equals(GUIAddPlayer.txtTeam.getText())) {
                    if (containsPlayer(GUIAddPlayer.txtTeam.getText(), GUIAddPlayer.lblNewPlayerId.getText())) {
                        ErrorWindow.displayErrorWindow("Can´t add the player", "Duplicate ID");
                    } else {
                        signInLogic.addPlayerToTree(GUIAddPlayer.lblNewPlayerId.getText());                        
                        signInLogic.validateTeamPlayers();
                        signInLogic.addToArray(team);
                        InformationWindow.displayInformationWindow("Player added");
                    }
                }
            }
        }
    }//End method

    /**
     * Changes team name if new one is valid
     */
    public void changeNameTeam() {
        String data = GUIChangeNameTeam.txtNameTeam.getText();
        if (verifyTeam(data) == false) {
            ErrorWindow.displayErrorWindow("Doesn´t exist", "Doesn´t exist team with the indicated name");
        } else {
            for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
                if (team.getTeamName().equals(data)) {

                    if (teamBuilder.validateString(GUIChangeNameTeam.txtNewNameTeam.getText(), REG_EXP_1, minLength1, maxLength1) == false) {
                        team.setTeamName(GUIChangeNameTeam.txtNewNameTeam.getText());
                        signInLogic.validateTeamPlayers();
                        managerWriter.writeTeams();
                        InformationWindow.displayInformationWindow("Name modified");
                    } else {
                        ErrorWindow.displayErrorWindow("Error", "Name not valid");
                    }
                }
            }
        }

    }//End method
}//End class
