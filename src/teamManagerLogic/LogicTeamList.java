package teamManagerLogic;

import teamManagerGUI.GUITeamList;
import java.util.ArrayList;
import teamListManager.InterfaceSort;
import teamListManager.SortByDate;
import teamListManager.SortByName;
import teamManager.Team;

public class LogicTeamList {
    
    public void sortByName() {
        InterfaceSort sortStrategy = new SortByName();
        
        ArrayList<Team> teamsSort = sortStrategy.sort();
      
        for (Team team : teamsSort) {
            GUITeamList.textAreaTeamList.setText(GUITeamList.textAreaTeamList.getText() 
                    + "\n" + team.toFileString());
        }
    }
    public void sortByDate() {
        InterfaceSort sortStrategy = new SortByDate();
        
        ArrayList<Team> teamsSort = sortStrategy.sort();
      
        for (Team team : teamsSort) {
            GUITeamList.textAreaTeamList.setText(GUITeamList.textAreaTeamList.getText() 
                    + "\n" + team.toFileString());
        }
    }
}
