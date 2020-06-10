# JAVA-MST - Java SE mester

## Javasolt haladás

* Először nézd meg a videót! A videóban szereplő forráskódot a [demos](demos) könyvtárban találod.
* Dolgozd fel a videóhoz tartozó írott anyagot, amelynek itt találod a tartalomjegyzékét, és a következő részekből áll:
	* Olvasd el a megfelelő elméleti részt, értelmezd!
	* Próbálj válaszolni az ellenőrző kérdésekre!
	* Old meg a gyakorlati feladatot, melynek itt találod a feladatleírását. Dolgozhatsz ugyanabba a projektbe. Minden leckéhez hozz létre külön csomagot! Figyelj, hogy a minden leckéhez vannak tesztesetek, ezeket másold be a projektedbe!

## Tartalomjegyzék

* [formatlocaleregexp - RegExp](examples/formatlocaleregexp/README.md)
* [formatlocale - Locale](examples/formatlocale/README.md)
* [formatnumberformat - NumberFormat](examples/formatnumberformat/README.md)
* [formatlocalebundle - Resource Bundle](examples/formatlocalebundle/README.md)
* [formatlocalemessage - MessageFormat](examples/formatlocalemessage/README.md)
* [bigdecimal - Nagy számok kezelése](examples/bigdecimal/README.md)
* [nestedclasses - Belső osztályok](examples/nestedclasses/README.md)
* [genericclass - Generikus osztályok](examples/genericclass/README.md)
* [genericinterface - Generikus interfészek](examples/genericinterface/README.md)
* [genericmethod - Generikus metódusok](examples/genericmethod/README.md)
* [reflectionintro - Bevezetés a reflection használatába](examples/reflectionintro/README.md)
* [reflectionclasses - Osztályokkal kapcsolatos információk lekérdezése reflectionnel](examples/reflectionclasses/README.md)
* [reflectionattributes - Attribútumok reflectionnel](examples/reflectionattributes/README.md)
* [reflectionmethods - Metódusok kezelése reflectionnel](examples/reflectionmethods/README.md)
* [reflectionconstructors - Konstruktorok kezelése reflectionnel](examples/reflectionconstructors/README.md)
* [reflectionforname - Osztály referencia a neve alapján](examples/reflectionforname/README.md)
* [reflectiongenerics - Generikusok és tömbök használata reflectionnel](examples/reflectiongenerics/README.md)
* [dynamicproxy - Dynamic Proxy](examples/dynamicproxy/README.md)

## Java fejlesztőeszközök

Ellenőrizd, lehet, hogy a gépeden már előre van telepítve a 
Java SE Development Kit!

Nézd meg a `C:\Program Files\Java` könyvtárat!

A Java SE Development Kit már nem állítja be sem a `JAVA_HOME`
környezeti változót, sem a `PATH`-t, ezért
kézzel kell beállítani a környezeti változók között.

Ez ettől függetlenül nem szükséges, mert a 
Java SE Development Kitet kizárólag fejlesztőkörnyezetből
használjuk, parancssorból nem.

Amennyiben mégis be kell állítani, a következő kettőt kell:

```
JAVA_HOME=C:\Program Files\Java\jdk-12.0.0
```

Valamint módosítani kell a `PATH` környezeti változó
értékét, fel kell venni egy új sort:

```
%JAVA_HOME%\bin
```
