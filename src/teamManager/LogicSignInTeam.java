package teamManager;

import alerts.ErrorWindow;
import alerts.InformationWindow;
import escapeRoomFiles.EscapeRoomConfigurations;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicSignInTeam {

    private final String REG_EXP = "[A-Za-z0-9]";
    private final int minLength = 2;
    private final int maxLength = 8;
    public static final TreeSet<Player> playersList = new TreeSet<>();
    private static Team team;
    private ManagerTeamFile manager = new ManagerTeamFile();    
    ManagerWriter managerWriter = new ManagerWriter();

    public boolean checkTeamDuplicated(Team team) {
        return EscapeRoomConfigurations.TEAMS_FROM_FILE.contains(team);
    }

    public boolean validateTeamPlayers() {
        //System.out.println("Team " + team.getTeamName());
        boolean completeTeam = false;
        if (!playersList.isEmpty() && playersList.size() >= 3) {
            for (Player p : playersList) {
                team.addPlayerToArray(p);
                System.out.println(p.getID());
            }
            managerWriter.writeTeams();
            System.out.println("Player add to array");
            completeTeam = true;

        }
        return completeTeam;
    }

    public void addToArray(Team team){
        for (Player p : playersList) {
            System.out.println(team.getTeamPlayersList());
                team.addPlayerToArray(p);
                System.out.println(p.getID());
            }
            managerWriter.writeTeams();
            System.out.println("Player add to array");
    }
    
    public void createTeam() {
        try {
            BuilderAbstract builder = new BuilderTeam();
            builder.buildTeam();
            builder.buildTeamName(GUISignInTeam.txtTeamName.getText());
            builder.buildDate();
            team = builder.getTeam();

            boolean duplicatedTeam = checkTeamDuplicated(team);

            if (duplicatedTeam) {
                ErrorWindow.displayErrorWindow("Team duplicated", "Can not exists two team with same names");
            } else {
                boolean completeTeam = validateTeamPlayers();

                if (completeTeam) {
                    GUISignInTeam.signStage.close();
                    EscapeRoomConfigurations.TEAMS_FROM_FILE.add(team);
                    manager.saveTeamsOnFile();
                    InformationWindow.displayInformationWindow("Team saved");
                    new GUISignIn().displaySignWindow();
                } else {
                    completeTeam = false;
                    ErrorWindow.displayErrorWindow("Can not save Team", "Team must have at least 3 players");
                }
            }
        } catch (ExceptionInformationRequired ex) {
            ErrorWindow.displayErrorWindow(ex.getMessage(), "Team name must have only letters and spaces"
                    + "\nTeam name length must be between 2 and 10 characters");
        }
    }

    public void addPlayerToMap(String playerID) {
        Player player = new Player(playerID);
        boolean addPlayer = playersList.add(player);
        if (addPlayer == false) {
            ErrorWindow.displayErrorWindow("Can not add player", "Can not repeat player IDs");
        } else {
            //playersList.put(GUISignInTeam.txtPlayerID.getText(), player);
            //GUISignInTeam.textAreaPlayerList.setText(GUISignInTeam.textAreaPlayerList.getText() + "\n" + playerID);
            System.out.println("Player add to map");
        }
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

    public static Team getTeam() {
        return team;
    }

    public static TreeSet getTree() {
        return playersList;
    }
    
    public boolean removePlayer(String data) {
        for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            if (team.getTeamName().equals(GUIModifyPlayerId.txtTeam.getText())) {
                System.out.println("Remove team found");
                for (int i = 0; i < team.getTeamPlayers().size(); i++) {
                    if (team.getTeamPlayers().get(i).getID().equals(data)) {
                        System.out.println("player remove list");
                        team.getTeamPlayers().remove(i);
                        validateTeamPlayers();
                        return true;
                    }
                }
                for (Player p : playersList) {
                    if (p.getID().equals(data)) {
                        return playersList.remove(p);
                    }
                }
            }
        }
        System.out.println("player not found");
        return false;
//        for (Player p : playersList) {
//            if (p.getID().equals(data)) {
//               return playersList.remove(p);  
//            }           
//        }
//        return false;
    }
}
