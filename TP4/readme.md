# TP4 - M1 MIAGE

## Notifications

Les notifications sont un moyen d'afficher un message à un utilisateur et de lui proposer des actions simples alors que l'utilisateur n'a plus l'application en premier plan.

<https://developer.android.com/training/notify-user/build-notification.html>

> Si l'importation de dépendance de fonctionne pas avec `implementation`, utiliser `compile` à la place
>
> Les versions des libraires de support doivent être les même, dans le cas des machines IMAG, c'est `25.2.0`.

* Créer un nouveau projet avec une "empty activity"
* Ajouter un bouton avec un texte "Go !"

> Vous pouvez utiliser `android.R.drawable.sym_def_app_icon` comme icône.
* Afficher une notification qui affiche le texte "Hello World" lors de l'appui sur le bouton
* Ajouter à cette notification un bouton "d'action" ouvrant la page web <https://github.com>
> Pour aider : <https://developer.android.com/guide/components/intents-common.html#Browser>
>
> Pour le `PendingIntent`, vous ne l'envoyez pas en broadcast mais depuis une activité...

## Services

Les services Android permettent de réaliser des actions en arrière-plan, c'est-à-dire sans que l'utilisateur soit activement en train d'utiliser l'application.

<https://developer.android.com/guide/components/services.html>

> Il peut être interessant de vous documenter rapidement sur les intents : <https://developer.android.com/guide/components/intents-filters.html>

* Modifier l'action du bouton créé dans la partie précédente : ce bouton devra maintenant lancer un service
> Pour des raisons de simplicité, nous utiliserons un IntentService <https://developer.android.com/training/run-background-service/create-service.html>
>
> Pour le constructeur.. je vous laisse chercher

* Ce service devra tout d'abord afficher un message dans les logs 2 secondes après son lancement.
> Voir la classe android `Log`
>
> Nous n'affichons pas de Toast car un `IntentService` execute ses requêtes sur un nouveau thread, et Android ne permet pas des actions UI en dehors du main thread.
* Remplacer le message dans les logs par un intent renvoyé à votre activité principale. <https://developer.android.com/training/run-background-service/report-status.html>
  1. Créer le broadcast receiver
  2. Enregistrer (register) votre "receiver" dans votre activité
  3. Envoyer le message/intent en broadcast depuis le service
* Modifier l'activité pour qu'elle affiche la notification à la réception de ce message

## Appels REST

Pour étendre les capacités de notre application, nous allons y ajouter des appels à des services REST.
Le but de cette partie est d'utiliser l'API rendu disponible par <https://yesno.wtf/>.

Un appel à cette API retourne ce type de valeur au format JSON :

```json
{
  "answer":"yes",
  "forced":false,
  "image":"https://yesno.wtf/assets/yes/4-c53643ecec77153eefb461e053fb4947.gif"
}
```

Nous allons utiliser [RetroFit](http://square.github.io/retrofit/) en tant que client HTTP.

* Pour commencer, il faut l'importer. Ajoutez `compile 'com.squareup.retrofit2:retrofit:2.3.0'` à la partie *dependencies* de votre fichier *.gradle*.
* Il faut aussi donner à notre l'application l'accès à internet. Ajoutez la permission nécessaire au fichier `Manifest`.
* Copier la class `YesNoAnswer` fournie
* Créer une interface `YesNoService` en vous inspirant de l'exemple du site Retrofit et en utilisant `YesNoAnswer`. L'URL à inclure dans l'annotation @GET est `"api"`. Les méthode de l'interface doivent renvoyer des objets de type `Call`.
* Dans votre service Android : toujours en se basant sur l'exemple de Retrofit, générer votre service en utilisant `"https://yesno.wtf/"` en baseUrl. Enlever l'attente de 2 secondes.
> Vous allez avoir besoin d'un *converter*. A vous de trouvez comment faire mais utilisez le *converter* `Gson`
* Dans votre service Android : Faire appel à votre service Retrofit et renvoyer les données reçu dans l'intent envoyé en broadcast

Android n'autorise pas les appels HTTP sur le *main thread*. Ce n'est pas notre cas ici car `IntentService` crée un thread. Nous allons tout de même faire comme si le service était executé sur le *main thread*. Plus d'info [ici](https://developer.android.com/guide/components/processes-and-threads.html) et [ici](https://developer.android.com/training/basics/network-ops/connecting.html). Retrofit propose au travers de sa class `Call` la création d'un thread et le lancement de la requête de manière asynchrone. Voici un exemple :

```java
Call<YesNoAnswer> call = yesNoService.get();
call.enqueue(new Callback<YesNoAnswer>() {
    @Override
    public void onResponse(Call<YesNoAnswer> call, Response<YesNoAnswer> response) {
        if (response.isSuccessful()) {
            // anwser available
            YesNoAnswer answer = response.body();
        } else {
            // error response, no access to resource?
        }
    }

    @Override
    public void onFailure(Call<YesNoAnswer> call, Throwable t) {
        // something went completely south (like no internet connection)
        Log.d("Error", t.getMessage());
    }
}
```

* Dans votre activity, à la reception du message du service : Afficher le contenu de `answer` dans une notification.
* Ajouter un bouton sur la notification : Ce bouton devra ouvrir une page web vers l'url contenu dans `image`

Schéma résultat simplifié : 

![Diagramme de séquence simplifié](https://raw.githubusercontent.com/will421/TP-M1-MIAGE/master/TP4/assets/tp4_sequence.PNG "Diagramme de séquence simplifié")