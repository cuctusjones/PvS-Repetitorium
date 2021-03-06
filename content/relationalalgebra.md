# Relationale Algebra



Wikipedia:
>*In der Theorie der Datenbanken versteht man unter einer Relationenalgebra oder einer relationalen Algebra eine _**formale Sprache**_, mit der sich Abfragen über einem relationalen Schema formulieren lassen.<br/><br/> Sie erlaubt es, Relationen miteinander zu verknüpfen oder zu reduzieren und komplexere Informationen daraus herzuleiten.*



## Operationen
Bei allen Operationen handelt es sich immer um Mengenoperationen.

Hierzu zählen beispielsweise:
* Vereinigung
* Schnitt
* Differenz
* Kreuzprodukt
* Projektion
* Selektion
* Join



![Union](content/images/Union.svg)



![Intersect](content/images/Intersect.svg)



![Relative_complement](content/images/Relative_complement.svg)



![Cross_product](content/images/Cross_product.svg)



![Projection](content/images/Projection.svg)



![Selection](content/images/Selection.svg)



![Join](content/images/Join.svg)



![Equi-Join](content/images/Equi-Join.svg)



![Natural Join](content/images/Natural_Join.svg)



![Semi Join](content/images/Semi_Join.svg)



![Outer Join](content/images/Outer_Join.svg)



![Rename](content/images/Rename.svg)



Ein Beispiel:

* Zwei Alternativen
  1. &pi;<sub style="font-size:20px;">KdNr, KdName</sub> (&sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> Kunden)
  2. &sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> (&pi;<sub style="font-size:20px;">KdNr, KdName</sub> Kunden)
* Eine der beiden Alternativen führt nicht zum gewünschten Ergebnis

* Welche?

* Warum?
Note: Ergebnis unten



Ein Beispiel:

* Zwei Alternativen
  1. &pi;<sub style="font-size:20px;">KdNr, KdName</sub> (&sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> Kunden)
  2. &sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> (&pi;<sub style="font-size:20px;">KdNr, KdName</sub> Kunden)
* Eine der beiden Alternativen führt nicht zum gewünschten Ergebnis

* Welche? Nr 2

* Warum? Weil die Kundenstadt beim Auswerten der Selektion nicht mehr existiert.



## Aufgabe
Gegeben seien die folgenden Relationenschemata:

|Mensa|||
|---|---|---|
|MensaID|GerichtID|Sitzplätze|

|Gericht||||
|---|---|---|---|
|GerichtID|Name|Preis|Menge|

|Zutaten|||
|---|---|---|
|ZutatID|GerichtID|Name|

--------

Gib die Algebra-Ausdrücke für die folgenden Anfragen an:
1. Gib die Namen und Preise aller Gerichte aus
4. Gib die Preise der Gerichte aus, die in der Mensa mit 530 Sitzplätzen angeboten werden.
3. Gib die Sitzplätze aller Mensen aus, die mit Fisch kochen
2. Gib alle Zutaten aus, die für das Gericht *Gut & Günstig* bestellt werden müssen, aber nicht für das Gericht *Lecker & Fein*



## Lösungsvorschlag
|Mensa|||
|---|---|---|
|MensaID|GerichtID|Sitzplätze|

|Gericht||||
|---|---|---|---|
|GerichtID|Name|Preis|Menge|

|Zutaten|||
|---|---|---|
|ZutatID|GerichtID|Name|

--------

1. &pi;<sub style="font-size:20px;">{Name,Preis}</sub>Gericht
2. &pi;<sub style="font-size:20px;">{Preis}</sub>Gericht &#10781;<sub style="font-size:20px;">{GerichtID}</sub>(&sigma;<sub style="font-size:20px;">{Sitzplätze = 530}</sub>Mensa)
3. &pi;<sub style="font-size:20px;">{Sitzplätze}</sub>Mensa &#10781;<sub style="font-size:20px;">{GerichtID}</sub> (Gericht &#10781;<sub style="font-size:20px;">{ZutatID}</sub> (&sigma;<sub style="font-size:20px;">{Zutaten.Name = Fisch}</sub>Zutaten))
4. &pi;<sub style="font-size:20px;">{Name}</sub>Zutaten &#10781;<sub style="font-size:20px;">{GerichtID}</sub> (&sigma;<sub style="font-size:20px;">{Gericht.Name = Gut & Günstig}</sub>Gericht) - &pi;<sub style="font-size:20px;">{Name}</sub>Zutaten &#10781;<sub style="font-size:20px;">{GerichtID}</sub> (&sigma;<sub style="font-size:20px;">{Gericht.Name = Lecker & Fein}</sub>Gericht)



## Aufgabe
Gegeben seien die folgenden Relationenschemata:

|Teile||||
|---|---|---|---|
|TNR|Name|Preis|Bestand|

|Lieferant|||
|---|---|---|
|LiefNr|LiefName|LiefStadt|

|Bestellung|||
|---|---|---|
|TNR|LiefNr|KdNr|

|Kunde|||
|---|---|---|
|KdNR|KdName|KdStadt|

--------

Gib die Algebra-Ausdrücke für die folgenden Anfragen an:
1. Gib alle Namen der Teile aus, deren Bestand kleiner gleich 5 ist.
2. Gib alle Städte aus, in denen ein Kunde wohnt oder ein Lieferant seinen Firmensitz hat.
3. Gib alle Namen der Kunden aus, die nicht gleichzeitig auch Lieferanten sind.
4. Gib den Namen und die Stadt aller Lieferanten aus, bei denen keine Bestellungen vorliegen.
5. Gib alle Namen von Teilen, die von einem Kunden aus Ulm beim Lieferanten ’Rapp’ bestellt wurden.
6. Gib die Namen aller Teile, bei denen der Kunde und Lieferant in der gleichen Stadt sind.



## Lösungsvorschlag
|Teile||||
|---|---|---|---|
|TNR|Name|Preis|Bestand|

|Lieferant|||
|---|---|---|
|LiefNr|LiefName|LiefStadt|

|Bestellung|||
|---|---|---|
|TNR|LiefNr|KdNr|

|Kunde|||
|---|---|---|
|KdNR|KdName|KdStadt|

--------

1. &pi;<sub style="font-size:20px;">{Name}</sub>(&sigma;<sub style="font-size:20px;">{Bestand<=5}</sub>Teile)
2. &pi;<sub style="font-size:20px;">{LiefStadt}</sub>Lieferant &#x222a; &pi;<sub style="font-size:20px;">{KdStadt}</sub>(Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.KdNr = Kunde.KdNr}</sub> Kunde)
3. &pi;<sub style="font-size:20px;">{Name:KdName}</sub>Kunde − &pi;<sub style="font-size:20px;">{Name:LiefName}</sub>Lieferant
4. &pi;<sub style="font-size:20px;">{LiefName, LiefStadt}</sub>Lieferant − &pi;<sub style="font-size:20px;">{LiefName, LiefStadt}</sub>(Lieferant &#10781;<sub style="font-size:20px;">{Lieferant.LiefNr = Bestellung.LiefNr}</sub> Bestellung)
5. &pi;<sub style="font-size:20px;">{Name}</sub>(Teile &#10781;<sub style="font-size:20px;">{Teile.TNR = Bestellung.TNR}</sub> (&sigma;<sub style="font-size:20px;">{KdStadt = ’Ulm’ ^ LiefName = ’Rapp’}</sub>
((Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.LiefNr = Lieferant.LiefNr}</sub> Lieferant) &#10781;<sub style="font-size:20px;">{Bestellung.KdNr = Kunde.KdNr}</sub> Kunde)))
6. &pi;<sub style="font-size:20px;">{Name}</sub>(Teile &#10781;<sub style="font-size:20px;">{Teile.TNR = Bestellung.TNR}</sub> (Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.LiefNr = Lieferant.LiefNr ^ Bestellung.KdNr = Kunde.KdNr}</sub>
(Lieferant &#10781;<sub style="font-size:20px;">{LiefStadt = KdStadt}</sub> Kunde)))



# Normalformen & Anomalien
Die Normalisierung eines relationalen Datenbankschemas hat den Zweck, Redundanzen zu verringern und dadurch verursachte Anomalien zu verhindern, um so die Aktualisierung einer Datenbank zu vereinfachen sowie die Konsistenz der Daten zu gewährleisten.



Zu diesem Zweck gibt es die Normalformen, welche erreicht werden, wenn bestimmte Normalisierungsregeln eingehalten werden.



## Vorgehen
![Normalisierung](content/images/Vorgehen_3NF.png)



## Beispiel

Primärschlüssel ist CD_ID

<div style="font-size:20px;">

| *CD_ID* | Album                                  | Erscheinungsjahr | Titel                                                  |
|     --- | ---                                    |              --- | ---                                                    |
|       1 | Michael Jackson - Thriller             |             1982 | {1. Baby Be Mine, 2. The Girl Is Mine, 3. Thriller }   |
|       2 | AC/DC - Back in Black                  |             1980 | {1. Hells Bells, 2. Shoot to Thrill, 3. Back in Black} |
|       3 | Pink Floyd - The Dark Side of the Moon |             1973 | {1. Speak to Me, 2. On the Run}                        |

### 1. NF verletzt! (Album, Titel) nicht atomar!



### Jetzt in 1. Normalform 

Primärschlüssel ist jetzt CD_ID **und** Track, da auf einer CD nicht zwei mal Track 1.

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret       | Geburtsjahr | *Track* | Titel            |
|     --- | ---                       | ---             |         --- |     --- | ---              |
|       1 | Thriller                  | Michael Jackson |        1982 |       1 | Baby Be Mine     |
|       1 | Thriller                  | Michael Jackson |        1982 |       2 | The Girl Is Mine |
|       1 | Thriller                  | Michael Jackson |        1982 |       3 | Thriller         |
|       2 | Back in Black             | AC/DC           |        1980 |       1 | Hells Bells      |
|       2 | Back in Black             | AC/DC           |        1980 |       2 | Shoot to Thrill  |
|       2 | Back in Black             | AC/DC           |        1980 |       3 | Back in Black    |
|       3 | The Dark Side of the Moon | Pink Floyd      |        1973 |       1 | Speak to Me      |
|       3 | The Dark Side of the Moon | Pink Floyd      |        1973 |       2 | On the Run, Time |



### 2. NF verletzt!

Album, Interpret, Erscheinungsjahr hängen von CD_ID ab, Titel nicht. Titel ist aber Schlüssel!

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret           | Geburtsjahr | *Track* | Titel            |
|     --- | ---                       | ---                 |         --- |     --- | ---              |
|       1 | **Thriller**              | **Michael Jackson** |    **1982** |       1 | Baby Be Mine     |
|       1 | **Thriller**              | **Michael Jackson** |    **1982** |       2 | The Girl Is Mine |
|       1 | **Thriller**              | **Michael Jackson** |    **1982** |       3 | Thriller         |
|       2 | Back in Black             | AC/DC               |        1980 |       1 | Hells Bells      |
|       2 | Back in Black             | AC/DC               |        1980 |       2 | Shoot to Thrill  |
|       2 | Back in Black             | AC/DC               |        1980 |       3 | Back in Black    |
|       3 | The Dark Side of the Moon | Pink Floyd          |        1973 |       1 | Speak to Me      |
|       3 | The Dark Side of the Moon | Pink Floyd          |        1973 |       2 | On the Run, Time |



### Jetzt in 2. Normalform

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret       | Geburtsjahr |
|     --- | ---                       | ---             |         --- |
|       1 | Thriller                  | Michael Jackson |        1982 |
|       2 | Back in Black             | AC/DC           |        1980 |
|       3 | The Dark Side of the Moon | Pink Floyd      |        1973 |
|       4 | Highway to Hell           | AC/DC           |        1980 |

| *CD_ID* | *Track* | Titel            |
|     --- |     --- | ---              |
|       1 |       1 | Baby Be Mine     |
|       1 |       2 | The Girl Is Mine |
|       1 |       3 | Thriller         |
|       1 |       1 | Hells Bells      |
|       2 |       2 | Shoot to Thrill  |
|       2 |       3 | Back in Black    |
|       3 |       1 | Speak to Me      |
|       3 |       2 | On the Run, Time |



### 3. NF verletzt

Interpret einer CD lässt sich über CD_ID bestimmen. Das Geburtsjahr hängt aber vom Interpreten ab. Beides sind keine Schlüssel.

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret       | Geburtsjahr |
|     --- | ---                       | ---             | ---         |
|       1 | Thriller                  | Michael Jackson | 1982        |
|       2 | Back in Black             | **AC/DC**       | **1980**    |
|       3 | The Dark Side of the Moon | Pink Floyd      | 1973        |
|       4 | Highway to Hell           | **AC/DC**       | **1980**    |

| *CD_ID* | *Track* | Titel            |
|     --- |     --- | ---              |
|       1 |       1 | Baby Be Mine     |
|       1 |       2 | The Girl Is Mine |
|       1 |       3 | Thriller         |
|       2 |       1 | Hells Bells      |
|       2 |       2 | Shoot to Thrill  |
|       2 |       3 | Back in Black    |
|       3 |       1 | Speak to Me      |
|       3 |       2 | On the Run, Time |



### Jetzt in 3. Normalform

Titel Tabelle wie oben.

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret_ID |
|     --- | ---                       |          --- |
|       1 | Thriller                  |            1 |
|       2 | Back in Black             |            2 |
|       3 | The Dark Side of the Moon |            3 |
|       4 | Highway to Hell           |            2 |

| Interpret_ID | Interpret       | Geburtsjahr |
|          --- | ---             |         --- |
|            1 | Michael Jackson |        1982 |
|            2 | AC/DC           |        1980 |
|            3 | Pink Floyd      |        1973 |



## Anomalien



### Insertion Anomalie
Beim Einfügen von Daten in eine Datenbank spricht man von einer Einfüge-Anomalie, wenn ein neues Tupel in die Relation nicht oder nur schwierig eingetragen werden kann, weil nicht zu allen Attributen des Primärschlüssels Werte vorliegen.



### Beispiel
|Kennzeichen|Hersteller|Vorname|Nachname|
|---|---|---|---|
|K-KJ 321|VW|Peter|Schmidt|
|H-CH 333|Audi|Fritz|Schneider|
|B-MD 321|BMW|Max|Maier|
|B-MD 321|BMW|Tom|Lehmann|
|A-BC 123|Škoda| ?| ?|
|A-BC 123|Škoda| ?| ?|

In dieser Tabelle wird für Fahrzeuge der jeweilige Fahrer angegeben. Die Attribute Kennzeichen und Nachname seien Identifikationsschlüssel. Hier treten Einfügeanomalien auf, wenn ein neues Fahrzeug eingefügt werden soll, aber noch kein Fahrer bestimmt wurde.



### Update Anomalie
Beim Ändern von Daten in einer Datenbank spricht man von einer Änderungs-Anomalie, wenn nicht alle (redundanten) Vorkommen eines Attributwert zugleich geändert werden. Dieses führt zu inkonsistenten Daten.



### Beispiel
|Kennzeichen|Hersteller|Farbe|Vorname|Nachname|
|---|---|---|---|
|K-KJ 321|VW|Blau|Peter|Schmidt|
|H-CH 333|Opel|Rot|Fritz|Schneider|
|B-MD 321|BMW|Schwarz|Max|Maier|
|B-MM 473|Peugeot|Grün|Max|Maier|

Es wird in dieser Tabelle davon ausgegangen, dass die Erwähnungen von „Max Maier“ für ein und dieselbe Person gelten. Wird der Name „Maier“ in „Meier“ geändert, muss dieses an zwei Stellen geschehen. Geschieht dieses nicht, spricht man von einer Update-Anomalie.



### Delete Anomalie
Eine Lösch-Anomalie entsteht, wenn durch das Löschen eines Datensatzes mehr Informationen als erwünscht verloren gehen. Sie entsteht, wenn ein Datensatz mehrere unabhängige Informationen enthält. Durch das Löschen der einen Information wird dann auch die andere gelöscht, obwohl diese noch benötigt wird.



### Beispiel
|Kennzeichen|Hersteller|Farbe|Vorname|Nachname|
|---|---|---|---|
|K-KJ 321|VW|Blau|Peter|Schmidt|
|H-CH 333|Opel|Rot|Fritz|Schneider|
|B-MD 321|BMW|Schwarz|Max|Maier|

Hier kann das Fahrzeug B-MD 321 nicht gelöscht werden, ohne den Fahrer ebenfalls zu löschen.



Alle Anomalien können beseitigt werden, wenn die Relationen in 3 Normalform vorliegt.
