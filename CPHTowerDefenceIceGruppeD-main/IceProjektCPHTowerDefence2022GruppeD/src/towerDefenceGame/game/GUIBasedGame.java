package towerDefenceGame.game;

import towerDefenceGame.Player;
import towerDefenceGame.enemies.Enemy;
import towerDefenceGame.gui.Map;
import towerDefenceGame.io.FileIO;
import towerDefenceGame.towers.BasicTower;
import towerDefenceGame.towers.RookieTower;
import towerDefenceGame.towers.SuperTower;
import towerDefenceGame.towers.Tower;

import java.util.ArrayList;
import java.util.Scanner;

public class GUIBasedGame implements GameType{
    Scanner scan = new Scanner(System.in);
    ArrayList<Tower> towers;
    ArrayList<ArrayList<Enemy>> waves;
    FileIO fileIO = new FileIO();
    private int currentWave = 0;
    private boolean hasLost = false;
    private int startingCoins = 200;
    private int coinsPerWave = 100;
    private Player player;
    private int nextTowerPosX=1;
    private int nextTowerPosY=5;
    private int nextEnemyPosX=2;
    private int nextEnemyPosY=2;
    String arrow = "\u2192";
    Map gameScreen;

    public GUIBasedGame(Player player){
        gameScreen  = new Map();
        this.player = player;
        player.setCoins(startingCoins);
        towers = new ArrayList<>();
        waves = fileIO.readWaveData();
        while (hasLost != true && waves.size()!=currentWave) {
            for(int i=0;i<waves.get(currentWave).size();i++){
                placeEnemy(waves.get(currentWave).get(i));
            }
            menuSelect();
        }
        if(waves.size()==currentWave){
            System.out.println("CONGRATZ MY DUDE! You won the game :D Good job!!!!");
        }
        player.setScore(currentWave * 69420);
        System.out.println(player.getName() + " your score is: " + player.getScore());
    }

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
                    doWave();
                break;
            case "c":
                System.out.println("#### GAME OVER! ####\n");
                hasLost = true;
                break;
        }
    }


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
        System.out.println("#### GAME OVER! ####\n");
    }

    public void reloadAllTowers() {
        for (Tower t : towers) {
            t.reload();
        }
    }

    public void buyTower() {
//strings
        String text = "You do not have the coins to buy this tower\n";

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
                    placeTower(tmpTower);
                } else {
                    System.out.println(text);
                }
                break;

            case "2":
                tmpTower = new RookieTower();
                if (player.getCoins() >= tmpTower.getCost()) {
                    towers.add(tmpTower);
                    player.addCoin(-tmpTower.getCost());
                    placeTower(tmpTower);
                } else {
                    System.out.println(text);
                }
                break;

            case "3":
                tmpTower = new SuperTower();
                if (player.getCoins() >= tmpTower.getCost()) {
                    towers.add(tmpTower);
                    player.addCoin(-tmpTower.getCost());
                    placeTower(tmpTower);
                } else {
                    System.out.println(text);
                }
                break;
        }
    }

    public void placeTower(Tower t){
        gameScreen.addIconToPanel(t.getIcon(),nextTowerPosX,nextTowerPosY);
        if(nextTowerPosX  == 11){
            nextTowerPosX = 0;
            nextTowerPosY++;
        }else if(nextTowerPosX == 10){
            nextTowerPosX =1;
            nextTowerPosY++;
        }else{
            nextTowerPosX+=2;
        }
    }

    public void placeEnemy(Enemy e){
        gameScreen.removeIconFromPanel(nextEnemyPosX,nextEnemyPosY);
        gameScreen.addIconToPanel(e.getIcon(),nextEnemyPosX,nextEnemyPosY);
        if(nextEnemyPosY == 2){
            if(nextEnemyPosX==9){
                nextEnemyPosY--;
                nextEnemyPosX = 0;
            }else {
                nextEnemyPosX++;
            }
        }else if (nextEnemyPosY==1){
            if(nextEnemyPosX==10){
                nextEnemyPosY--;
                nextEnemyPosX=1;
            }else {
                nextEnemyPosX+=2;
            }
        }else if (nextEnemyPosY==0){
            if(nextEnemyPosX==11){
                nextEnemyPosY=2;
                nextEnemyPosX=2;
            }else {
                nextEnemyPosX+=2;
            }
        }
    }
}
