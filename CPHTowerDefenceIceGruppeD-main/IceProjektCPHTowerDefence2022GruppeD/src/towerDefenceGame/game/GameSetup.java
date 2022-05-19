package towerDefenceGame.game;

import towerDefenceGame.Player;
import towerDefenceGame.gui.GameScreen;

import java.util.ArrayList;
import java.util.Scanner;

public class GameSetup {
    GameMenu gameMenu;
    GameScreen gameScreen;
    GameType game;
    Scanner scan = new Scanner(System.in);
    ArrayList<Player> players;

    //CONSTRUCTOR
    public GameSetup() {
        gameMenu = new GameMenu();
        gameScreen = new GameScreen();
        players = new ArrayList<>();
        Player player = new Player("AbeMand22");
        players.add(player);
    }

    //method to run the game description and user menu
    public void runGame() {
        gameMenu.gameDescription();
        gameMenu.userMenu();
    }

    public void startGame() {
        System.out.println("you have started the game");
        System.out.println("Do you want graphics? /y");
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("y")){
            game = new UIBasedGame();
        }else {
            game = new TextBasedGame(players.get(0));
        }
    }

    //method to end the game -- shutdown program
    public void endGame() {
        System.out.println("you have ended the game");
    }
    public void gameDescription() {
        String bullet = "\u2022 ";

        //about
        System.out.println("""
                \n>> Welcome to CPH Tower Defense game <<
                A minigame made by Helena, Isak, Jamie & Felicia.
                CPH Business - DAT 1. sem - ICE PROJECT

                """);

        //game description
        System.out.println("""
                 DESCRIPTION 
                Tower Defence is a game where you build some towers to protect your kingdom against enemies.\s
                When playing the game the player needs to use these towers to defend different waves of enemies from reaching the end of the path.\s
                The more enemies you shoot the more money you receive. The money can be used to build more towers.\s""");

        //game rules
        System.out.println("\n RULES " +
                "\n" + bullet + "Make towers to defend your kingdom" +
                "\n" + bullet + "Play waves to earn money to buy more towers" +
                "\n" + bullet + "You have 5/5 lives - you will lose a life when ...." +
                "\n" + bullet + "Have fun!");
    }
    public void userMenu() {
        Scanner scan = new Scanner(System.in);
        GameSetup gameSetup = new GameSetup();
        boolean quit = false;
        int menu;

        System.out.println("\n MENU ");
        System.out.println(  " Press 0 to quit the menu");
        System.out.println(  " Press 1 to start the game");
        System.out.println(  " Press 2 to end the game");
        System.out.println(  " Press 3 to insert a new player");
        System.out.println(  " Press 4 to delete a player");
        System.out.println( " Press 5 to search for all added players");
        System.out.println( " Press 6 to show leaderboard");

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
                    //registerPlayer();
                    break;
                case 4:
                    //databaseIO.ShowAllPlayersAndDeleteFromDB();
                    break;
                case 5:
                    //databaseIO.searchForPlayerFromDB();
                    break;
                case 6:
                    //databaseIO.showLeaderBoard();
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