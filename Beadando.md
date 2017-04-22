Készítsünk egy alkalmazást, mely az alábbi üzleti igényt valósítja meg:

Adott két szerepkör, Tanár és Admin, akik egyetemen felvehető kurzusokat kezelnek.
A Tanár joggal rendelkező felhasználók kurzusokat tudnak létrehozni,
amiket aztán az Admin felhasználók törölhetnek,módosíthatnak.
Egy Admin felhasználó  törölheti,módosíthatja az összes Tanár felhasználó kurzusát.



Technikai részletek:

Fontos!:A feladat megoldása során választható, hogy kurzus törlést vagy módosítást valósítjuk meg az Admin felhasználó részére. Nem kell mindkettőt implementálni.

Alapkövetelmény:

-Új felhasználó regisztrációja 

-Egy felhasználót ne vegyünk fel kétszer, ha az azonosítója már létezik

-Új kurzus mentése

-Kurzust módosítása vagy törlése

Bármennyi felhasználó regisztrálhat a rendszerbe, regisztráció során adjuk meg, hogy melyik szerepkörbe tartozik.
Ne engedjük, hogy egy felhasználó többször regisztráljon, ha az azonosítója már létezik a rendszerben,
ne mentsük el újra az adatait.

Admin felhasználó a kurzus azonosítója alapján tud egy kurzust törölni/módosítani.

Adatbázisba vegyünk fel 2 táblát(kurzus, felhasznalo).

Kurzus tábla

-kurzus_id (primary key)

-azonosito(egyedi)

-rövid leírás a kurzusról

-óraszám

-időpont(pl Kedd 14-15 óráig, opcionálisan megadható)

-létszám



Felhasználó tábla

-felhasznalo_id (primary key)

-azonositó(legyen egyedi)

-név

-szerepkör(Tanár vagy Admin)


Mindegyik táblának legyen elsődleges kulcsa, egy külön erre a célre szolgáló oszlop(kurzus_id, felhasználó_id).
A kulcsok legyenek generáltak(identity) ne mi állítsuk be az értékét.
A két tábla foreign key-vel legyen összekapcsolva, hogy tudjuk melyik Tanár hozta létre az adott kurzust.
Az azonosító típusú oszlopok legyen egyediek(unique constraint).

Extra feladat
Készítsünk egy history táblát, amibe minden egyes kurzust elmentünk, de ebből a táblából soha nem törlünk.
