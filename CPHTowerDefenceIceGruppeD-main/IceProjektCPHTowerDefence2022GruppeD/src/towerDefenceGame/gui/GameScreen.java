package towerDefenceGame.gui;

import javax.swing.*;

public class GameScreen {

    // PRIMITIVE DATA FIELDS
    private int width = 12;
    private int height = 8;

    // OBJECTS OF CLASSES
    private JFrame frame;
    private JPanel panels[][];
    private JPanel bgPanel;

    // CONSTRUCTOR
    public GameScreen() {
        makeFrame();
        makeBG();

        // Creates a 2D int array where every value is a JPanel on the JFrame
        panels = new JPanel[width][height];
        makePanels();
        addPanelToFrame();
        frame.setVisible(true);
    }

    // Method to make a JFrame that functions as the game window
    private void makeFrame(){
        frame = new JFrame(" >> DEFENDER MINIGAME << ");
        frame.setSize(1080,720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    // Method to make JPanels to place as grid on the game window
    private void makePanels(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                JPanel panel = new JPanel();
                panel.setBounds(i * 90, j * 90,90,90);
                panels[i][j] = panel;
            }
        }
    }

    // Method to add the created JPanels to the JFrame
    private void addPanelToFrame(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                frame.add(panels[i][j]);
            }
        }
    }

    // Method to save icons in the panels double array
    public void addIconToPanel(ImageIcon icon, int posX, int posY){
        JLabel label = new JLabel(icon);
        panels[posX][posY].add(label);
        frame.setVisible(true);
    }

    // Method to remove all icons from the panel
    public void removeIconFromPanel(int posX, int posY){
        panels[posX][posY].removeAll();
        frame.setVisible(true);
    }

    // Method to make the background image for the game window
    private void makeBG(){
        bgPanel = new JPanel();
        ImageIcon icon = new ImageIcon("CPHTowerDefenceIceGruppeD-main/IceProjektCPHTowerDefence2022GruppeD/src/res/backgroundImage.png");
        JLabel label = new JLabel(icon);
        bgPanel.setBounds(0,0,1080,720);
        bgPanel.add(label);
        frame.add(bgPanel);
    }
}