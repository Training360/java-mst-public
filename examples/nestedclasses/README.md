# Belső osztályok

A belső osztályok olyan osztályok melyek más osztályokon belül helyezkednek el. Viszonylag ritkán használjuk. Különböző típusok:

*	_Member inner class_ – Az osztályon belül szerepel egy új tagként
*	_Local inner class_ – Metóduson belül definiált
*	_Anonymus inner class_ – Metóduson belül név nélküli osztály
*	_Static nested class_ – Osztályon belül helyezkedik el tagként, statikus

A belső osztályok használatával könnyebben olvashatóvá válik a kód, ha az osztály kellően rövid. Ezek az osztályok jól elrejthetőek.


## Member inner class
Példa:
```java
public class Outer {

    public class Inner {
        public String sayHello() {
            return "Hello";
        }
    }

    public String saySomething() {
        return new Inner().sayHello();
    }
}
```

Jól látható, hogy minden belső osztály egy külső példányhoz tartozik, ezért látható a következő szintaktika: `Outer.Inner inner = outer.new Inner()`.

```java
Outer outer = new Outer();
assertThat(outer.saySomething(), equalTo("Hello"));

Outer outer2 = new Outer();
Outer.Inner inner = outer2.new Inner();
assertThat(inner.sayHello(), equalTo("Hello"));
```

#### Local inner class
Példa:
Az inner class csak a metódus végéig látható.
```java
public class Outer {

    public String saySomething() {
        class Inner {
            public String sayHello() {
                return "Hello";
            }
        }
        return new Inner().sayHello();
    }
}

```
#### Anonymus inner class

Példa:

```java
public class Outer {

    private List<String> words;

    public List<String> getListSortedIgnoreCase() {
        List<String> result = new ArrayList<>(words);
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase()
                    .compareTo(o2.toLowerCase());
            }
        });
        return result;
    }
}
```
Tipikusan `Comparator` implementáció esetén használjuk. A `sort()` metódusnak át kell adni egy `Comparator` osztályt amit egyből példányosítunk és definiálunk.


#### Static nested class

```java
public class Outer {

    public String saySomething() {
        Inner inner = new Inner();
        return inner.sayHello();
    }

    public static class Inner {
        public String sayHello() {
            return "Hello";
        }
    }
}
```

Fontos, hogy itt az inner class nem kapcsolódik közvetlenül pédányhoz!

```java
Outer outer = new Outer();
assertThat(outer.saySomething(), equalTo("Hello"));
Outer.Inner inner = new Outer.Inner();
assertThat(inner.sayHello(), equalTo("Hello"));
```
## Ellenőrző kérdések

* Milyen típusú belső osztályokat ismersz?
* Mik a belső osztályok használatának előnyei?
* Hogyan kell ezeket definiálni?
* Hol találhatunk példákat az osztálykönyvtárban belső osztályok használatára?
* Hogyan kell belső osztályokat definiálni?
* Mikor használhatjuk a belső osztályt a befoglaló metóduson/osztályon kívül? Hogyan?

## Gyakorlat - NameServer

Készíts egy `nestedclasses.dns.NameServer` osztályt, amely akárcsak egy domain name server tárolja,
hogy milyen IP-címhez milyen domain név tartozik.

* Lehessen hozzáadni új név, IP-cím párost a `addEntry(String hostName, String hostIp)` metódussal, ami
dobjon `IllegalArgumentException` kivételt `Already exists` szöveggel, ha már van ilyen IP-cím, vagy név.
* Lehessen törölni egy bejegyzést a nevet megadva a `removeEntryByName` metódussal, ha nincs ilyen nevű, akkor ne történjen semmi.
* Lehessen törölni IP-cím alapján, a `removeEntryByIp` metódussal. Ha nincs ilyen IP-címmel rendelkező, akkor ne történjen semmi.
* Lehessen megkapni az adott névhez tartozó IP-címet (`getIpByName` metódussal), dobjon `IllegalArgumentException`
kivételt `Element not found` szöveggel ha nincs ilyen.
* Lehessen megkapni az adott ip-hez tartozó nevet (`getNameByIp` metódussal), dobjon `IllegalArgumentException` kivételt
`Element not found` szöveggel ha nincs ilyen.

### Megoldáshoz

Legyen egy private static nested class (pl. `DnsEntry` néven), amely egy név, IP-cím párost tartalmaz és a
`NameServer` osztály ilyen típusú adatokat tartalmazzon.

[rating feedback=java-nestedclasses-nameserver]

## Gyakorlat - Soccer

Legyen egy `nestedclasses.soccer.Championship` osztály, amely egy focibajnokság eredményeit megadva megkaphatjuk a tabellát.
A feladathoz szükség van egy `nestedclasses.soccer.TeamStatistics` osztályra, amely egy tabella sor adatait tartalmazza.
A `Championship` osztály tartalmazzon egy `GameResult` static nested classt, amely egy meccs eredményét tartalmazza.
Ennek alapján kell a `TeamStatistics` példányokat módosítani.

### `TeamStatistics` osztály

* Adatai: csapat neve (`teamName`), lejátszott meccsek száma (`played`),
győzelmek (`won`), döntetlenek (`tied`), vereségek (`lost`), rúgott gólok (`goalsFor`),
kapott gólok (`goalsAgainst`), pontszám (`points`)
* getterek
* `equals` és `hashCode` metódusok a `teamName` alapján legenerálva
* egy metódus, amely egy megadott eredmény alapján, módosítja az adatokat (`void played(int plusGoalsFor, int plusGoalsAgainst)`)

### `GameResult` belső osztály

* Adatai: `teamHome`, `teamGuest`, `goalHome`, `goalGuest`
* Konstruktorra szükség van, de getterekre, setterekre nincs, mivel a külső osztály látja a tagosztály private attribútumait is.

### `Championship` osztály

* Adata: `TeamStatistics` lista
* Legyen hozzá getter
* Legyen egy metódus, amivel egy meccs eredmény megadhatunk (`public void addGame(GameResult result)`)

[rating feedback=java-nestedclasses-soccer]

## Gyakorlat - WebShop

Írj egy `nestedclasses.webshop.Product` osztályt `name`, `price` és `LocalDateTime from` attribútumokkal, és konstruktorral.
Írj egy `nestedclasses.webshop.WebShop` osztályt mely tartalmaz egy attribútumot, mely egy `Product` lista. Implementálj
három metódust, melyek a termékeket különböző sorrendben adják vissza. Ne az eredeti listát rendezd, hanem készíts
egy másolatot. A `Comparator` implementációkat anonymous inner classként add meg.

[rating feedback=java-nestedclasses-webshop]

## Gyakorlat - Thermostat

Készíts egy `nestedclass.thermo.Thermostat` osztályt, amely szabályozza adott épületben levő, hőmérővel rendelkező helyiségek fűtését.
Egy épületben tetszőleges számú hőmérő lehet. A termosztát rendelkezik egy `roomsToHeat` listával amely azon szobák
neveit tartalmazza, amelyet fűt. A hőmérők (`nestedclass.thermo.ThermoMeter` osztály) értesítéseket kell küldjenek, amikor a hőmérséklet megváltozik
(a példában ez a hőmérő `setTemperature()` metódusának meghívásával történhet meg). Az értesítéseket a figyelő objektumok kapják, akik
a termosztátban beállított hőmérséklettől függően módosítják a `roomsToHeat` listáját.

### Megoldás részletei

`ThermometerObserver` interfész tartalmazza azon metódus deklarációját, amellyel a hőmérő értesíti a figyelőket.
`void handleTemperatureChange(int temp, String room)`

A `Thermometer` osztály egy hőmérő.

* Rendelkezik a szoba neve és hőmérséklete adatokkal, valamint egy `ThermometerObserver` referenciával, akit értesíteni kell.
(Általában tetszőleges számű figyelő lehet, de most legyen csak egyetlen figyelő.)
* Létrehozáskor a szoba nevét és a hőmérsékletét lehet megadni, figyelő nincsen (értéke `null`).
* Legyenek getterei a tagokhoz.
* Legyen metódusa, amely meghívásával a figyelő bejegyezheti magát mint figyelő (`setThermometerObserver(ThermometerObserver observer)`).
 (Figyeljünk rá, hogy a figyelő bejegyzése hőmérséklet változásnak számít.)
* Legyen egy metódusa (`onTemperatureChanged()`), amely ha van bejegyzett figyelő meghívja a figyelő `handleTemperatureChange` metódusát.
* Legyen setter metódus a temperature adatra (`setTemperature`), amelyik az adatbeállításon kívül még meghívja az `onTemperatureChanged` metódust.

A `Thermostat` osztály reprezentálja a termosztátot.

* Rendelkezik egy `Thermometer` listával, egy fűtött szobák nevének listájával, valamint
egy `temperatureLimit` attribútummal, amely a termosztáton beállított (minimum) hőmérséklet.
* Létrehozáskor a két lista üres legyen és a `limit` értéke legyen 23.
* Legyen egy `addThermometer(Thermometer thermometer)` metódusa, amelyel egy újabb hőmérőt adhatunk a termosztáthoz.
A hőmérő hozzáadásakor jegyezzünk be hozzá egy figyelő objektumot (mely egy `ThermometerObserver` típusú
névtelen belső osztály), amelyet a bejegyzés utasításában definiáljunk. Implementálja a `ThermometerObserver` interface-t
úgy, hogy ha a szoba hőmérséklete kisebb, mint a termosztát limit-je, akkor tegye be a fűtött szobák listájába a szobát,
ha nem akkor vegye ki onnan.
* Legyen getter a fűtött szobák listájára

[rating feedback=java-nestedclasses-thermostat]
