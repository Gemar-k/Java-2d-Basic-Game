package handlers;

import java.io.File; 
import java.io.IOException; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public class AudioHandler{
    private Clip clip;
    private AudioInputStream audioInputStream;
    private String audioSource;

    public AudioHandler(String src){
        //set audio source and create a  new clip
        this.audioSource = src;
        this.createClip(src);
    }

    //play audio clip
    public void play(){
        if(this.clip.isOpen()){
            this.clip.start();
        }else{
            this.createClip(this.audioSource);
            this.clip.start();
        }
    }

    //stop audio clip
    public void stop(){
        this.clip.stop();
        this.clip.close();
    }

    //pause audio clip
    public void pause(){
        this.clip.stop();
    }
    
    //loop the audio clip
    public void loop(){
        this.clip.loop(this.clip.LOOP_CONTINUOUSLY);
    }
    
    //get the status of the clip
    public boolean isPlaying(){
        return this.clip.isRunning();
    }
    
    //create new audio clip
    public void createClip(String src){
        try{
            audioInputStream =  
            AudioSystem.getAudioInputStream(new File(src).getAbsoluteFile()); 

            // create audio clip 
            clip = AudioSystem.getClip(); 

            // open audioInputStream to the clip 
            clip.open(audioInputStream); 
        }catch(Exception e){
            System.out.println("Error new audio clip could not be created " + e);
        }
    }
}