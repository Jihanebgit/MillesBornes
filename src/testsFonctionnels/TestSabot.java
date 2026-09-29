package testsFonctionnels;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {

    public static void main(String[] args) {

        JeuDeCartes jeu = new JeuDeCartes();

        
        System.out.println("TEST PIOCHER");

        Sabot sabot = new Sabot(jeu.donnerCartes());

        while (!sabot.estVide()) {
            System.out.println("je pioche " + sabot.piocher());
        }


        
        System.out.println();
        System.out.println("TEST ITERATEUR ET REMOVE ");

        sabot = new Sabot(jeu.donnerCartes());

        Iterator<Carte> iterator = sabot.iterator();

        while (iterator.hasNext()) {

            Carte carte = iterator.next();

            System.out.println("je pioche " + carte);

            iterator.remove();
        }


        
        System.out.println();
        System.out.println("TEST CONCURRENT MODIFICATION");

        sabot = new Sabot(jeu.donnerCartes());

        iterator = sabot.iterator();

        iterator.next();

        sabot.piocher();

        try {

            iterator.next();

        } catch (ConcurrentModificationException e) {

            System.out.println(
                "ConcurrentModificationException correctement levee."
            );
        }


        
        System.out.println();
        System.out.println("TEST AJOUT PENDANT ITERATION");

        sabot = new Sabot(jeu.donnerCartes());

        
        sabot.piocher();

        iterator = sabot.iterator();

        iterator.next();

        sabot.ajouterCarte(new Botte(Type.ACCIDENT));

        try {

            iterator.next();

        } catch (ConcurrentModificationException e) {

            System.out.println(
                "ConcurrentModificationException correctement levee."
            );
        }
    }
}