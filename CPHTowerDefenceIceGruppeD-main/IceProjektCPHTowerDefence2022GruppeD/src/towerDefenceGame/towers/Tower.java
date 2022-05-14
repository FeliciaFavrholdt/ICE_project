package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;

public interface Tower {

    public void towerPosition();
    public void ifEnemyNearby();
    public void shootEnemy(Enemy e);
    public void setDmg(int damage);
}
