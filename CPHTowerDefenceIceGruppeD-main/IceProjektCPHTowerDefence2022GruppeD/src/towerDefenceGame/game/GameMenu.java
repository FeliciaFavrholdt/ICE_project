package towerDefenceGame.game;

import towerDefenceGame.io.DatabaseIO;
import java.util.Scanner;

public class GameMenu {
    StringBuilder userInput;
    Scanner scan;
    DatabaseIO databaseIO;
    GameSetup gameSetup;

    //CONSTRUCTOR
    public GameMenu() {
        this.userInput = new StringBuilder(); //builds a string for user input
        this.databaseIO = new DatabaseIO();
    }

    //method to show submenu and call methods from DatabaseIO
    private void registerPlayer() {
        scan = new Scanner(System.in);
        String arrow = "\u2192";
        String startMessage = "\n" + arrow + " Press R to register a Player or Q to return to the menu:";

        System.out.println(startMessage);
        userInput.append(scan.nextLine());

        if (userInput.toString().equalsIgnoreCase("R")) {
            databaseIO.registerPlayerToDB();
        } else if (userInput.toString().equalsIgnoreCase("Q")) {
            userMenu();
        }
    }

    //method to display description of the project/game
    public void gameDescription() {
        String bullet = "\u2022 ";

        System.out.println("\n>> Welcome to CPH Tower Defense game <<");
        System.out.println("A minigame made by Helena, Isak, Jamie & Felicia");
        System.out.println("CPH Business - DAT 1. sem - ICE PROJECT"  + "\n");

        System.out.println("""
                **** DESCRIPTION ****
                Tower Defence is a game where you build some towers to protect your kingdom against enemies.\s
                When playing the game the player needs to use these towers to defend different waves of enemies from reaching the end of the path.\s
                The more enemies you shoot the more money you receive. The money can be used to build more towers.\s""");

        //CHANGE THIS
        System.out.println("\n**** RULES ****" +
                "\n" + bullet + "Make towers to defend your kingdom" +
                "\n" + bullet + "Play waves to earn money to buy more towers" +
                "\n" + bullet + "You have 5/5 lives - you will lose a life when ...." +
                "\n" + bullet + "Have fun!");
    }

    //method to display a user menu with calls to other methods
    public void userMenu() {
        scan = new Scanner(System.in);
        gameSetup = new GameSetup();
        boolean quit = false;
        int menu;
        String arrow = "\u2192";

        System.out.println("\n**** MENU ****");
        System.out.println(arrow + " Press 0 to quit the menu");
        System.out.println(arrow + " Press 1 to start the game");
        System.out.println(arrow + " Press 2 to end the game");
        System.out.println(arrow + " Press 3 to insert a new player");
        System.out.println(arrow + " Press 4 to delete an existing player");
        System.out.println(arrow + " Press 5 to search for an existing player");
        System.out.println(arrow + " Press 6 to add scorepoints");
        System.out.println(arrow + " Press 7 to show leaderboard");

        while (!quit) {
            menu = scan.nextInt();
            switch (menu) {
                case 1:
                    gameSetup.startGame();
                    break;
                case 2:
                    gameSetup.endGame();
                    break;
                case 3:
                    registerPlayer();
                    break;
                case 4:
                    databaseIO.ShowAllPlayersAndDeleteFromDB();
                    break;
                case 5:
                    databaseIO.searchForPlayerFromDB();
                    break;
                case 6:
                    databaseIO.addScorePointsToDB();
                    break;
                case 7:
                    databaseIO.showLeaderBoard();
                    break;
                case 0:
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