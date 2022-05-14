package towerDefenceGame.gui;

//JFrame -
//JPanel - a GUI component that functions as a container to draw other components like buttons etc.
//JLabel -

import javax.swing.*; //JFrame, JPanel, JLabel etc.
import java.awt.*;

public class GameScreen extends JFrame {
    int x, y, w, h;
    //private Dimension size;

    //CONSTRUCTOR
    public GameScreen() {
        x = 0;
        y = 0;
        w = 100;
        h = 100;
    }

    //method to make the game screen
    public void makeGameScreen() {
        //Icons

        //Labels
        JLabel helloLabel = new JLabel();
        helloLabel.setText("Hello You");

        JLabel byeLabel = new JLabel();
        byeLabel.setText("Bye Bye!");

        //Tiles
        JPanel greyPanel = new JPanel();
        greyPanel.setBackground(Color.darkGray);
        greyPanel.setBounds(x, y, w, h);

        JPanel pinkPanel = new JPanel();
        pinkPanel.setBackground(Color.pink);
        pinkPanel.setBounds(x+100, y, w, h);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(x+200, y, w, h);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(x, y+100, w, h);

        //Window
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setSize(w*10, h*10);
        frame.setVisible(true);

        //add labels to panels
        pinkPanel.add(helloLabel);
        greenPanel.add(byeLabel);

        //add tiles to frame/window
        frame.add(greyPanel);
        frame.add(pinkPanel);
        frame.add(greenPanel);
        frame.add(redPanel);
    }



    /*
    //method to set a constant size of the component
    private Dimension setFrameSize(Dimension size) {
        this.size = new Dimension(1000, 1000);
        setMinimumSize(this.size);
        setPreferredSize(this.size);
        setMaximumSize(this.size);
        return size;
    }

    //method to paint on a JFrame
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
     */
}
