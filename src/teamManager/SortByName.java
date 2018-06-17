/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author San
 */
public class SortByName implements InterfaceSort {

    @Override
    public ArrayList<Team> sort() {
        ArrayList<Team> teams = new ArrayList<>();
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            teams.add(team);
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
    }
    
    
    
    /*
    Ordenada   por   nombre   del   equipo   y   en   los   equipos,   los   jugadores   ordenados   por   su
identificador 
(de forma ascendente)
.
     */
}
