# M1 MIAGE - Projet Android 2018

## Objectif

L'objectif du projet est de réaliser une application Android de rappel du prochain passage du tram ou bus.
Pour cela vous utiliserez l'API REST proposée par Metromobilité : <https://www.metromobilite.fr/pages/opendata/OpenDataApi.html>
L'affichage des rappels sera fait par l'intermédiaire de notifications.

## Fonctionnalités

### Pouvoir selectionner un arrêt et une direction à surveiller

* Niveau 1 : Sélectionner depuis la liste statique donnée
* Niveau 2 : Sélectionner depuis une liste fournie par l'API TAG

### Recupération et affichage du prochain passage

#### Niveau 1 : Afficher le prochain passage dans un champ texte de l'application

Vous devrez recupérer les horaires du prochain passage pour l'arrêt et la direction selectionnés.
La récuperation devra se faire par un appel régulier (toute les 30 secondes) à l'API REST de metromobilité. Voir **exemple**.
L'affichage devra contenir le temps d'attente pour le prochain passage et optionnellement, celui d'après.

#### Niveau 2 : Fonctionne même lorsque l'application n'est plus au premier plan

L'affichage devra en plus être fait par l'intermediaire d'une notification. Y afficher l'arrêt, la direction, le temps d'attente pour le prochain passage et optionnellement, celui d'après.
Toucher la notification renverra vers la page de configuration de l'application.
> Attention aux Threads, un `IntentService` en crée un par defaut, il peut être judicieux de ne pas s'en servir.

#### Niveau 3 : Dissocier la récuperation de l'emission de notifications

Afficher la notification uniquement lorsque le temps du/des prochains passages changent du précédent appel.

### Systeme de favoris

Permettre l'enregistrement, la sélection et la suppression d'arrêt+direction en favoris.
Les favoris devront être persistants. C'est à dire qu'ils devront être conservés aux travers des lancements de l'application.

## En plus avancé

### Geolocalisation

...

## Travail à réaliser

<!-- ### Rédaction des spécifications fonctionnelles avec

* Les cas d'utilisation principaux
* Les modèles de données globaux
* Les maquettes IHM

### Réalisation de l'application à partir des besoins exprimés et des spécifications -->

## Modalités d'évaluation du projet

<!--Le projet s'effectue uniquement en **binôme**.
Les binômes doivent se déclarer dans le document pré-renseigné sur le drive d’échange Android.
Le projet donne lieu :

* à une présentation orale (démo)
* à un livrable sous forme d’archives (zip NOM1_NOM2) -->

### Présentation orale

<!--Date : **A definir**

Lieu : **A definir**

Chaque **binôme** sera convoqué à une heure précise.

* Il dispose de 20 minutes pour préparer la démonstration (configuration de l'environnement, éditeur ouvert avec code et API du projet et toute initialisation nécessaire au lancement de l'application).
* Puis il dispose de 10 minutes pour présenter son travail
* Les 10 minutes ne pourront être dépassées : si vous n'êtes pas prêts à l'heure, le temps sera décompté.
* Présentez les différentes fonctionnalités réalisées du projet. Veillez à disposer de jeux d'essais convaincants. -->

### Remise du fichier à l'enseignant

<!-- Préparer une archive contenant :

* un répertoire « src » avec le code source du projet
* un répertoire «doc » avec
  * un fichier « sfg.pdf » pour les spécifications fonctionnelles,
  * un fichier « CR.pdf » présentant un brève compte-rendu de l’état du projet (états d’avancement : étapes réalisées et étapes non réalisées, difficultés rencontrées, choix d’architecture, idées d’améliorations)
* un répertoire « bin » avec le fichier binaire « apk » de l’application

Ce fichier sera envoyé à mickael.contreras@gmail.com au plus tard la veille de la soutenance.

* Le message aura pour sujet : NOM1_NOM2 (nom de chaque personne du binôme en ordre alphabétique).
* La pièce jointe (archive) aura également le nom : NOM1_NOM2.

Si plusieurs envois de même sujet sont envoyés, seul le dernier sera pris en compte, quel que soit l'expéditeur (NOM1 ou NOM2).
L'évaluation du projet tiendra compte de la présentation, de l’état d’avancement du projet, du nombre de fonctionnalités implémentées, de l’ergonomie de l’application et de la qualité des livrables (documents et code source). -->
