package towerDefenceGame;

public class Player {
    private String name;
    private int score=0;
    private int coins;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void addCoin(int coinsPerWave) {
        coins += coinsPerWave;
    }
}
