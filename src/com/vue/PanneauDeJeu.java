package com.vue;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


import com.modele.Plateau;
import com.modele.Niveau;
import com.modele.BlocCouleur;
import com.modele.Joueur;
import com.pics.Images;



public class PanneauDeJeu extends JPanel {

    private static final long serialVersionUID = 5510463459456770171L;
    private Dimension taille;
    private Plateau plateau;
    private int x, y;
    private static int startX, startY;
    private final static int LARGEUR_BLOC = 60;
    private Joueur joueur;
    


    public PanneauDeJeu(Dimension t, int niv, Joueur j) {
        super();
        taille = t;
        init();
        joueur = j;
        Niveau niveau = new Niveau(niv);
        plateau = niveau.getPlateau();
    }

    private void init() {
        this.setLayout(null);
        this.setSize(taille);
        this.setOpaque(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                x = (mouseEvent.getX() - startX) / LARGEUR_BLOC;
                y = (mouseEvent.getY() - startY) / LARGEUR_BLOC;
                plateau.testGroupeVide(y, x);
                repaint();
				revalidate();
				if (plateau.resultatVictoire()) {

                    initScore(plateau.getNiveau());

					String options[] = { "Niveau Suivant", "Recommencer", "Finir Ici " };
                    int option = JOptionPane.showOptionDialog(null, "Niveau Complété ! Que voulez vous faire ?","Niveau Complété", 0, 
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                    choixVictoire(option);
					repaint();
					revalidate();
				}
				if (plateau.resultatDefaite()) {
					String options[] = { "Recommencer", "Finir Ici " };
					int option = JOptionPane.showOptionDialog(null, "Vous avez perdu ! Que voulez vous faire ?",
							"Niveau Complété", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    
                    choixDefaite(option);
                    repaint();
                    revalidate();
                }
             
            }
				
            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });
    }


    public void initScore(int a){
        switch(a){
            case 1: 
                    joueur.setScore(2);
                    break;
            case 2: 
                    joueur.setScore(5);
                    break;
            case 3: 
                    joueur.setScore(7);
                    break;
            case 4: 
                    joueur.setScore(10);
                    break;
            case 5: 
                    joueur.setScore(15);
                    break;
            case 6: 
                    joueur.setScore(20);
                    break;
            case 7: 
                    joueur.setScore(25);
                    break;
            case 8: 
                    joueur.setScore(30);
                    break;
            case 9: 
                    joueur.setScore(45);
                    break;
            case 10: 
                    joueur.setScore(100);
                    break;
        }

    }
    public void choixVictoire(int o){
        switch(o){
            case 0: plateau = new Niveau(plateau.getNiveau() + 1).getPlateau();
                    break;
            case 1: plateau = new Niveau(plateau.getNiveau()).getPlateau();
                    break;
            case 2: new PanneauJoueur(joueur);
                    break;
        }
    }
    public void choixDefaite(int o){
        if (o == 0 && joueur.getArgent()>0) {
            joueur.setArgent(5);
            plateau = new Niveau(plateau.getNiveau()).getPlateau();
        }else if(o == 0 && joueur.getArgent()<=0){
            JOptionPane.showMessageDialog(null, "Vous n'avez plus d'argent pour recommencer le niveau. Veuillez quitter le jeu!","Règles du Jeu",
            JOptionPane.PLAIN_MESSAGE);
        }else{
            new PanneauJoueur(joueur);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Image redBox = Images.getImageRouge();
        Image blueBox = Images.getImageBleue();
        Image yellowBox = Images.getImageJaune();
        Image pinkBoxImage = Images.getImageRose();
        Image greenBoxImage = Images.getImageVerte();
        Image orangeBoxImage = Images.getImageOrange();
        Image bobImage = Images.getBobImage();
        startX = (taille.width - plateau.getHauteur() * LARGEUR_BLOC) / 2;
        startY = (taille.height - plateau.getLargeur() * LARGEUR_BLOC) / 2;
        g2.setColor(new Color(125, 125, 125, 150));
        g2.fillRoundRect(startX - 15, startY - 15, plateau.getHauteur() * LARGEUR_BLOC + 30, plateau.getLargeur() * LARGEUR_BLOC + 30, 100, 100);
        for (int j = 0; j < plateau.getHauteur();j++) {
            for (int i = 0; i < plateau.getLargeur(); i++) {
                if (plateau.getBloc(i, j) == null)
                    continue;
                if (plateau.getBloc(i, j).getType() == 'a') {
                    g2.drawImage(bobImage, startX + j * LARGEUR_BLOC, startY + i * LARGEUR_BLOC, null);
                }
                if (plateau.getBloc(i, j).getType() == 'c') {
                    BlocCouleur bloc = (BlocCouleur) plateau.getBloc(i, j);
                    if(bloc.getColor() == Color.RED) g2.drawImage(redBox, startX + j * LARGEUR_BLOC, startY + i * LARGEUR_BLOC, null);
                    if(bloc.getColor() == Color.BLUE) g2.drawImage(blueBox, startX + j * LARGEUR_BLOC, startY + i * LARGEUR_BLOC, null);
                    if(bloc.getColor() == Color.PINK) g2.drawImage(pinkBoxImage, startX + j * LARGEUR_BLOC, startY + i * LARGEUR_BLOC, null);
                    if(bloc.getColor() == Color.GREEN) g2.drawImage(greenBoxImage, startX + j * LARGEUR_BLOC, startY + i * LARGEUR_BLOC, null);
                    if(bloc.getColor() == Color.ORANGE) g2.drawImage(orangeBoxImage, startX + j * LARGEUR_BLOC, startY + i * LARGEUR_BLOC, null);
                    if(bloc.getColor() == Color.YELLOW) g2.drawImage(yellowBox, startX + j * LARGEUR_BLOC, startY + i * LARGEUR_BLOC, null);

                }
            }
        }
    }
    
    
}
