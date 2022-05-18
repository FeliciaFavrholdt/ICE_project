package towerDefenceGame;

public class Player {
    private String name;
    private int score=0;
    private int coins;
    private int id;

    //constructor
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
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

    public int getId(){
        return id;
    }

    //setters
    public void setScore(int score) {
        this.score = score;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}