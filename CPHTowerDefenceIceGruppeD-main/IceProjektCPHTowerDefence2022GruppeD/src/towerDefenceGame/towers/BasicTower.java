package towerDefenceGame.towers;

public class BasicTower extends ATower {

    public BasicTower() {
        this.damage = 100;
        this.cost = 100;
    }

    @Override
    public String toString() {
        return "Basic Tower";
    }

}



