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

    /*  NOT USED ????
    private int x;
    private int y;
    private int value;

    // Method that makes the enemy move based on x and y position
    public void moveEnemy(int x,int y) {
        this.x = x;
        this.y = y;
    }

    // Method to show the enemy dies
    public void deathOfEnemy() {
        System.out.println("im dead now");
    }

    // Method to check if enemy has survived
    public int checkIfEnemyIsInBase(int basex, int basey) {
        if (x == basex && y == basey){
            return 1;
        }
        return 0;
    }*/

}