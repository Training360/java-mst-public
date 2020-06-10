# Generikus metódusok

Láttuk, hogy a generikus osztályokban a metódusok generikus paramétert kaphatnak, illetve a generikus típussal térhetnek vissza. Mivel az osztály szinten deklarált generikus típus csak példányosításkor derül ki, statikus attribútum és metódus ezt nem használhatja. Statikus metódusoknál van megoldás erre a problémára.

```java
public class Boxer {
    ...
    public static <T> Box<T> ship(T t) {
        Box<T> box = new Box<>();
        box.pack(t);
        return box;
    }
}
```

A metódus a visszatérési értékének típusa előtt deklarálja a formális paramétertípust, amit aztán használhat a paraméterlistában, visszatérési típusban és a metódus törzsében. A paraméteren elérhető metódusok függnek a formális paramétertípustól, ami általában az `Object` metódusaira korlátozódik.

Hívásakor az aktuális paraméter típusából derül ki, hogy milyen típusra gondoltunk, de explicit is megadhatjuk a metódus neve előtt.

```java
Box<Zebra> box1 = Boxer.ship(new Zebra());
Box<Zebra> box2 = Boxer.<Zebra>ship(new Zebra());
```

## Generikus metódus korlátozott típussal

Generikus metódus esetén is használhatunk megkötéseket a generikus típusra. Ennek akkor látjuk főként hasznát, ha ki szeretnénk használni a kapott generikus valamely tulajdonságát, képességét, például meghívnánk rajta egy metódust.

```java
public interface CanMakeSound {
    String makeSound();
}
```

```java
public static <T extends CanMakeSound> T getFirstWithSound(List<T> list, String sound) {
    for (T item: list) {
        if (item.makeSound().equals(sound)) {
            return item;
        }
    }
    throw new IllegalArgumentException("Not found with sound" + sound);
}
```

## Megszorítások generikus típusokkal kapcsolatban

- Primitív típusok nem használhatóak típus paraméterként
- Típus paraméterrel nem lehet példányosítani
- Típus paraméterrel nem lehet statikus attribútumot létrehozni
- `instanceof` után nem állhat paraméterezett típus
- Típuskényszerítés sem használható mindig

```java
List<String> l = new ArrayList<>();
List<Object> o1 = (List<Object>) l; // NEM FORDUL
List<Object> o2 = (List<Object>)(List)l; // FORDUL
```

- Paraméterezett típussal nem hozható létre tömb
- Nem lehet létrehozni paraméterezett típust, mely `Throwable` leszármazott
- Nem lehet metódus túlterhetlés úgy, hogy a raw type ugyanaz, csak a típusparaméter eltérő

## Ellenőrző kérdések

* Főleg mikor használunk generikus típus deklarációt metódusnál?
* Hogyan tudunk generikus típust megadni metódusnál?

## Gyakorlati feladat - tetszés szerinti tömb középső elemének visszaadása

Tetszőleges tömbből kell a középső elemet visszadni.

### Hibakezelés

* Ha `null` értéket kap dobjon `NullPointerException` kivételt
* Ha a tömb üres, dobjon `IllegalArgumentException` kivételt
* Ha a tömb elemeinek száma páros, és így nincs középső érték, dobjon `IllegalArgumentException` kivételt

### Megvalósítás

Létre kell hozni egy `ArrayMiddleObjectFinder` osztályt és ennek generikus metódusa végzi a műveletet.

Metódusai:

```java
public <T> T findMiddleObject (T... values) throws IllegalArgumentException
```

[rating feedback=java-genericmethod-kozepsoelem]
