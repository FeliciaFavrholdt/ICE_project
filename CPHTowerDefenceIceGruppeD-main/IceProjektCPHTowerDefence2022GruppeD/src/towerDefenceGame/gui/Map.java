package towerDefenceGame.gui;

import towerDefenceGame.enemies.BasicEnemy;
import towerDefenceGame.enemies.Enemy;
import towerDefenceGame.enemies.EpicEnemy;
import towerDefenceGame.enemies.LegendaryEnemy;
import towerDefenceGame.towers.BasicTower;
import towerDefenceGame.towers.Tower;

import javax.swing.*;
import java.awt.*;

public class Map {
    private int width = 12;
    private int height = 8;
    private JFrame frame;
    private JPanel panels[][];
    private JPanel bgPanel;

    public Map() {
        makeFrame();
        makeBG();
        panels = new JPanel[width][height]; // double array
        makePanels();
        addPanelToFrame();
        frame.setVisible(true);
    }

    private void makeFrame(){
        frame = new JFrame("Game");
        frame.setSize(1080,720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void makePanels(){
        for(int i =0;i<width;i++){
            for(int j=0;j<height;j++){
                JPanel panel = new JPanel();
                panel.setBounds(i*90,j*90,90,90);
                panels[i][j] = panel;
            }
        }
    }

    private void addPanelToFrame(){
        for(int i =0;i<width;i++){
            for(int j=0;j<height;j++){
                frame.add(panels[i][j]);
            }
        }
    }

    public void addIconToPanel(ImageIcon icon,int posX, int posY){
        JLabel label = new JLabel(icon);
        panels[posX][posY].add(label);
        frame.setVisible(true);
    }

    public void removeIconFromPanel(int PosX,int PosY){
        panels[PosX][PosY].removeAll();
        frame.setVisible(true);
    }

    private void makeBG(){
        bgPanel = new JPanel();
        ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/BAGGRUND.png");
        JLabel label = new JLabel(icon);
        bgPanel.setBounds(0,0,1080,720);
        bgPanel.add(label);
        frame.add(bgPanel);
    }

}
