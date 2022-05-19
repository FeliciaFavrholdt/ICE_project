package towerDefenceGame.towers;

import javax.swing.*;

public class BasicTower extends ATower {
    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/towerJesper.png");

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
    public ImageIcon getIcon() {
        return icon;
    }

}



