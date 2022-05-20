package towerDefenceGame.towers;

import towerDefenceGame.enemies.Enemy;

public abstract class ATower implements Tower {

    // PRIMITIVE DATA FIELDS
    protected int damage;
    protected int cost;
    private int maxAmmunition = 20;
    private int ammunition;

    // CONSTRUCTOR
    public ATower() {
    }

    // Method to
    @Override
    public void towerPosition() {
    }

    // Method to see if the tower is out of ammo
    @Override
    public boolean ifOutOfAmmo() {
        if(ammunition <= 0){
            return true;
        }
        return false;
    }

    // Method to shoot the enemy, enemy looses health and tower looses ammunition
    @Override
    public void shootEnemy(Enemy e) {
        e.enemyTakeDamage(damage);
        ammunition--;
        System.out.println("bang!");
    }

    // Setter to set damage
    @Override
    public void setDmg(int damage) {
        this.damage = damage;
    }

    // Getter to get damage
    @Override
    public int getDmg() {
        return damage;
    }

    // Method to reload the tower
    @Override
    public void reload() {
        ammunition = maxAmmunition;
        System.out.println(this.toString() + " is reloading");
    }

    // Getter - the cost of the tower
    public int getCost() {
        return cost;
    }

}