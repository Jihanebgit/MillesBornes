package testsFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public class TestCartes {

    public static void main(String[] args) {

        Carte attaque = new Attaque(Type.FEU);
        Carte parade = new Parade(Type.FEU);
        Carte botte = new Botte(Type.FEU);

        System.out.println(attaque);
        System.out.println(parade);
        System.out.println(botte);
        
        
        System.out.println(new Attaque(Type.ESSENCE));
        System.out.println(new Parade(Type.ESSENCE));
        System.out.println(new Botte(Type.ESSENCE));
        
        System.out.println(new Attaque(Type.CREVAISON));
        System.out.println(new Parade(Type.CREVAISON));
        System.out.println(new Botte(Type.CREVAISON));
    }
}