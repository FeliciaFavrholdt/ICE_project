package towerDefenceGame.enemies;

import javax.swing.*;

public interface Enemy {

    void moveEnemy(int x,int y);
    void showEnemy();
    void deathOfEnemy();
    int checkIfEnemyIsInBase(int baseX, int baseY);
    void enemyTakeDamage(int damageNumber);
    int getEnemyHealth();
    ImageIcon getIcon();
}
