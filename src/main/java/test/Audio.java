package test;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Audio {

    private File file;
    private AudioInputStream audioStream;
    private Clip clip;
    private Timer timer;
    private TimerTask task;

    public Audio(){
//        file = new File("src/main/resources/gameOver1.wav");
//
//        try {
//            audioStream = AudioSystem.getAudioInputStream(file);
//        } catch (UnsupportedAudioFileException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            clip = AudioSystem.getClip();
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            clip.open(audioStream);
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void playGameOver() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        file = new File("src/main/resources/gameOver.wav");
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

//        timer = new Timer();
//        task = new TimerTask() {
//
//            int counter = 10;
//
//            @Override
//            public void run() {
//                if (counter>0){
//                    clip.start();
//                    counter--;
//                }
//                else {
//                    timer.cancel();
//                }
//
//            }
//        };
//
//        timer.schedule(task, 0, 1000);
    }

    public void playAllWallDestroyed() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        file = new File("src/main/resources/allWallDestroyed.wav");
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public void playNextLevel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        file = new File("src/main/resources/nextLevel.wav");
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

}
