/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import alerts.ErrorWindow;
import alerts.InformationWindow;
import static teamManager.ModifyPlayerIdGUI.txtPlayerID;

/**
 *
 * @author Maricela Ledezma
 */
public class ModifyPlayerIdLogic {

    SignInTeamLogic signInLogic = new SignInTeamLogic();

    public boolean containsPlayer(String valor) {
        return SignInTeamLogic.getTeam().getTeamPlayersList().contains(valor);
    }

    public void modifyId() {
        if (verifyTeam() == false) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Equipo no existe");
        } else if (containsPlayer(txtPlayerID.getText()) == false) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Jugador no existe");
        } else if (containsPlayer(ModifyPlayerIdGUI.txtNewPlayerId.getText()) == true) {
            ErrorWindow.displayErrorWindow("No se puede modificar el jugador", "Identificador repetido");
        } else {
            for (int i = 0; i < SignInTeamLogic.getTeam().getTeamPlayers().size(); i++) {
                if (SignInTeamLogic.getTeam().getTeamPlayers().get(i).getID().equals(ModifyPlayerIdGUI.txtNewPlayerId.getText())) {
                    SignInTeamLogic.getTeam().getTeamPlayers().get(i).setID(ModifyPlayerIdGUI.txtNewPlayerId.getText());
                    InformationWindow.displayInformationWindow("Identificador modificado");
                }
            }

        }

    }

    public boolean verifyTeam() {
//        for (int i = 0; i < ListaTeam.size(); i++) {
//            if (listaTeam.get(i).getName().equals(ModifyPlayerIdGUI.txtTeam.getText())  {
//                return true;
//            }verifyTeam
//        }
        return false;
    }
}
