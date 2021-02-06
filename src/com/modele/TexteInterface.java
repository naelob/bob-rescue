package com.modele;

import java.util.Random;
import java.util.Scanner;

public class TexteInterface {
    private Niveau niv;
    private Joueur joueur;
    private Plateau plateau;


    public TexteInterface(boolean b) {
        System.out.println("BIENVENUE DANS LE JEU BOB RESCUE !");
        Scanner clavier = new Scanner(System.in);
        if(b){
            updatePrenomNiveauRobot(clavier);
            lanceJeuRobot(clavier);
            clavier.close();
        }else{
            updatePrenomNiveauJoueur(clavier);
            lanceJeu(clavier);
            clavier.close();
        }   
    }

    public void updatePrenomNiveauJoueur(Scanner sc){
        
        System.out.println("Quel est ton nom de joueur ?");
        String nom = sc.nextLine();
        joueur = new Joueur(nom);
        System.out.println("Quel est ton niveau ?");
        int niveau = sc.nextInt();
        setNiveau(niveau);
        
    }

    public void updatePrenomNiveauRobot(Scanner sc){
        System.out.println("Quel est ton nom de joueur ?");

        String [] prenoms = {"Bob","Patrick","SquidWard","Plankton","Sandy Cheeks","Mr Krabs","Karen"};
        int rnd = new Random().nextInt(prenoms.length);
        String nom = prenoms[rnd];
        System.out.println("Super ! Je m'appelle "+nom+ " !");
        joueur = new Joueur(nom);

        System.out.println("VEUILLEZ CHOISIR VOTRE NIVEAU (1-10) :");
        setNiveau(1);

     
    }

    public void lanceJeu(Scanner sc){
        while(!(plateau.resultatVictoire() ||plateau.resultatDefaite()) ) {
            plateau.affichePlateau();
            
            
            System.out.println("Veuillez indiquer la coordonée i du bloc sur laquelle vous voulez cliquer :");
            int i = sc.nextInt();
            System.out.println("Veuillez indiquer la coordonée j du bloc sur laquelle vous voulez cliquer :");
            int j= sc.nextInt();

            plateau.testGroupeVide(i, j);  
        }
        if(plateau.resultatVictoire()) {
            updateScore();
            System.out.println("Bien Joué! Voulez vous continuer la partie ? (oui/non)");
           
            String str = sc.nextLine();
            if(str.equals("oui")) {
                setNiveau(niv.getNiveauActuel()+1);
                lanceJeu(sc);
            }else{
                System.out.println("Bravo " + joueur.getNom() + "! Tu as fini la partie en gagnant " + joueur.getScore()+ " points !");
            }
        }else{
            System.out.println("Bravo " + joueur.getNom() + "! Tu as fini la partie en gagnant " + joueur.getScore()+ " points !");
        }
        
    }
    public void lanceJeuRobot(Scanner sc){
        while(!(plateau.resultatVictoire() ||plateau.resultatDefaite()) ) {
            niv.getPlateau().affichePlateau();
            

            System.out.println("Veuillez indiquer la coordonée i du bloc sur laquelle vous voulez cliquer :");
            int i = new Random().nextInt(plateau.getLargeur());
            System.out.println("Pour i, j'ai choisi la coordonnée "+i);
            
            System.out.println("Veuillez indiquer la coordonée j du bloc sur laquelle vous voulez cliquer :");
            int j= new Random().nextInt(plateau.getHauteur());
            System.out.println("Pour j, j'ai choisi la coordonnée "+j);
            

            

            while (plateau.getPlateau()[i][j].getType() == 'x') {
                i = new Random().nextInt(plateau.getLargeur());
                j = new Random().nextInt(plateau.getHauteur());
            }
            if (plateau.getPlateau()[i][j].getType() == 'c') {
                plateau.testGroupeVide(i, j);
            }

            
        }
        if(plateau.resultatVictoire()) {
            updateScore();
            System.out.println("Bien Joué! Voulez vous continuer la partie ? (0:oui/1:non)");
            int a = 0;
            int b=1;
            int c = new Random().nextBoolean() ? a : b;
            switch(c) {
                case 0:
                    System.out.println("J'ai choisi de continuer!");
                    setNiveau(niv.getNiveauActuel()+1);
                    lanceJeuRobot(sc);
                break;

                case 1:
                    System.out.println("Bravo" + joueur.getNom() + "! Tu as fini la partie en gagnant " + joueur.getScore()+ "points !");
                break;
            }
        }else{
            System.out.println("Bravo" + joueur.getNom() + "! Tu as fini la partie en gagnant " + joueur.getScore()+ "points !");
        }
        
    }
    public void updateScore(){
            switch(niv.getNiveauActuel()) {
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
    
    public Plateau getPlateau(){
        return niv.getPlateau();
    }
    public int getNiveau(){
        return niv.getNiveauActuel();
    }

    public void setNiveau(int optionValue) {
         niv = new Niveau(optionValue);
         plateau = niv.getPlateau();
        
    }

}
