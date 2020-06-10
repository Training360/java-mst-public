# Számformázás

## `NumberFormat` és `DecimalFormat`
 
Számok formázására `NumberFormat` __absztrakt__ osztály, és `DecimalFormat` leszármazott használható.

 * Példány factory metódussal: `NumberFormat.getInstance()`, `getIntegerInstance()`, `getPercentInstance()`
 * Tipikusan `DecimalFormat` példányt ad vissza
 * Default locale-lal jön létre
 * Overloadolt metódusainak megadható `Locale` példány
 * `parse()` és `format()` metódusok
 * Nem szálbiztos

### `DecimalFormat` formázás

* NumberFormat factory metódus által visszaadott példányt típuskényszeríteni
* Alapesetben ezreshatárolóval, három tizedesjegyre kerekítve
* Tipikus formátumok:
   * Például a `###,###.###` - ezreshatárolóval, három tizedesjegyre kerekítve
   * `000000.000` - ezreshatároló nélkül, mindig három tizedesjeggyel, és minimum öt egész jeggyel
   * Például a `###,###.###'.- Ft'` - pénznemmel, nem változó szöveg része aposztrófok között

```java
if (nf instanceof DecimalFormat) {
    ((DecimalFormat) nf).applyPattern("###,###.###");
}
```
## Ellenőrző kérdések

* Miért van szükség a számok formázására? Mit lehet megadni, ha konfigurálni akarjuk a szám formázását?
* Milyen osztályt kell használnunk és hogyan számok formázásakor?
* Alapesetben hogyan történik a formázás?
* Hogyan kell személyre szabni?

## Gyakorlat - FormatLocale

Készíts egy `FormatLocale` osztályt, amely metódusainak segítségével `Locale` támogatott szám, pénznem és százalék
formázásokat lehet elvégezni.

### Hibakezelés

A metódusoknak ellenőrizni kell a `Locale` létrehozásához szükséges paraméterek meglétét.
Amennyiben `Locale` példány kerül átadásra, vizsgálni kell, hogy ismeri-e a JVM (operációs rendszer alapján)
az adott `Locale`-t. (Benne van-e az elérhető `Locale` példányok listájában, használd a `availableLocales()`
mdetódust.) Hiányzó vagy nem megfelelő paraméter esetén `IllegalArgumentException`-t várunk.

### Megvalósítás

A számformázáskor két tizedesre kell kerekíteni, a kerekítés szabályainak megadásával.

### Tippek

A létrehozott `Locale` támogatásának ellenőrzésére célszerű egy `boolean localePresent(Locale locale)` metódus
és a paraméterek ellenőrzésére egy `boolean isEmpty(String str)` metódus létrehozása.

[rating feedback=java-formatnumberformat-formatlocale]  
