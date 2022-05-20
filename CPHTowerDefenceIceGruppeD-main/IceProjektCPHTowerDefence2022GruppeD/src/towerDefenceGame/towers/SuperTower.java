package towerDefenceGame.towers;

import javax.swing.*;
import java.io.File;

public class SuperTower extends ATower {

    // OBJECTS OF CLASSES
    private ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/superTower.png");
    private File audio = new File("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/zapsplat_fantasy_wizard_old_male_deep_voice_wise_says_i_am_the_wise_one_77637.wav");


    // CONSTRUCTOR
    public SuperTower(){
        this.damage = 400;
        this.cost = 400;
    }

    // toString method to write that the tower is reloading later on
    @Override
    public String toString() {
        return "Super Tower";
    }

    // Getter to return icon
    public ImageIcon getIcon() {
        return icon;
    }

    // Getter to return audio
    public File getAudio() {
        return audio;
    }
}
