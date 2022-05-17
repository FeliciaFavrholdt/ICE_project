package towerDefenceGame.enemies;

public abstract class AEnemy implements Enemy {
    private int health;
    private int value;
    private int x;
    private int y;

    public AEnemy(int health){
        this.health = health;
    }

    @Override
    public void moveEnemy(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void showEnemy() {

    }

    @Override
    public void deathOfEnemy() {
        System.out.println("im dead now");
    }

    @Override
    public int checkIfEnemyIsInBase(int basex, int basey) {
        if (x == basex && y == basey){
            return 1;
        }
        return 0;
    }

    public void enemyTakeDamage(int damageNumber){
        this.health = this.health - damageNumber;
    }
    public int getEnemyHealth(){
        return this.health;
    }
}
