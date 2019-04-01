# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovelluksen päätoiminnallisuus on sudoku-pelin pelaaminen. Käyttäjä voi valita valmiista pelipohjista tai pelata omaa pohjansa

## Käyttäjät
Sovelluksella on yhdenlaisia käyttäjiä, eli pelaajat. En toteuta tähän mitään erityistä etuoikeutettua super-user tilaa.

## Käyttöliittymäluonnos
Pelin koodaaminen on jo aloitettu ja pelin lopullinenkin muoto tulee näyttämään osapuilleen tältä:

<img src="https://github.com/VirtualAkseli/ot-harjoitustyo/dokumentointi/demo1.png" />

Sovelluksen avautumisnäkymäksi tulee muutamalla painikkeella varustettu ikkuna, josta valitaan joko jokin 3:sta valmiiksi asetetusta pelipohjasta tai luodaan oma sudoku.


## Ohjelman ominaisuudet

### Tämänhetkiset toiminnallisuudet
"Pelimuodon" (vaikeusaste) valittua pelaajalle avautuu yllä kuvattu pelilauta. Peli ilmoittaa nykytilassaan punaisella symbolilla jos pysty- tai vaakarivillä tai 3x3 ruudussa on duplikaattinumeroita. Syöte on toistaiseksi rajattu pelkkiin numeroihin.

### Tulevat toiminnallisuudet
- Pelikello
- Merkkiäänet virheestä ja pelin loppumisesta
- Pelitulosten tallentaminen (nopeimmat suoritukset)

## Jatkokehitysideoita

Mikäli innostun ja aikaa löytyy, toteutan joitakin seuraavista ominasuuksista:
- Sudoku-pohjien tallennus tiedostoon/tietokantaan
- Cheat-code jolla saadaan käyttöön sudokunratkomisalgoritmi
- Läpäisyaikaan sidottu käyttäjän henkisiä kykyjä solvaava teksti 
- Taustamusiikkia
- ??? jotain ???