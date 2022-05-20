package towerDefenceGame.enemies;

import javax.swing.*;

public class BasicEnemy extends AEnemy {

    // OBJECTS OF CLASSES
    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/basicEnemy.png");

    // CONSTRUCTOR
    public BasicEnemy(int health) {
        super(health);
    }

    // Getter to return icon
    public ImageIcon getIcon() {
        return icon;
    }
}