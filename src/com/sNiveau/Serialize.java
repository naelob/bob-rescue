package com.sNiveau;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.modele.Niveau;
import com.modele.BlocCouleur;

public class Serialize {
    public static int num_file = 0;
	// SERIALIZER LES NIVEAUX ET LES STOCKER DANS UN DOSSIER
		public static void serialize(String chemin, Niveau niveauSerialise) {
			try(FileOutputStream fos = new FileOutputStream("src/com/Niveaux/niveau_"+num_file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(niveauSerialise);
				System.out.println("Le fichier " + "niveau_" + num_file + " a bien été executé et sérializé dans le dossier Niveaux");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
	
	
	}
}
