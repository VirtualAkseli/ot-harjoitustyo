# SudokuNow
Se tuttu ja turvallinen Sudoku, pienillä lisämausteilla. Lopullisessa versiossa pelaaja voi pelata valmiita sudokuja ja 
tallentaa omia pohjiaan.
## Dokumentointi
- [Vaatimusmäärittely](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md "Vaatimusmäärittely")
- [Arkkitehtuurikuvaus](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md "Arkkitehtuurikuvaus")
- [Työaikakirjanpito](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md "Työaikakirjanpito")


## Releaset

- [Viikko 5](https://github.com/VirtualAkseli/ot-harjoitustyo/releases/tag/viikko5 "Release viikko 5")

## Komentorivitoiminnot

### Suoritus

Suoritettavan jarin generointi komennolla

```
mvn package
```

.jar suoritus

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


