# Arkkitehtuurikuvaus
## Rakenne
Ohjelman rakenne tulee noudattamaan kolmitasoista kerrosarkkitehtuuria, kunhan tietokantatoiminnallisuus totetutuu. Tämänhetkinen pakkausrakenne:
<img src="https://raw.githubusercontent.com/VirtualAkseli/ot-harjoitustyo/master/dokumentointi/arkkitehtuurikaavio.png" alt="Arkkitehtuurikuvaus" width="700">

Pakkauksessa sudokuNow.ui on JavaFX:llä toteutettu käyttöliittymä, sudokuNow.domain sisältää sovelluslogiikan, ja FileSudokuDao tiedostoon tallentamisesta vastaavan logiikan. 

Oheinen kaavio kuvaa syötteen käsittelyä ohjelmassa
<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/sequence_setSudoku.png?raw=true">

<img src="https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fdancesportlive.net%2Fdsl%2Fimages%2Funder_construction.gif&f=1">

## Käyttöliittymä
Work in progress

## Sovelluslogiikka 
Work in progress

## Tietojen pysyväistallennus
Tiedot tallennetaan save.xml tiedostoon "taulukkona", josta ne pelitilanteen ladatessa saadaan takaisin. 
