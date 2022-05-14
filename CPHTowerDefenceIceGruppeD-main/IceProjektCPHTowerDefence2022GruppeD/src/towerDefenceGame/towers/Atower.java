package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;

public abstract class Atower implements Tower {
    private int damage;
    private int radius;

    @Override
    public void towerPosition() {

    }

    @Override
    public void ifEnemyNearby() {

    }

    @Override
    public void shootEnemy(Enemy e) {
        e.enemyTakeDamage(damage);
    }

    @Override
    public void setDmg(int damage) {
        this.damage = damage;
    }
}
