package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;

public abstract class Atower implements Tower {
    protected int damage;
    protected int cost;
    private int maxAmmuntion=20;
    private int ammunition;

    @Override
    public void towerPosition() {

    }

    @Override
    public boolean ifOutOfAmmo() {
        if(ammunition <=0){
            return true;
        }
        return false;
    }

    @Override
    public void shootEnemy(Enemy e) {
        e.enemyTakeDamage(damage);
        ammunition--;
        System.out.println("bang!");
    }

    @Override
    public void setDmg(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDmg() {
        return damage;
    }
    @Override
    public void reload(){
        ammunition = maxAmmuntion;
        System.out.println("im reloading");
    }

    public int getCost() {
        return cost;
    }
}
