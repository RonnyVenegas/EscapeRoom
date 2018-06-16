/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterManager {

    private BufferedWriter writer;

    public void open(String fileName) throws IOException {
        if(writer == null){
            writer = new BufferedWriter(new FileWriter(fileName));
        }
                  
    }

    public void write(Team team) throws IOException {
        writer.write(team.toFileString() + "\n");
    }

    public void close() throws IOException {
        writer.close();
    }
}
