# Nagy számok kezelése
Mit értünk nagy szám alatt? Amennyiben a primitív típusok értékkészlete nem megfelelő, akkor nagy számokról beszélünk, azaz vagy túl sok jegyből vagy túl sok tizedesjegyből áll.

### `BigDecimal` és `BigInteger` osztályok
A fent említett számokra használhatjuk ezeket az osztályokat, illetve akkor, ha fontos a pontosság (pl. pénzmennyiségek). A bináris számábrázolás miatt furcsaságokba ütközhetünk, nézzük például a következő műveletet:
`0.10d * 3`, melynek értéke `0.30000000000000004`.

Ha nem akarunk ilyen és ehhez hasonló kellemetlenségekbe ütközni, akkor minden esetben a `BigDecimal` osztályt használjuk. Hátránya, hogy lassúak a műveletek.

### Konstansok és műveletek
 A leggyakrabban használt konstansok : `BigDecimal.ZERO`, `BigDecimal.ONE`, `BigDecimal.TEN`. Természetesen az alapműveletek deklarálva vannak:

- `add()`
- `substract()`
- `multiple()`
- `divide()`

Utóbbi kettőnek egy plusz paramétert is át lehet adni, méghozzá a kerekítés típusát. Kerekíteni lehet a nulla, plusz/mínusz végtelen fele illetve mindig páros szám fele. Ez azért jó, mert ha sok számot adunk össze és mindig kerekítünk, akkor elég nagy lehet a hiba, viszont ha mindig a páros szám felé kerekítünk, a hiba minimalizálható. További metódusok a `pow()` (hatványozás) és a `setScale()`, mely adott tizedesjegyre kerekít egy számot. Ilyenkor is meg lehet adni, hogy merre kerekítsünk.

[important]
A BigDecimal osztály `ROUND_*` konstansai deprecated státuszba kerültek. Helyettük a `RoundingMode` enum példányai használandók pl. `RoundingMode.HALF_UP` a matematikai kerekítés szabályai szerint.
[/important]

## Ellenőrző kérdések

* Mikor használjuk a `BigDecimal` és `BigInteger` osztályokat?
* Milyen konstansokat és metódusokat ismersz a `BigDecimal` és `BigInteger` osztályokban.

## Feladat - Adószámítás

A `bigdecimal.BigDecimalOperations` osztályba dolgozz, a metódusokat a `BigDecimalMain` osztály `main()` metódusában
teszteld.

Implementáld a `BigDecimal calculateTax(BigDecimal price)` metódust, mely
a paraméterként átadott számot a matematikai kerekítés szabályai szerint
két tizedesjegyre kerekíti (a leírásban továbbiakban mkszsz(2)), majd
megszoroz egy konstansként definiált 0.27 értékkel, és az eredményt is mkszsz(2).

Az áfa értékét konstansként definiáld. A kerekítés mértékét `DEFAULT_SCALE`
konstansként tárold.

Implementáld a `BigDecimal calculatePriceWithTax(BigDecimal price)` metódust, mely
az eredeti árhoz hozzá is adja az áfát.

[rating feedback=java-bigdecimal-adoszamitas]

## Feladat - Napokra elosztás

Implementáld a `BigDecimal distributeBetweenDays(BigDecimal price, int numberOfDays)`
metódust, mely a paraméterként átadott összeget elosztja a második paraméterként
átadott napok számával, de mindig felfele kerekít.

[rating feedback=java-bigdecimal-napokraosztas]

## Feladat - Kamatos kamat számítás

Implementáld a `BigDecimal interestOnInterest(BigDecimal principle, BigDecimal rate, int years)`
metódust, mely a `principle` összeggel, a `rate` kamattal,
`years` évre kamatos kamatot számol. Feltételezzük, hogy a kamatperiódus egy év, ez után
a megtakarítás is tőkévé válik (kamatos kamat definiciója).

[rating feedback=java-bigdecimal-kamatoskamat]

## Feladat - kerekítési hibák összegyűjtése

Implementáld a `List<BigDecimal> roundHalfUpAndAddToLast(List<BigDecimal> numbers, int scale)`
metódust, mely végigmegy a paraméterként átadott számokon, majd a második paraméterként
megadott tizedesjegyre kerekíti. A kerekítési pontatlanságokat összegyűjti, összeadja, és
a lista végére teszi.

[rating feedback=java-bigdecimal-kerekitesihibak]

## Bónusz feladat

Mi ír ki a `System.out.println(new BigDecimal("1.1234").setScale(2));` kifejezés?
Miért?
