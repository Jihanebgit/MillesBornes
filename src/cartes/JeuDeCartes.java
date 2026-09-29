package cartes;

public class JeuDeCartes {

    private Configuration[] configurations;

    private static class Configuration {

        private Carte carte;
        private int nombre;

        public Configuration(Carte carte, int nombre) {
            this.carte = carte;
            this.nombre = nombre;
        }

        public Carte getCarte() {
            return carte;
        }

        public int getNombre() {
            return nombre;
        }
    }

    public JeuDeCartes() {

        configurations = new Configuration[] {
            new Configuration(new Borne(25), 10),
            new Configuration(new Borne(50), 10),
            new Configuration(new Borne(75), 10),
            new Configuration(new Borne(100), 12),
            new Configuration(new Borne(200), 4),

            new Configuration(new Parade(Type.FEU), 14),
            new Configuration(new FinLimite(), 6),
            new Configuration(new Parade(Type.ESSENCE), 6),
            new Configuration(new Parade(Type.CREVAISON), 6),
            new Configuration(new Parade(Type.ACCIDENT), 6),

            new Configuration(new Attaque(Type.FEU), 5),
            new Configuration(new DebutLimite(), 4),
            new Configuration(new Attaque(Type.ESSENCE), 3),
            new Configuration(new Attaque(Type.CREVAISON), 3),
            new Configuration(new Attaque(Type.ACCIDENT), 3),

            new Configuration(new Botte(Type.FEU), 1),
            new Configuration(new Botte(Type.ESSENCE), 1),
            new Configuration(new Botte(Type.CREVAISON), 1),
            new Configuration(new Botte(Type.ACCIDENT), 1)
        };
    }

    public void affichageJeuDeCartes() {

        System.out.println("JEU :");

        for (Configuration configuration : configurations) {
            System.out.println(
                configuration.getNombre() + " "
                + configuration.getCarte()
            );
        }
    }

    private int nombreTotalDeCartes() {

        int total = 0;

        for (Configuration configuration : configurations) {
            total += configuration.getNombre();
        }

        return total;
    }

    public Carte[] donnerCartes() {

        Carte[] cartes = new Carte[nombreTotalDeCartes()];

        int indice = 0;

        for (Configuration configuration : configurations) {

            for (int i = 0; i < configuration.getNombre(); i++) {
                cartes[indice] = configuration.getCarte();
                indice++;
            }
        }

        return cartes;
    }
}