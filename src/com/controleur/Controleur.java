package com.controleur;

import com.vue.Vue;

import java.util.Scanner;

import com.modele.TexteInterface;

public class Controleur {
 
	Vue vue;
	TexteInterface texteUI;
	
	public Controleur() {}
	public Controleur(boolean b, boolean robot) {
		if (b) {
			vue = new Vue();			
		} else {
			texteUI = new TexteInterface(robot);
		}
	}
	

	static void afficheAide() {
        System.out.println("Options disponibles:\n" + "-t ou -texte pour jouer en mode texte" + "\n"
                + "-g or -graphique pour jouer en mode graphique");
		System.exit(1);
	}

	public static void main(String[] args) {

		if (args.length == 0 || args[0].equals("-h")) afficheAide();
        if (args[0].equals("-t") || args[0].equals("-texte")){
			System.out.println("JEU EN MODE TEXTE");
			Controleur c = new Controleur(false,false);
		}else if (args[0].equals("-g") || args[0].equals("-graphique")){
			new Controleur(true,false);
			
        }else if(args[0].equals("-b") || args[0].equals("-bot")){
			System.out.println("JEU EN MODE BOT");
			Controleur c = new Controleur(false,true);
        }else{
			System.out.println("JEU EN MODE TEXTE");
			Controleur c = new Controleur(false,false);
		
		}
	}

}
