# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovelluksen päätoiminnallisuus on sudoku-pelin pelaaminen. Käyttäjä voi valita kahdesta valmiista pelipohjasta tai pelata omaa pohjaansa

## Käyttäjät
Sovelluksella on yhdenlaisia käyttäjiä, eli pelaajat. En toteuta tähän mitään erityistä etuoikeutettua super-user tilaa.

## Käyttöliittymäluonnos
Pelin näyttää tältä:

<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/blob/master/dokumentointi/demo1.png" />

Sovelluksen avautumisnäkymä on muutamalla painikkeella varustettu ikkuna, josta valitaan joko jokin 2:sta valmiiksi asetetusta pelipohjasta tai luodaan oma sudoku.


## Ohjelman ominaisuudet

### Tämänhetkiset toiminnallisuudet
"Pelimuodon" (vaikeusaste) valittua pelaajalle avautuu yllä kuvattu pelilauta. Peli ilmoittaa nykytilassaan huutomerkkisymbolilla jos pysty- tai vaakarivillä tai 3x3 ruudussa on duplikaattinumeroita. Syöte on toistaiseksi rajattu pelkkiin numeroihin.
Pelikello kertoo pelin aloittamisesta kuluneen ajan. Pelin valmistuttua tulos tallentuu highscore.xml taulukkoon jonka sisältö on projisoitu alkunäyttöön.


## Jatkokehitysideoita

- Cheat-code jolla saadaan käyttöön sudokunratkomisalgoritmi
- Läpäisyaikaan sidottu käyttäjän henkisiä kykyjä solvaava teksti 
- Taustamusiikkia

