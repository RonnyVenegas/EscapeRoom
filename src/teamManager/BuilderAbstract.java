/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import java.util.Date;

/**
 *
 * @author San
 */
public interface BuilderAbstract {
    
    void buildTeam();
    void buildTeamName(String teamName);
    void buildDate();
    Team getTeam() throws ExceptionInformationRequired;
    
    
}
