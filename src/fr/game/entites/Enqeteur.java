package fr.game.entites;

import fr.game.entites.Contribuable;

public class Enqeteur extends Contribuable {
    private boolean robot;
    private String pseudo;
    public Enqeteur(String nom, String prenom, Pays pays, boolean robot, String pseudo) {
        super(nom, prenom, pays);
        this.pseudo = pseudo;
        this.robot = robot;
    }

    public boolean isRobot() {
        return robot;
    }

    public void setRobot(boolean robot) {
        this.robot = robot;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
