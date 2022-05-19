package towerDefenceGame.enemies;

import javax.swing.*;

public class LegendaryEnemy extends AEnemy {

    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/EnemyThree.png");

    // CONSTRUCTOR
    public LegendaryEnemy(int health) {
        super(health);
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
