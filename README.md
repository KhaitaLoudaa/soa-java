Ce projet est une implémentation simple et pédagogique de SOA en Java, destinée à illustrer les principes fondamentaux de l’architecture orientée services à travers un exemple clair et exécutable.

🎯 Objectif
Montrer comment des services métier autonomes peuvent collaborer sans couplage direct, grâce à un Service Registry (annuaire central).

🧩 Éléments clés du projet
Service Registry : annuaire central (Singleton) pour enregistrer et découvrir les services

Services métier :
ClientService : gestion des clients
CommandeService : gestion des commandes

Orchestration : un service peut utiliser un autre via le registry

Découplage : aucun service ne dépend directement d’un autre

🔑 Concepts SOA démontrés
Registry Pattern : les services s’enregistrent et sont retrouvés dynamiquement
Autonomie des services : chaque service a une responsabilité unique
Orchestration : CommandeService vérifie l’existence d’un client via ClientService
Faible couplage : remplacement ou évolution d’un service sans impact global

⚙️ Fonctionnement global
Au démarrage, les services s’enregistrent automatiquement dans le registry
Les appels entre services passent par l’annuaire
Les règles métier sont respectées (commande refusée si client inexistant)

🎯 Point clé de SOA
Les services ne se connaissent pas directement
➡️ Communication via un annuaire central, ce qui garantit flexibilité, maintenabilité et réutilisabilité

🛠️ Technologies
Java 21
IDE Java Eclipse

💡 Conclusion
Ce projet montre clairement la puissance de SOA :
➡️ changer ou remplacer un service sans modifier les autres, grâce au découplage et au registry.

Implémentation volontairement simplifiée à but pédagogique (sans REST, SOAP, Kafka, etc.).

👤 Auteur : Khaita
