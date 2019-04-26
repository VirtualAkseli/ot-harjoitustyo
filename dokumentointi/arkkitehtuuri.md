# Arkkitehtuurikuvaus
## Rakenne
Ohjelman rakenne noudattaa kolmitasoista kerrosarkkitehtuuria. Tämänhetkinen pakkausrakenne:
<img src="https://raw.githubusercontent.com/VirtualAkseli/ot-harjoitustyo/master/dokumentointi/arkkitehtuurikaavio.png" alt="Arkkitehtuurikuvaus" width="700">

Pakkauksessa sudokuNow.ui on JavaFX:llä toteutettu käyttöliittymä, sudokuNow.domain sisältää sovelluslogiikan, ja FileSudokuDao tiedostoon tallentamisesta vastaavan logiikan. 



## Käyttöliittymä
Käyttöliittymä sisältää 2 erilaista näkymää
- uuden pelin valinta tai tallennustiedoston lataaminen
- pelin pelaaminen (mahdollisuus pelin tallentamiseen)

Em. tilat on totetutettu JavaFX Scene-olioina. Käyttöliittymä on rakennettu kokonaisuudessaan luokkaan SudokuNow.ui.SudokuUI

Kun käyttäjä syöttää sudokuun numeron, ohjelmakoodissa olevat EventListenerit huomaavat muutoksen ja tarkastavat lisäyksen oikeellisuuden ennen sen lisäämistä taulukkoon.

## Sovelluslogiikka 
Sovelluslogiikka muodostuu SudokuUI ja Sudoku -luokkien yhteispelistä. Kun käyttöliittymäkomponentti huomaa muutoksen, se kutsuu Sudoku-luokan tarkastusmetodia, jonka tarkastusten perusteella muodostetaan virheestä ilmoittava punainen ilmoitussymboli, jos taulussa on ristiriita. Tauluun lisääminen tapahtuu vasta tarkastusten jälkeen, sovelluslogiikan yksinkertaistamiseksi. Sudoku-luokka palauttaa taulukon, joka iteratiivisesti läpikäyden renderöidään uudestaan näkyviin pelaajalle.

## Tietojen pysyväistallennus
Pelitaulukon tiedot tallennetaan save.xml tiedostoon "taulukkona", josta ne pelitilanteen ladatessa saadaan takaisin. Pakkauksen SudokuNow.dao luokka FileSudokuDao vastaa tietojen pysyäistallentamisesta.
### Pelitilanteen (numerot ja pelikello) tallentaminen
Sovellus tallentaa pelin numerot ja pelatessa kuluneen ajan eri tiedostoihin.

## Päätoiminnallisuudet 
Seuraavissa kuvissa esitetään sekvenssikaavioina muutama keskeinen pelitoiminnallisuus
### Pelaajan syötteen käsittely TextField-oliossa
Oheinen kaavio kuvaa syötteen käsittelyä ohjelmassa
<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/sequence_setSudoku.png?raw=true">


## Ohjelman rakenteeseen jääneet heikkoudet
TBA
