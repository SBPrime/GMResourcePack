/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notegen;

import java.io.File;
import java.io.IOException;
import org.jfugue.Instrument;
import org.jfugue.Pattern;
import org.jfugue.Player;

/**
 *
 * @author SBPrime
 */
public class NoteGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int instrument = Integer.parseInt(args[0]);
        int octave = Integer.parseInt(args[1]);
        String fileName = args[2];
        
        
        Player player = new Player();
        File file = new File(fileName);
        
        Pattern p = new Pattern();        
        p.addElement(new Instrument((byte)instrument));
        p.add("G"+octave);
        
        player.saveMidi(p, file);
    }
    
}
