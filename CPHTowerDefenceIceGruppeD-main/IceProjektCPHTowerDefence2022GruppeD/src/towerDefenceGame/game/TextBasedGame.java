package towerDefenceGame.game;

import towerDefenceGame.Player;
import towerDefenceGame.enemies.Enemy;
import towerDefenceGame.io.FileIO;
import towerDefenceGame.towers.Tower;
import towerDefenceGame.towers.BasicTower;
import towerDefenceGame.towers.RookieTower;
import towerDefenceGame.towers.SuperTower;
import java.util.ArrayList;
import java.util.Scanner;

public class TextBasedGame implements GameType {

    //SCANNER
    private Scanner scan = new Scanner(System.in);

    // OBJECTS OF CLASSES
    private FileIO fileIO = new FileIO();
    private Player player;

    // PRIMITIVE DATA FIELDS
    private boolean hasLost = false;
    private int currentWave = 0;
    private int startingCoins = 200;
    private int coinsPerWave = 100;

    // STRINGS
    public String arrow = "\u2192";

    // ARRAYLISTS
    ArrayList<Tower> towers;
    ArrayList<ArrayList<Enemy>> waves;

    // CONSTRUCTOR
    public TextBasedGame(Player player) {
        this.player = player;
        player.setCoins(startingCoins);
        towers = new ArrayList<>();
        waves = fileIO.readWaveData();
        while (hasLost != true) {
            menuSelect();
        }
        player.setScore(currentWave * 69420);
        System.out.println(player.getName() + " your score is: " + player.getScore());
    }

    // Method which shows a menu to buy towers, play a wave or end game
    public void menuSelect() {
        System.out.println("\nCurrent amount of towers: " + towers.size());
        System.out.println("Current amount of coins: " + player.getCoins());

        System.out.println(
                        arrow + " A) to buy a new tower" + "\n" +
                        arrow + " B) to play next wave" + "\n" +
                        arrow + " C) to end game");

        String input = scan.nextLine();
        switch (input.toLowerCase()) {
            case "a":
                buyTower();
                break;
            case "b":
                if (waves.size()!=currentWave){
                    doWave();
                }else{
                    System.out.println("CONGRATZ MY DUDE! You won the game :D Good job!!!!");
                    hasLost = true;
                }

                break;
            case "c":
                System.out.println("#### GAME OVER! ####\n");
                hasLost = true;
                break;
        }
    }

    // Method to run a wave - loops through all 15 waves
    public void doWave() {
        reloadAllTowers();
        for (int i = 0; i < towers.size(); i++) {
            while (!towers.get(i).ifOutOfAmmo()) {
                towers.get(i).shootEnemy(waves.get(currentWave).get(0));
                System.out.println(waves.get(currentWave).get(0).getEnemyHealth()); //shows enemy health
                if (waves.get(currentWave).size() == 1 && waves.get(currentWave).get(0).getEnemyHealth() <= 0) { //hvis der ikke er nogen enemies tilbage så
                    currentWave++;
                    System.out.println("You have completed wave: " + currentWave);
                    player.addCoin(coinsPerWave);
                    System.out.println("You got " + coinsPerWave + " coins.");
                    return;
                }
                if (waves.get(currentWave).get(0).getEnemyHealth() <= 0) {
                    waves.get(currentWave).remove(0);
                }
            }
        }
        hasLost = true;
    }

    // Method to reload all the towers the player has bought
    public void reloadAllTowers() {
        for (Tower t : towers) {
            t.reload();
        }
    }

    // Method to buy towers - shows how many coins you have and what the towers cost
    public void buyTower() {
        //strings
        String text = "You do not have enough coins to buy this tower!";

        System.out.println("""
                Basic Tower = costs 100 coins, gives 100 damage
                Rookie Tower = costs 200 coins, gives 200 damage
                Super Tower = costs 400 coins, gives 400 damage
                """);

        System.out.println("Which tower do you want to buy?");

        System.out.println(arrow + " 1) Basic Tower\n" +
                arrow + " 2) Rookie Tower\n" +
                arrow + " 3) Super Tower");

        Tower tmpTower;
        switch (scan.nextLine()) {
            case "1":
                tmpTower = new BasicTower();
                if (player.getCoins() >= tmpTower.getCost()) {
                    towers.add(tmpTower);
                    player.addCoin(-tmpTower.getCost());
                } else {
                    System.out.println(text);
                }
                break;

            case "2":
                tmpTower = new RookieTower();
                if (player.getCoins() >= tmpTower.getCost()) {
                    towers.add(tmpTower);
                    player.addCoin(-tmpTower.getCost());
                } else {
                    System.out.println(text);
                }
                break;

            case "3":
                tmpTower = new SuperTower();
                if (player.getCoins() >= tmpTower.getCost()) {
                    towers.add(tmpTower);
                    player.addCoin(-tmpTower.getCost());
                } else {
                    System.out.println(text);
                }
                break;
        }
    }
}