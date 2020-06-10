# `MessageFormat` osztály


A `MessageFormat` osztály szövegek összefűzésére használható. Java-ban a konkatenáció operátora a + jel, de ez nem mindig jól olvasható. A `MessageFormat` esetén statikus szövegeket és placeholdereket adunk meg, amiket kicserélünk. Gyakran kombináljuk Resource Bundle-vel. 

Nézzünk egy példát:


```java
System.out.println(MessageFormat.format("Hello {0}, hello {1}!", "World", "Java"));
```
A placeholderek kapcsos zárojelben találhatóak indexel ellátva. 

#### Formázott helyörzők
A placeholdereket formázni is lehet, pédául szám, dátum vagy idő esetén. Ehhez a `format()` statikus metódust kell használni a következő képpen: 

```java
System.out.println(
  MessageFormat.format("The time is now: {0,date,medium} {0,time,medium}", new Date()));


```

Ilyenkor az operációs rendszer nyelvének megfelelő formátumban hozza létre a dátumot. Ha más nyelvet (locale-t ) szeretnénk használni akkor példányosítanunk kell:

```java
MessageFormat messageFormat =
  new MessageFormat("The time is now: {0,date,medium} {0,time,medium}", Locale.US);
System.out.println(messageFormat.format(new Object[]{new Date()}));

```
Eredménye például (aznapi dátum és idő): The time is now: Apr 4, 2018 2:13:47 PM


#### Választás

Lehetőségünk van a formátum szövegben a paraméterre vonatkozóan feltétel elhelyezésére. 

```java
System.out.println(
  MessageFormat.format(
    "There {0,choice,0#are no files|1#is one file|1<are {0,number,integer} files}.", 0));
```

Ez a szöveg a paraméter függvényében a következő szöveget adja:

*	0->There are no file
*	1->There is one file
*	2 ->There are 2 files
*	x->There are x files.


## Ellenőrző kérdések

* Mire való a `MessageFormat` osztály?
* Hogyan adhatók meg a helyőrzők értékei? Mitől függ az indexelés?
* Hogyan formázható pl. egy dátum a helyőrzőben?
* Hogyan alkalmazható `Locale` a `MessageFormat` esetében?
* Hogyan lehet választást használni `MessageFormat` esetében?

## Gyakorlat - MessageGenerator

Készítsünk egy `MessageGenerator` osztályt, ami a `MessageFormat` segítségével formáz meg adott szövegeket.
Az egyik metódus "időjárás jelentést" generál, a másik egy lottónyeremény bejelentése.

### Megvalósítás

Publikus metódusok:

```java
public String generateForecastText(String weather, int degree, String place)
public String generateLotteryAnnouncement(String name)
```

[rating feedback=java-formatlocalemessage-messagegenerator]  
