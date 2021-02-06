package com.pics;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {

    private static Image imagePrincipale;
    private static Image imageJaune, imageRouge, imageBleue, imageRose, imageVerte, imageOrange;
    private static Image imageBob;
    private static Image imageObstacle;
    
    public static Image getImagePrincipale() {
        if (imagePrincipale == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/sponge2.png"));
                imagePrincipale = tmp.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imagePrincipale;
    }

    public static Image getImageRouge() {
        if (imageRouge == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/red.png"));
                imageRouge = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageRouge;
    }

    public static Image getImageBleue() {
        if (imageBleue == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/blue.png"));
                imageBleue = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageBleue;
    }

    public static Image getImageJaune() {
        if (imageJaune == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/yellow.png"));
                imageJaune = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageJaune;
    }

    public static Image getImageRose() {
        if (imageRose == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/pink.png"));
                imageRose = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageRose;
    }

    public static Image getImageVerte() {
        if (imageVerte == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/green.png"));
                imageVerte = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageVerte;
    }

    public static Image getImageOrange() {
        if (imageOrange == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/orange.png"));
                imageOrange = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageOrange;
    }

    public static Image getObstacleImage() {
        if (imageObstacle == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/obstacle.jpg"));
                imageObstacle = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageObstacle;
    }

    public static Image getBobImage() {
        if (imageBob == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("src/com/imgEXT/bob.png"));
                imageBob = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageBob;
    }
    
}
