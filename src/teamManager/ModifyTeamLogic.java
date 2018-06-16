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
public class ModifyTeamLogic {

    private final String REG_EXP_1 = "[A-Za-z ]";
    private final int minLength1 = 2;
    private final int maxLength1 = 10;
    SignInTeamLogic signInLogic = new SignInTeamLogic();
    TeamBuilder teamBuilder = new TeamBuilder();

    public boolean containsPlayer(String valor) {
        for (int i = 0; i < SignInTeamLogic.getTeam().getTeamPlayers().size(); i++) {
            if (SignInTeamLogic.getTeam().getTeamPlayers().get(i).getID().equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public void modifyId() {
        if (verifyTeam(ModifyPlayerIdGUI.txtTeam.getText()) == false) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Equipo no existe");
        } else if (containsPlayer(ModifyPlayerIdGUI.txtPlayerID.getText()) == false) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Jugador no existe");
        } else if (containsPlayer(ModifyPlayerIdGUI.txtNewPlayerId.getText()) == true) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Identificador repetido");
        } else {
            for (int i = 0; i < SignInTeamLogic.getTeam().getTeamPlayers().size(); i++) {
                if (SignInTeamLogic.getTeam().getTeamPlayers().get(i).getID().equals(ModifyPlayerIdGUI.txtPlayerID.getText())) {
                    SignInTeamLogic.getTeam().getTeamPlayers().get(i).setID(ModifyPlayerIdGUI.txtNewPlayerId.getText());
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
        if (verifyTeam(AddPlayerGUI.txtTeam.getText()) == false) {
            ErrorWindow.displayErrorWindow("No se puede agregar el jugador", "Equipo no existe");
        } else if (containsPlayer(AddPlayerGUI.txtNewPlayerId.getText()) == true) {
            ErrorWindow.displayErrorWindow("No se puede agregar el jugador", "Id Repetido");
        } else {
            Player player = new Player(AddPlayerGUI.txtNewPlayerId.getText());
            //team.getListPlayer.add(player);
            InformationWindow.displayInformationWindow("Jugador agregado");
        }
    }

    public void changeNameTeam() {
        if (verifyTeam(ChangeNameTeamGUI.txtNameTeam.getText()) == false) {
            ErrorWindow.displayErrorWindow("No existe", "No existe un equipo con el nombre indicado");
        } else {
            for (Team team : EscapeRoomConfigurations.TEAMS_FROM_FILE) {
                if (team.getTeamName().equals(ChangeNameTeamGUI.txtNameTeam.getText())) {
                    if (teamBuilder.validateString(ModifyPlayerIdGUI.txtNewPlayerId.getText(), REG_EXP_1, minLength1, maxLength1) == true) {
                        team.setTeamName(ChangeNameTeamGUI.txtNewNameTeam.getText());
                        InformationWindow.displayInformationWindow("Nombre modificado");
                    }
                }
            }
        }

    }
}
