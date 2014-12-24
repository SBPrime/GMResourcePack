/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notegen;

import java.io.File;
import java.io.IOException;
import org.jfugue.Instrument;
import org.jfugue.Note;
import org.jfugue.Pattern;
import org.jfugue.Player;
import org.jfugue.Voice;

/**
 *
 * @author SBPrime
 */
public class NoteGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String fileName = args[2];

        Player player = new Player();
        File file = new File(fileName);        

        Pattern p;
        if (args[0].equalsIgnoreCase("D")) {
            p = Drum(args);
        } else {
            p = Instrument(args);
        }

        player.saveMidi(p, file);
    }

    private static Pattern Instrument(String[] args) throws NumberFormatException {
        int instrument = Integer.parseInt(args[0]);
        int octave = Integer.parseInt(args[1]);
        
        Pattern p = new Pattern();
        p.addElement(new Instrument((byte) instrument));
        p.add("G" + octave);
        
        return p;
    }

    private static Pattern Drum(String[] args) {
        int noteId = Integer.parseInt(args[1]);
        Pattern p = new Pattern();
        p.addElement(new Voice((byte)9));
        p.add(Note.getStringForNote((byte) noteId));
        
        return p;
    }

}
