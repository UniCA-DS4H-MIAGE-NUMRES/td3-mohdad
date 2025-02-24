# PizzApp
Equipe Mohdad Ralph Matthéo Vasseur
Une application multiplateforme de commande de pizzas développée avec Kotlin Multiplatform et Jetpack Compose.

## Aperçu du Projet

PizzApp est une application multiplateforme fonctionnant sur Android, Desktop et Web. Elle implémente un système de commande de pizzas avec les fonctionnalités suivantes :

- Affichage du menu des pizzas en grille
- Vue détaillée des pizzas avec options de personnalisation
- Gestion du panier
- Gestion des états avec ViewModels
- Gestion de l'extrat fromage 

## Implémentation Technique

Le projet utilise :

- Kotlin Multiplatform pour le partage de code multiplateforme
- Jetpack Compose pour l'implémentation de l'interface utilisateur
- Le système de design Material 3
- Architecture MVVM avec ViewModels pour la gestion des états
- Gestion des ressources pour le chargement d'images multiplateforme
- Sqllite pour la gestion des données pour la partie Desktop
- LocalStorage pour la gestion des données pour la partie Web
- Room pour la gestion des données pour la partie Android

## Structure du Projet

- `composeApp/` : Module principal de l'application contenant :
    - Le code commun pour toutes les plateformes
    - Les implémentations spécifiques aux plateformes
    - Les composants et écrans UI
    - Les ViewModels pour la gestion des états

## Défis et Solutions de Développement

Les principaux défis rencontrés et résolus incluent :

- Chargement d'images multiplateforme : Implémenté via ResourceLoader spécifique à chaque plateforme
- Gestion des états : Résolue avec ViewModels utilisant MutableStateFlow
- Cohérence de l'interface : Obtenue grâce au thème Material 3
- Gestion du panier : Implémentée avec une gestion d'état réactive

Le projet démontre les pratiques modernes de développement Kotlin Multiplatform tout en maintenant une architecture propre et une interface utilisateur réactive.

## État Actuel et Limitations

- L'application fonctionne correctement sur Android et Desktop et web
- Le chargement des images a été implémenté et fonctionne correctement sur toutes les plateformes
  - L'interface utilisateur est réactive et fonctionnelle avec Jetpack Compose et ViewModels pour la gestion des états

VIDEO: https://drive.google.com/file/d/12Zcj-axSn4RaNGdTBtrJi2kgfp7tPbQa/view?usp=sharing
