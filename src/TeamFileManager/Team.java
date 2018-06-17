package TeamFileManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.ArrayList;
import java.util.Date;


public class Team implements Comparable<Team> {
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
        return teamName + "-" + EscapeRoomConfigurations.DATE_FORMAT.format(signInDate) + getTeamPlayersList();
    }
    
    @Override
    public int compareTo(Team o) {
        int compare = 0;
        if(o.getTeamName().equals(this.teamName)){
            compare = 0;
        } else {
            compare = 1;
        }
        return compare;
    }
}
