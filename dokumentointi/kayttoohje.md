# Käyttöohje
Lataa tiedosto [SudokuNow-1.0-jar-with-dependencies.jar](https://github.com/VirtualAkseli/ot-harjoitustyo/releases/download/Final/sudokuNow-1.0-jar-with-dependencies.jar "Lataa sudoku")
## Alustustoimet
- target hakemistosta tulee löytyä kopio "highscore.xml" tiedostosta. (Löytyy SudokuNow-hakemistosta).
- Jos kuvissa näkyvän hienon fontin toivoo toimivan itsellään, src/main/resources -hakemistosta löytyvä "MagicCardsNormal.ttf"-fontti tulee asentaa.

## Ohjelman käynnistäminen
ohjelma käynnistetään target-hakemistossa komennolla 
`` java -jar sudokuNow-1.0-jar-with-dependencies.jar ``

## Pelivalikko
Pelivalikosta valitaan pelin vaikeustaso ("Easy", "Hard") tai ladataan vanha peli ("Load"). Käyttäjä voi myös luoda tyhjän pelipohjan painamalla "New".
<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/ark2.png?raw=true">
## Pelin pelaaminen
Pelaaja voi tabulaattori-painikkeella, tai hiiren osoittimella valita ruudun. 
Ruutu hyväksyy vain kokonaislukusyötteitä näppäimistöltä. Oikealla näkyvällä "Reset" painikkeella pelikenttä tyhjennetään numeroista.
"Save" painike tallentaa pelin.
<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/ark3.png?raw=true">
## Vianhallinta
Jos pelin aloittaessa, missä vain muussa vaiheessa kaikki menee peliruudussa mustaksi, tabulaattori-painikkeella kaikkien rivien läpi sahaaminen ja "Check-painikkeen painaminen auttavat.

Kun pelaaja kokee olevansa valmis, "Check"-painikkeella tarkastetaan pelin oikeellisuus. Jos sudoku on oikein, palataan aloitusruutuun
