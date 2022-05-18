package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;

import java.util.ArrayList;

public interface Tower {
    void towerPosition();
    boolean ifOutOfAmmo();
    void shootEnemy(Enemy e);
    void setDmg(int damage);
    int getDmg();
    void reload();
    int getCost();
}
