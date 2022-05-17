package towerDefenceGame;

import towerDefenceGame.enemies.Enemy;
import towerDefenceGame.enemies.legendaryEnemy;
import towerDefenceGame.game.GameSetup;
import towerDefenceGame.gui.GameScreen;
import towerDefenceGame.inputs.Audio;
import towerDefenceGame.io.FileIO;
import towerDefenceGame.towers.Tower;
import towerDefenceGame.towers.superTower;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Main {

    //psvm - main method to run the program
    public static void main(String[] args) {


        GameSetup gameSetup = new GameSetup();
        gameSetup.runGame();
    }
}
