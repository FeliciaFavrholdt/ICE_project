package towerDefenceGame.enemies;

import javax.swing.*;

public class EpicEnemy extends AEnemy {

    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/EnemyTwo.png");

    // CONSTRUCTOR
    public EpicEnemy(int health) {
        super(health);
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
