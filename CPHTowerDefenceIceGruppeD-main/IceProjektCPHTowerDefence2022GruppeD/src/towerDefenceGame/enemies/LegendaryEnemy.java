package towerDefenceGame.enemies;

import javax.swing.*;

public class LegendaryEnemy extends AEnemy {

    // OBJECTS OF CLASSES
    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/legendaryEnemy.png");

    // CONSTRUCTOR
    public LegendaryEnemy(int health) {
        super(health);
    }

    // Getter to return icon
    public ImageIcon getIcon() {
        return icon;
    }
}