package com.modele;

import java.awt.Color;

public class BlocCouleur extends Bloc {

    private Color color;
    
    public BlocCouleur(Color c) {
        this.color = c;
    }
    
    public void setColor(Color c) {
    	color = c;
    }
    public Color getColor() {
        return color;
    }
    public String toString() {
        Color couleurActuelle = getColor();
    	return "La couleur du bloc est : " + couleurActuelle;
    }
}
