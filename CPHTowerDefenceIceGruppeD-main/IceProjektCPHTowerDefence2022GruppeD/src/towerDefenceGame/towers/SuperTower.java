package towerDefenceGame.towers;

public class SuperTower extends ATower {

    // CONSTRUCTOR
    public SuperTower(){
        this.damage = 400;
        this.cost = 400;
    }

    // toString method to write that the tower is reloading later on
    @Override
    public String toString() {
        return "Super Tower";
    }

}
