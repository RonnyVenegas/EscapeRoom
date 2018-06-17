
package teamManager;

import exceptions.ExceptionInformationRequired;

//Builder interface
public interface BuilderAbstract {
    
    void buildTeam();
    void buildTeamName(String teamName);
    void buildDate();
    Team getTeam() throws ExceptionInformationRequired;
    
    
}//End interface
