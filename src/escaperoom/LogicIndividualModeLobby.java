package escaperoom;

import alerts.ErrorWindow;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.ArrayList;
import java.util.Random;
import teamManager.Player;
import teamManager.Team;

public class LogicIndividualModeLobby {
    
    ArrayList<Player> playersSelected = new ArrayList<>();
    
    public void fillTeamsComboBox() {
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            GUIIndividualModeLobby.teamCombo.getItems().add(team.getTeamName());
        }
    }
    
    public void fillPlayersComboBox(String teamSelected) {
        GUIIndividualModeLobby.textAreaPlayerList.setText("Team players \n-----------------------------------------------------------");
        GUIIndividualModeLobby.playerCombo.getItems().clear();
        playersSelected.clear();
        Team teamFound = null;
        ArrayList<Player> players = null;
        
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            if (team.getTeamName().equals(teamSelected)) {
                teamFound = team;
                break;
            }
        }
        if (teamFound != null) {
            players = teamFound.getTeamPlayers();
        }
        
        for (Player player : players) {
            GUIIndividualModeLobby.playerCombo.getItems().add(player.getID());
        }
    }
    
    public void addPlayer(String playerSelected) {
        playersSelected.add(new Player(playerSelected));
        GUIIndividualModeLobby.playerCombo.getItems().remove(playerSelected);
        GUIIndividualModeLobby.textAreaPlayerList.setText(GUIIndividualModeLobby.textAreaPlayerList.getText() + "\n" + playerSelected);
        System.out.println("SIZE: " + playersSelected.size());
    }   
    
    public void startGame() {
        if (playersSelected.size() < 2 || playersSelected.size() > 5) {
            ErrorWindow.displayErrorWindow("Players incomplete", "Select between two and five players");
        } else {
            LevelGenerator Level1 = new LevelGenerator();
            for (Player player : playersSelected) {
                new ClientHandler(Level1, player).runScenario();
            }
        }
    }
}
