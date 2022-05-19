package towerDefenceGame.game;

import towerDefenceGame.gui.GameScreen;
import towerDefenceGame.gui.Map;

public class UIBasedGame implements GameType{
    Map gameScreen;
    public UIBasedGame(){
        gameScreen  = new Map();
    }
}
