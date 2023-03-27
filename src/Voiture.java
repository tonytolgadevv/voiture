class Voiture {

    // Les attributs
    String numImmatriculation;
    int puissance;
    double cout;
    int nbPleins;
    int nbDepannages;
    // Fin attributs

    // Objets associés
    Compteur compteur;
    Reservoir reservoir;
    private double chevaux;
    Voiture(String numImmatriculation, int puissance) {
        this.numImmatriculation = numImmatriculation;
        this.puissance = puissance;
        this.compteur = new Compteur();
        this.reservoir = new Reservoir(puissance <= 6 ? 40 : 60);
        this.chevaux = puissance;
        this.nbPleins = 0;
        this.nbDepannages = 0;
    }

    public double calculerConsommation(double vitesse) {
        double consommation = 0;
        if (vitesse > 0 && vitesse <= 80) consommation = 6;
        else if (vitesse > 80 && vitesse <= 100) consommation = 7;
        else if (vitesse > 100 && vitesse <= 120) consommation = 8;
        else if (vitesse > 120 && vitesse <= 130) consommation = 9;

        double coefficient = 1 + 0.0015 * (chevaux - 4);
        return consommation * coefficient;
    }



    void simulerTrajet(double distance, double vitesse) {
        double consommation = calculerConsommation(vitesse);
        double distanceParcourue = 0;

        while (distanceParcourue < distance) {
            double distanceRestante = distance - distanceParcourue;
            double distancePossibles = reservoir.contenu * 100 / consommation;

            if (distancePossibles >= distanceRestante) {
                compteur.incrementerKilometrage(distanceRestante);
                reservoir.consommer(distanceRestante * consommation / 100);
                distanceParcourue = distance;
            } else {
                compteur.incrementerKilometrage(distancePossibles);
                reservoir.consommer(reservoir.contenu);
                distanceParcourue += distancePossibles;

                nbDepannages++; // Incrémenter le nombre de dépannages
                cout += 100; // Coût du dépannage
                reservoir.faireLePlein();
            }
        }

        nbPleins++; // Incrémenter le nombre de pleins
        cout += compteur.kmParcourus * consommation / 100; // Coût de l'essence
    }
}
