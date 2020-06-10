# Locale

Az alkalmazás fejlesztés fontos szempontja lehet, hogy több nyelven is meg tudjon jelenni a felület. Erre szolgál az  Internationalization (I18N) módszer. Fontos, hogy nem elegendő a szöveget lefordítani. Gondoljunk a szavak hosszára, karakterkódolásra, dátum formátumokra, szám formátumokra, pénznemekre. 

## Locale osztály

A `Locale` osztály egy nyelvet és egy földrajzi lokalizációt ír le. Pl.: angol/USA , angol/UK, német/Németország. Tehát a `Locale` két adattagot tartalmaz: `language` és `country`. A `toString()` metódus ezeket aláhúzás jellel elválasztva adja vissza rövidítve pl.: `en_US`, `hu_HU`. Lehetőség van létrehozni `Locale` objektumot csak nyelv alapján, de fontos, hogy csak ország alapján nem!

### Locale osztály használata, metódusai

*	A `Locale.getDefault()` statikus metódus, az operációs rendszer alapnyelvét adja vissza.
*	`getLanguage()`, `getCountry()` 
*	Konstansok pl.: `Locale.US`
*	Saját példányt is létrehozhatunk : `new Locale("hu", "HU")`
*	Lekérhetjük az oprendszer által támogatott `Locale`-okat : `Locale.getAvailableLocales()`

## Ellenőrző kérdések

* Mi az a internationalization/localization? Az alkalmazás mely részeit érintheti?
* Mi a `Locale` szerepe? Miből épül fel?
* Hogyan lehet lekérdezni a rendelkezésre álló locale-okat, és hogyan az alapértelmezett locale-t?
* Milyen konstansok vannak? Hogyan lehet konstansként nem szereplő locale-t létrehozni?
