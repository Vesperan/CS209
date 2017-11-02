package edu.virginia.engine.display;
import java.util.*;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class SoundManager extends JFrame{

    private HashMap<String,String> sound_hm;
    private HashMap<String,String> music_hm;

    public SoundManager() {
        sound_hm = new HashMap<String,String>();
        music_hm = new HashMap<String,String>();
    }

    public void LoadSoundEffect(String id, String filename) {
        //Loads sound effect files into a hashmap of sound effects where the
        //key is the String id and the value is the sound clip.
        sound_hm.put(id, filename);
        // String file = ("resources" + File.separator+ filename);

    }

    public void PlaySoundEffect(String id) {
        //plays sound effect

        //get filename from hashmap
        String filename = sound_hm.get(id);
        File soundFile = new File(filename);



        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);
            //clip plays once
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        //
        //sound_hm.get(id).start();

    }
    public void StopSoundEffect(String id) {

    }

    public void LoadMusic(String id, String filename) {
        music_hm.put(id, filename);

    }

    public void PlayMusic(String id) {
        //get filename from hashmap
        String filename = music_hm.get(id);

        File soundFile = new File(filename);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println("music playing!!");

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        //music theme song clip plays continuously
    }

}
