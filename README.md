# Coding-Challenge

## BESCHREIBUNG

Gegeben ist eine Serie von 5 Büchern über einer Serie von speziellen Fachbüchern. Software
Engineers auf der ganzen Welt finden sie herausragend, und der Verlag natürlich auch. In einer Geste
großer Großzügigkeit gegenüber der Menschheit (und zur Steigerung der Verkaufszahlen) haben sie
das folgende Preismodell eingeführt:

Ein Exemplar von jedem der fünf Bücher kostet 8 EUR. Wenn Sie jedoch zwei verschiedene Bücher
aus der Reihe kaufen, erhalten Sie einen Rabatt von 5 % auf diese beiden Bücher. Wenn Sie 3
verschiedene Bücher kaufen, erhalten Sie 10% Rabatt. Bei 4 verschiedenen Büchern erhalten Sie
einen Rabatt von 20 %. Wenn Sie alle 5 Bücher kaufen, erhalten Sie einen satten Rabatt von 25 %.
Wenn Sie z. B. vier Bücher kaufen, von denen drei verschiedene Titel sind, erhalten Sie einen Rabatt
von 10 % auf die drei Bücher, die Teil eines Sets sind, aber das vierte Buch kostet immer noch 8
EUR.

**Ihre Aufgabe ist es, einen Code zu schreiben, der den Preis für jeden denkbaren Warenkorb
berechnet und dabei einen möglichst großen Rabatt gewährt. Achten Sie dabei auf sauberen Code
und eine gute Testabdeckung.**

### Wie viel kostet zum Beispiel dieser Korb mit Büchern?

2 Exemplare des ersten Buches<br>
2 Exemplare des zweiten Buches<br>
2 Exemplare des dritten Buches<br>
1 Exemplar des vierten Buches<br>
1 Exemplar des fünften Buches<br>


#### Antwort:
```sh
(4 * 8) - 20% [Buch1, Buch2, Buch3, Buch4]
+ (4 * 8) - 20% [Buch1, Buch2, Buch3, Buch5]
  = 25.6 * 2 = 51.20
```