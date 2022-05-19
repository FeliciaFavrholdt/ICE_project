package towerDefenceGame.enemies;

import javax.swing.*;

public class LegendaryEnemy extends AEnemy {

    private ImageIcon icon;

    // CONSTRUCTOR
    public LegendaryEnemy(int health) {
        super(health);
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
