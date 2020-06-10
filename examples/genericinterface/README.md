# Generikus interfészek

Nem csak az osztályok, hanem az interfészek is lehetnek generikusak. Elsősorban API fejlesztése során fordulnak elő, de konkrét alkalmazás fejlesztésénél is hasznos lehet. Ilyen generikus interfész a `Comparable<T>` is.

```java
public interface Comparable<T> {
    int compareTo(T o);
}
```

Saját generikus interfészt is készíthetünk.

```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}
```

Az interfészt implementáló osztály dönthet úgy, hogy konkrét típussal helyettesíti a generikus típust.

```java
public class OrderedStringPair implements Pair<String, String> {
    private String key;
    private String value;
    
    public OrderedStringPair(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getValue() {
        return value;
    }
}
```

Készíthetünk generikus osztályt is.

```java
public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;
    
    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
}
```

Az osztály elhagyhatja a generikus típust, és implementálhatja raw type-ként a `Pair` interfészt, de ez nem ajánlott.

```java
public class OrderedPair implements Pair {
    private Object key;
    private Object value;
    
    public OrderedPair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    
    public Object getKey() {
        return key;
    }
    
    public Object getValue() {
        return value;
    }
}
```

## Ellenőrző kérdések

* Hogyan lehet generikus típust megadni interfésznél?
* Hogyan lehet egyszerre több generikus típust megadni?
* Keress példákat generikus interfészekre Java API-ban!

## Gyakorlati feladat - keresőszolgáltatás

Implementáljunk egy keresőszolgáltatást, ahol minden, `Item` típusú elemet tárolni lehet. (Az `Item` legyen egy interfész.) Ez lehet például `Book`,
de legyen lehetőség más típusú elemek implementálására is.
A könyvtárban különböző szempontok szerint lehet keresni az egyes konkrét elemek között,  például szerző vagy cím alapján.
A kereséshez egy generikus `SearchService<T extends Item>` osztályt kell létrehozni, melynek a `public T findFirst(List<T> items, SearchCriteria criteria)`
metódusa implementálja a keresést. A `SearchCriteria` egy olyan interfész, melynek van egy
`boolean pass(T target)` metódusa, mely azt adja vissza, hogy a paraméterként megadott objektum megfelel-e a feltételnek.

Implementálni kell ennek két implementációját, egyet `BookAuthorSearchCriteria` néven, mely konstruktorban
kap egy szerzőt, és az alapján keres, valamint egyet `BookTitleSearchCriteria` néven, mely egy címet kap.

### Tippek

Ha a keresett elem nem található, `IllegalArgumentException` kivételt dobjon.

[rating feedback=java-genericinterface-keresoszolgaltatas]
