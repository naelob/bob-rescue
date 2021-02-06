package com.modele;

public class Bloc implements Cloneable {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getType() {
        if (this instanceof BlocAnimal)
            return 'a';
        if (this instanceof BlocCouleur)
            return 'c';
        if (this instanceof BlocObstacle)
            return 'o';
        return 'x';
    }

    @Override
    public Bloc clone() throws CloneNotSupportedException {

        return (Bloc) super.clone();
    }
}
