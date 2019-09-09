/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notegen;

import java.io.File;
import java.io.IOException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.theory.Note;

/**
 *
 * @author SBPrime
 */
public class NoteGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 4) {
            String fileName = args[3];
            File file = new File(fileName);
            Pattern p;
            boolean isDrums = args[0].equalsIgnoreCase("D");
            Integer octave = tryParseInt(args[1]);
            Integer velocity = tryParseInt(args[2]);
            Integer instrument = null;
            if (!isDrums) {
                instrument = tryParseInt(args[0]);
            }

            if (isDrums || (instrument != null && 0 <= instrument && instrument <= 127)) {
                if (octave != null && 0 <= octave && octave <= 127) {
                    if (velocity != null && 0 <= velocity && velocity <= 127) {
                        if (isDrums) {
                            p = Drum(octave.byteValue(), velocity.byteValue());
                        } else {
                            p = Instrument(instrument.byteValue(), octave.byteValue(), velocity.byteValue());
                        }

                        if (p != null) {
                            try {
                                System.out.println("Saving " + p.toString() + "...");
                                MidiFileManager.savePatternToMidi(p, file);
                                System.out.println("Done!");
                                System.exit(0);
                            }
                            catch (IOException ex) {
                                System.out.println("Error while saving MIDI!");
                                ex.printStackTrace();
                                System.exit(3);
                            }
                        }
                    }
                    else {
                        System.out.println("Error: Velocity must be a number between 0 and 127 (both included)");
                        System.exit(2);
                    }
                }
                else {
                    System.out.println("Error: Octave must be a number between 0 and 127 (both included)");
                    System.exit(2);
                }
            }
            else {
                System.out.println("Error: Instrument must be a number between 0 and 127 (both included) or a letter \"D\"");
                System.exit(2);
            }
        }
        else {
            System.out.println("Syntax: java -jar NoteGen.jar <Instrument> <Octave> <Velocity> <OutputFileName>");
            System.exit(1);
        }
    }

    private static Pattern Instrument(byte instrument, byte octave, byte velocity) {
        return new Pattern("G" + octave + "a" + velocity).setInstrument(instrument);
    }

    private static Pattern Drum(byte noteId, byte velocity) {
        return new Pattern(Note.getToneString(noteId) + "a" + velocity).setVoice(9);
    }

    private static Integer tryParseInt(String strong) {
        Integer result;

        try {
            result = Integer.parseInt(strong);
        }
        catch (NumberFormatException ex) {
            result = null;
            System.out.println("\"" + strong + "\" is not an Integer!");
            ex.printStackTrace();
        }

        return result;
    }
}
