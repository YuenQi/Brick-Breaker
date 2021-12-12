package model;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

//ADDITION: add Audio class to play music to give reward or penalty to player
/**
 * This is Audio class which will play audio (to give reward or penalty to player).
 */
public class Audio {

    /**AudioInputStream object*/
    private AudioInputStream audioStream;

    /**Clip object*/
    private Clip clip;

    /**audio file name*/
    URL gameOverUrl, allWallDestroyedUrl, nextLevelUrl;

    /**
     * This method plays "gameOver.wav" melancholy music when the user loses all the balls to give some sort of penalty to user.
     *
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playGameOver() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        gameOverUrl = getClass().getResource("/gameOver.wav");
        playMusic(gameOverUrl);
    }

    /**
     * This method plays "allWallDestroyed.wav" cheering music when the user completes the last level to give some sort of reward to user.
     *
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playAllWallDestroyed() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        allWallDestroyedUrl = getClass().getResource("/allWallDestroyed.wav");
        playMusic(allWallDestroyedUrl);
    }

    /**
     * This method plays "nextLevel.wav" cheering music when user successfully breaks all the bricks in 1 level and goes to next level
     * to give some sort of reward to user.
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playNextLevel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        nextLevelUrl = getClass().getResource("/nextLevel.wav");
        playMusic(nextLevelUrl);
    }

    /**
     * This method plays music specified by the calling method.
     * @param file audio file that is going to be played
     * @throws UnsupportedAudioFileException an exception indicating that an operation failed because a file did not contain valid data of a recognised file type and format
     * @throws IOException I/O exception of some sort has occurred
     * @throws LineUnavailableException indicating that a line cannot be opened because it is unavailable
     */
    public void playMusic(URL file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}
