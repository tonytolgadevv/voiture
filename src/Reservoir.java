/* La classe Reservoir représente le réservoir d'essence de la voiture. Elle a deux attributs : capacite qui correspond à la capacité maximale du réservoir et contenu qui correspond à la quantité d'essence actuellement présente dans le réservoir. */
class Reservoir {
    double capacite;
    double contenu;

    Reservoir(double capacite) {
        this.capacite = capacite;
        this.contenu = capacite;
    }
    // La méthode consommer prend en paramètre le nombre de litres d'essence à consommer et soustrait cette quantité de contenu.
    void consommer(double litres) {
        contenu -= litres;
    }
 // La méthode faireLePlein remplit le réservoir jusqu'à sa capacité maximale en affectant la valeur de capacite à contenu.
    void faireLePlein() {
        contenu = capacite;
    }
}
