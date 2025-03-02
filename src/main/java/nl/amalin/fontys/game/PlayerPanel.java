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

public class PlayerPanel extends JPanel {
    private BufferedImage fishPlayer;
    private String score = "0";
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("player1.png");
    private String imageLocation = "src/main/resources/player1.png";

    // Constructor
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

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
        updateImage();
        repaint();
    }

    public String getImageLocation() {
        return imageLocation;
    }

    private void updateImage() {
        try {
            fishPlayer = ImageIO.read(new File(getImageLocation()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}