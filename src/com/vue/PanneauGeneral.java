package com.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.modele.Joueur;
import com.pics.Images;
import com.pics.Sons;

import java.awt.image.BufferedImage;
import java.io.File;



public class PanneauGeneral extends JPanel{

    private static final long serialVersionUID = 1L;
    private Dimension dim;
	public Image title;
	public Joueur joueur;
	
	
	
	//Call the menuPanel 
	public PanneauGeneral(Dimension d) {
		super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		dim = d;
		setBackground(Color.BLACK);
		JButton jb1 = new JButton("JOUER");
        JButton jb2 = new JButton("QUITTER");
		JButton jb3 = new JButton("REGLES DU JEU");
		add(jb1);
		add(jb2);
		add(jb3);


		jb1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {

				String nomJoueur = JOptionPane.showInputDialog(null, "Quel est ton nom de joueur ?");
				joueur = new Joueur(nomJoueur);

				String options[] = {"1","2","3","4","5","6","7","8","9","10"};
					int option = JOptionPane.showOptionDialog(null, "Quel niveau veux-tu choisir ?",
							"Niveaux", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				
				lancePartie(option);
				
				Sons.stopMusique();
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});

		jb2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});

		

		jb3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {

				String reglesDuJeu = "Bienvenue sur BOB RESCUE ! L’objectif est de ramener sain et sauf BOB.\n Pour y arriver, il faut cliquer sur les blocs de couleur. En cliquant sur un bloc, tous les blocs contigus de même couleur disparaissent.\n Une fois que tous les BOB sont en bas du plateau, alors la partie se termine.\n Pour chaque niveau des conditions spécifiques sont requises. Have fun !";
				JOptionPane.showMessageDialog(null, reglesDuJeu,"Règles du Jeu",JOptionPane.PLAIN_MESSAGE);
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
	
	}
	public void lancePartie(int o){
		switch(o){
			case 0: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 1,joueur));
					revalidate();
					repaint();
			break;
			case 1: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 2,joueur));
					revalidate();
					repaint();
			break;
			case 2: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 3,joueur));
					revalidate();
					repaint();
			break;
			case 3: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 4,joueur));
					revalidate();
					repaint();
			break;
			case 4: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 5,joueur));
					revalidate();
					repaint();
			break;
			case 5: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 6,joueur));
					revalidate();
					repaint();
			break;
			case 6: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 7,joueur));
					revalidate();
					repaint();
			break;
			case 7: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 8,joueur));
					revalidate();
					repaint();
			break;
			case 8: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 9,joueur));
					revalidate();
					repaint();
			break;
			case 9: 
					removeAll();
					revalidate();
					this.add(new PanneauDeJeu(dim, 10,joueur));
					revalidate();
					repaint();
			break;

		}
	}

	public final void close(){
		SwingUtilities.getWindowAncestor(this).dispose();;
	}
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.BLACK);
		g2.drawImage(Images.getImagePrincipale(), 0,0, this);
		
	}
	

}
