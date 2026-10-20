package com.bibliotheque;

import com.bibliotheque.model.Emprunt;
import com.bibliotheque.service.EmpruntService;
import com.bibliotheque.service.LivreService;
import com.bibliotheque.service.MembreService;

public class Main {
    public static void main(String[] args) {
        LivreService livres = new LivreService();
        MembreService membres = new MembreService();
        EmpruntService emprunts = new EmpruntService(livres, membres);

        livres.ajouter("Le Petit Prince", "Antoine de Saint-Exupéry");
        livres.ajouter("L'Étranger", "Albert Camus");
        membres.inscrire("Awa Dossou", "awa@example.com");

        Emprunt e = emprunts.emprunter(1, 1);
        System.out.println("Emprunt créé : " + e);
        System.out.println("Livres disponibles : " + livres.listerDisponibles());

        emprunts.retourner(e.getId());
        System.out.println("Après retour : " + livres.listerDisponibles());
    }
}
