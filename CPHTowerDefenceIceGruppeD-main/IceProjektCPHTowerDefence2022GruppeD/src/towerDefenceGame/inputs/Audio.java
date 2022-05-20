package towerDefenceGame.inputs;

import towerDefenceGame.towers.Tower;

import javax.sound.sampled.*;
import java.io.File;

public class Audio {

    // FILES
    private File soundEffect1;
    private File soundEffect2;
    private File soundEffect3;
    // CONSTRUCTOR
    public Audio() {
        this.soundEffect1 = new File("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/zapsplat_multimedia_male_voice_processed_says_game_over_004_23671.wav");
        this.soundEffect2 = new File("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/little_robot_sound_factory_Shoot_00.wav");
        this.soundEffect3 = new File("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/zapsplat_multimedia_game_sound_synth_mallet_style_positive_complete_001_55290.wav");
    }

    // Method to load a music .wav file and play the sound effect : GAME OVER
    public void playSoundEffect1() {
        AudioInputStream stream;

        try {
            stream = AudioSystem.getAudioInputStream(soundEffect1);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to load a music .wav file and play the sound effect : SHOOTING
    public void playSoundEffect2() {
        AudioInputStream stream;

        try {
            stream = AudioSystem.getAudioInputStream(soundEffect2);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to load a music .wav file and play the sound effect : WAVE COMPLETED
    public void playSoundEffect3() {
        AudioInputStream stream;

        try {
            stream = AudioSystem.getAudioInputStream(soundEffect3);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to load a music .wav file and play the sound effect : TOWERS
    public void playSoundEffect4(Tower tower) {
        AudioInputStream stream;

        try {
            stream = AudioSystem.getAudioInputStream(tower.getAudio());
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
