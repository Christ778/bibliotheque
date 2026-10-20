package com.bibliotheque.service;

import com.bibliotheque.model.Livre;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivreService {
    private final List<Livre> livres = new ArrayList<>();
    private int compteur = 1;

    public Livre ajouter(String titre, String auteur) {
        Livre livre = new Livre(compteur++, titre, auteur);
        livres.add(livre);
        return livre;
    }

    public Optional<Livre> trouverParId(int id) {
        return livres.stream().filter(l -> l.getId() == id).findFirst();
    }

    public List<Livre> rechercherParTitre(String motCle) {
        String m = motCle.toLowerCase();
        return livres.stream()
                .filter(l -> l.getTitre().toLowerCase().contains(m))
                .toList();
    }

    public List<Livre> listerDisponibles() {
        return livres.stream().filter(Livre::isDisponible).toList();
    }

    public List<Livre> listerTous() { return new ArrayList<>(livres); }

    public boolean supprimer(int id) {
        return livres.removeIf(l -> l.getId() == id);
    }
}
