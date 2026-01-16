package soa;

import java.util.*;

//Service de gestion des clients
 
class ClientService extends BaseService {
    private Map<String, String> clients = new HashMap<>();
    
    public ClientService() {
        super("ClientService");
        // Données de test
        clients.put("C001", "Jean Dupont");
        clients.put("C002", "Marie Martin");
    }
    
    @Override
    public String execute(String clientId) {
        String nom = clients.get(clientId);
        if (nom != null) {
            return "Client trouvé: " + nom;
        }
        return "Client non trouvé: " + clientId;
    }
    
    public boolean clientExiste(String clientId) {
        return clients.containsKey(clientId);
    }
}

 //Service de gestion des commandes
 //Utilise le ClientService pour valider les clients
 
class CommandeService extends BaseService {
    private List<String> commandes = new ArrayList<>();
    private int numeroCommande = 1;
    
    public CommandeService() {
        super("CommandeService");
    }
    
    @Override
    public String execute(String clientId) {
        // Appel à un autre service (orchestration)
        ServiceRegistry registry = ServiceRegistry.getInstance();
        ClientService clientService = (ClientService) registry.findService("ClientService");
        
        // Vérifier si le client existe
        if (!clientService.clientExiste(clientId)) {
            return "❌ Erreur: Client " + clientId + " n'existe pas";
        }
        
        // Créer la commande
        String commande = "CMD" + numeroCommande++ + " pour client " + clientId;
        commandes.add(commande);
        
        return "✓ Commande créée: " + commande;
    }
    
    public void afficherCommandes() {
        System.out.println("\n=== Commandes ===");
        if (commandes.isEmpty()) {
            System.out.println("  Aucune commande");
        } else {
            commandes.forEach(c -> System.out.println("  " + c));
        }
    }
}