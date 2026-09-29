package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {

    public static void main(String[] args) {

        JeuDeCartes jeu = new JeuDeCartes();

        Carte[] cartes = jeu.donnerCartes();

        Sabot sabot = new Sabot(cartes);

        while (!sabot.estVide()) {
            System.out.println("je pioche " + sabot.piocher());
        }
    }
}