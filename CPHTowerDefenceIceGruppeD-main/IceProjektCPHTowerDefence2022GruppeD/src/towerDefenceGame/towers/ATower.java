package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;

import java.util.ArrayList;

public abstract class ATower implements Tower {
    protected int damage;
    protected int cost;
    private int maxAmmunition = 20;
    private int ammunition;

    //constructor
    public ATower() {
    }

    @Override
    public void towerPosition() {
    }

    @Override
    public boolean ifOutOfAmmo() {
        if(ammunition <= 0){
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
    public void reload() {
        ammunition = maxAmmunition;
        System.out.println(this.toString() + " is reloading");
    }

    public int getCost() {
        return cost;
    }
}
