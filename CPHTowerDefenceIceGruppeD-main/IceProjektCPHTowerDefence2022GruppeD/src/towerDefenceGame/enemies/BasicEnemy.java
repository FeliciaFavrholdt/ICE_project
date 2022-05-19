package towerDefenceGame.enemies;

import javax.swing.*;

public class BasicEnemy extends AEnemy{
    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/basicEnemy.png");
    // CONSTRUCTOR
    public BasicEnemy(int health) {
        super(health);
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
