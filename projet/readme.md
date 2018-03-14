# M1 MIAGE - Projet Android 2018

## Objectif

L'objectif du projet est de réaliser une application Android de rappel du prochain passage du tram ou bus.
Pour cela vous utiliserez l'API REST proposée par Metromobilité : <https://www.metromobilite.fr/pages/opendata/OpenDataApi.html>
L'affichage des rappels sera fait par l'intermédiaire de notifications.

## Fonctionnalités

### Pouvoir selectionner un arrêt et une direction à surveiller

#### Niveau 1 : Sélectionner depuis la liste statique donnée

#### Niveau 2 : Sélectionner depuis une liste fournie par l'API TAG

### Recupération et affichage du prochain passage

#### Niveau 1 : Afficher le prochain passage dans un champ texte de l'application

Vous devrez recupérer les horaires du prochain passage pour l'arrêt et la direction sélectionnés.
La récuperation devra se faire par un appel régulier (toute les 30 secondes) à l'API REST de metromobilité. Voir **exemple**.
L'affichage devra contenir le temps d'attente pour le prochain passage et optionnellement, celui d'après.

#### Niveau 2 : Fonctionne même lorsque l'application n'est plus au premier plan

L'affichage devra en plus être fait par l'intermediaire d'une notification. Y afficher l'arrêt, la direction, le temps d'attente pour le prochain passage et optionnellement, celui d'après.
Toucher la notification renverra vers la page de configuration de l'application.
> Attention aux Threads, un `IntentService` en crée un par defaut, il peut être judicieux de ne pas s'en servir.

#### Niveau 3 : Dissocier la récupération de l'émission de notifications

Afficher la notification uniquement lorsque le temps du/des prochains passages changent du précédent appel.

### Système de favoris

Permettre l'enregistrement, la sélection et la suppression d'arrêt+direction en favoris.
Les favoris devront être persistants. C'est à dire qu'ils devront être conservés aux travers des lancements de l'application.

### Géolocalisation

Aider l'utilisateur à selectionner un arrêt en selectionnant l'arrêt le plus proche

## En plus avancé

### Alertes TAG

Avertir l'utilisateur lorsqu'un incident se produit impactant la ligne surveillée.

## Travail à réaliser

### Préparations

* Réaliser des maquettes IHM de l'application avec un outil permettant de réaliser des mockups ou wireframe de votre choix. Par exemple : <https://ninjamock.com/>, l'outil de design inclus dans Android Studio. Inutile de les faire evoluer avec le projet, c'est pour vous faire une idée initiale.
* Realiser pour chacune des fonctionnalités : des diagrammes de sequences representant les interactions entre vos composants applicatif. Ces diagrammes seront à faire évoluer avec les changements de votre implémentation.

### Réalisation de l'application

## Modalités d'évaluation du projet

Le projet s'effectue en binome.
Les binomes doivent se déclarer sur ce pad : <https://semestriel.framapad.org/p/Binomes-M1-MIAGE-Android-2018>
Le projet donne lieu :

* __Une possible présentation orale, la reflexion est toujours en cours__
* A un livrable sous forme d’archives (zip NOM1_NOM2)

<!--### Présentation orale

Date : **A definir**

Lieu : **A definir**

Chaque **binôme** sera convoqué à une heure précise.

* Il dispose de 20 minutes pour préparer la démonstration (configuration de l'environnement, éditeur ouvert avec code et API du projet et toute initialisation nécessaire au lancement de l'application).
* Puis il dispose de 10 minutes pour présenter son travail
* Les 10 minutes ne pourront être dépassées : si vous n'êtes pas prêts à l'heure, le temps sera décompté.
* Présentez les différentes fonctionnalités réalisées du projet. Veillez à disposer de jeux d'essais convaincants. -->

### Remise du projet

Préparer une archive contenant :

* un répertoire « src » avec le code source du projet
* un répertoire « doc » avec
  * Vos fichiers images de diagramme de séquence.
  * Vos fichiers de maquette IHM pré-developement.
  * Un fichier « compte-rendu.pdf » présentant un brève compte-rendu de l’état du projet (états d’avancement : étapes réalisées et étapes non réalisées, difficultés rencontrées, choix d’architecture, idées d’améliorations).
* un répertoire « bin » avec le fichier binaire « apk » de l’application

Ce fichier sera envoyé à `william.bobo@hardis.fr` __au plus tard la veille de la soutenance__.

* Le message aura pour sujet : NOM1_NOM2 (nom de chaque personne du binôme en ordre alphabétique).
* La pièce jointe (archive) aura également le nom : NOM1_NOM2.

Si plusieurs envois de même sujet sont envoyés, seul le dernier sera pris en compte, quel que soit l'expéditeur (NOM1 ou NOM2).
L'évaluation du projet tiendra compte de la présentation, de l’état d’avancement du projet, du nombre de fonctionnalités implémentées, de l’ergonomie de l’application et de la qualité des livrables (documents et code source).
