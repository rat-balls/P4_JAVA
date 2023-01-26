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