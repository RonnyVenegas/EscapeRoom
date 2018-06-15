/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import java.util.Iterator;

/**
 *
 * @author Maricela Ledezma
 */
public class ModifyPlayerIdLogic {
  
    SignInLogic signInLogic = new SignInLogic();
    
    public boolean containsPlayer(String valor) {
        return SignInLogic.getTeam().getTeamPlayersList().contains(valor);
    }

    public void modifyId() {
        if (containsPlayer(ModifyPlayerIdGUI.txtNewPlayerId.getText()) == true) {
            ModifyPlayerIdGUI.textAreaPlayer.setText("No se puede modificar el jugador. El identificador esta repetido.");
        } else if (signInLogic.validatePlayerID(ModifyPlayerIdGUI.txtNewPlayerId.getText())) {
            ModifyPlayerIdGUI.textAreaPlayer.setText("El identificador es invalido.");
        } else {
//            Iterator list = playersList.iterator();
//            boolean next = true;
//            while (next) {
//                if (list.next().equals(ModifyPlayerIdGUI.txtNewPlayerId.getText())) {
//                    next = false;
//                }
                // Map.Entry e = (Map.Entry) list.next();
               // next = list.hasNext();
            }
            //list.next(). = ModifyPlayerIdGUI.txtNewPlayerId.getText();  
            ModifyPlayerIdGUI.textAreaPlayer.setText("Id modificado");
        }
    }
    
    

