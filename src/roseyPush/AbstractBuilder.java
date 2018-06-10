/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roseyPush;

import java.util.Date;

/**
 *
 * @author San
 */
public interface AbstractBuilder {
    
    void buildTeam();
    void buildTeamName();
    void buildDate();
    Team getTeam() throws InformationRequiredException;
    
    
}
