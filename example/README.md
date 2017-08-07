# Beispiel-Projekt zur Java-Referenzarchitektur
Dies ist eine exemplarische Anwendung für die Referenzarchitektur.

* `api-gateway` - API-Gateway für Zugriffskontrolle und GUI-Aggregation.
 - TODO: Entscheidung Notwendigkeit je nach GUI-Pattern
 - TODO: ggf. Konfiguration 

* `service-registry` - Eureka-Service-Registry bei der sich alle Microservices registrieren.

* `zuchtregister` - Ein einfacher Rest-Service mit nur einer DB-Tabelle.

* `zooverwaltung` - Ein etwas komplexerer Rest-Service mit mehreren Entitäten und entsprechenden Relationen.
 - TODO: Relationen korrekt über Rest-API abbilden.
 - TODO: Spring Data Rest mit HATEOAS und automatisch generierter REST-API versus Spring MVC und 
         händisch gebauten @RestController.

## Ressources
* https://spring.io/guides/gs/rest-hateoas/
* http://projects.spring.io/spring-data-rest/