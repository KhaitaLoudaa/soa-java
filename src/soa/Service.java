package soa;

/**
 * Interface de base pour tous les services
 */
public interface Service {
    String getName();
    String execute(String data);
}

/**
 * Classe de base pour créer facilement des services
 */
abstract class BaseService implements Service {
    private String name;
    
    public BaseService(String name) {
        this.name = name;
        // Auto-enregistrement dans le registre
        ServiceRegistry.getInstance().register(this);
    }
    
    @Override
    public String getName() {
        return name;
    }
}
