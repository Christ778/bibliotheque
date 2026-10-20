package com.bibliotheque.model;

public class Livre {
    private final int id;
    private String titre;
    private String auteur;
    private boolean disponible = true;

    public Livre(int id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Livre{id=" + id + ", titre='" + titre + "', auteur='" + auteur
                + "', disponible=" + disponible + "}";
    }
}
