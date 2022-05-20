package towerDefenceGame.towers;

import javax.swing.*;
import java.io.File;

public class BasicTower extends ATower {

    // OBJECTS OF CLASSES
    private ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/basicTower.png");
    private File audio = new File("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/aaj_0182_Sipping_Coffee_01.wav");

    // CONSTRUCTOR
    public BasicTower() {
        this.damage = 100;
        this.cost = 100;
    }

    // toString method to write that the tower is reloading later on
    @Override
    public String toString() {
        return "Basic Tower";
    }

    // Getter to return icon
    public ImageIcon getIcon() {
        return icon;
    }

    // Method to get sound effect
    public File getAudio() {
        return  audio;
    }
}



