# PUISSANCE 4 JAVA

## Pour commencer
Le projet consiste à réalisé un Puissance 4 fonctionel en Java avec quelques fonctionnalités supplémentaires et une IA avec plusieurs difficultés.

## Structure du dossier

le projet contiens 3 dossiers:
- `bin`: où se trouve les méta données 
- `src`: contient tout le code, les fonctions et les classes

dans `src/model` se trouve tout les fonctions qui permetent au programme de gérer l'affichage, la customisation, le logger etc.

## Equipe:

Tristan Turgy (Scrum master)<br>
Ethan Delalande (Développeur)<br>
Sasha Harel (Développeur)<br>
Amin Kassiev (Développeur)<br>

## Fonctions:

Un puissance 4 étant simplement un tableau à petits disques qui est soumis au lois de la gravité, on a déduit qu'il fallait faire en code un tableau à deux matrices (tab [[][][]...]) de 7 x 6 cases.<br>
src/model/Grid :      `createGrid()` <br>
Une fonction qui ne prends rien en paramètres et qui renvoie ArrayList<ArrayList<String>> (une liste de listes cotenant des chaîne de caractères. Ce code à était fait par Amin et Ethan. Il s'agit là de faire une double boucle for pour faire une tableau replis de liste qui ont tous comme variable un tiret du 6 
`"-"` .<br>
  

Pour afficher ce tableau vide, Amin s'est occupé de l'affichage.<br>
`affichage (ArrayList<ArrayList<String>> g)`<br>
Cette fonction prends en paramètre la liste que créer la fonction plus haut, elle la parcours en faisant des System.out.println() à chaque ligne. Donnant un tableau resseblant à cela quand il est vide:
`  1   2   3   4   5   6   7  ` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`| -   -   -   -   -   -   - |` <br>
`|---------------------------|` <br>

Pour apporter des modifications à la grille Amin écrit les bases d'une modifications (ajout de pions) qui vont être réutilisé à plusieurs réprises dans d'autres Classes. <br>
`modif(ArrayList<ArrayList<String>> g, String message, String symbole)`<br>
Comme pour `affichage()`, `modif()`prends en paramètres : une grille. Mais aussi un message et un symbole, le message correspond au message d'erreur en cas de mauvais input (pas un chiffre, chiffre négatif, chiffre trop grand), et symbole qui correspond à l'apparence du pion. La fonction par cours la grille avec 2 boucles for, remplace libre de la colone designer par le jour avec son symbole.

## IA

Tristan c'est ensuite occupé de la partie IA, en reprenant la méthode `modif` il a au début fait une autre méthode `IAmodif` qui prends en paramètre `ArrayList<ArrayList<String>> g, String symbole` ce qui est exactement la même chose que pour `modif` sauf que le message a été retiré car l'IA au niveau 1 cherche seulement une colonne aléatoire pour placer son pion.

Par la suite il a fait l'IA niveau 2, il nous était demander de bloquer le prochain coup du joueur si celui-ci lui permet de gagner ainsi il a fait une méthode `anticipation(ArrayList<ArrayList<String>> g, String symbole, String symbole2)` ici symbole est le symbole du joueur et symbole2 est celui de l'IA. Cette méthode est ici pour parcourir le tableau et regarde si 3 symboles du joueur sont alignés, si c'est le cas alors elle renvoie la colone du point à jouer. Ensuite la méthode `IAmodif2` a été crée, c'est la même chose que pour `IAmodif` sauf qu'il y a une condition pour chosir si il doit bloquer le joueur de jouer ou jouer un pion aléatoirement.

Ensuite il a fait une méthode `checkWin` pour verifier si quelqu'un a gagner et si oui elle retourne true ce qui arrete le jeu tout en métant un message pour savoir qui a gagner

La méthode permettant de faire l'ia niveau 3 a été faite par Tristan et Éthan, elle marche comme pour celle de l'ia niveau 2 mais elle est un peu plus poussé, si trois pion sont peu importe l'ordre, et comment elle va les bloquer et elle regarde seulement si la ligne est supérieur ou égal à 1 alors elle regarde la ligne du dessous 3 colonnes plus loin en avant ou en arrière si elle est diffèrentes de "-" qui ici représente une case vide, si elle est vide elle ne va pas placer le pion ici mais autre part.

Pour finir on à la méthode `Anticipationniv3` qui est un copier collé de l'anticipation niv2 sauf que certaines conditions sont supprimées et qu'on inverse les 2 symboles, pour ne pas vérifier si le joueur peut gagner mais l'ia et retourne la colonne à jouer.

Enfin nous avons la méthode `checkWinIA` qui est la même chose que le checkWin mais pour l'ia et elle retourne true ou false

Par la suite nous avons mis dans IA.java la méthode `IAmodif4` qui est la méthode appelé pour jouer le coup de l'ia, si le `checkWinIA` est vrai alors la méthode le coup jouer sera le résultat de l'Anticipationniv3 sinon si le résultat de la méthode `anticipationniv2` est différent de -1 alors la colonne jouer est le résultat de anticipation niv2 sinon c‘est une colonne aléatoire.