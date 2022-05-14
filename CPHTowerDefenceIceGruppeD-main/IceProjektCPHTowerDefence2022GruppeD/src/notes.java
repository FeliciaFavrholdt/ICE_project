public class notes {


        //    public void paintComponent(Graphics g) {
        //
        // g.drawImage(sprites.get(8), 0, 0, null); //'observer' is used to check status when drawing over image when networking - set to 'null' as we are not using it.

        /*
        BufferedImage subImg = img.getSubimage(32 * 9, 32, 32, 32); //gets a part of the image
        g.drawImage(subImg, 0, 0, null);
        */

        //sets the colour of the rectangle
        //g.setColor(Color.MAGENTA);

        //draw a rectangle (x, y, width, height in pixels)
        //g.drawRect(50, 50, 100, 100);

        //fill a rectangle (x, y, width, height in pixels)
        //g.fillRect(0, 0, 32, 32)

        //makes a new color from r, g, b (0-255)
        //g.setColor(new Color(129, 50, 208));

        /*loop to make grid of rectangles on a x-axis
        for (int x = 0; x < 20; x++) { //20 tiles, adds a tile for every loop
            g.setColor(getRandomColor());
            g.fillRect(x * 32, 0, 32, 32);
        }

        //loop to make grid of rectangles on a x-axis
        for (int y = 0; y < 20; y++) { //20 tiles, adds a tile for every loop
            g.setColor(getRandomColor());
            g.fillRect(0, y * 32, 32, 32);
        }


        //nested loop to make a grid of rectangles with random colours (20x20)
        for (int y = 0; y < 20; y++) { //20 tiles, adds a tile for every loop
            for (int x = 0; x < 20; x++) { //20 tiles, adds a tile for every loop
                g.setColor(getRandomColor());
                g.fillRect(x * 32, y * 32, 32, 32);
            }
        }


         //method to call FPS
    private void callFPS() {
        frames++;
        //every time a second has passed it will print out the FPS and then reset it
        if (System.currentTimeMillis() - lastTime >= 1000) { //checking if its more or equal to 1 second
            System.out.println("FPS: "+ frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
        }
    }

            repaint(); //tells the window to repaint itself, called by or when GUI is resized manually (window)


        //setSize(640, 640); //sets the width and height (32x20 = 640 - used for grid)



    /* importImg(); //import here because of threading
            gameScreen = new GameScreen(img); //initialize GameScreen


    import java.util.Random; //creates pseudo-random numbers with math and the internal clock - true randomness does not exist.

 private void loadSprites() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }


    //method to do all the rendering / painting
    //when window is moves we use the repaint(); function
    public void paintComponent(Graphics g) {
        //calls the superclass JPanel to do all the graphic calculation and drawing that we don't need to mess with such as background and making sure there is nothing leftover from the previous frame
        super.paintComponent(g);

        //nested loop to make a grid of rectangles with random sprites (20x20)
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                g.drawImage(sprites.get(getRandomInt()), x * 32, y * 32, null);
            }
        }
    }

    //method to get a random int
    private int getRandomInt() {
        return random.nextInt(100);
    }

    //method to generate and return a random colour
    private Color getRandomColor() {
        int r = random.nextInt(256); //red - upper limit = 256 therefore reaches from (0-255)
        int g = random.nextInt(256); //green
        int b = random.nextInt(256); //blue

        return new Color(r, g, b);
    }

import java.awt.image.BufferedImage; //extends Image - can manipulate specific pixels and and display images
import java.io.IOException;
import java.io.InputStream; //class that allows us to read a resource as a stream
import javax.imageio.ImageIO;
         */



	/*
	 * 1000/60 = x; if(Sys.currTime - lastFrame >= x) update else nothing
	 *
	 *
	 * if (System.nanoTime() - lastFrame >= timePerFrame) { lastFrame =
	 * System.nanoTime(); repaint(); } else { // nothing, we wait. }
	 * 		boolean test = SwingUtilities.isEventDispatchThread();
		System.out.println("test: " + test + " : " + Thread.currentThread().getName());
	 *
	 */
}