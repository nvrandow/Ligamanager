# Modus (Vorgehensweise des Algorithmus)

* Dem der 1. Deutschen Bundesliga nachempfunden, eventuell abweichend bzw. Vereinfacht
* Mannschaften und Schiedsrichter der Saison 2011/12 (Bundesliga.ods)
* Anpfiff: Samstag 15:30 und 17:30, Sonntag 18:30 und 20:30

	## Einzelschritte

	1. Alle Kombinationen (Begegnungen) werden systematisch ermittelt
	2. Die Liste der Begegnungen wird zufällig umsortiert
	3. Mannschaft hat dieses Wochenende schon gespielt => Begegnung wird herausgekommen und am Ende eingefügt (Nachteil: wenn durch wenige Vereinen im Verhältnis zu Anpfiffzeiten unmöglich, unendliche Laufzeit; Passiert bei 18 Teams + 4 Zeiten jedoch nie)
	4. Schritt 3 wird wiederholt falls nachdem alle verbleibenden Möglichkeiten ausprobiert wurden ohne eine mögliche Lösung zu erhalten
	5. In der Hinrunde ist das Team1 Heimmahnschaft, im Anschluss (Rückrunde) jeweils Team2
	6. Schiedsrichter werden zufällig umsortiert; dann turnusmäßig Wiederholung der Liste

* Spielplan wird serialisiert und in "data.ser" gespeichert.
* Punktevergabe: *0* für Niederlage, *+1* für Unentschieden, *+3* für Sieg
* Vergleich: erst nach Punkten, dann nach Tordifferenz
* Test mit zufälligen Ergebnissen, Tore zwischen 0 und 4
