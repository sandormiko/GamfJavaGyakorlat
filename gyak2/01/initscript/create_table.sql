


create table szamitas(
	szamitas_id Integer  identity primary key,
	netto_osszeg  numeric(10,2) not null,
	afa numeric(10,2) not null,
	brutto_osszeg numeric(10,2) not null,
	ado_ertek numeric(10,2) not null,
	letrehozas_ideje timestamp not null

)