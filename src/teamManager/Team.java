package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.ArrayList;
import java.util.Date;


 //Contains Team attributes and implements Comparable to sort Teams
 
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
    /**
     * Goes through array of players
     * @return String content of array
     */
    
    public void setTeamPlayers(ArrayList<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public String getTeamPlayersList() {
        String content = "";
        for(Player player : teamPlayers){
            content +="-"+ player.getID();
        }
        return content;
    } //End method

    /**
     * String format for file
     * @return String class attibutes 
     */
    public String toFileString() {
        return teamName + "-" + EscapeRoomConfigurations.DATE_FORMAT.format(signInDate) + getTeamPlayersList();
    }//End method
    
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
