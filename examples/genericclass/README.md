# Generikus osztályok

Saját generikus osztályt úgy hozhatunk létre, hogy az osztálynév után relációs jelek között a befogadott típust jelző betűt helyezünk el. Az osztályon belül aztán ezt a betűjelet használhatjuk attribútumok és paraméterek deklarációjában típusként. Konvenció szerint nagybetűket használunk:

| Betűjel | Jelentés                                                    |
| ------- | ----------------------------------------------------------- |
| `T`           | type                                                  |
| `E`           | element                                               |
| `N`           | number                                                |
| `K`           | map key                                               |
| `V`           | map value                                             |
| `S`, `U`, `V` | ha több, egymástól független típust kell meghatározni |

Például hozzunk létre egy dobozt valamilyen objektum tárolására.

```java
public class Box<T> {
    private T content;

    public T lookInto() {
        return contents;
    }

    public void pack(T content) {
        this.content = content;
    }
}
```

A `Box` példányosításakor derül ki, hogy a `T` milyen típussal helyettesítődik.

```java
Box<Zebra> boxForZebra = new Box<>();
boxForZebra.pack(new Zebra());
Zebra zebra = boxForZebra.lookInto();

Box<Treasure> boxForTreasure = new Box<>();
```

A `boxForZebra` csak `Zebra` példányt tud tárolni, de a `Box` osztályt felhasználhatjuk természetesen más, például `Treasure` tárolására is.

A generikus típusok egymásba ágyazhatóak. Például létrehozhatunk egy listát is kincsesládából.

```java
List<Box<Treasure>> treasureBoxes = new ArrayList<>();
```

## Type erasure

A Java fordításkor a generikus osztályt a típus paramétert mindenhol `Object` típusra cseréli, és ahol szükséges, típuskényszerítést végez. Ezt a folyamatot **type erasure**-nek nevezzük.

Például a fenti osztály ténylegesen csak egy példányban létezik, és a `boxForZebra` és a `boxForTreasure` mögött ugyanaz a kód áll.

```java
public class Box {
    private Object content;

    public Object lookInto() {
        return contents;
	}

    public void pack(Object content) {
        this.content = content;
    }
}
```

Használatkor az értékadás castolással egészül ki.

```java
Zebra zebra = (Zebra) boxForZebra.lookInto();
```

## Heap pollution

Láthatjuk, hogy a type erasure miatt futási időben két `Box`  objektum ugyanolyan típusú. A Java a típusok két nagy csoportját különbözteti meg:

- *reifiable types*: futási időben minden információ rendelkezésre áll a típusról
- *non-reifiable types*: nem minden információ érhető el futási időben

A reifiable típusokkal mindent meg tudunk tenni, amit csak a Java tud. A non-reifiable típusoknál léteznek korlátozások:

- A type erasure miatt a `List<String>` és a `List<Number>` között nincs különbség, ezért a `instanceof` operátor nem használható.
- Nem hívható a konstruktora, hiszen a `T()` helyett az `Object()` hívódna meg.

Amikor nem érhető el futási időben minden információ, előfordulhat, hogy egy paraméterezett típussal deklarált változó nem a neki megfelelő típusú objektumra tart referenciát, és ez fordítási időben figyelmeztetéshez, futás közben pedig `ClassCastException`-höz vezethet.

```java
List<String> l = new ArrayList<>();
List l2 = l;
List<Integer> l3 = l2;	// Unchecked assignment
l3.add(1);
System.out.println(l.get(0));
```

## Korlátozott típusok használata

### Upper bounds osztály típus paraméterénél

A generikus osztályban, - mivel nem tudhatjuk, hogy a tényleges típus mi lesz, - csak az `Object` metódusait érhetjük el a paraméterezett változóknál. A paramétert meghatározhatjuk úgy is, hogy valamely osztályt/interfészt és az összes leszármazottját/implementálóját fogadja. Ekkor természetesen elérhetjük az összes metódusát. Ennek jelölésére az `extends` kulcsszót használjuk.

```java
public interface CanMakeSound {
    String makeSound();
}
```

```java
public class Box<T extends CanMakeSound> {

    private T content;

    public T lookInto() {
        return content;
    }

    public void pack(T content) {
        this.content = content;
    }

    public String listenInto() {
        return content.makeSound();
    }
}
```

### Wildcard használata

Amikor generikus változót deklarálunk, meg kell adnunk, hogy mi lesz a generikus típusa. Ettől később nem tudunk eltérni semmilyen módon, és láttuk, hogy ez `ClassCastException`-höz vezethet. Amikor elképzelhető, hogy ugyanaz a referencia változó másik generikus típust is fogad, akkor ezt jelezhetjük egy joker (`?`) használatával.

```java
List<?> list = new ArrayList<String>();
List<Integer> numberList = new ArrayList<>();
list = numberList;
```

Ebben az esetben a `list` változón csak az `Object` metódusai hívhatóak.

### Upper-bounded wildcard

Tegyük fel, hogy a `Human` osztályt kiterjeszti a `Trainer` és a `Student` is.  Megadhatjuk, hogy egy generikus változó bármilyen `Human` leszármazottat befogadjon az `extends` kulcsszóval. Ekkor a `Human` minden metódusa elérhető.

```java
public String names(List<? extends Human> humans) {
  // ...
  StringBuilder sb = new StringBuilder();
  for (Human h: humans) {
      sb.append(h.getName()).append(", ");
  }
  return sb.toString();
}
```

A fenti metódusnak átadható `List<Human>`, `List<Trainer>` és `List<Student>` is, de például `List<Object>` már nem. Fontos megjegyeznünk, hogy az így átadott kollekciók a metódusban logikailag módosíthatatlanok, hiszen nem tudhatjuk, mit kaptunk.

```java
humans.add(new Human()); // Mi van, ha a lista Student példányokból áll?
```

### Lower-bounded wildcard

Megadhatjuk, hogy egy generikus változó bármilyen `Human` őst befogadjon a `super` kulcsszóval. Ekkor ugyan csak az `Object` metódusai az érhetőek el az elemeken, de a generikus listához biztonságosan hozzáadhatunk új elemeket, amelyek `Human` típusúak, azaz például egy `Trainer` objektumot is.

```java
public void add(List<? super Human> humans) {
    humans.add(new Human());
    humans.add(new Trainer());
}
```

## Ellenőrző kérdések

* Hogyan tudod a saját osztályodat generikus típussal paraméterezni?
* Melyek a Java konvenciók a típusjelölésekre?
* Mi az a type erasure?
* Mi a bounding type szerepe?
* Milyen típusú korlátozásokat ismersz, azoknak mi a szerepe?

## Gyakorlati feladat - tömb adott elemeinek kigyűjtése, visszaadása

Írj egy metódust, mely visszaadja a tömb első és az utolsó elemét. Az elemeket egyetlen, újrahasznosítható objektumban akarjuk visszakapni.
Fontos, hogy a tömböt alkotó objektum típusok alapján lehessen létrehozni a visszaadást biztosító adatobjektumot.

### Hibakezelés

* Ha `null` értéket kap, dobjon `NullPointerException` kivételt
* Ha a tömb üres, dobjon `IllegalArgumentException` kivételt

### Megvalósítás

Létre kell hozni egy `DataPair` generikus osztályt és ezt fogjuk használni az adatok visszaadására.

publikus metódusok:
```java
public T getFirstObject()
public T getSecondObject()
```

Az adatok kinyerését az `ArraySearch` osztály metódusa végzi.

publikus metódusok:
```java
 public DataPair<String> getFirstAndLastWord(String[] words)
```

[rating feedback=java-genericclass-tombelemekgyujtese]
