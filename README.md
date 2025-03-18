# 📚 Application Order

L'application Order permet de listes les commandes et d'effectuer des réclamations sur ces derniéres.

## Prérequis
Jdk 21
Maven

## Construire le projet
```bash
mvn clean install
```

## Lancer le projet
```bash
mvn spring-boot:run
```
ou lancez la classe principale `OrderApplication`


## Exemple de requête
```bash
curl -X GET localhost:8080/orders?customerId=1000&orderDate=2022-03-13
```


## Reste à faire
- Configurer Cucumber pour les tests d'intégration
- Ajouter des tests unitaires
- Configurer CI/CD
- Ajouter SonarQube pour la qualité du code
- Mettre à disposition une documentation Swagger
