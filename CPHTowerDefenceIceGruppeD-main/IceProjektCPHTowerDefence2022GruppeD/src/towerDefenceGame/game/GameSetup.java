package towerDefenceGame.game;

import towerDefenceGame.gui.GameScreen;

public class GameSetup {
    GameMenu gameMenu;
    GameScreen gameScreen;

    //CONSTRUCTOR
    public GameSetup() {
        gameMenu = new GameMenu();
        gameScreen = new GameScreen();
    }

    //method to run the game description and user menu
    public void runGame() {
        gameMenu.gameDescription();
        gameMenu.userMenu();
    }

    //method to start the game -- open JFrame window (gameScreen)
    public void startGame() {
        System.out.println("you have started the game");
        gameScreen.makeGameScreen();
    }

    //method to end the game -- shutdown program
    public void endGame() {
        System.out.println("you have ended the game");
    }
}