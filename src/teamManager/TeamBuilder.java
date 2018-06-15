package teamManager;

import escapeRoomFiles.EscapeRoomConfigurations;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeamBuilder implements AbstractBuilder {

    private final String REG_EXP_1 = "[A-Za-z ]";
    private final int minLength1 = 2;
    private final int maxLength1 = 10;
    protected Team team;

    @Override
    public void buildTeam() {
        team = new Team();
    }

    @Override
    public void buildTeamName() {
        String teamName = SignInTeamGUI.txtTeamName.getText();
        boolean invalidName = validateString(teamName, REG_EXP_1, minLength1, maxLength1);
        if (invalidName == true) {
            team.setTeamName("");
        } else {
            if (invalidName == false) {
                team.setTeamName(teamName);
            }
        }
    }

    private boolean validateString(String valor, String expresion, int maxLength, int minLength) {

        String REG_EXP = expresion;
        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher;
        boolean invalidName = false;

        if (valor.length() > minLength && valor.length() <= maxLength) {
            for (char c : valor.toCharArray()) {
                matcher = pattern.matcher("" + c);
                if (!matcher.find()) {
                    invalidName = true;
                    break;
                }
            }
        }

        return invalidName;
    }


    @Override
    public void buildDate() {
        try {
            team.setSignInDate(EscapeRoomConfigurations.getDATE_FORMAT().parse(SignInTeamGUI.txtDate.getText()));
        } catch (ParseException ex) {
            ex.getMessage();
        }
    }

    @Override
    public Team getTeam() throws InformationRequiredException {
        if (team.getTeamName().equals("")) {
            throw new InformationRequiredException("Invalid Team Name");
        }
        return team;
    }

    
}
