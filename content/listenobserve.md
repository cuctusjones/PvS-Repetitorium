#Listener und Observer



##Observer Pattern
Wir erl�utern das Observer-Pattern anhand des PvS-Repetitoriums. 

In diesem beispiel sind die Tutoren, welche das Rep halten die Erz�hler und berichten von wichtigen Themen im Stoff von Programmierung von Systemen. Die Zuh�rer, also ale Studenten im H�rsaal, sind diejenigen, welche sich f�r den Stoff interessieren und aufmerksam zuh�ren. Wir nennen die Tutoren jetzt Observable (beobachtbar) und die Studenten Observer(Beobachter).

Unser Beispiel mit den Erz�hlern und Zuh�rern k�nnen wir auf Datenstrukturen �bertragen. Die Datenstruktur l�sst sich beobachten und wird zum Beobachteten. Sie wird in Java als Exemplar der Bibliotheksklasse Observable repr�sentiert. Der Beobachter wird durch die Schnittstelle Observer abgedeckt und ist der, der informiert werden will, wenn sich die Datenstruktur �ndert.

###Observer-Pattern: Push-Variante



###Observer-Pattern: Pull-Variante



##Listener



###ActionListener



###MouseListener



###MouseMotionListener
