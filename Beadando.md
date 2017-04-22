Készítsünk egy alkalmazást, mely az alábbi üzleti igényt valósítja meg:

Adott két szerepkör, Tanár és Admin, akik egyetemen felvehető kurzusokat kezelnek.
A Tanár joggal rendelkező felhasználók kurzusokat tudnak létrehozni, de
bizonyos információkat nem tudnak még ekkor a kurzussal kapcsolatban megadni(óraszám,időpont, létszám).

Miután a Tanár joggal rendelkező felhasználók létrehozták a kurzust, tovább tudják küldeni
az Admin felhasználóknak jóváhagyásra, akik a hiányzó információkat megadják és a kurzust jóváhagyják.
Egy Admin felhasználó látja és jóváhagyhatja az összes Tanár felhasználó kurzusát, amennyiben azok Jóváhagyásra várnak.

Technikai részletek:
Bármennyi felhasználó regisztrálhat a rendszerbe, regisztráció során adjuk meg, hogy melyik szerepkörbe tartozik.
Ne engedjük, hogy egy felhasználó többször regisztráljon, ha az azonosítója már létezik a rendszerben,
ne mentsük el újra az adatait.

Azt, hogy mikor kerül egy kurzus az Adminhoz vagy Tanárhoz egy státusz oszlop mondja meg.
Vegyük  fel ezt az oszlopot a kurzus táblába, értékei az alábbiak lehetnek:

-Létrehozott
-Jóváhagyásra vár
-Jóváhagyott

Amikor a Tanár létrehozza a kurzust, az Létrehozott állapotba kerül( ekkor az admin még nem látja és nem hagyhatja jóvá) 
Amikor végzett és szeretné jóváhagyatni az Adminnal, Jóváhagyásra vár státuszba teszi(ekkor az admin már látja és jóváhagyhatja) 
Amikor az Admin jóváhagyja Jóváhagyott állapotba kerül, ezután már egyikük sem módosíthatja az adott kurzust.

Adatbázisba vegyünk fel 2 táblát(kurzus, felhasznalo).
Kurzus tábla
-rövid leírás a kurzusról
-óraszám
-időpont(pl Kedd 14-15 óráig)
-létszám
-kurzus státusza

Felhasználó
-azonositó(legyen egyedi)
-név
-szerepkör(Tanár vagy Admin)

Mindegyik táblának legyen elsődleges kulcsa, egy külön erre a célre szolgáló oszlop(kurzus_id, felhasználó_id).
A kulcsok legyenek generáltak(auto increment, identity) ne mi állítsuk be az értékét.
A két tábla foreign keyyel legyen összekapcsolva, hogy tudjuk melyik Tanár hozta létre az adott kurzust.

Extra feladat
Készítsünk egy history táblát, amiben a kurzus minden egyes állapotát eltároljuk, ezáltal láthatóvá
válik, hogy ki milyen változtatásokat hajtott végre rajtuk. Amikor a kurzus létrejön, vagy státuszát
módosítják, be kell szúrni egy sortba history táblába.
