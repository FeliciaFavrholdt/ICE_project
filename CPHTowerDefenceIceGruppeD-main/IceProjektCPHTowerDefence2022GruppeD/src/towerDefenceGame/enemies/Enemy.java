package towerDefenceGame.enemies;

import javax.swing.*;

public interface Enemy {

    // METHODS
    void enemyTakeDamage(int damageNumber);
    int getEnemyHealth();
    ImageIcon getIcon();
}
