# Arkkitehtuurikuvaus
## Rakenne
Ohjelman rakenne noudattaa kolmitasoista kerrosarkkitehtuuria. Tämänhetkinen pakkausrakenne:
<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuurikuvaus.png?raw=true" alt="Arkkitehtuurikuvaus" width="700">

Pakkauksessa sudokuNow.ui on JavaFX:llä toteutettu käyttöliittymä, sudokuNow.domain sisältää sovelluslogiikan, ja SavingSudokuDao tiedostoon tallentamisesta ja lukemisesta vastaavan logiikan. 



## Käyttöliittymä
Käyttöliittymä sisältää 2 erilaista näkymää
- uuden pelin valinta tai tallennustiedoston lataaminen
- pelin pelaaminen (mahdollisuus pelin tallentamiseen)

Em. tilat on totetutettu JavaFX Scene-olioina. Käyttöliittymä on rakennettu kokonaisuudessaan luokkaan SudokuNow.ui.UI

Kun käyttäjä syöttää sudokuun numeron, ohjelmakoodissa olevat EventListenerit huomaavat muutoksen ja tarkastavat lisäyksen oikeellisuuden ennen sen lisäämistä taulukkoon.

## Sovelluslogiikka 
Sovelluslogiikka muodostuu UI ja SudokuMain -luokkien yhteispelistä. Kun käyttöliittymäkomponentti huomaa muutoksen, se kutsuu Sudoku-luokan tarkastusmetodia, jonka tarkastusten perusteella muodostetaan virheestä ilmoittava punainen ilmoitussymboli, jos taulussa on ristiriita. Tauluun lisääminen tapahtuu vasta tarkastusten jälkeen, sovelluslogiikan yksinkertaistamiseksi. SudokuMain-luokka palauttaa taulukon, joka iteratiivisesti läpikäyden renderöidään uudestaan näkyviin pelaajalle.

## Tietojen pysyväistallennus
Pelitaulukon tiedot tallennetaan save.xml tiedostoon "taulukkona", josta ne pelitilanteen ladatessa saadaan takaisin. Tallennushetkellä kulunut aika tallennetaan time.xml tiedostoon, ratkaisuun käytetty aika highscore.xml tiedostoon. Pakkauksen SudokuNow.dao luokka SavingSudokuDao vastaa tietojen pysyäistallentamisesta.

### Tallennustiedosto
Sovellus kirjoittaa .xml tiedostoihin hyvin yksinkertaista dataa, joka sitten muutetaan merkkijonoksi ja pilkotaan tulkitsemisessa vaadittaviin osiin. 
esim. rivillä `` |easy: 3,39|easy: 8,32|easy: 4,4|easy: 1,23|easy: 0,50|easy: 0,47|easy: 0,44|easy: 0,43 ``
lukevat suoritustyypit ja ajat tiedostoon kirjoitetussa muodossa.

### Pelitilanteen (numerot ja pelikello) tallentaminen
Sovellus tallentaa pelin numerot ja pelatessa kuluneen ajan eri tiedostoihin.

## Päätoiminnallisuudet 
Seuraavissa kuvissa esitetään sekvenssikaavioina muutama keskeinen pelitoiminnallisuus
### Pelaajan syötteen käsittely TextField-oliossa
Oheinen kaavio kuvaa syötteen käsittelyä ohjelmassa (HUOM. Sudoku = SudokuMain, SudokuUI = UI)
<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/sequence_setSudoku.png?raw=true">

Alla oleva kaavio kuvaa "Check" painikkeen painamisen jälkeiset tapahtumat
<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/_Check_%20-painikkeen%20painaminen%20(3).png?raw=true">

## Ohjelman rakenteeseen jääneet heikkoudet
Ohjelmassa on muutama bugi.
- Lista parhaista tuloksista tulostuu kahteen kertaa pelin valmistuttua
- Jos merkin laittaa väärään paikkaan, ja tekee muutoksen muualle, alkuperäinen virhemerkki "unohtuu"
- ylimääräinen "0" ilmestyy kymmenen minuutin pelaamisen jälkeen kelloelementin eteen

Ohjelmassa on edelleen liian suuri ja sekalainen start-metodi. Lisäksi, käyttöliittymän kasaaminen olisi järkevää toteuttaa hieman keskitetymmin, vaikka useammassa metodissa.
