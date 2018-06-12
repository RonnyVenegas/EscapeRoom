/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author San
 */
public class ReaderManager {

     private BufferedReader reader;

    public void open(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    public Team read() throws IOException {
        Team team = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String line = reader.readLine();
        String datos[];
        if (line != null) {
            try {
                team = new Team();
                datos = line.split("-");
                team.setTeamName(datos[0]);
                team.setSignInDate(format.parse(datos[1]));
                //?? lista de jugadores
            } catch (ParseException ex) {
                Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return team;
    }

    public void close() throws IOException {
        reader.close();
    }
}
