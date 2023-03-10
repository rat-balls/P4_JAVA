# PUISSANCE 4 JAVA

## Pour commencer
Le projet consiste à réaliser un Puissance 4 fonctionnel en Java avec quelques fonctionnalités supplémentaires ainsi qu'une IA avec plusieurs difficultés.

## Structure du dossier

le projet contient 3 dossiers:
- `bin`: où se trouvent les méta données 
- `src`: contient tout le code, les fonctions et les classes

dans `src/model` se trouvent toutes les fonctions qui permettent au programme de gérer l'affichage, la customisation, le logger etc.

## Equipe:

Tristan Turgy (Scrum master)<br>
Ethan Delalande (Développeur)<br>
Sasha Harel (Développeur)<br>
Amin Kassiev (Développeur)<br>

## Fonctions:

Un puissance 4 étant simplement un tableau à petits disques qui est soumis au lois de la gravité, on a déduit qu'il fallait faire en code un tableau à deux matrices (tab [[][][]...]) de 7 x 6 cases.<br>
src/model/Grid :      `createGrid()` <br>
Une fonction qui ne prends rien en paramètres et qui renvoie ArrayList<ArrayList<String>> (une liste de listes contenant des chaîne de caractères. Ce code à été fait par Amin et Ethan. Il s'agit là de faire une double boucle for pour faire une tableau replis de liste qui ont tous comme variable un tiret du 6 
`"-"` .<br>
  

Pour afficher ce tableau vide, Amin s'est occupé de l'affichage.<br>
`affichage (ArrayList<ArrayList<String>> g)`<br>
Cette fonction prends en paramètre la liste que créer la fonction plus haut, elle la parcours en faisant des System.out.println() à chaque ligne. Donnant un tableau ressemblant à cela quand il est vide:
`  1   2   3   4   5   6   7  ` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`|---------------------------|` <br>

Pour apporter des modifications à la grille Amin écrit les bases d'une modification (ajout de pions) qui vont être réutilisées à plusieurs réprises dans d'autres Classes. <br>
`modif(ArrayList<ArrayList<String>> g, String message, String symbole)`<br>
Comme pour `affichage()`, `modif()`prends en paramètres : une grille. Mais aussi un message et un symbole, le message correspond au message d'erreur en cas de mauvais input (pas un chiffre, chiffre négatif, chiffre trop grand), et symbole qui correspond à l'apparence du pion. La fonction par cours la grille avec 2 boucles for, remplace libre de la colonne designée par le joueur avec son symbole.

Sacha s'est occupé de l'affichage des menus, de leurs différentes interactions entre eux et surtout de l'écriture / lecture dans un fichier .csv des scores des gagnants de chaque partie de Puissance 4, que ce soit contre une IA ou en joueur contre joueur.
`enregistrer(nom,score)` sert à, comme son nom l'indique, enregistrer un score et le nom associé dans le fichier `top10.csv`. Cette méthode séparera les deux chaînes de caractères d'un ";" afin de pouvoir les séparer plus facilement à l'aide d'une regex lorsqu'on voudra retourner le top 10 grâce aux méthodes suivantes.

`creerListe()` et `listeOrdre()` sont deux méthodes qui serviront à renvoyer une liste de chaînes de caractères pour but de les afficher plus tard. `creerListe()` crééra une liste constituée des lignes du fichier `top10.csv` où chaque élément sera délimité à partir d'un ";" ou par un passage à la ligne suivante. La méthode crééra ensuite des objets de type "Joueur" et "Score" où l'on stockera nom et score dans chacun des objets et où l'on ajoutera ces-derniers dans la liste. `listeOrdre()`, elle, servira à ordonner la liste créée via `creerListe()` dans l'ordre croissant de tous les scores et des joueurs y étant attachés.

`afficherListe()` permettra d'appeler la liste une fois ordonnée par la méthode `listeOrdre()` et d'afficher les éléments un à un en les mettant dans le contexte du top. Soit : "[place du joueur] - [nom du joueur] : [score du joueur]".
Si la liste est vide, la méthode affichera "Aucun score enregistré", et si la taille de la liste est inférieure à dix, elle affichera : "Top [longueur de la liste] des meilleurs scores :". Autrement, elle n'affichera tout le temps que les 10 meilleurs scores.

[Fonctionnalité supplémentaire] `supprListe()` est une méthode qui permet de récupérer le fichier `top10.csv`, de le supprimer, et d'en créer un nouveau du même nom; en somme, il permet de réinitialiser la liste.



## IA

Tristan c'est ensuite occupé de la partie IA, en reprenant la méthode `modif` il a au début fait une autre méthode `IAmodif` qui prends en paramètre `ArrayList<ArrayList<String>> g, String symbole` ce qui est exactement la même chose que pour `modif` sauf que le message a été retiré car l'IA au niveau 1 cherche seulement une colonne aléatoire pour placer son pion.

Par la suite il a fait l'IA niveau 2, il nous était demandé de bloquer le prochain coup du joueur si celui-ci lui permet de gagner ainsi il a fait une méthode `anticipation(ArrayList<ArrayList<String>> g, String symbole, String symbole2)` ici symbole est le symbole du joueur et symbole2 est celui de l'IA. Cette méthode est ici pour parcourir le tableau et regarde si 3 symboles du joueur sont alignés, si c'est le cas alors elle renvoie la colonne du point à jouer. Ensuite la méthode `IAmodif2` a été créée, c'est la même chose que pour `IAmodif` sauf qu'il y a une condition pour choisir si il doit bloquer le joueur de jouer ou jouer un pion aléatoirement.

Ensuite il a fait une méthode `checkWin` pour vérifier si quelqu'un a gagn2 et si oui elle retourne true ce qui arrête le jeu tout en mettant un message pour savoir qui a gagné.

La méthode permettant de faire l'ia niveau 3 a été faite par Tristan et Ethan, elle marche comme pour celle de l'ia niveau 2 mais elle est un peu plus poussée, si trois pions sont alignés, peu importe l'ordre et comment elle va les bloquer, elle regarde seulement si la ligne est supérieure ou égal à 1 alors elle regarde la ligne du dessous 3 colonnes plus loin en avant ou en arrière si elle est différentes de "-" qui ici représente une case vide, si elle est vide elle ne va pas placer le pion ici mais autre part.

Pour finir on à la méthode `Anticipationniv3` qui est un copié collé de l'anticipation niv2 sauf que certaines conditions sont supprimées et qu'on inverse les 2 symboles, pour ne pas vérifier si le joueur peut gagner mais l'ia et retourne la colonne à jouer.

Enfin nous avons la méthode `checkWinIA` qui est la même chose que le checkWin mais pour l'ia et elle retourne true ou false

Par la suite nous avons mis dans IA.java la méthode `IAmodif4` qui est la méthode appelée pour jouer le coup de l'ia, si le `checkWinIA` est vrai alors la méthode le coup jouer sera le résultat de l'Anticipationniv3 sinon si le résultat de la méthode `anticipationniv2` est différent de -1 alors la colonne jouer est le résultat de anticipation niv2 sinon c‘est une colonne aléatoire.

## Menu et rythme du jeu

Ethan s'est occupé d'intégrer les fonctions de ses camarades et de les faire marcher en tandem dans un fichier `Game.java` pour créer un jeu fonctionnel.
Il a créé les classes et a pris en charge leurs intégrations dans le projet.

## Couleur

La classe `Couleur.java` a d'abord été créée par Amin, puis ensuite utilisée par Ethan pour créer les fonctions de changement de couleurs dans les paramètres (`Couleur.changeColors(J)`) ainsi qu'en fin de partie (`Grid.checkWin()`). Les variables de la classe couleurs sont des Strings définis de manière finale contenant les codes couleurs reconnus par le terminal de Java. Les fonctions de changement de couleurs entourent donc les symboles et les noms des Joueurs lors de leur initialisation pour ne pas avoir à répéter le code couleur à chaque appel du symbole ou du nom.