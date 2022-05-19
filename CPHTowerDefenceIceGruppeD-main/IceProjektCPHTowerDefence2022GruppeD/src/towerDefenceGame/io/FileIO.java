package towerDefenceGame.io;

import towerDefenceGame.enemies.BasicEnemy;
import towerDefenceGame.enemies.Enemy;
import towerDefenceGame.enemies.EpicEnemy;
import towerDefenceGame.enemies.LegendaryEnemy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<ArrayList<Enemy>> readWaveData() {

        ArrayList<ArrayList<Enemy>> waves =new ArrayList<>();
        //File file = new File("C:\\Users\\jcall\\Documents\\GitHub\\ICE_project\\CPHTowerDefenceIceGruppeD-main\\IceProjektCPHTowerDefence2022GruppeD\\src\\waveData.txt");
        File file = new File("/Users/fillefilejs_m1/Desktop/Github/ICE_project/CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/resources/waveData.txt");
        //File file = new File("C:\\Users\\Helen\\OneDrive\\Dokumenter\\GitHub\\ICE_project\\CPHTowerDefenceIceGruppeD-main\\IceProjektCPHTowerDefence2022GruppeD\\resources\\waveData.txt");
        ArrayList<String> waveData = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                waveData.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            waveData = null;
        }

        String[] currentWaveData;
        for(int i = 0; i < waveData.size(); i++)
        {
            currentWaveData = waveData.get(i).split(",");
            ArrayList<Enemy> enemies = new ArrayList<>();
            for(int j = 0; j  < currentWaveData.length; j++) {
                switch (Integer.parseInt(currentWaveData[j])){
                    case 1:
                        Enemy basicEnemy = new BasicEnemy(100);
                        enemies.add(basicEnemy);
                        break;
                    case 2:
                        Enemy epicEnemy = new EpicEnemy(200);
                        enemies.add(epicEnemy);

                        break;
                    case 3:
                        Enemy legendaryEnemy = new LegendaryEnemy(400);
                        enemies.add(legendaryEnemy);

                        break;
                    default:
                        Enemy defaultEnemy = new BasicEnemy(1000);
                        System.out.println("an terrible monster has been unleashed");
                        enemies.add(defaultEnemy);


                }
            }
            waves.add(enemies);
        }
        return waves;
    }
}