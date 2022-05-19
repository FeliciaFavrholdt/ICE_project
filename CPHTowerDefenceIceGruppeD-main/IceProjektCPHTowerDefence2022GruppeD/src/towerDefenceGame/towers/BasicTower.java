package towerDefenceGame.towers;

public class BasicTower extends ATower {

    // CONSTRUCTOR
    public BasicTower() {
        this.damage = 100;
        this.cost = 100;
    }

    // toString method to write that the tower is reloading later on
    @Override
    public String toString() {
        return "Basic Tower";
    }

}



