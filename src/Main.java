import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtenir les informations de l'utilisateur
        System.out.print("Entrez l'immatriculation de la voiture : ");
        String immatriculation = scanner.next();

        System.out.print("Entrez la distance du trajet en km : ");
        double distance = scanner.nextDouble();

        double vitesse = 0;
        boolean vitesseValide = false;
        while (!vitesseValide) {
            System.out.print("Entrez la vitesse moyenne en km/h (maximum 130 km/h) : ");
            vitesse = scanner.nextDouble();
            if (vitesse <= 130) {
                vitesseValide = true;
            } else {
                System.out.println("Erreur : la vitesse moyenne doit être inférieure ou égale à 130 km/h.");
            }
        }

        System.out.print("Entrez la puissance en chevaux : ");
        int puissance = scanner.nextInt();

        scanner.close();

        // Créer une instance de Voiture et simuler le trajet
        Voiture voiture = new Voiture(immatriculation, puissance);
        voiture.simulerTrajet(distance, vitesse);

        // Afficher le coût du trajet, le nombre de pleins et de dépannages
        System.out.println("Coût du trajet: " + voiture.cout + " €");
        System.out.println("Nombre de pleins effectués: " + voiture.nbPleins);
        System.out.println("Nombre de dépannages effectués: " + voiture.nbDepannages);
    }
}
