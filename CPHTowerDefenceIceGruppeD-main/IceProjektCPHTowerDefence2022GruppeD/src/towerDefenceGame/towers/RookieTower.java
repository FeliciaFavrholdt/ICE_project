package towerDefenceGame.towers;

import javax.swing.*;

public class RookieTower extends ATower {
    ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/towerTess.png");

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
    public ImageIcon getIcon() {
        return icon;
    }
}
