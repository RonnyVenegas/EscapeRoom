/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

//import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInLogic {

    private final String REG_EXP = "[A-Za-z0-9]";
    private final int minLength = 2;
    private final int maxLength = 8;
    private final TreeSet<Player> playersList = new TreeSet<>();
    private static Team team;
    private TeamFileManager manager = new TeamFileManager();

    public void validateTeam() {
        System.out.println("Team " + team.getTeamName());
        if (!playersList.isEmpty() && playersList.size() >= 3) {
            System.out.println("validate team");
//            for (Map.Entry<Player> e : playersList.entrySet()) {
//                team.addPlayerToArray(e.getValue());
//                System.out.println(e.getKey() + " " + e.getValue().toString());
//            }
            for (Player p : playersList) {
                team.addPlayerToArray(p);
                System.out.println(p.getID().toString());
            }
            manager.createOpenTeamFile();
        } else {
            System.out.println("El equipo debe contener al menos 3 jugadores");
        }
    }

    public void createTeam() {
        try {
            AbstractBuilder builder = new TeamBuilder();
            builder.buildTeam();
            builder.buildTeamName();
            builder.buildDate();
            team = builder.getTeam();

            System.out.println("Team " + team.getTeamName());
        } catch (InformationRequiredException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void addPlayerToMap() {
        if (playersList.contains(SignInTeam.txtPlayerID.getText())) {
            System.out.println("No se puede introducir el jugador. El identificador esta repetido.");
        } else {
            Player player = new Player(SignInTeam.txtPlayerID.getText());
            //playersList.put(SignInTeam.txtPlayerID.getText(), player);
            playersList.add(player);

        }
        mostrarJugadores();
    }

    public boolean validatePlayerID(String valor) {
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
        } else {
            nombreInvalido = true;
        }

        return nombreInvalido;
    }

    public void mostrarJugadores() {
        //Iterator list = playersList.entrySet().iterator();
        Iterator list = playersList.iterator();
        while (list.hasNext()) {
            Map.Entry e = (Map.Entry) list.next();
            System.out.println(e.getKey().toString());
        }
    }

    public static Team getTeam() {
        return team;
    }
    
}
