package towerDefenceGame.enemies;

public abstract class AEnemy implements Enemy {

    // PRIMITIVE DATA FIELDS
    private int health;

    // CONSTRUCTOR
    public AEnemy(int health){
        this.health = health;
    }

    // Method to change the health of the enemy because it takes damage
    public void enemyTakeDamage(int damageNumber){
        this.health = this.health - damageNumber;
    }

    // Getter for enemy health
    public int getEnemyHealth(){
        return this.health;
    }


}