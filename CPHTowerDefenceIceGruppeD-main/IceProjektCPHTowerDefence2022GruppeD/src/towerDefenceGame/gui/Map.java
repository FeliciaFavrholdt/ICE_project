package towerDefenceGame.gui;

import towerDefenceGame.enemies.BasicEnemy;
import towerDefenceGame.enemies.Enemy;

import javax.swing.*;
import java.awt.*;

public class Map {
    Enemy test = new BasicEnemy(1);
    int width = 12;
    int height = 8;
    JFrame frame;
    JPanel panels[][];
    public Map() {
        makeFrame();
        panels = new JPanel[width][height]; // double array
        makePanels();
        addPanelToFrame();
        addIconToPanel(test,4,6);
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
                panel.setBackground(Color.CYAN);
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

    public void addIconToPanel(Enemy enemy,int posX, int posY){
        ImageIcon icon = enemy.getIcon();
        JLabel label = new JLabel(icon);
        panels[posX][posY].add(label);
    }

}
