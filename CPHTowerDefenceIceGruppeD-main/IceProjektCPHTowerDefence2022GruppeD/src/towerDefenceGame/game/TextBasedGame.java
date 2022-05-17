package towerDefenceGame.game;

import towerDefenceGame.Player;
import towerDefenceGame.enemies.Enemy;
import towerDefenceGame.io.FileIO;
import towerDefenceGame.towers.Tower;
import towerDefenceGame.towers.basicTower;
import towerDefenceGame.towers.rookieTower;
import towerDefenceGame.towers.superTower;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TextBasedGame implements GameType{
    Scanner scan = new Scanner(System.in);
    ArrayList<Tower> towers;
    ArrayList<ArrayList<Enemy>> waves;
    FileIO fileIO = new FileIO();
    private int currentWave =0;
    private boolean hasLost = false;
    private int startingCoins = 200;
    private int coinsPerWave = 100;
    private Player player;

    public TextBasedGame(Player player){
        this.player = player;
        player.setCoins(startingCoins);
        towers = new ArrayList<>();
        waves = fileIO.readWaveData();
        while (hasLost!=true){
            menuSelect();
        }
        player.setScore(currentWave * 69420);
        System.out.println("Game over!\n" +
                player.getName() + " your score is: " + player.getScore());
    }

    private void menuSelect(){
        System.out.println("""
                            Press A to buy a new tower.
                            Press B to play next wave. 
                            Press C to end game. 
                            """);
        System.out.println("you have " + towers.size() + " towers");
        String input = scan.nextLine();
        switch (input.toLowerCase()){
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
    public void doWave(){
        reloadAllTowers();
        for (int i=0;i<towers.size();i++){
            while (!towers.get(i).ifOutOfAmmo()){
                towers.get(i).shootEnemy(waves.get(currentWave).get(0));
                System.out.println(waves.get(currentWave).get(0).getEnemyHealth());
                if(waves.get(currentWave).size() == 1 && waves.get(currentWave).get(0).getEnemyHealth() <= 0){ //hvis der ikke er nogen enemies tilbage så
                    currentWave++;
                    System.out.println("you compeleted wave: " + currentWave);
                    player.addCoin(coinsPerWave);
                    return;
                }
                if(waves.get(currentWave).get(0).getEnemyHealth() <= 0){
                    waves.get(currentWave).remove(0);
                }
            }
        }
        hasLost = true;
    }

    public void reloadAllTowers(){
        for (Tower t:towers) {
            t.reload();
        }
    }

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

    private void buyTower(){
            System.out.println("what tower?");
            Tower tmpTower;
            switch (scan.nextLine()){
                case "1":
                    tmpTower = new basicTower();
                    if(player.getCoins()>=tmpTower.getCost()){
                        towers.add(tmpTower);
                        player.addCoin(-tmpTower.getCost());
                    }else{
                        System.out.println("You do not have the coin to buy this tower");
                    }
                    break;
                case "2":
                    tmpTower = new rookieTower();
                    if(player.getCoins()>=tmpTower.getCost()){
                        towers.add(tmpTower);
                        player.addCoin(-tmpTower.getCost());
                    }else{
                        System.out.println("You do not have the coin to buy this tower");
                    }
                    break;
                case "3":
                    tmpTower = new superTower();
                    if(player.getCoins()>=tmpTower.getCost()){
                        towers.add(tmpTower);
                        player.addCoin(-tmpTower.getCost());
                    }else{
                        System.out.println("You do not have the coin to buy this tower");
                    }
                    break;
            }

    }
}
