package com.modele;

import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;

public class Joueur{
    private String nom;
    private int score,argent;
    private ImageIcon profilePic;

    public Joueur(String n) {
        nom=n;
        score=0;
        argent=15;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score){
        this.score+=score;
    }

    public void setArgent(int a){
        this.argent-=a;
    }
    public int getArgent() {
        return argent;
    }

    public String getNom() {
        return nom;
    }
    public ImageIcon getImage(){
        if (profilePic == null) {
            try {
                Random rand = new Random();
                int randomNum = rand.nextInt(10) + 1;
                Image tmp = ImageIO.read(new File("src/com/profiles/"+"image"+randomNum+".png"));
                tmp = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                profilePic = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return profilePic;
    }


}