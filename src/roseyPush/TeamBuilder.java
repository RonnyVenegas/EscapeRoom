/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roseyPush;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author San
 */
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
        String teamName = SignInGUI.txtTeamName.getText();
        boolean result = validateString(teamName, REG_EXP_1, minLength1, maxLength1);
        if (result == true) {
            System.out.println("Nombre equipo invalido");
        } else {
            if (result == false) {
                System.out.println("Nombre equipo valido");
                team.setTeamName(teamName);
            }
        }
    }

    private boolean validateString(String valor, String expresion, int maxLength, int minLength) {

        String REG_EXP = expresion;
        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher;
        boolean nombreInvalido = false;

        if (valor.length() > minLength && valor.length() <= maxLength) {
            for (char c : valor.toCharArray()) {
                matcher = pattern.matcher("" + c);
                if (!matcher.find()) {
                    nombreInvalido = true;
                    break;
                }
            }
        }

        return nombreInvalido;
    }


    @Override
    public void buildDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            team.setSignInDate(format.parse(SignInGUI.txtDate.getText()));
        } catch (ParseException ex) {
            ex.getMessage();
        }
    }

    @Override
    public Team getTeam() throws InformationRequiredException {
        if (team.getTeamName().equals("")) {
            throw new InformationRequiredException("El nombre del equipo no es valido");
        }
        return team;
    }

}
