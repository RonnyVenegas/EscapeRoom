/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamListManager;

import teamManager.Team;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import teamManager.Player;

//Sort strategy
public class SortByName implements InterfaceSort {

    /**
     * sort team list by team name
     * @return ArrayList<Team>
     */
    @Override
    public ArrayList<Team> sort() {
        
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Player> players = null;
        int counter = 0;
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            players = new ArrayList<>();
            for (Player player : team.getTeamPlayers()) {
                players.add(player);
            }
            teams.add(team);
            teams.get(counter).setTeamPlayers(sortPlayers(players));
            counter++;
        }
        
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team team1, Team team2) {
                if (team1.getTeamName().compareTo(team2.getTeamName()) > 0) {
                    return 1;
                } else if (team1.getTeamName().compareTo(team2.getTeamName()) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        return teams;
    }//End method
    
    /**Sort team player list
     * @param players players ArrayList 
     * @return ArrayList<Player> sorted
     */
    private ArrayList<Player> sortPlayers(ArrayList<Player> players) {
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                if (player1.getID().compareTo(player2.getID()) > 0) {
                    return 1;
                } else if (player1.getID().compareTo(player2.getID()) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return players;
    }//End method
}//End class
