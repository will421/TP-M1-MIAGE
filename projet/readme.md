# M1 MIAGE - Projet Android 2018

## Objectif

L'objectif du projet est de réaliser une application Android de rappel du prochain passage du tram ou bus.
Pour cela vous utiliserez l'API REST proposée par Metromobilité : <https://www.metromobilite.fr/pages/opendata/OpenDataApi.html>
L'affichage des rappels sera fait en utilisant des notifications.

> Ce sujet sera mis à jour en fonctions des nouvelles idées, retours et remarques. Surveillez de temps en temps qu'un nouveau commit n'est pas apparu sur le git, ça peut être une information pouvant vous aider.

## Fonctionnalités

Qu'il y ai des fonctionnalités marqué comme *optionnelle* ne veut pas dire que réaliser uniquement les fonctionnalités obligatoires suffit à avoir une note maximale. Elles sont *optionnelle* pour vous donner du mou sur ce que vous voulez réaliser.

### Pouvoir sélectionner un arrêt et une direction à surveiller

Utilisez les api suivantes pour :

* Récupérer la liste des lignes : <https://data.metromobilite.fr/api/routers/default/index/routes>
* Récupérer la liste des arrêts d'une ligne (exemple pour la ligne A) : <https://data.metromobilite.fr/api/routers/default/index/routes/SEM:A/clusters>

Vous ferez en sorte de ne traiter que les lignes de tramway et bus TAG.

### Récupération et affichage du prochain passage

#### Etape 1 : Afficher le prochain passage dans un champ texte de l'application

Vous devrez récupérer les horaires du prochain passage pour l'arrêt et la direction sélectionnés.
La récupération devra se faire par un appel régulier (toute les 30 secondes) à l'API REST de Metromobilité **"Horaires pour une zone d'arrêt"**
L'affichage devra contenir le temps d'attente pour le prochain passage et optionnellement, celui d'après.

#### Etape 2 : Fonctionne même lorsque l'application n'est plus au premier plan

L'affichage devra en plus être fait par l'intermédiaire d'une notification. Y afficher l'arrêt, la direction, le temps d'attente pour le prochain passage et optionnellement, celui d'après.
Toucher la notification renverra vers la page de configuration du rappel.
> Attention aux Threads, un `IntentService` en crée déjà un par défaut.

### Simplifier le parametrage du rappel pour l'utilisateur

#### Possibilité 1

Permettre l'enregistrement, la sélection et la suppression d'arrêt+direction en favoris.
Les favoris devront être persistants. C'est à dire qu'ils devront être conservés aux travers des lancements de l'application.

#### Possibilité 2

Enregistrer les rappels les plus recents pour les re-proposer à l'utilisateurs. Moins d'IHM nécéssaire mais *peut-être* un peu d'algorithme pour proposer le meilleur arrêt+direction en fonction de la quantité d'utilisation et de la date de dernière utilisation ?

#### Possibilité 3

Si une idée interessante, la proposer.

### Géolocalisation (*optionnelle*)

Aider l'utilisateur à sélectionner un arrêt en proposant le ou les arrêts les plus proches.
Pour cela, utilisez l'API **"Liste des lignes de transport à proximité d'un point"** et <https://developer.android.com/training/location/retrieve-current.html>

### Alertes TAG (*optionnelle*)

Avertir l'utilisateur lorsqu'un incident se produit impactant la ligne surveillée.
Utilisez l'API "Données dynamiques" avec le paramètre `evtTC`.

### Gérer les cas non prévus (*optionnelle* mais preuve de qualité)

* Gérer le fait qu'il peut ne pas y avoir de connexion internet
* Prévoir qu'il n'y ai pas de GPS pour la géolocalisation
* ...

### Un peu de créativité (*optionnelle*)

C'est votre application et vous en êtes le premier utilisateur, si vous pensez que des fonctionnalités peuvent être ajoutées/modifiées et qu'elles apportent une plus-value à l'utilisateur. Faites-le. Idée simple : Utiliser des vibrations.

## Travail à réaliser

### Préparations

* Réaliser des maquettes IHM de l'application avec un outil permettant de réaliser des mockups ou wireframe de votre choix. Par exemple : <https://ninjamock.com/> ou l'outil de design inclus dans Android Studio. Inutile de les faire évoluer avec le projet, c'est pour vous faire une idée initiale.
* Realiser pour chacune des fonctionnalités : des diagrammes de séquences représentant les interactions entre vos composants applicatif. Ces diagrammes seront à faire évoluer avec les changements de votre implémentation. Ils serviront à démontrer que vous comprenez ce que vous faîtes.

### Réalisation de l'application

## Modalités d'évaluation du projet

Le projet s'effectue en binôme. M'envoyer un mail à `william.bobo@hardis.fr` pour l'annoncer en début de projet.
Le projet donne lieu à un livrable sous forme d'une archive `NOM1_NOM2.zip`

### Remise du projet

Préparer une archive contenant :

* un répertoire « src » avec le code source du projet
* un répertoire « doc » avec
  * Vos fichiers images de diagramme de séquence.
  * Vos fichiers image de maquette IHM pré-développement.
  * Un fichier « compte-rendu.pdf » présentant un brève compte rendu de l’état du projet (états d’avancement : étapes réalisées et étapes non réalisées, difficultés rencontrées, choix d’architecture, idées d’améliorations).
* un répertoire « bin » avec le fichier binaire « apk » de l’application

Ce fichier sera envoyé à déposer sur le moodle avant le *To be defined (autour de mai)*.

L'évaluation du projet tiendra compte de la présentation, de l’état d’avancement du projet, des fonctionnalités implémentées, de l’ergonomie de l’application et de la qualité des livrables (documents et code source).

## Outils sympa

* Pour générer des classes java à partir du json : <http://www.jsonschema2pojo.org/> (Source type : `JSON`, Annotation style : `Gson`)
* Pour simplifier les `findViewById` : <http://jakewharton.github.io/butterknife/>