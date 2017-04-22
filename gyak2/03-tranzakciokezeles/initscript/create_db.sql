


drop table szamitas;


create table szemely(
	szemely_id integer  identity primary key,
	azonosito varchar(50) not null,
	keresztnev varchar(100) not null,
	vezeteknev varchar(100) not null ,
	szuletesi_ido date not null
);


create table szamitas(
	szamitas_id Integer  identity primary key,
	netto_osszeg  numeric(10,2) not null,
	afa numeric(10,2) not null,
	brutto_osszeg numeric(10,2) not null,
	ado_ertek numeric(10,2) not null,
	letrehozas_ideje timestamp not null,
	szemely_id integer not null
);

alter table szamitas add foreign key (szemely_id)
references szemely(szemely_id);

ALTER TABLE szemely ADD CONSTRAINT azon_egyedi UNIQUE (azonosito);

