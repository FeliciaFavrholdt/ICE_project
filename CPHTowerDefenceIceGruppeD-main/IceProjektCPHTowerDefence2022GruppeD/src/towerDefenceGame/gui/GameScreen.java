package towerDefenceGame.gui;

//JFrame -
//JPanel - a GUI component that functions as a container to draw other components like buttons etc.
//JLabel -

import javax.swing.*; //JFrame, JPanel, JLabel etc.
import java.awt.*;
import java.io.BufferedWriter;
import java.io.Writer;

public class GameScreen {
    int x, y, w, h;
    JFrame frame;
    JPanel terminal;
    JTextField chatBox;
    JTextPane writeToUserField;

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
        makeJFrame();
        makeTerminal();
        frame.add(terminal);
        writeToUser("hejasdfgfdasafgfdssdf");
        writeToUser("hej");
    }

    private void makeJFrame(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void makeTerminal(){
        terminal = new JPanel();
        terminal.setBounds((int)(frame.getWidth()*0.8),0,200,frame.getHeight());
        chatBox = new JTextField("Write Here!");
        chatBox.setBounds(0,(int)(terminal.getHeight()*0.8),terminal.getWidth()-20,100);
        writeToUserField = new JTextPane();
        writeToUserField.setBounds(0,10,terminal.getWidth()-20,(int)(terminal.getHeight()*0.8)-10);
        writeToUserField.setEditable(true);

        terminal.add(writeToUserField);
        terminal.add(chatBox);
    }

    public void writeToUser(String string){
        String tmp = writeToUserField.getText();
        tmp = tmp + "\n" + string;
        writeToUserField.setText(tmp);
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
