/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import alerts.ErrorWindow;
import alerts.InformationWindow;
import escapeRoomFiles.EscapeRoomConfigurations;

/**
 *
 * @author Maricela Ledezma
 */
public class LogicModifyTeam {

    private final String REG_EXP_1 = "[A-Za-z ]";
    private final int minLength1 = 2;
    private final int maxLength1 = 10;
    LogicSignInTeam signInLogic = new LogicSignInTeam();
    BuilderTeam teamBuilder = new BuilderTeam();

    public boolean containsPlayer(String valor) {
        for (int i = 0; i < LogicSignInTeam.getTeam().getTeamPlayers().size(); i++) {
            if (LogicSignInTeam.getTeam().getTeamPlayers().get(i).getID().equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public void modifyId() {
        if (verifyTeam(GUIModifyPlayerId.txtTeam.getText()) == false) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Equipo no existe");
        } else if (containsPlayer(GUIModifyPlayerId.txtPlayerID.getText()) == false) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Jugador no existe");
        } else if (containsPlayer(GUIModifyPlayerId.txtNewPlayerId.getText()) == true) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Identificador repetido");
        } else {
            for (int i = 0; i < LogicSignInTeam.getTeam().getTeamPlayers().size(); i++) {
                if (LogicSignInTeam.getTeam().getTeamPlayers().get(i).getID().equals(GUIModifyPlayerId.txtPlayerID.getText())) {
                    LogicSignInTeam.getTeam().getTeamPlayers().get(i).setID(GUIModifyPlayerId.txtNewPlayerId.getText());
                    InformationWindow.displayInformationWindow("Identificador modificado");
                }
            }

        }

    }

    public boolean verifyTeam(String team) {
        for (Team t : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
            if (t.getTeamName().equals(team)) {
                return true;
            }
        }
        return false;
    }

    public void addPlayer() {
        if (verifyTeam(GUIAddPlayer.txtTeam.getText()) == false) {
            ErrorWindow.displayErrorWindow("No se puede agregar el jugador", "Equipo no existe");
        } else if (containsPlayer(GUIAddPlayer.txtNewPlayerId.getText()) == true) {
            ErrorWindow.displayErrorWindow("No se puede agregar el jugador", "Id Repetido");
        } else {
            Player player = new Player(GUIAddPlayer.txtNewPlayerId.getText());
            //team.getListPlayer.add(player);
            InformationWindow.displayInformationWindow("Jugador agregado");
        }
    }

    public void changeNameTeam() {

        String data = GUIChangeNameTeam.txtNameTeam.getText();
        if (verifyTeam(data) == false) {
            ErrorWindow.displayErrorWindow("No existe", "No existe un equipo con el nombre indicado");
        } else {
            for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
                if (team.getTeamName().equals(data)) {
                    if (teamBuilder.validateString(GUIModifyPlayerId.txtNewPlayerId.getText(), REG_EXP_1, minLength1, maxLength1) == true) {
                        team.setTeamName(GUIChangeNameTeam.txtNewNameTeam.getText());

                        InformationWindow.displayInformationWindow("Nombre modificado");
                    }
                }
            }
        }

    }
}
