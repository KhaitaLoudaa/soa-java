package soa;

// Démonstration SOA
 
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Démarrage de l'application SOA...\n");
        
        // Créer les services
        ClientService clientService = new ClientService();
        CommandeService commandeService = new CommandeService();
        
        // Afficher les services disponibles
        ServiceRegistry.getInstance().listServices();
        
        System.out.println("\n--- Tests ---\n");
        
        // Test 1: Consulter un client
        System.out.println("Consultation d'un client:");
        String resultat1 = clientService.execute("C001");
        System.out.println(resultat1);
        
        System.out.println();
        
        // Test 2: Créer une commande avec un client valide
        System.out.println("Création de commande pour un client existant:");
        String resultat2 = commandeService.execute("C001");
        System.out.println(resultat2);
        
        System.out.println();
        
        // Test 3: Créer une commande avec un client invalide
        System.out.println("Tentative de commande pour un client inexistant:");
        String resultat3 = commandeService.execute("C999");
        System.out.println(resultat3);
        
        System.out.println();
        
        // Test 4: Créer une autre commande
        System.out.println("Création d'une autre commande:");
        String resultat4 = commandeService.execute("C002");
        System.out.println(resultat4);
        
        System.out.println();
        
        // Afficher toutes les commandes
        commandeService.afficherCommandes();
        
        System.out.println("\nApplication terminée.");
    }
}
