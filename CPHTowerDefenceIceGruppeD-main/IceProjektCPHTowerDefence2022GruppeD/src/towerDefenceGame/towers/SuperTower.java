package towerDefenceGame.towers;

import javax.swing.*;

public class SuperTower extends ATower {
    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/TowerTobias.png");

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
    public ImageIcon getIcon() {
        return icon;
    }

}
