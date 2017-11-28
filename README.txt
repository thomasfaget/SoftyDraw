SoftyDraw

Berthet Maxime
Faget Thomas


 ----- Pr�sentation de l'application -----

Notre application permet de r�aliser de petits dessins, en coloriant directement en touchant l'�cran.
La particularit� de notre application est de g�rer le Multitouch, permettant de dessiner avec plusieurs doigts.
En fait, en touchant l'�cran avec deux doigts, on trace une ligne entre les deux doigts. Si on touche l'�cran avec trois doigts, on trace un rectangle.
De plus, si par exemple on a plac� deux doigts plac�s sur l'�cran et que l'on d�place ces doigts, nous allons prolonger cette ligne et cr�er un rectangle.
On peut donc r�aliser toute sorte de forme gr�ce � cette application.


Nous avons aussi incorpor� une palette de couleur configurable, ainsi qu'une barre d'outils permettant de changer les options de dessin.

La palette permet de changer la couleur utilis� pour dessiner.
Il suffit alors de selectionner une couleur pour changer celle utilis� pour dessiner.
En appuyant longuement sur une couleur, on peut aussi configuer la couleur du bouton.

La barre d'outils poss�dent 5 boutons :
	- Un bouton pour ajouter une couleur dans la palette
	- Un pour changer la taille du pinceau
	- Un gomme
	- Un bouton "nouveau" pour effacer le dessin en cours
	- un boutton pour suavegarder le dessin dans le t�l�phone


 -- Templates utilis�s --

Nous avons r�-utilis� deux templates pour ce projet :
	- Un tutoriel pour cr�er une Drawing App (https://code.tutsplus.com/tutorials/android-sdk-create-a-drawing-app-essential-functionality--mobile-19328)
	- colorpicker, un outil permettant de choisir une couleur (https://github.com/chiralcode/Android-Color-Picker)

Pour le tutoriel, nous avons utiliser les m�thodes permettant de gommer, changer la taille de pinceau, sauvegarder et cr�er un nouveau dessin. 
Nous nous sommes aussi inspir� de la m�thode utilis�e pour dessiner sur l'�cran (le OnTouchListener).
Nous avons n�anmoins refait compl�tement le design de l'application (propos� par le tutoriel).
On a aussi modifi� le "OnTouchListener" pour l'adapter dans le cadre de notre application.

Concernant l'outil colorpicker, nous avons utilis� uniquement les classes permettant de choisir une couleur via une boite de dialogue, sans les modifier.