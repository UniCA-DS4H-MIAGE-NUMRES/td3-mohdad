# PizzApp

Une application multiplateforme de commande de pizzas développée avec Kotlin Multiplatform et Jetpack Compose.

## Aperçu du Projet

PizzApp est une application multiplateforme fonctionnant sur Android, Desktop et Web. Elle implémente un système de commande de pizzas avec les fonctionnalités suivantes :

- Affichage du menu des pizzas en grille
- Vue détaillée des pizzas avec options de personnalisation
- Gestion du panier
- Gestion des états avec ViewModels

## Implémentation Technique

Le projet utilise :

- Kotlin Multiplatform pour le partage de code multiplateforme
- Jetpack Compose pour l'implémentation de l'interface utilisateur
- Le système de design Material 3
- Architecture MVVM avec ViewModels pour la gestion des états
- Gestion des ressources pour le chargement d'images multiplateforme

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

- L'application fonctionne correctement sur Android et Desktop
- Le chargement des images n'a pas été complètement implémenté en raison de difficultés avec la gestion des ressources multiplateforme
- L'interface utilisateur reste fonctionnelle mais basique
- Des améliorations visuelles sont nécessaires pour une meilleure expérience utilisateur et je n'ai pas réussi à les implémenter.