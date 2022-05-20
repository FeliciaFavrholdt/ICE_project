package towerDefenceGame.game;

import towerDefenceGame.Player;
import towerDefenceGame.io.DatabaseIO;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSetup {

    // OBJECTS OF CLASSES
    private GameType game;
    private Scanner scan;
    private ArrayList<Player> players;
    private String arrow = "\u2192";
    private DatabaseIO databaseIO;
    private String input;
    private Player player;

    // CONSTRUCTOR
    public GameSetup() {
        //players = new ArrayList<>();
        databaseIO = new DatabaseIO();
        scan = new Scanner(System.in);
    }

    // Method to run the game description and user menu
    public void runGame() {
        gameDescription();
        userMenu();
    }

    // Method to choose which kind of game to start
    public void startGame() {
        System.out.println("\n#### GAME STARTED ####");
        player = addPlayerToGame();
        gameChoice();
    }

    // Method to ask user if they want to play with graphics or just text based
    private void gameChoice() {
        System.out.println("\nDo you want graphics?");
        System.out.println(arrow + " Y) for yes");
        System.out.println(arrow + " N) for no");

        input = scan.nextLine();
        if(input.equalsIgnoreCase("y")) {
            game = new GUIBasedGame(player);
            databaseIO.updateScorePoint(player);
        } else if(input.equalsIgnoreCase("n")) {
            game = new TextBasedGame(player);
            databaseIO.updateScorePoint(player);
        }
    }

    // Method to choose which player should play the game
    public Player addPlayerToGame() {
        databaseIO.showAllPlayersFromDB();
        System.out.println("\nWho is playing?");
        return databaseIO.userInputOnID();
    }

    // Method to display description of the project/game
    private void gameDescription() {
        String bullet = "\u2022 ";

        //titel & about
        System.out.println("""
                \n>> DEFENDER MINIGAME <<
                A minigame made by Helena, Isak, Jamie & Felicia.
                CPH Business - DAT 1. sem - ICE PROJECT
                """);

        //game description
        System.out.println("""
                DESCRIPTION
                This is a game where you can buy some towers to protect your kingdom against enemies.
                To play the game you need to enter a player name. Your goal is to kill all waves of enemies.
                When a wave is won you will get more coins to build more towers. 
                """);

        //game rules
        System.out.println("RULES " +
                "\n" + bullet + "The game is dependent on your user input." +
                "\n" + bullet + "Buy towers to defend your kingdom." +
                "\n" + bullet + "Play waves to earn money to buy more towers." +
                "\n" + bullet + "Have fun!\n");
    }

    // Method to load other methods through a switch case
    public void userMenu() {
        boolean quit = false;
        String menu;
        displayMenu();

        while (!quit) {
            menu = scan.nextLine();
            switch (menu) {
                case "1":
                    startGame();
                    break;
                case "2":
                    databaseIO.registerPlayerToDB();
                    break;
                case "3":
                    databaseIO.deleteFromDB();
                    break;
                case "4":
                    databaseIO.searchForPlayerFromDB();
                    break;
                case "5":
                    databaseIO.showLeaderBoard();
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.. choose again");
            }
            displayMenu();
        }
    }

    // Method to display the menu
    public void displayMenu(){
        System.out.println("\nMENU ");
        System.out.println(arrow + " 0) to quit the main menu");
        System.out.println(arrow + " 1) to start the game");
        System.out.println(arrow + " 2) to add a new player");
        System.out.println(arrow + " 3) to delete a player");
        System.out.println(arrow + " 4) to search for a player");
        System.out.println(arrow + " 5) to show leaderboard");
    }
}