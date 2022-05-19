package towerDefenceGame.game;

import towerDefenceGame.Player;
import towerDefenceGame.io.DatabaseIO;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSetup {
    GameType game;
    Scanner scan;
    ArrayList<Player> players;
    String arrow = "\u2192";
    DatabaseIO databaseIO;
    String input;
    private Player player;

    //constructor
    public GameSetup() {
        //players = new ArrayList<>();
        databaseIO = new DatabaseIO();
        scan = new Scanner(System.in);
    }

    //method to run the game description and user menu
    public void runGame() {
        gameDescription();
        userMenu();
    }

    //method to choose which kind of game to start
    public void startGame() {
        System.out.println("\n#### GAME STARTED ####");
        player = addPlayerToGame();
        gameChoice();
    }

    private void gameChoice() {
        System.out.println("\nDo you want graphics?");
        System.out.println(arrow + " Y) for yes");
        System.out.println(arrow + " N) for no");

        input = scan.nextLine();
        if(input.equalsIgnoreCase("y")) {
            game = new UIBasedGame();
        } else if(input.equalsIgnoreCase("n")) {
            game = new TextBasedGame(player);
            databaseIO.updateScorePoint(player);
        }
        userMenu();
    }

    //method to choose which player should play the game
    public Player addPlayerToGame() {
        databaseIO.showAllPlayersFromDB();
        System.out.println("\nWho is playing?");
        return databaseIO.userInputOnID();
    }

    //method to end the game -- shutdown program
    public void endGame() {
        System.out.println("GAME ENDED!");
    }

    //method to display description of the project/game
    private void gameDescription() {
        String bullet = "\u2022 ";

        //titel & about
        System.out.println("""
                \n>> CPH TOWER DEFENSE MINIGAME <<
                A minigame made by Helena, Isak, Jamie & Felicia.
                CPH Business - DAT 1. sem - ICE PROJECT
                """);

        //game description
        System.out.println("""
                DESCRIPTION
                Tower Defence is a game where you build some towers to protect your kingdom against enemies.
                When playing the game the player needs to use these towers to defend different waves of enemies from reaching the end of the path.
                The more enemies you shoot the more money you receive. The money can be used to build more towers.
                """);

        //game rules
        System.out.println("RULES " +
                "\n" + bullet + "Make towers to defend your kingdom" +
                "\n" + bullet + "Play waves to earn money to buy more towers" +
                "\n" + bullet + "Have fun!\n");
    }

    //method to display a user menu with calls to other methods
    public void userMenu() {
        boolean quit = false;
        String menu;

        System.out.println("\nMENU ");
        System.out.println(arrow + " 0) to quit the menu");
        System.out.println(arrow + " 1) to start the game");
        System.out.println(arrow + " 2) to end the game");
        System.out.println(arrow + " 3) to add a new player");
        System.out.println(arrow + " 4) to delete a player");
        System.out.println(arrow + " 5) to search for a player");
        System.out.println(arrow + " 6) to show leaderboard");

        while (!quit) {
            menu = scan.nextLine();
            switch (menu) {
                case "1":
                    startGame();
                    break;
                case "2":
                    endGame();
                    break;
                case "3":
                    databaseIO.registerPlayerToDB();
                    userMenu();
                    break;
                case "4":
                    databaseIO.deleteFromDB();
                    userMenu();
                    break;
                case "5":
                    databaseIO.searchForPlayerFromDB();
                    userMenu();
                    break;
                case "6":
                    databaseIO.showLeaderBoard();
                    userMenu();
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.. choose again");
                    userMenu();
            }
        }
        System.out.println("You quit the menu!");
    }
}