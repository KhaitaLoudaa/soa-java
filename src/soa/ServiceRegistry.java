package soa;

import java.util.*;

//Registre central des services - Annuaire de tous les services disponibles
 
public class ServiceRegistry {
    private static ServiceRegistry instance;
    private Map<String, Service> services = new HashMap<>();
    
    private ServiceRegistry() {}
    
    public static ServiceRegistry getInstance() {
        if (instance == null) {
            instance = new ServiceRegistry();
        }
        return instance;
    }
    
    // Enregistrer un service
    public void register(Service service) {
        services.put(service.getName(), service);
        System.out.println("✓ Service enregistré: " + service.getName());
    }
    
    // Trouver un service par son nom
    public Service findService(String name) {
        return services.get(name);
    }
    
    // Lister tous les services
    public void listServices() {
        System.out.println("\n=== Services disponibles ===");
        services.keySet().forEach(name -> System.out.println("  - " + name));
    }
}