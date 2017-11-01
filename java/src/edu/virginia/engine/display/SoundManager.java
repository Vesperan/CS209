package edu.virginia.engine.display;
import java.util.*;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class SoundManager extends JFrame{

    private HashMap<String,String> sound_hm = new HashMap<String,String>();
    private HashMap<String,String> music_hm = new HashMap<String,String>();
    private File soundEffect;
    private Clip clip;

    public void LoadSoundEffect(String id, String filename) {
        //Loads sound effect files into a hashmap of sound effects where the
        //key is the String id and the value is the sound clip.
        sound_hm.put(id, filename);
    }

    public void PlaySoundEffect(String id) {
        //plays sound effect

        //get filename from hashmap
        String filename = sound_hm.get(id);

        File soundFile = new File(filename);

        //stack overflow solution for below
//        AudioInputStream audioIn=AudioSystem.getAudioInputStream(
//                new BufferedInputStream(new FileInputStream(soundFile)));


        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

        Clip clip = AudioSystem.getClip();

        clip.open(audioIn);
        //clip plays once
        clip.start();

    }

    public void LoadMusic(String id, String filename) {
        music_hm.put(id, filename);

    }

    public void PlayMusic(String id) {
        //get filename from hashmap
        String filename = music_hm.get(id);

        File soundFile = new File(filename);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

        Clip clip = AudioSystem.getClip();

        clip.open(audioIn);
        //music theme song clip plays continuously
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
