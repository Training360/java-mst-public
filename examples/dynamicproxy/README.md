# Dynamic Proxy

## Ellenőrző kérdések

* Mire való a dinamikus proxy?
* Hogyan kell dinamikus proxy-t létrehozni? Mi kell egy dinamikus proxy-hoz?
* Látható-e, hogy a visszaadott referencia proxy?

## Gyakorlati feladat

Keszíts egy `AuthorizeHandler` proxy osztályt, amely bármilyen
interfészt implementáló osztály elé betehető, esetünkben egy ajtó (`Door`) és egy nyomtató (`Printer`)
elé. Ezek interfészek, és van egy `EntryDoor` és egy `HpPrinter` implementáció.
Az ezekben lévő metódusok első paramétere mindig a felhasználó neve.

Hozz létre egy `AuthorizeHandler` osztályt, amely

* rendelkezik továbbá egy Object típusú `target` nevű attribútummal, amelyben majd
a védett objektum referenciáját tároljuk.
* Hozz létre konstruktort, amely megkapja az `Object` értékét, és beállítja.
* implementáld az `InvocationHandler` interfészt
  * implementáld úgy a `public Object invoke(Object proxy, Method method, Object[] args) throws Throwable`,
  metódust, hogy dobjon `SecurityException` kivételt, ha a művelet nem engedélyezett, és továbbítsa a metódushívást, ha engedélyezett.
  Akkor engedélyezett, ha a `target` `Door` típusú, és a felhasználó `John Doe`, vagy
  a `target` `Printer` típusú, és a felhasználó `Jane Doe`.
* Hozz létre egy `createProxy(Object target)` statikus metódust, amely
 létrehozza a proxyt, és visszatér azzal használva a `Proxy` osztált statikus `newProxyInstance` metódusát.
 Az első paramétere egy referencia a védett objektumot.
 
 [rating feedback=java-dynamicproxy-authorizehandler]
 