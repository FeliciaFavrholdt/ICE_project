package towerDefenceGame;

public class Player {
    private String name;
    private int currentHealth;
    private int maxHealth;

    public Player (int health){
        this.maxHealth = health;
        this.currentHealth = health;
    }

    public void takeDamage(int damage){
        System.out.println("you took damage!");
        this.currentHealth = this.currentHealth-damage;
        if(this.currentHealth <= 0){
            System.out.println("game over!");
        }
    }
}
