package nl.amalin.fontys.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * The SocietyQuest class represents the main game board for the Society Quest Game.
 */
public class SocietyQuest extends JPanel {
    int boardWidth = 20 * 32; // board width = 320
    int boardHeight = 21 * 32; // board height = 672
    private final int gridLines = 5;  // Define fixed number of grid lines
    private Image backgroundImage;
    private Rectangle rect;

    // Constructor
    /**
     * Constructor for SocietyQuest.
     * Initializes the game board and loads the background image.
     */
    SocietyQuest() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("waterCartoon.jpeg")) {
            if (is == null) {
                throw new IOException("Image file not found: " + "waterCartoon.jpeg");
            }
            backgroundImage = new ImageIcon(ImageIO.read(is)).getImage().getScaledInstance(boardWidth, boardHeight, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        rect = new Rectangle(50, 50, 100, 100); // x, y, width, height
    }

    // responsible for all the drawing
    /**
     * Paints the component, including the background image and grid lines.
     *
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering

        // Draws the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this);
        }

        // Sets grid color
        g.setColor(Color.BLACK);

        // Calculates spacing for fixed grid lines
        int verticalSpacing = boardWidth / gridLines;
        int horizontalSpacing = boardHeight / gridLines;

        // Draws vertical lines
        for (int i = 0; i <= gridLines; i++) {
            g.drawLine(i * verticalSpacing, 0, i * verticalSpacing, boardHeight);
        }

        // Draws horizontal lines
        for (int i = 0; i <= gridLines; i++) {
            g.drawLine(0, i * horizontalSpacing, boardWidth, i * horizontalSpacing);
        }
    }
}