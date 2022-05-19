package towerDefenceGame.towers;

public class RookieTower extends ATower {

    // CONSTRUCTOR
    public RookieTower(){
        this.damage = 200;
        this.cost = 200;
    }

    // toString method to write that the tower is reloading later on
    @Override
    public String toString() {
        return "Rookie Tower";
    }
}
