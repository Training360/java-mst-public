# RegExp

A reguláris kifejezések (regular expression – regex) tulajdonképpen szöveg minták, Stringek halmazát lehet vele megadni. 
Mire használjuk? 
*	Megvizsgálhatjuk, hogy egy szöveg megfelel-e egy adott mintának
*	Megvizsgálhatjuk, hogy egy szöveg tartalmaz-e egy, a mintának megfelelő részletet
Fontos, hogy a reguláris kifejezések nem csak Java-ban használhatóak, hanem gyakorlatilag bármely programozási nyelvben megtalálhatóak.

#### Példák

Nézzünk néhány példát a reguláris kifejezések használatára
*	e-mail cím formátum ellenőrzése
*	egyéb kötött formátumú azonosítók (pl. SZIG szám) ellenőrzése
*	html formátumú állományból a linkek kigyűjtése

Példák regexre
*	[Jj]ava.+ - a Java szöveget keresi, kis- és nagybetűvel
*	^[A-Za-z]+$ -A szövegnek az eleje a ^ a vége pedig a $
*	<([a-z][a-z0-9]*)\b[^>]*>(.*?)</\1> - csoportok használata, html tagek keresésére

#### Formátumok, egyszerű kifejezések
Nézzük a leggyakrabban használt regex formátumokat
*	x - x karakter
*	[abc] - a, b vagy c karakter
*	[^abc] - összes karakter, kivéve az a, b vagy c karakter
*	[a-zA-Z] - angol ábécé összes kis és nagybetűje
*	. - bármilyen karakter
*	\d - számjegy (digit), \s - whitespace karakter
*	\b - szóhatár (word boundary), \\ - visszafele perjel
*	^ - sor eleje, $ - sor vége

#### Formátum, ismétlődések, csoportosítások
*	X? - X egyszer sem, vagy egyszer
*	X* - X egyszer sem, egyszer vagy többször
*	X+ - X legalább egyszer
*	X{n} - X pontosan n ismétlődése
*	X{n,} - X legalább n ismétlődése
*	X{n,m} - X legalább n, de nem több, mint m ismétlődése
*	(X) - csoport
*	\n - visszamutató

#### Regex használata Java-ban
A reguláris kifejezések használatáért Javaban a `Pattern` osztály felel. Ezt nem kell példányosítani, használjuk a `compile()` statikus metódust. Ezek után a példányon kell meghívni a `matcher()` metódust és átadni neki a `String`-t, majd a `matches()` metódussal lehet ellenőrizni. Karaktersorozatok megtalálására használjuk a `find()` metódust egy ciklusban, hiszen egy sorozat többször is szerepelhet a szövegben, majd a csoport tartalmát `group()` metódussal lehet kivenni. 

```java
Pattern pattern = Pattern.compile("[Jj]ava.+");
Matcher matcher = pattern.matcher("Java course");
if (matcher.matches()) {
  // ...
}
```
```java
Pattern pattern = Pattern.compile("\\*([a-z]*)\\*");
Matcher matcher = pattern.matcher("aaa bbb *ccc* ddd *eee*");
while (matcher.find()) {
    System.out.print(matcher.group(1) + " ");
}
```
Kimete: "ccc eee"

Karaktersorozatok cseréjére is van lehetőség. Ehhez a `replaceAll()` metódust kell meghívnunk. 

```java
Pattern pattern = Pattern.compile("[a-z]+");
Matcher matcher = pattern.matcher("aaa 123 bbb 346 ddd");
System.out.println(matcher.replaceAll("xxx"));
```
Kimenete: "xxx 123 xxx 346 xxx"

A `split()` metódus egy `String` feldarabolására szolgál. Ennek is adhatunk meg paraméterül reguláris kifejezést, így a darabolás pontjai a kifejezésnek megfelelő szövegek lesznek.

```java
Pattern pattern = Pattern.compile("\\s[0-9]+\\s");
System.out.println(Arrays.toString(pattern.split("aaa 111 bbb 222 ccc 1a1 ddd 123")));
```
Kimenete: [aaa, bbb, ccc 1a1 ddd 123]

#### String metódusok
A következő metódusok közvetlenül hívhatók `String` objektumokon, nem kötelező a `Pattern` illetve a `Matcher` osztály használata:

*	`matches(String regex)`
*	`replaceAll(String regex, String replacement)`
*	`replaceFirst(String regex, String replacement)`
*	`split(String regex)`
*	`split(String regex, int limit)` – a limit a tömb maximalizálására szolgál

## Ellenőrző kérdések

* Mi az a reguláris kifejezés?
* Hogyan épülnek fel a reguláris kifejezések?
* Mire alkalmazhatók a reguláris kifejezések?
* Hol találhatók meg a reguláris kifejezésekre vonatkozó szabályok?
* Hogyan kell használni a `Pattern` és `Matcher` osztályokat?
* Milyen metódusok vannak a `String` osztályban, melyek regexet várnak paraméterül?

## Gyakorlat - validátor

Hozzunk létre egy reguláris kifejezéseken alapuló validátor osztályt a gyakrabban előforduló validálási feladatokra.

A `validateEmail()` metódus olyan stringet fogadjon csak el, ami e-mail formátumú. Az e-mail formátumot a következőképp
definiáljuk:

* Van benne `@` karakter
* A `@` előtt elfogadható kis- és nagybetű, számjegy, aláhúzásjel, kötőjel és pont
* A `@` utáni rész a domain
* A domain bármennyi ponttal elválasztott tagot tartalmazhat
* Az utolsó tagon kívül szerepelhet kis- és nagybetű, számjegy, aláhúzásjel és kötőjel
* Az utilsó tag 2-4 darab kis- vagy nagybetűt tartalmazhat

A `validateAcademicYear()` metódus két évszámot vár kötőjellel elválasztva. Az évszámnak 2000 és 2099
között bármi elfogadható. Nem kell figyelni arra, hogy az első kisebb legyen, mint a második.

A `validateYear()` metódus 2000 és 2999 bármilyen évszámot elfogadhat.


### Hibakezelés

`null` vagy üres string, illetve évszám validálás esetén a `null` érték dobjon `IllegalArgumentException`-t

### Megvalósítás

Használjuk a String `matches()` metódust és a `Pattern` és `Matcher` osztályokat
 is felváltva a különböző validátorokban.

publikus metódusok:

```java
public boolean validateEmail(String email)
public boolean validateAcademicYear(String academicYear)
public boolean validateYearString(String yearString)
```

### Tippek

Az összeállított reguláris kifejezéseket konstansként adjuk meg!
A paraméter ellenőrzésére hozzunk létre egy `boolean isEmpty(String str)` metódust!

[rating feedback=java-formatlocaleregexp-validator]  
