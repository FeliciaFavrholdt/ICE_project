package towerDefenceGame.towers;

import javax.swing.*;
import java.io.File;

public class RookieTower extends ATower {

    //OBJECTS OF CLASSES
    private ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/rookieTower.png");
    private File audio = new File("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/smartsound_HUMAN_VOCAL_Female_Laugh_Breathy.wav");

    // CONSTRUCTOR
    public RookieTower(){
        this.damage = 200;
        this.cost = 200;
    }

    // toString method to write that the tower is reloading later on
    @Override
    public String toString() {
        return "Rookie Tower";
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