package com.vue;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;


import com.modele.Joueur;

public class PanneauJoueur {
    private Joueur joueur;

    public PanneauJoueur(Joueur j){
        joueur=j;
        ImageIcon icon = joueur.getImage();
        JLabel label = new JLabel(icon);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(label);

        JPanel textPanel = new JPanel();
        String text = "Bravo "+ joueur.getNom()+"!"+" Tu as fini la partie en gagnant "+ joueur.getScore() + " points!";
        textPanel.add(new JLabel(text));
        
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(textPanel);
        panel2.add(panel, BorderLayout.EAST);
        JOptionPane.showMessageDialog(null, panel2, "BOB RESCUE GAME",JOptionPane.DEFAULT_OPTION);
    } 

}
