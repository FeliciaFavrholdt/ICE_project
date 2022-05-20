package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;
import javax.swing.*;
import java.io.File;

public interface Tower {

    //METHODS
    boolean ifOutOfAmmo();
    void shootEnemy(Enemy e);
    void setDmg(int damage);
    int getDmg();
    void reload();
    int getCost();
    ImageIcon getIcon();
    File getAudio();
}