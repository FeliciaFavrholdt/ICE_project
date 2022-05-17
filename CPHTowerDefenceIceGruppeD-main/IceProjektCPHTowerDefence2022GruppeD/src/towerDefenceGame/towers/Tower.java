package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;

public interface Tower {
    void towerPosition();
    boolean ifOutOfAmmo();
    void shootEnemy(Enemy e);
    void setDmg(int damage);
    int getDmg();
    void reload();
    int getCost();
}
