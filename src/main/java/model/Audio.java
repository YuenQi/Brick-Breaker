package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This is Audio class which will play audio.
 */
public class Audio {

    private File file;
    private AudioInputStream audioStream;
    private Clip clip;

    /**
     * This method plays "gameOver.wav" melancholy music when the user loses all the balls.
     *
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playGameOver() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        file = new File("src/main/resources/gameOver.wav");
        playMusic(file);
    }

    /**
     * This method plays "allWallDestroyed.wav" cheering music when the user completes the last level.
     *
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playAllWallDestroyed() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        file = new File("src/main/resources/allWallDestroyed.wav");
        playMusic(file);
    }

    /**
     * This method plays "nextLevel.wav" cheering music when user successfully breaks all the bricks in 1 level and goes to next level
     *
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playNextLevel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        file = new File("src/main/resources/nextLevel.wav");
        playMusic(file);
    }

    /**
     * This method plays music specified by the calling method.
     *
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playMusic(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}
