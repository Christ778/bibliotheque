# Bibliothèque – Modélisation objet en Java

Petit système de gestion de bibliothèque (stockage en mémoire).

## Entités
- `Livre` : id, titre, auteur, disponibilité
- `Membre` : id, nom, email
- `Emprunt` : id, livre, membre, date d'emprunt, date de retour

## Services
- `LivreService` : ajouter, rechercher, lister, supprimer
- `MembreService` : inscrire (email unique), trouver, lister, supprimer
- `EmpruntService` : emprunter, retourner, lister les emprunts en cours, historique d'un membre

## Exécution
```
./gradlew run        # ou lancer Main.java depuis Android Studio
```

## Auteurs
- Nom 1
- Nom 2
