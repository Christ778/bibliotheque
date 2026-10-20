package com.bibliotheque.model;

public class Membre {
    private final int id;
    private String nom;
    private String email;

    public Membre(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Membre{id=" + id + ", nom='" + nom + "', email='" + email + "'}";
    }
}
