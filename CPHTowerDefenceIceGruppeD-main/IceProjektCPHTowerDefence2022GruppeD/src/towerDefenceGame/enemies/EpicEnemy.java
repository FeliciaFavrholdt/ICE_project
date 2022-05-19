package towerDefenceGame.enemies;

import javax.swing.*;

public class EpicEnemy extends AEnemy {

    private ImageIcon icon;

    // CONSTRUCTOR
    public EpicEnemy(int health) {
        super(health);
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
