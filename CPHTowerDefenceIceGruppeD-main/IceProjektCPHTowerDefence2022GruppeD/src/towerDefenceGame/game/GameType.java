package towerDefenceGame.game;

import towerDefenceGame.Player;

public interface GameType {
    void menuSelect();
    void doWave();
    void reloadAllTowers();
    void buyTower();
}
