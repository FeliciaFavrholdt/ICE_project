package towerDefenceGame.inputs;

import javax.sound.sampled.*;
import java.io.File;

public class Audio {

    public void playMusicFile(File musicFile) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        } catch (Exception e) {

        }
    }
}
