package towerDefenceGame;

public class Player {

    // STRINGS
    private String name;

    // PRIMITIVE DATA FIELDS
    private int score=0;
    private int coins;
    private int id;

    // CONSTRUCTOR
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to add coins per wave
    public void addCoin(int coinsPerWave) {
        coins += coinsPerWave;
    }

    // GETTERS
    // Getter to get the name of the player
    public String getName() {
        return name;
    }

    // Getter to get the score
    public int getScore() {
        return score;
    }

    // Getter to get the coins
    public int getCoins() {
        return coins;
    }

    // Getter to get the id
    public int getId(){
        return id;
    }



    // SETTERS
    // Setter to set the score
    public void setScore(int score) {
        this.score = score;
    }

    // Setter to set the coins
    public void setCoins(int coins) {
        this.coins = coins;
    }
}