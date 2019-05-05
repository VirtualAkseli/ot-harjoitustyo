# Testausdokumentti

## Testauksen luonne
Tein testejä kartoittaakseni kehittämiseni tukeana sitä, missä voisivat olla ohjelmani heikkoudet. Yksikkötestit eivät auttaneet siinä yhtä paljon, kuin käyttöliittymän kautta tehty mekaaninen testaaminen.

### Yksikkötestaus

JUNIT-testit varmistavat perustoiminnallisuuden 7 testillä;
- onnistuuko numeron lisääminen
- onnistuuko eri vaikeusasteiden luonti (easy ja hard)
- onnistuuko tallennetun pelin lataaminen
- Tunnistaako check-metodi virheen pysty-, vaaka-, ja laatikkomuodoissaan

## Mekaaninen testaus

Olen yrittänyt syöttää ohjelmalle väärää syötettä (välilyönti, kirjaimet, erikoismerkit). Se ei onnistu.
Olen klikkaillut painikkeita varmistaakseni, että ehtolauseet takaavat oikean toiminnallisuuden. 
Peli on pelattu läpi ja kuten vaatimusmäärittelyssä lukee, huomattu joitain puutteita;

- Lista parhaista tuloksista tulostuu kahteen kertaa pelin valmistuttua
- Jos merkin laittaa väärään paikkaan, ja tekee muutoksen muualle, alkuperäinen virhemerkki "unohtuu"
- Ylimääräinen "0" ilmestyy kymmenen minuutin pelaamisen jälkeen kelloelementin eteen
