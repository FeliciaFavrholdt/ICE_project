package towerDefenceGame.enemies;

public abstract class AEnemy implements Enemy {
    private int health;
    private int value;
    private int x;
    private int y;

    public AEnemy(int health){
        this.health = health;
    }

    // Meethod that makes the enemy move based on x and y position
    @Override
    public void moveEnemy(int x,int y) {
        this.x = x;
        this.y = y;
    }

    // Method that shows the enemy on screen
    @Override
    public void showEnemy() {

    }

    // Method to show the enemy dies
    @Override
    public void deathOfEnemy() {
        System.out.println("im dead now");
    }

    // Method to check if enemy has survived
    @Override
    public int checkIfEnemyIsInBase(int basex, int basey) {
        if (x == basex && y == basey){
            return 1;
        }
        return 0;
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
