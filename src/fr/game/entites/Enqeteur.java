package fr.game.entites;

import fr.game.entites.Contribuable;

public class Enqeteur extends Contribuable {
    private boolean robot;
    private String pseudo;
    public Enqeteur(String nom, String prenom, int idPays, boolean robot, String pseudo) {
        super(nom, prenom, idPays);
        this.pseudo = pseudo;
        this.robot = robot;
    }
}
