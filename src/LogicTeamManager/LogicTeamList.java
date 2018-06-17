package LogicTeamManager;

import GUITeamManager.GUITeamList;
import java.util.ArrayList;
import TeamFileManager.InterfaceSort;
import TeamFileManager.SortByDate;
import TeamFileManager.SortByName;
import TeamFileManager.Team;

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
