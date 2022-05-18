package towerDefenceGame.towers;

public class SuperTower extends ATower {
    public SuperTower(){
        this.damage = 400;
        this.cost = 400;
    }

    @Override
    public String toString() {
        return "Super Tower";
    }

}
