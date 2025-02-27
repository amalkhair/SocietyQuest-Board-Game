package nl.amalin.fontys.game;

import javax.swing.*;
import java.awt.*;

public class SocietyQuest extends JPanel {
    int boardWidth = 20 * 32; // board width = 320
    int boardHeight = 21 * 32; // board height = 672
    private final int gridLines = 5;  // Define fixed number of grid lines
    private Image backgroundImage;
    private Rectangle rect;

    // Constructor
    SocietyQuest() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        backgroundImage = new ImageIcon("src/main/resources/waterCartoon.jpeg").getImage().getScaledInstance(boardWidth, boardHeight, Image.SCALE_SMOOTH);
//        rect = new Rectangle(50, 50, 100, 100); // x, y, width, height
    }

    // responsible for all the drawing
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