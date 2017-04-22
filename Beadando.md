Készítsünk egy alkalmazást, mely az alábbi üzleti igényt valósítja meg:

Adott két szerepkör, Tanár és Admin, akik egyetemen felvehető kurzusokat kezelnek.
A Tanár joggal rendelkező felhasználók kurzusokat tudnak létrehozni, de
amit aztán az Admin felhasználók törölhetnek.

Egy Admin felhasználó látja és törölheti az összes Tanár felhasználó kurzusát.

Technikai részletek:
Bármennyi felhasználó regisztrálhat a rendszerbe, regisztráció során adjuk meg, hogy melyik szerepkörbe tartozik.
Ne engedjük, hogy egy felhasználó többször regisztráljon, ha az azonosítója már létezik a rendszerben,
ne mentsük el újra az adatait.

Admin felhasználó a kurzu azonosítója alpaján tud egy kurzust törölni

Adatbázisba vegyünk fel 2 táblát(kurzus, felhasznalo).
Kurzus tábla
-azonosito(egyedi)

-rövid leírás a kurzusról

-óraszám

-időpont(pl Kedd 14-15 óráig, opcionálisan megadható)

-létszám



Felhasználó

-azonositó(legyen egyedi)

-név

-szerepkör(Tanár vagy Admin)


Mindegyik táblának legyen elsődleges kulcsa, egy külön erre a célre szolgáló oszlop(kurzus_id, felhasználó_id).
A kulcsok legyenek generáltak(auto increment, identity) ne mi állítsuk be az értékét.
A két tábla foreign keyyel legyen összekapcsolva, hogy tudjuk melyik Tanár hozta létre az adott kurzust.
Az azonosító típusú oszlopok legyen egyediek(unique constraint).

Extra feladat
Készítsünk egy history táblát, amibe minden egyes kurzust elmentünk, de ebből a táblából soha nem törlünk.
