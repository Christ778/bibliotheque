package com.bibliotheque.service;

import com.bibliotheque.model.Membre;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MembreService {
    private final List<Membre> membres = new ArrayList<>();
    private int compteur = 1;

    public Membre inscrire(String nom, String email) {
        boolean existe = membres.stream()
                .anyMatch(m -> m.getEmail().equalsIgnoreCase(email));
        if (existe) {
            throw new IllegalArgumentException("Email déjà utilisé : " + email);
        }
        Membre membre = new Membre(compteur++, nom, email);
        membres.add(membre);
        return membre;
    }

    public Optional<Membre> trouverParId(int id) {
        return membres.stream().filter(m -> m.getId() == id).findFirst();
    }

    public List<Membre> listerTous() { return new ArrayList<>(membres); }

    public boolean supprimer(int id) {
        return membres.removeIf(m -> m.getId() == id);
    }
}
