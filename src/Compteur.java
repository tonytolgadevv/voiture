// La classe Compteur représente le compteur kilométrique de la voiture. Elle possède deux attributs vitesse et kmParcourus, ainsi qu'une méthode incrementerKilometrage(double km) pour incrémenter le nombre de kilomètres parcourus. Le constructeur Compteur() initialise les deux attributs à zéro. La méthode incrementerKilometrage(double km) ajoute le nombre de kilomètres km spécifié à l'attribut kmParcourus.

class Compteur {
    double vitesse;
    double kmParcourus;

    Compteur() {
        this.vitesse = 0;
        this.kmParcourus = 0;
    }

    void incrementerKilometrage(double km) {
        kmParcourus += km;
    }
}