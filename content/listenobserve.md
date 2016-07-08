#Listener und Observer



##Observer Pattern
###Das Beobachter-Muster
Wir erl�utern das Observer-Pattern anhand des PvS-Repetitoriums. 

In diesem Beispiel sind die Tutoren (*wir*) die Erz�hler und erkl�ren den Stoff von Programmierung von Systemen. Die Zuh�rer (*ihr*) seid diejenigen, welche sich f�r den Stoff interessieren und aufmerksam zuh�ren. Wir nennen die Tutoren jetzt Observable (beobachtbar) und die Studenten Observer(Beobachter).

Solange ein Observable einen oder mehrere Observer hat erz�hlt er, sendet also Mitteilungen. Wenn allerdings kein Observer dem Observable zuh�rt, dann schweigt er auch. 

Die Observer sind vielleicht nicht immer am Stoff interessiert, dann k�nnen sie sich beim Observer abmelden und bekommen keine neuen Nachrichten.
Sollten neue Observer hinzu kommen, k�nnen sich diese beim Observable anmelden und werden auch informiert.



###Beispiel: Die Push Variante
![Observer](content/images/Observer_Push.svg)



Unser Beispiel mit den Erz�hlern und Zuh�rern k�nnen wir auf Datenstrukturen �bertragen. Die Datenstruktur l�sst sich beobachten und wird zum Beobachteten. Sie wird in Java als Exemplar der Bibliotheksklasse Observable repr�sentiert. Der Beobachter wird durch die Schnittstelle Observer abgedeckt und ist der, der informiert werden will, wenn sich die Datenstruktur �ndert.



###Observer-Pattern: Push-Variante



###Observer-Pattern: Pull-Variante



##Listener



###ActionListener



###MouseListener



###MouseMotionListener
