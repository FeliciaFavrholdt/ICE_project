package towerDefenceGame;

public class Player {
    String name;
    private int score=0;
    private int coins;

    //constructor
    public Player(String name) {
        this.name = name;
    }

    //method to ...
    public void addCoin(int coinsPerWave) {
        coins += coinsPerWave;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getCoins() {
        return coins;
    }

    //setters
    public void setScore(int score) {
        this.score = score;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}