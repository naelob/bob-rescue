package com.vue;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;

import com.pics.Sons;

public class Vue extends JFrame {
    private PanneauGeneral panneauGeneral;
    public static boolean quitter=false;


	public Vue() {
        setTitle("BOB RESCUE GAME");
        /*System.out.println(Images.getImagePrincipale().getWidth());
        System.out.println(Images.getImagePrincipale().getHeight());*/
        setSize(1320,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panneauGeneral = new PanneauGeneral(new Dimension(1320,1080));
        this.getContentPane().add(panneauGeneral);
        setVisible(true);
        pack();
        
        try {
            Sons.joueMusique();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        Vue v= new Vue();
    }

    
    
}
