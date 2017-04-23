A második gyakorlat kódja.

Adatbázis séma létrehozó szkriptek az adott változat initscript könyvtárában találhatóak
A szkriptek futtatása előtt mindig dobjuk el a korábban létrehozott táblákat.

01 könyvtárban lévő változat elmenti a számításainkat egyetlen táblába, és le is kérdezi onnan

02 könyvtárban lévő változat már 2 táblába ment, a táblák közt foreign key kapcsolat van

03-tranzakciokezeles változat minden műveletet egy tranzakcióba fog és atomivá tesz, azaz
abban az esetben történik commit, ha mindkét(felhasználó mentés, számítás mentés) adatbázisművelet sikeres, különben rollbackelünk
