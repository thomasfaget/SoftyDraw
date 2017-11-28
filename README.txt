SoftyDraw

Berthet Maxime
Faget Thomas


 ----- Présentation de l'application -----

Notre application permet de réaliser de petits dessins, en coloriant directement en touchant l'écran.
La particularité de notre application est de gérer le Multitouch, permettant de dessiner avec plusieurs doigts.
En fait, en touchant l'écran avec deux doigts, on trace une ligne entre les deux doigts. Si on touche l'écran avec trois doigts, on trace un rectangle.
De plus, si par exemple on a placé deux doigts placés sur l'écran et que l'on déplace ces doigts, nous allons prolonger cette ligne et créer un rectangle.
On peut donc réaliser toute sorte de forme grâce à cette application.


Nous avons aussi incorporé une palette de couleur configurable, ainsi qu'une barre d'outils permettant de changer les options de dessin.

La palette permet de changer la couleur utilisé pour dessiner.
Il suffit alors de selectionner une couleur pour changer celle utilisé pour dessiner.
En appuyant longuement sur une couleur, on peut aussi configuer la couleur du bouton.

La barre d'outils possèdent 5 boutons :
	- Un bouton pour ajouter une couleur dans la palette
	- Un pour changer la taille du pinceau
	- Un gomme
	- Un bouton "nouveau" pour effacer le dessin en cours
	- un boutton pour suavegarder le dessin dans le téléphone


 -- Templates utilisés --

Nous avons ré-utilisé deux templates pour ce projet :
	- Un tutoriel pour créer une Drawing App (https://code.tutsplus.com/tutorials/android-sdk-create-a-drawing-app-essential-functionality--mobile-19328)
	- colorpicker, un outil permettant de choisir une couleur (https://github.com/chiralcode/Android-Color-Picker)

Pour le tutoriel, nous avons utiliser les méthodes permettant de gommer, changer la taille de pinceau, sauvegarder et créer un nouveau dessin. 
Nous nous sommes aussi inspiré de la méthode utilisée pour dessiner sur l'écran (le OnTouchListener).
Nous avons néanmoins refait complètement le design de l'application (proposé par le tutoriel).
On a aussi modifié le "OnTouchListener" pour l'adapter dans le cadre de notre application.

Concernant l'outil colorpicker, nous avons utilisé uniquement les classes permettant de choisir une couleur via une boite de dialogue, sans les modifier.