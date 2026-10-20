package com.bibliotheque.service;

import com.bibliotheque.model.Emprunt;
import com.bibliotheque.model.Livre;
import com.bibliotheque.model.Membre;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpruntService {
    private final List<Emprunt> emprunts = new ArrayList<>();
    private final LivreService livreService;
    private final MembreService membreService;
    private int compteur = 1;

    public EmpruntService(LivreService livreService, MembreService membreService) {
        this.livreService = livreService;
        this.membreService = membreService;
    }

    public Emprunt emprunter(int idLivre, int idMembre) {
        Livre livre = livreService.trouverParId(idLivre)
                .orElseThrow(() -> new IllegalArgumentException("Livre introuvable"));
        Membre membre = membreService.trouverParId(idMembre)
                .orElseThrow(() -> new IllegalArgumentException("Membre introuvable"));
        if (!livre.isDisponible()) {
            throw new IllegalStateException("Livre déjà emprunté : " + livre.getTitre());
        }
        livre.setDisponible(false);
        Emprunt emprunt = new Emprunt(compteur++, livre, membre);
        emprunts.add(emprunt);
        return emprunt;
    }

    public void retourner(int idEmprunt) {
        Emprunt emprunt = emprunts.stream()
                .filter(e -> e.getId() == idEmprunt && e.isEnCours())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Emprunt en cours introuvable"));
        emprunt.setDateRetour(LocalDate.now());
        emprunt.getLivre().setDisponible(true);
    }

    public List<Emprunt> listerEnCours() {
        return emprunts.stream().filter(Emprunt::isEnCours).toList();
    }

    public List<Emprunt> historiqueMembre(int idMembre) {
        return emprunts.stream()
                .filter(e -> e.getMembre().getId() == idMembre)
                .toList();
    }
}
