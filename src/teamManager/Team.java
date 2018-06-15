/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.ArrayList;
import java.util.Date;


public class Team {
    private String teamName;
    private Date signInDate;
    private ArrayList<Player> teamPlayers = new ArrayList<>();

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void addPlayerToArray(Player player){
        teamPlayers.add(player);
    }
    public Date getSignInDate() {
        return signInDate;
    }

    public void setSignInDate(Date signInDate) {
        this.signInDate = signInDate;
    }
    
    public String getTeamPlayersList() {
        String content = "";
        for(Player player : teamPlayers){
            content +="-"+ player.getID();
        }
        return content;
    }

    public String toFileString() {
        return teamName + "-" + EscapeRoomConfigurations.getDATE_FORMAT().format(signInDate) + getTeamPlayersList();
    }
    
}
