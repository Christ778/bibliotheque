package com.bibliotheque.model;

import java.time.LocalDate;

public class Emprunt {
    private final int id;
    private final Livre livre;
    private final Membre membre;
    private final LocalDate dateEmprunt;
    private LocalDate dateRetour; // null tant que le livre n'est pas rendu

    public Emprunt(int id, Livre livre, Membre membre) {
        this.id = id;
        this.livre = livre;
        this.membre = membre;
        this.dateEmprunt = LocalDate.now();
    }

    public int getId() { return id; }
    public Livre getLivre() { return livre; }
    public Membre getMembre() { return membre; }
    public LocalDate getDateEmprunt() { return dateEmprunt; }
    public LocalDate getDateRetour() { return dateRetour; }
    public void setDateRetour(LocalDate dateRetour) { this.dateRetour = dateRetour; }
    public boolean isEnCours() { return dateRetour == null; }

    @Override
    public String toString() {
        return "Emprunt{id=" + id + ", livre='" + livre.getTitre() + "', membre='"
                + membre.getNom() + "', date=" + dateEmprunt
                + ", retour=" + dateRetour + "}";
    }
}
