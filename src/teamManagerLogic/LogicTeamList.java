package teamManagerLogic;

import teamManagerGUI.GUITeamList;
import java.util.ArrayList;
import teamListManager.InterfaceSort;
import teamListManager.SortByDate;
import teamListManager.SortByName;
import teamManager.Team;

public class LogicTeamList {
    
    /**
     * Sets the sortByName strategy and shows the sorted list in the textArea
     */
    public void sortByName() {
        InterfaceSort sortStrategy = new SortByName();
        GUITeamList.textAreaTeamList.setText("Teams list \n-----------------------------------------------------------");
        ArrayList<Team> teamsSort = sortStrategy.sort();
      
        for (Team team : teamsSort) {
            GUITeamList.textAreaTeamList.setText(GUITeamList.textAreaTeamList.getText() 
                    + "\n" + team.toFileString());
        }
        //GUITeamList.textAreaTeamList.setText("Teams list \n-----------------------------------------------------------");
    }//End method
    
    /**
     * Sets the sortByDate strategy and shows the sorted list in the textArea
     */
    public void sortByDate() {
        InterfaceSort sortStrategy = new SortByDate();
        GUITeamList.textAreaTeamList.setText("Teams list \n-----------------------------------------------------------");
        ArrayList<Team> teamsSort = sortStrategy.sort();
      
        for (Team team : teamsSort) {
            GUITeamList.textAreaTeamList.setText(GUITeamList.textAreaTeamList.getText() 
                    + "\n" + team.toFileString());
        }
        //GUITeamList.textAreaTeamList.setText("Teams list \n-----------------------------------------------------------");
    }//End method
}//End class
