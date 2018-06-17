package teamManager;

import teamManagerGUI.GUISignInTeam;
import exceptions.ExceptionInformationRequired;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuilderTeam implements BuilderAbstract {

    private final String REG_EXP_1 = "[A-Za-z ]";
    private final int minLength1 = 2;
    private final int maxLength1 = 10;
    protected Team team;

    /**
     * Creates new Team Object
     */
    @Override
    public void buildTeam() {
        team = new Team();
    }

    /**
     * Validate if team name is valid
     * @param teamName 
     */
    @Override
    public void buildTeamName(String teamName) {
        boolean invalidName = validateString(teamName, REG_EXP_1, minLength1, maxLength1);
        if (invalidName == true) {
            team.setTeamName("");
        } else {
            if (invalidName == false) {
                team.setTeamName(teamName);
            }
        }
    }//End method

    /**
     * Recibes a String and validate it acording to regular expressions
     * @param value String to be validated
     * @param expresion regular expression
     * @param maxLength minimum length required of  String value
     * @param minLength maximum length required of String value
     * @return boolean if value is invalid
     */
    public boolean validateString(String value, String expresion, int maxLength, int minLength) {
        String REG_EXP = expresion;
        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher;
        boolean invalidName = false;

        if (value.length() > minLength && value.length() <= maxLength) {
            for (char c : value.toCharArray()) {
                matcher = pattern.matcher("" + c);
                if (!matcher.find()) {
                    invalidName = true;
                    break;
                }
            }
        }

        return invalidName;
    }//End method

    /**
     * Sets a date format 
     */
    @Override
    public void buildDate() {
        try {
            team.setSignInDate(EscapeRoomConfigurations.DATE_FORMAT.parse(GUISignInTeam.txtDate.getText()));
        } catch (ParseException ex) {
            ex.getMessage();
        }
    }//End method

    /**
     * Validate team name 
     * @return team created
     * @throws ExceptionInformationRequired if team was not correctly created
     */
    @Override
    public Team getTeam() throws ExceptionInformationRequired {
        if (team.getTeamName().equals("")) {
            throw new ExceptionInformationRequired("Invalid Team Name");
        }
        return team;
    }//End method

    
}//End class
