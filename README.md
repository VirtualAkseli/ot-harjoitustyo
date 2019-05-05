# SudokuNow
Se tuttu ja turvallinen Sudoku, pienillä lisämausteilla. Lopullisessa versiossa pelaaja voi pelata valmiita sudokuja ja 
tallentaa omia pohjiaan.
## Dokumentointi
- [Käyttöohje](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md
"Käyttöohje")
- [Vaatimusmäärittely](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md "Vaatimusmäärittely")
- [Arkkitehtuurikuvaus](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md "Arkkitehtuurikuvaus")
- [Työaikakirjanpito](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md "Työaikakirjanpito")

## Releaset

- [Viikko 5](https://github.com/VirtualAkseli/ot-harjoitustyo/releases/tag/viikko5 "Viikko 5 Release")
- [Viikko 6](https://github.com/VirtualAkseli/ot-harjoitustyo/releases/tag/viikko6 "Viikko 6 Release")
-[Final](https://github.com/VirtualAkseli/ot-harjoitustyo/releases/tag/Final "Final Release")

## Komentorivitoiminnot

### Suoritus

Ohjelma on paketoitavissa -jar muotoon komennolla

```
mvn package
```

.jar on suoritettavissa komennolla

```
java -jar sudokuNow-1.0-jar-with-dependencies.jar
```

Ohjelma on suoritettavissa komennolla

```
mvn compile exec:java -Dexec.mainClass=sudokuNow.ui.SudokuUI
```

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn test jacoco:report
```

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/SudokuNow/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Virheilmoitukset löytyvät tiedostosta _target/site/checkstyle.html_ 


