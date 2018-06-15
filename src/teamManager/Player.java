/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import java.util.Objects;

/**
 *
 * @author San
 */
public class Player implements Comparable<Player> {
    
    private String ID;

    public Player(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Player o) {
        int compare = 0;
        if(o.getID().equals(this.ID)){
            compare = 0;
        } else {
            compare = 1;
        }
        return compare;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.ID);
        return hash;
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Player other = (Player) obj;
//        if (!Objects.equals(this.ID, other.ID)) {
//            return false;
//        }
//        return true;
//    }

    
}
