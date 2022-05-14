package towerDefenceGame.enemies;

public interface Enemy {

    public void moveEnemy(int x,int y);
    public void showEnemy();
    public void deathOfEnemy();
    public int checkIfEnemyIsInBase(int baseX, int baseY);
    public void enemyTakeDamage(int damageNumber);
    public int getEnemyHealth();
}
