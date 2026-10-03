# Java 1 - 3. cvičení v2

## Monster
Z vašeho projektu z minulého cvičení nebo z projektu s řešením minulého cvičení
(<https://gitlab.vsb.cz/jez04-vyuka/java1/labs/lab03v2.git>)

Vytvořte třídu `Monster`, která bude implementovat metody `draw` a `simulate`
podobně jako je implementuje `Player`. Rozdíl bude ten, že se příšera
bude pohybovat konstantní rychlostí shora dolů. V okamžiku, kdy se příšera
posune mimo plátno tak se objeví na horní straně plátna
(zkuste použijte funkci modulo, nebude fungovat pro pohyb nahoru).
Jako obrázek můžete použít například [red-monster.gif](https://swi.cs.vsb.cz/dam/jcr:7c8b66e9-2b40-4045-83e0-3c77ba4796e2/red-monster.gif)

## Pole
Vytvořte pole objektů monster ve třídě `Level`. Toto pole inicializujte 5
příšerami na různých pozicích a s různými rychlostmi.
Vytvořte si konstruktor pro třídu Monster takový, že jako parametr
bude mít pouze objekt `Level`. Tento konstruktor uloží hodnotu level a nastaví náhodnou pozici
v pravé části světa/plátna a nastaví nějakou (náhodnou) rychlost.

Modifikujte metody `draw` a `simulate` ve třídě `Level` tak,
že se bude volat `draw` a `simulate` na každou příšeru.

Generování náhodných čísel (přidejte do třídy `Monster`):
````java
//deklarace třídní proměnné
private static final Random RANDOM = new Random();

//použití
RANDOM.nextDouble(0, world.getWidth()*0.3))
````

## Kolize

Vytvořte metody `getBoundingBox` ve třídách `Monster` a `Player`, které budou
vracet objekt typu `javafx.geometry.Rectangle2D`, který ohraničuje
daný objekt - tzv. "bounding box". Prozatím zanedbejte případnou rotaci hráče.

Modifikujte metodu `simulate` ve třídě `Level` tak, že se bude
pro každou příšeru testovat, zda se nestřetla s objektem `Player`
můžete použít například metodu `intersects` ze třídy `Rectangle2D`.

Pokud bude nějaké monstrum zasaženo, tak obraťte jeho směr pomocí metody `changeDirection` kterou si vytvořte ve třídě `Monster`.

## Pole překážek

Vytvořte pole objektů typu `Obstacle` ve třídě `Level` jako instanční proměnnou (field). Naplňte ho překážkami na náhodných pozicích.
Upravte konstruktor `public Obstacle(Level level)` obdobně jako u monster, aby překážky umisťoval náhodně.
Zajistěte vykreslování všech překážek.

## Kolize s překážkami

U hráče (`Player`) vytvořte metodu `randomBounce()`, která otočí jeho směr a navíc ještě směr náhodně mírně pozmění v obou složkách x a z.
Také vytvořte metodu `getBoundingBox` (ignorujte natočení hráče).

Zajistěte a by se hráč při kolizi s překážkou změnil směr pomocí metody `randomBounce()`.

Zajistěte aby monstra měnili směr i při kolizi s překážkou.

## Způsob odevzdání

Projekt odevzdejte do systému Kelvin (právě jste zde). Nahrajte zde celou složku **src** a soubor **pom.xml**
dle níže zobrazeného odkazu na video.

Následně bude projekt zkompilován a provedou se Unit Testy. Vzhledem k povaze projektu a prozatímnímu
testovacímu využití systému Kelvin v předmětu Java 1 v případě selhání nezoufejte.

Jedná se o pomocný test, vše bude ještě hodnoceno ručně. Důležité je nahrát soubory aby bylo možno vše vyhodnotit
a provést analýzu na plagiáty. Věřím, že je to je formalita a všichni z Vás tvoří vlastní kód.

[
![Upload řešení - Přehrát video!](https://swi.cs.vsb.cz/dam/jcr:4feb2bd3-b2b1-4393-bb6c-ae831c731fde/upload-java-to-kelvin.2024-10-05-18-44-47.png "Přehrát video")
](https://swi.cs.vsb.cz/jezek/student-information/Java1/kelvin-submision.html)


