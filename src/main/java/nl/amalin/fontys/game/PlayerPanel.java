package nl.amalin.fontys.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * The PlayerPanel class represents the panel displaying the player's character and score.
 */
public class PlayerPanel extends JPanel {
    private BufferedImage fishPlayer;
    private String score = "0";
    private String imageLocation = "player1.png";

    // Constructor
    /**
     * The PlayerPanel class represents the panel displaying the player's character and score.
     */
    PlayerPanel() {
        updateImage();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
    }

    // responsible for all the drawing
    /**
     *
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering
        // draws fishPlayer
        g.drawImage(fishPlayer, 0, 0, 100, 100, this);

        // Set the font and color for the text
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.BLUE);

        // Draw the text at the specified position
        g.drawString(getScore(), 25, 75);
    }

    /**
     * Sets the player's score.
     *
     * @param score the new score to set
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * Gets the player's score.
     *
     * @return the current score
     */
    public String getScore() {
        return score;
    }

    /**
     * Sets the image location for the player's character and updates the image.
     *
     * @param imageLocation the new image location
     */
    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
        updateImage();
        repaint();
    }

    /**
     * Gets the image location for the player's character.
     *
     * @return the current image location
     */
    public String getImageLocation() {
        return imageLocation;
    }

    /**
     * Updates the image of the player's character based on the current image location.
     */
    private void updateImage() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(getImageLocation())) {
            if (is == null) {
                throw new IOException("Image file not found: " + getImageLocation());
            }
            fishPlayer = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}