package com.modele;

import com.modele.Plateau;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Niveau {
    private static final long serialVersionUID = -6578584791683082932L;
	private Plateau plateau;
	private int nbrDeChats;
	private int niveauActuel;
	
	
	public Niveau(int l) {
		niveauActuel = l;
		lancePlateau();
	}
	
	public Niveau(Plateau p) {
		setPlateau(p);
	}
		
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau p) {
		plateau = p;
	}
	public void lancePlateau(){
		switch(niveauActuel){
			case 1: 
					organisation1();
					nbrDeChats = 2;
			break;
			case 2: 
					organisation2();
					nbrDeChats = 5;
			break;
			case 3: 
					organisation3();
					nbrDeChats = 3;
			break;
			case 4: 
					organisation4();
					nbrDeChats = 4;
			break;
			case 5: 
					organisation5();
					nbrDeChats = 2;
			break;
			case 6: 
					organisation6();
					nbrDeChats = 6;
			break;
			case 7: 
					organisation7();
					nbrDeChats = 2;
			break;
			case 8: 
					organisation8();
					nbrDeChats = 5;
			break;
			case 9: 
					organisation9();
					nbrDeChats = 3;
			break;
			case 10: 
					organisation10();
					nbrDeChats = 5;
			break;
		}
		remplirNulles();
	}
	public int getNbrDeChats() {
		return nbrDeChats;
	}

	public int getNiveauActuel() {
		return niveauActuel;
	}

	private void organisation1() {
		plateau = new Plateau(7, 7, this);

		plateau.getPlateau()[0][1] = new BlocAnimal();
		plateau.getPlateau()[0][5] = new BlocAnimal();

		plateau.getPlateau()[1][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][1] = new BlocCouleur(Color.PINK);

		for (int i = 2; i < 5; i++) {
			plateau.getPlateau()[1][i] = new BlocCouleur(Color.GREEN);
		}
		plateau.getPlateau()[1][5] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[2][5] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][6] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[2][6] = new BlocCouleur(Color.YELLOW);

		for (int i = 2; i < 5; i++)
			for (int j = 2; j < 5; j++)
				plateau.getPlateau()[i][j] = new BlocCouleur(Color.RED);

		plateau.getPlateau()[3][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[4][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[4][1] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[3][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[3][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[4][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[4][6] = new BlocCouleur(Color.BLUE);

		plateau.getPlateau()[5][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][0] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[5][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[5][2] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[6][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[6][2] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[5][3] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][3] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[5][4] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][4] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][5] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[5][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][6] = new BlocCouleur(Color.GREEN);

		

	}

	private void organisation2() {
		plateau = new Plateau(8, 5, this);
		plateau.getPlateau()[0][2] = new BlocAnimal();
		plateau.getPlateau()[1][2] = new BlocAnimal();
		plateau.getPlateau()[2][2] = new BlocAnimal();
		plateau.getPlateau()[1][0] = new BlocAnimal();
		plateau.getPlateau()[1][4] = new BlocAnimal();

		plateau.getPlateau()[0][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][1] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[0][3] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][3] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[2][0] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][0] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[2][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[3][1] = new BlocCouleur(Color.BLUE);

		plateau.getPlateau()[2][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[3][3] = new BlocCouleur(Color.BLUE);

		plateau.getPlateau()[2][4] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][4] = new BlocCouleur(Color.YELLOW);

		for (int i = 3; i < plateau.getHauteur(); i++)
			plateau.getPlateau()[i][2] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[4][0] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][0] = new BlocCouleur(Color.BLUE);

		plateau.getPlateau()[4][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][1] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[4][3] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][3] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[4][4] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][4] = new BlocCouleur(Color.BLUE);

		plateau.getPlateau()[6][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][0] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[6][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[7][1] = new BlocCouleur(Color.BLUE);

		plateau.getPlateau()[6][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[7][3] = new BlocCouleur(Color.BLUE);

		plateau.getPlateau()[6][4] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][4] = new BlocCouleur(Color.PINK);

		

	}

	private void organisation3() {
		plateau = new Plateau(9, 7, this);
	
		plateau.getPlateau()[0][2] = new BlocAnimal();
		plateau.getPlateau()[0][4] = new BlocAnimal();
		plateau.getPlateau()[0][6] = new BlocAnimal();

		plateau.getPlateau()[1][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][2] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[1][3] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[2][3] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[1][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][4] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[1][5] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[2][5] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[1][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][6] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[3][2] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[4][2] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[3][3] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[4][3] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[3][4] = new BlocObstacle();
		plateau.getPlateau()[4][4] = new BlocObstacle();

		plateau.getPlateau()[3][5] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[4][5] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[3][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][6] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[4][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[4][1] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[5][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][0] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[5][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][1] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[5][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][2] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[5][3] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][3] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[5][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][4] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[5][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][5] = new BlocCouleur(Color.PINK);

		plateau.getPlateau()[5][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][6] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[7][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[8][0] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[7][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[8][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[7][2] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[8][2] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[7][3] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[8][3] = new BlocCouleur(Color.GREEN);

		plateau.getPlateau()[7][4] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[8][4] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[7][5] = new BlocObstacle();
		plateau.getPlateau()[8][5] = new BlocObstacle();
		plateau.getPlateau()[7][6] = new BlocObstacle();
		plateau.getPlateau()[8][6] = new BlocObstacle();

	
	}

	private void organisation4() {
		plateau = new Plateau(8, 8, this);
	
		plateau.getPlateau()[0][7] = new BlocAnimal();
		plateau.getPlateau()[0][6] = new BlocAnimal();
		plateau.getPlateau()[0][5] = new BlocAnimal();
		plateau.getPlateau()[0][4] = new BlocAnimal();
		plateau.getPlateau()[1][7] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[2][7] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[4][5] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[5][5] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[3][5] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[2][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[3][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[5][0] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[7][0] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][1] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[7][1] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[5][2] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[4][2] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[7][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][0] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[4][0] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[1][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][3] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][5] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[2][5] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][7] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][6] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][4] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[4][6] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[4][4] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[4][3] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[4][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[5][3] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[5][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[5][0] = new BlocCouleur(Color.YELLOW);

		plateau.getPlateau()[7][7] = new BlocObstacle();
		plateau.getPlateau()[7][6] = new BlocObstacle();
		plateau.getPlateau()[7][5] = new BlocObstacle();
		plateau.getPlateau()[7][4] = new BlocObstacle();
		plateau.getPlateau()[6][7] = new BlocObstacle();
		plateau.getPlateau()[6][6] = new BlocObstacle();
		plateau.getPlateau()[6][5] = new BlocObstacle();
		plateau.getPlateau()[5][7] = new BlocObstacle();
		plateau.getPlateau()[5][6] = new BlocObstacle();
		plateau.getPlateau()[4][7] = new BlocObstacle();

	}

	private void organisation5() {
		plateau = new Plateau(8, 5, this);
		
		for (int j = 0; j < plateau.getLargeur(); j++) {
			for (int i = 0; i < plateau.getHauteur(); i++) {
				plateau.getPlateau()[i][j] = new BlocCouleur(Color.YELLOW);
			}
		}
		plateau.getPlateau()[0][1] = new BlocAnimal();
		plateau.getPlateau()[0][2] = new BlocAnimal();
		plateau.getPlateau()[1][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[2][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[0][0] = new BlocVide();
		plateau.getPlateau()[1][0] = new BlocVide();
		plateau.getPlateau()[2][0] = new BlocVide();
		plateau.getPlateau()[3][0] = new BlocVide();
		plateau.getPlateau()[0][3] = new BlocVide();
		plateau.getPlateau()[1][3] = new BlocVide();
		plateau.getPlateau()[2][3] = new BlocVide();
		plateau.getPlateau()[3][3] = new BlocVide();
		plateau.getPlateau()[0][4] = new BlocVide();
		plateau.getPlateau()[1][4] = new BlocVide();
		plateau.getPlateau()[2][4] = new BlocVide();
		plateau.getPlateau()[3][4] = new BlocVide();

	}

	private void organisation6() {
		plateau = new Plateau(9, 9, this);
		
		plateau.getPlateau()[0][7] = new BlocObstacle();
		plateau.getPlateau()[1][7] = new BlocObstacle();
		plateau.getPlateau()[2][7] = new BlocObstacle();
		plateau.getPlateau()[3][7] = new BlocObstacle();
		plateau.getPlateau()[3][7] = new BlocObstacle();
		plateau.getPlateau()[3][6] = new BlocObstacle();
		plateau.getPlateau()[3][5] = new BlocObstacle();
		plateau.getPlateau()[3][4] = new BlocObstacle();
		plateau.getPlateau()[3][3] = new BlocObstacle();
		plateau.getPlateau()[3][2] = new BlocObstacle();
		plateau.getPlateau()[3][1] = new BlocObstacle();
		plateau.getPlateau()[4][1] = new BlocObstacle();
		plateau.getPlateau()[4][3] = new BlocObstacle();
		plateau.getPlateau()[5][1] = new BlocObstacle();
		plateau.getPlateau()[5][3] = new BlocObstacle();
		plateau.getPlateau()[6][1] = new BlocObstacle();
		plateau.getPlateau()[6][3] = new BlocObstacle();
		plateau.getPlateau()[7][1] = new BlocObstacle();
		plateau.getPlateau()[7][3] = new BlocObstacle();
		plateau.getPlateau()[8][1] = new BlocObstacle();
		plateau.getPlateau()[8][3] = new BlocObstacle();
		plateau.getPlateau()[0][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[0][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][3] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][4] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[0][4] = new BlocAnimal();
		plateau.getPlateau()[1][3] = new BlocAnimal();
		plateau.getPlateau()[2][2] = new BlocAnimal();
		plateau.getPlateau()[2][6] = new BlocAnimal();
		plateau.getPlateau()[4][0] = new BlocAnimal();
		plateau.getPlateau()[6][0] = new BlocAnimal();
		plateau.getPlateau()[0][3] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[0][2] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[0][0] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][6] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[2][5] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][0] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[8][0] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[0][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][5] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][8] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[4][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][8] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][7] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[7][4] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[7][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[8][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[8][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[8][4] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[8][7] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[0][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[3][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[8][8] = new BlocCouleur(Color.PINK);

	}


	private void organisation7() {
		plateau = new Plateau(8, 7, this);
		
		plateau.getPlateau()[6][0] = new BlocAnimal();
		plateau.getPlateau()[6][6] = new BlocAnimal();
		plateau.getPlateau()[7][6] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[7][0] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[0][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[3][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[1][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[2][3] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[4][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][3] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[7][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[0][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][4] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[3][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][4] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[0][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[0][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][5] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][5] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[4][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[4][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][5] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][1] = new BlocCouleur(Color.GREEN);
	}

	private void organisation8() {
		
		plateau = new Plateau(9, 9, this);
		
		plateau.getPlateau()[0][8] = new BlocAnimal();
		plateau.getPlateau()[4][8] = new BlocAnimal();
		plateau.getPlateau()[2][2] = new BlocAnimal();
		plateau.getPlateau()[2][4] = new BlocAnimal();
		plateau.getPlateau()[2][6] = new BlocAnimal();
		plateau.getPlateau()[1][0] = new BlocObstacle();
		plateau.getPlateau()[1][8] = new BlocObstacle();
		plateau.getPlateau()[3][2] = new BlocObstacle();
		plateau.getPlateau()[3][3] = new BlocObstacle();
		plateau.getPlateau()[3][5] = new BlocObstacle();
		plateau.getPlateau()[3][6] = new BlocObstacle();
		plateau.getPlateau()[4][2] = new BlocObstacle();
		plateau.getPlateau()[4][3] = new BlocObstacle();
		plateau.getPlateau()[4][5] = new BlocObstacle();
		plateau.getPlateau()[4][6] = new BlocObstacle();
		plateau.getPlateau()[5][8] = new BlocObstacle();
		plateau.getPlateau()[6][8] = new BlocObstacle();
		plateau.getPlateau()[6][0] = new BlocObstacle();
		plateau.getPlateau()[7][8] = new BlocObstacle();
		plateau.getPlateau()[7][0] = new BlocObstacle();
		plateau.getPlateau()[8][8] = new BlocObstacle();
		plateau.getPlateau()[8][0] = new BlocObstacle();
		plateau.getPlateau()[4][4] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[0][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[0][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[0][7] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][3] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][7] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][7] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][1] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][8] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][0] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[8][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[8][7] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[1][4] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[1][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[2][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[2][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[4][7] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[7][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[7][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[7][2] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[8][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[8][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[8][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[0][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[0][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][3] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[3][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[3][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][0] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[4][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[5][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[6][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[7][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[8][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[8][2] = new BlocCouleur(Color.PINK);

	}



	private void organisation9() {
		
		plateau = new Plateau(7, 7, this);
	
		plateau.getPlateau()[0][3] = new BlocAnimal();
		plateau.getPlateau()[3][1] = new BlocAnimal();
		plateau.getPlateau()[3][5] = new BlocAnimal();
		plateau.getPlateau()[2][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[2][4] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[3][2] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[4][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[5][2] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[5][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][0] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][1] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][2] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][6] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[1][2] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[2][2] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[3][3] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[3][4] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[4][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[4][2] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[4][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][0] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][1] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[5][6] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][4] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[6][5] = new BlocCouleur(Color.BLUE);
		plateau.getPlateau()[1][3] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[4][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[5][5] = new BlocCouleur(Color.GREEN);

	}

	

	
	private void organisation10() {
	
		plateau = new Plateau(8, 9, this);

		plateau.getPlateau()[0][0] = new BlocObstacle();
		plateau.getPlateau()[0][8] = new BlocObstacle();
		plateau.getPlateau()[3][0] = new BlocObstacle();
		plateau.getPlateau()[3][8] = new BlocObstacle();
		plateau.getPlateau()[4][0] = new BlocObstacle();
		plateau.getPlateau()[4][8] = new BlocObstacle();
		plateau.getPlateau()[4][2] = new BlocObstacle();
		plateau.getPlateau()[4][1] = new BlocObstacle();
		plateau.getPlateau()[4][3] = new BlocObstacle();
		plateau.getPlateau()[4][4] = new BlocObstacle();
		plateau.getPlateau()[4][5] = new BlocObstacle();
		plateau.getPlateau()[4][6] = new BlocObstacle();
		plateau.getPlateau()[4][7] = new BlocObstacle();
		plateau.getPlateau()[5][1] = new BlocObstacle();
		plateau.getPlateau()[5][7] = new BlocObstacle();
		plateau.getPlateau()[6][1] = new BlocObstacle();
		plateau.getPlateau()[6][7] = new BlocObstacle();
		plateau.getPlateau()[7][1] = new BlocObstacle();
		plateau.getPlateau()[7][7] = new BlocObstacle();
		plateau.getPlateau()[5][6] = new BlocAnimal();
		plateau.getPlateau()[5][5] = new BlocAnimal();
		plateau.getPlateau()[5][4] = new BlocAnimal();
		plateau.getPlateau()[5][3] = new BlocAnimal();
		plateau.getPlateau()[5][2] = new BlocAnimal();
		plateau.getPlateau()[0][2] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[0][6] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][8] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][0] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][2] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][1] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][2] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[3][6] = new BlocCouleur(Color.YELLOW);
		plateau.getPlateau()[1][7] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[2][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[3][3] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][2] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][4] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[6][6] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][3] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[7][5] = new BlocCouleur(Color.GREEN);
		plateau.getPlateau()[0][1] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[0][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[0][4] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[0][5] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[1][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[1][4] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[2][4] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[2][0] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[2][7] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][3] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[6][5] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[7][2] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[7][4] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[7][6] = new BlocCouleur(Color.RED);
		plateau.getPlateau()[0][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][6] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[1][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][8] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][5] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][3] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][2] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[2][1] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[3][7] = new BlocCouleur(Color.PINK);
		plateau.getPlateau()[3][5] = new BlocCouleur(Color.PINK);

	}

	

	public void remplirNulles() {
		for (int i = 0; i < plateau.getLargeur(); i++) {
			for (int j = 0; j < plateau.getHauteur(); j++) {
				if (plateau.getPlateau()[i][j] == null) plateau.getPlateau()[i][j] = new BlocVide();
			}
		}
	}

    
	  
	  public static Niveau Deserialize2(String chemin) {
		  Niveau niveauDeserialise = null;
		  try (FileInputStream fis = new FileInputStream(chemin);
				  ObjectInputStream ois = new ObjectInputStream(fis)){
					niveauDeserialise = (Niveau) ois.readObject();
			  System.out.println("Le niveau " + chemin.charAt(5) + " a été déserialisé");
		  } catch (FileNotFoundException e) {
			  System.err.println("Le fichier : " + chemin + " n'a pas été trouvé.");
			  e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Le fichier : " + chemin + " ne peut pas être lu.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Erreur!");
			e.printStackTrace();
		}
		  return niveauDeserialise;
	  }
}
