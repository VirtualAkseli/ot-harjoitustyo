# SudokuNow
Se tuttu ja turvallinen Sudoku, pienillä lisämausteilla. Lopullisessa versiossa pelaaja voi pelata valmiita sudokuja ja 
tallentaa omia pohjiaan.
## Dokumentointi
- [Vaatimusmäärittely](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md "Vaatimusmäärittely")
- [Arkkitehtuurikuvaus](https://github.com/VirtualAkseli/ot-harjoitustyo/edit/master/dokumentointi/arkkitehtuuri.md "Arkkitehtuurikuvaus")
- [Työaikakirjanpito](https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md "Työaikakirjanpito")

## Komentorivitoiminnot

### Suoritus

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


