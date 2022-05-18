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
    Scanner scan = new Scanner(System.in);
    ArrayList<Tower> towers;
    ArrayList<ArrayList<Enemy>> waves;
    FileIO fileIO = new FileIO();
    private int currentWave = 0;
    private boolean hasLost = false;
    private int startingCoins = 200;
    private int coinsPerWave = 100;
    private Player player;
    String arrow = "\u2192";

    //constructor
    public TextBasedGame(Player player) {
        this.player = player;
        player.setCoins(startingCoins);
        towers = new ArrayList<>();
        waves = fileIO.readWaveData();
        while (hasLost != true) {
            menuSelect();
        }
        player.setScore(currentWave * 69420);
        System.out.println("#### GAME OVER! ####\n" +
                player.getName() + " your score is: " + player.getScore());
    }

    //method to
    private void menuSelect() {
        System.out.println("Current amount of towers: " + towers.size());
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
                doWave();
                break;
            case "c":
                hasLost = true;
                break;
        }
    }

    //method to run a wave - loops through all 15 waves
    public void doWave() {
        reloadAllTowers();
        for (int i = 0; i < towers.size(); i++) {
            while (!towers.get(i).ifOutOfAmmo()) {
                towers.get(i).shootEnemy(waves.get(currentWave).get(0));
                System.out.println(waves.get(currentWave).get(0).getEnemyHealth());
                if (waves.get(currentWave).size() == 1 && waves.get(currentWave).get(0).getEnemyHealth() <= 0) { //hvis der ikke er nogen enemies tilbage så
                    currentWave++;
                    System.out.println("You have completed the wave: " + currentWave);
                    player.addCoin(coinsPerWave);
                    return;
                }
                if (waves.get(currentWave).get(0).getEnemyHealth() <= 0) {
                    waves.get(currentWave).remove(0);
                }
            }
        }
        hasLost = true;
    }

    //method to
    public void reloadAllTowers() {
        for (Tower t : towers) {
            t.reload();
        }
    }

    //method to
    private void buyTower() {
        String text = "You do not have the coin to buy this tower\n";

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

//WE DO NOT USE THIS ??
      /* public void doWave(){
        int totalWaveHP = getTotalEnemyHP();
        int totalTowerDamage = getTotalTowerDamage();
        if(totalTowerDamage >= totalWaveHP){
            System.out.println("you won the wave!");
            currentWave++;
        }else{
            System.out.println("game over!");
            hasLost = true;
        }
    }*/

   /* private int getTotalTowerDamage() {
        int sum = 0;
        for (Tower t:towers) {
           sum += t.getDmg();
        }
        return sum;
    }*/


   /* private int getTotalEnemyHP() {
        int sum=0;
        for(int i =0;i<waves.get(currentWave).size();i++){
            sum += waves.get(currentWave).get(i).getEnemyHealth();
        }
        return sum;
    }*/
