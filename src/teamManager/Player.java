
package teamManager;

import java.util.Objects;

/**
 * Contains player attributes and implements Comparable to 
 * sort players
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        
        return Objects.equals(this.ID, other.ID);
    }

    
}//End class
