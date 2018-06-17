package teamManager;

import java.util.ArrayList;

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
