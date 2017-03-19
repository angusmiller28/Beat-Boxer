
/**
 *
 * @author Angus
 */
import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class BeatBox {
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
                                "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo","Maracas",
                                "Whistle", "Low Conga", "Cowbell","Vibraslap","Low-mid Tome",
                                "High Agogo", "Open Hi Conga"};
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
    
    public static void main (String[] args){
        new BeatBox().buildGUI();
    }
    
    public void buildGUI(){
        
    } // close method
    
    public void setUpMidi(){
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) { e.printStackTrace(); }       
    } // close method
    
    public void buildTrackAndStart(){
              
       
    } // close buildTrackAndStart method
    
    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent a){
           
        }
    } 
    
    public class MyStopListener implements ActionListener {
      public void actionPerformed(ActionEvent a){
           
        }
    } 
    
    public class MyUpTempoListener implements ActionListener {
       public void actionPerformed(ActionEvent a){
           
        }
    } 
    
    public class MyDownTempoListener implements ActionListener {
       public void actionPerformed(ActionEvent a){
           
        }
    } 
    public class MySendListener implements ActionListener {
       public void actionPerformed(ActionEvent a){
           
        }
    }// close inner class

    public class MyReadInListener implements ActionListener {
       public void actionPerformed(ActionEvent a){
           
       }
    } // close inner class
    
    public void makeTracks(int[] list){
       for (int i = 0; i < 16; i++){
            int key = list[i];
            
            if (key != 0){
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
        }
    }
    
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
       MidiEvent event = null;
       try {
        ShortMessage a = new ShortMessage();
        a.setMessage(comd, chan, one, two);
        event = new MidiEvent(a, tick);
        
    } catch(Exception e){ e.printStackTrace(); }
       return event;
    }
} // close outer class
