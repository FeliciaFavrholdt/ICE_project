package towerDefenceGame.towers;

public class RookieTower extends ATower {
    public RookieTower(){
        this.damage = 200;
        this.cost = 200;
    }

    @Override
    public String toString() {
        return "Rookie Tower";
    }
}
