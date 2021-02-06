package com.modele;

import com.pics.Sons;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Plateau {
    private Bloc[][] plateau;
    private int largeur,hauteur;
    private Niveau niveau;
    private int compteurDeChats;

    public Plateau(int l, int h, Niveau n){
        plateau = new Bloc[l][h];
        largeur=l;
        hauteur=h;
        niveau = n;
        compteurDeChats=0;
    }
    public boolean horsLimite(int x, int y) {
        return x < 0 || x >= largeur || y < 0 || y >= hauteur;
    }

    public Bloc getBloc(int x, int y) {
        return plateau[x][y];
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getNiveau(){
        return niveau.getNiveauActuel();
    }

    public boolean estVide(int x, int y) {
        return (plateau[x][y] == null);
    }

    public void creerBlocVide(int x, int y) {
        plateau[x][y] = new BlocVide();
    
    }


    public void testGroupeVide(int x, int y) {
       
        if (plateau[x][y].getType() != 'c')
        return;
        BlocCouleur blocClique = (BlocCouleur) plateau[x][y];
        int compteur = 1;

        if (supprime(x + 1, y, blocClique))
            compteur++;
        if (supprime(x - 1, y, blocClique))
            compteur++;
        if (supprime(x, y + 1, blocClique))
            compteur++;
        if (supprime(x, y - 1, blocClique))
            compteur++;

        if (compteur < 2)
            return;
        
        videGroupe(x, y);
        rearrangement();
        
    }

    private void videGroupe(int x, int y) {

        BlocCouleur blocClique = null;
        try {
            blocClique = (BlocCouleur) plateau[x][y].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        creerBlocVide(x, y);

        if (supprime(x + 1, y, blocClique))
            videGroupe(x + 1, y);

        if (supprime(x - 1, y, blocClique))
            videGroupe(x - 1, y);

        if (supprime(x, y + 1, blocClique))
            videGroupe(x, y + 1);

        if (supprime(x, y - 1, blocClique))
            videGroupe(x, y - 1);
    }



    private boolean supprime(int x, int y) {
        if (plateau[x][y].getType() != 'c')
            return false;
        BlocCouleur blocClique = (BlocCouleur) plateau[x][y];
        int compteur = 1;

        if (supprime(x + 1, y, blocClique))
            compteur++;
        if (supprime(x - 1, y, blocClique))
            compteur++;
        if (supprime(x, y + 1, blocClique))
            compteur++;
        if (supprime(x, y - 1, blocClique))
            compteur++;

        if (compteur < 2)
            return false;
        return true;
    }
    private boolean supprime(int x, int y, BlocCouleur blocClique) {
        if (!horsLimite(x, y) && plateau[x][y].getType() == 'c') {
            BlocCouleur bloc = (BlocCouleur) plateau[x][y];
            return (bloc.getColor() == blocClique.getColor());
        }
        return false;
    }
    

    public void rearrangement() {
        vertical();
		horizontal();
    }

    public void vertical() {
		for (int j = 0; j < largeur; j++) {
			for (int i = hauteur - 1; i >= 0; i--) {
				int index = i;
				while (!horsLimite(index, j) && plateau[index][j].getType() == 'x') {
					index--;
				}
				if (!horsLimite(index, j) && index != i)
					if (plateau[index][j].getType() == 'a'|| plateau[index][j].getType() == 'c') {
						plateau[i][j] = plateau[index][j];
                        plateau[index][j] = new BlocVide();
					}
			}
		}
		while (attrapeBob()) {
			bobSecouru();
			rearrangement();
		}
    }
    public void horizontal() {
		boolean doitBouger, bouge = false;

        for (int j = 1; j < largeur; j++) {
            doitBouger = false;
            for (int i = hauteur-1; i >= 0; i--) {
                while ((plateau[i][j] instanceof BlocObstacle)
                        && (plateau[i][j - 1] instanceof BlocVide || plateau[i][j - 1] instanceof BlocObstacle)) {
                    i--;
                    doitBouger = true;
                }
                if (i == hauteur - 1 && plateau[i][j - 1] instanceof BlocVide)
                    doitBouger = true;
                if (doitBouger && (plateau[i][j] instanceof BlocAnimal || plateau[i][j] instanceof BlocCouleur)) {
                    if (plateau[i][j - 1] instanceof BlocVide) {
                        plateau[i][j - 1] = plateau[i][j];
                        plateau[i][j] = new BlocVide();
                        bouge=true;
                        
                    } else
                    doitBouger = false;
                }
            }
            vertical();
            if (bouge  && j > 1) {
                j -= 2;
                bouge = false;
            }
        }
    }
    
    
    public boolean attrapeBob() {
		for (int i = 0; i < getLargeur(); i++) {
			if (plateau[getHauteur() - 1][i] instanceof BlocAnimal) {
				return true;
			}
		}
		return false;
	}

    public void bobSecouru() {
        for (int i = 0; i < getLargeur(); i++) {
            if (plateau[getHauteur() - 1][i] instanceof BlocAnimal) {
                creerBlocVide(getHauteur() - 1, i);
                compteurDeChats++;
            }
        }
    }

    public void affichePlateau() {
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                if (plateau[i][j].getType() == 'x')
                    System.out.print("n ");
                else if(plateau[i][j].getType() == 'c') {
                    BlocCouleur blocCouleur = (BlocCouleur) plateau[i][j];
                    System.out.print(blocCouleur.getColor().toString().charAt(0) + " ");
                }else if(plateau[i][j].getType() == 'a'){
                    System.out.print("b"); //b pour bob
                }
            }
            System.out.println();
        }
    }

    public boolean resultatVictoire() {
        return compteurDeChats >= niveau.getNbrDeChats();
    }

    public boolean resultatDefaite() {
        for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if (supprime(i, j))
					return false;
			}
		}
		return true;
    }

    public Bloc[][] getPlateau() {
        return plateau;
    }


    
}
