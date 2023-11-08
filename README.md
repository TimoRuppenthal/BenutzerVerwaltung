# Motivation
Ein Projekt um die Grundlagen der Software-Entwicklung zu lernen.
Dieses Projekt soll folgende Funktionalität anbieten: 
* Hinzufügen eines Benutzers in die Benutzerverwaltung
* Löschen eines Benutzers aus der Benutzerverwaltung
* Alle Benutzer aus der Benutzerverwaltung abfragen können
* Die BenutzerDaten eines Benutzers können aktualisiert werden

[User-Story Benutzer registrieren]Als Accountmanager möchte ich, dass ein neuer Kunde sich bei der BenutzerVerwaltung registrieren muss, damit ich die Möglichkeit habe die Registrierungsdaten automatisiert zu verifizieren.
* Bei der Registrierung muss eine gültige E-Mail-Adresse und Benutzerdaten angegeben werden.
* Es wird eine UUID an die angegebene E-Mail-Adresse verschickt
* Zahlencode muss zusammen mit der E-Mail-Adresse übergeben werden, damit der Benutzer in die Benutzerverwaltung hinzugefügt wird
* Der Zahlencode verliert nach 24 Stunden seine Gültigkeit

Abbildung auf DDD Mustersprache und Klassen
ApplicationService: BenutzerVerwaltung
    Neue Methoden: registriere und verifiziere
ValueObject: E-Mail-Adresse, Benutzerdaten, VerifizierungsCode
Aggregate: RegistrierungsDaten
Repository: RegistrierungsDatenRepository
DomainEvent: VerifizierungsCodeVerschickt

