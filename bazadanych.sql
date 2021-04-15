CREATE DATABASE IF NOT EXISTS firmafarm DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE firmafarm;

CREATE TABLE Dostawca(
	id_dostawcy INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nazwa VARCHAR(50) NOT NULL,
    NIP INT NOT NULL,
    kraj VARCHAR(50) NOT NULL,
    adres VARCHAR(100) NOT NULL
);
CREATE TABLE Surowiec(
	id_surowca INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nazwa VARCHAR(50) NOT NULL,
    id_dostawcy INT, FOREIGN KEY (id_dostawcy) REFERENCES Dostawca(id_dostawcy),
    pozycja_na_magazynie INT,
    data_przydatnosci DATE NOT NULL
);
CREATE TABLE Dostawa(
	id_dostawy INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data_dostawy DATE NOT NULL,
    id_dostawcy INT NOT NULL, FOREIGN KEY (id_dostawcy) REFERENCES Dostawca(id_dostawcy),
    id_surowca INT NOT NULL, FOREIGN KEY (id_surowca) REFERENCES Surowiec(id_surowca),
    ilosc INT DEFAULT '0',
    nr_serii INT NOT NULL
);
CREATE TABLE Faktura_firma(
	id_faktury INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nr_faktury VARCHAR(20) NOT NULL,
    id_dostawy INT NOT NULL, FOREIGN KEY (id_dostawy) REFERENCES Dostawa(id_dostawy)
);
CREATE TABLE Firma(
	NIP INT PRIMARY KEY NOT NULL,
    nazwa VARCHAR(40) NOT NULL,
    adres VARCHAR(100) NOT NULL,
    miasto VARCHAR(50) NOT NULL,
    kod_pocztowy VARCHAR(10) NOT NULL,
    regon INT NOT NULL,
    data_zalozenia DATE NOT NULL
);
CREATE TABLE Lek(
	id_leku INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nazwa VARCHAR(40) NOT NULL,
    gramatura INT NOT NULL
);
CREATE TABLE Oferta(
	id_oferty INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_leku INT NOT NULL, FOREIGN KEY (id_leku) REFERENCES Lek(id_leku),
    cena DOUBLE NOT NULL DEFAULT '0'
);
CREATE TABLE Koszyk(
	id_koszyka INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_oferty INT, FOREIGN KEY (id_oferty) REFERENCES Oferta(id_oferty),
    ilosc INT DEFAULT '0',
    koszt DOUBLE DEFAULT '0'
);
CREATE TABLE Osoba(
    id_osoby INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    imie VARCHAR(20) NOT NULL,
    nazwisko VARCHAR(30) NOT NULL,
    e_mail VARCHAR(30),
    nr_tel INT,
    pesel INT,
    haslo VARCHAR(30) NOT NULL,
    status_konta INT NOT NULL
);
CREATE TABLE Pracownik(
	id_pracownika INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_osoby INT NOT NULL, FOREIGN KEY (id_osoby) REFERENCES Osoba(id_osoby),
    wynagrodzenie INT NOT NULL DEFAULT '0',
    stanowisko VARCHAR(30) NOT NULL
);
CREATE TABLE Klient(
	id_klienta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_osoby INT NOT NULL, FOREIGN KEY (id_osoby) REFERENCES Osoba(id_osoby),
    NIP INT
);
CREATE TABLE Zamowienie(
	id_zamowienia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_klienta INT NOT NULL, FOREIGN KEY (id_klienta) REFERENCES Klient(id_klienta),
    id_koszyka INT NOT NULL, FOREIGN KEY (id_koszyka) REFERENCES Koszyk(id_koszyka),
    waga DOUBLE NOT NULL DEFAULT '0',
    data_zlozenia DATE NOT NULL,
    data_realizacji DATE,
    stan INT DEFAULT '0'
);
CREATE TABLE Faktura_klient(
	id_faktury INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nr_faktury VARCHAR(20) NOT NULL,
    id_klienta INT NOT NULL, FOREIGN KEY (id_klienta) REFERENCES Klient(id_klienta),
    id_zamowienia INT NOT NULL, FOREIGN KEY (id_zamowienia) REFERENCES Zamowienie(id_zamowienia)
);

CREATE TABLE Magazyn (
	pozycja_na_magazynie INT PRIMARY KEY NOT NULL,
	id_surowca int NOT NULL, FOREIGN KEY (id_surowca) REFERENCES Surowiec(id_surowca),
	ilosc int NOT NULL
);



insert into Osoba VALUES(NULL,'Administrator','Admin','adm@adm',1,11,'0admin',0);
insert into Osoba VALUES(NULL,'Magazynier','Magazyn','magazyn',2,22,'0haslo',0);
insert into Osoba VALUES(NULL,'Biurowy','Biuro','biuro',2,22,'0haslo',0);
insert into Pracownik VALUES(NULL,1,5000,'admin');
insert into Pracownik VALUES(NULL,2,5000,'pracownik_magazynu');
insert into Pracownik VALUES(NULL,3,5000,'pracownik_biurowy');
insert into dostawca VALUES(NULL,'polfa',123,'Ukraina','Bandery 2 Kijow');
insert into dostawca VALUES(NULL,'al-alam',124,'Maroko','Al-hafiz 2 Algier');
insert into dostawca VALUES(NULL,'ningdao',125,'PRC','Mao 3 Pekin');
select * from dostawca;

select id_klienta,imie,nazwisko from Osoba as os inner join Klient as kl on os.id_osoby=kl.id_osoby;


select * from klient;


INSERT INTO Oferta VALUES (NULL,1,12.0);
insert into Koszyk values(Null,1,50,500);
insert into Faktura_klient VALUES(NULL,'asd',10,2);
insert into Osoba VALUES(NULL,'producent','Admin','adm@adm',1,11,'haslo',0);
insert into Dostawca VALUES(NULL,'abc',1234,'Zanzibar','jakisadres');
insert into Zamowienie VALUES(NULL,1,1,50,'2020-08-08',NULL,0);

/*KUBA*/
select id_zamowienia,waga,data_zlozenia,stan,ilosc,koszt,nazwa,gramatura from Zamowienie AS zam 
INNER JOIN Koszyk AS kos ON zam.id_koszyka=kos.id_koszyka
INNER JOIN Oferta AS ofe ON kos.id_oferty=ofe.id_oferty
INNER JOIN Lek AS lek ON lek.id_leku=ofe.id_leku;
/*PATRYK*/
select id_pracownika,os.id_osoby,imie,nazwisko,wynagrodzenie,stanowisko,e_mail from Pracownik as pr 
INNER JOIN Osoba AS os ON pr.id_osoby=os.id_osoby;

select id_osoby,imie,nazwisko,e_mail,nr_tel,pesel,status_konta from Osoba;

/*MOJE*/
select id_oferty,nazwa,cena,gramatura from Oferta as ofe inner join lek on ofe.id_leku=lek.id_leku;/*oferta*/

select s.id_surowca,s.nazwa,pozycja_na_magazynie,data_przydatnosci,d.nazwa from surowiec as s 
inner join dostawca as d on s.id_dostawcy=d.id_dostawcy;/*surowce*/

select id_faktury,nr_faktury,id_zamowienia,NIP,imie,nazwisko,e_mail from faktura_klient as fk /*faktury*/
inner join klient as k on fk.id_klienta=k.id_klienta 
inner join osoba as o on o.id_osoby=k.id_osoby;

select s.pozycja_na_magazynie,s.id_surowca,nazwa,ilosc,data_przydatnosci from magazyn as m inner join surowiec as s on m.id_surowca=s.id_surowca;/*magazyn*/

select id_dostawy,data_dostawy,s.id_surowca,s.nazwa,ilosc,nr_serii,doss.id_dostawcy,doss.nazwa from dostawa as dos/*dostawa*/
inner join dostawca as doss on dos.id_dostawcy=doss.id_dostawcy 
inner join surowiec as s on s.id_surowca=dos.id_surowca;


select * from pracownik;
select stanowisko,e_mail,haslo from osoba inner join pracownik on osoba.id_osoby=pracownik.id_osoby;
select * from Oferta where id_leku=(select id_leku from Lek where nazwa='Calcium2');
select id_surowca,nazwa from Surowiec where pozycja_na_magazynie!=0;


update Osoba set haslo='0haslo' where id_osoby=2;
update Pracownik set stanowisko='pracownik_magazynu' where id_osoby=4;

select id_zamowienia from Zamowienie as z 
inner join klient as kli on z.id_klienta=kli.id_klienta where id_klienta="+tokens[2]+";


select ofe.id_oferty,ko.id_koszyka,zam.id_zamowienia,fk.id_faktury from Oferta as ofe
inner join koszyk as ko on ofe.id_oferty=ko.id_oferty 
inner join zamowienie as zam on zam.id_koszyka=ko.id_koszyka 
inner join faktura_klient as fk on fk.id_zamowienia=zam.id_zamowienia;

select * from osoba;
select * from oferta;
select * from surowiec;

select * from koszyk;
insert into koszyk values(NULL,9,99,900);
select * from zamowienie;
insert into zamowienie values(NULL,2,1,100,'2020-02-02','2020-02-02',0);
select * from faktura_klient;
insert into faktura_klient values(NULL,'AYSC',2,1);


SELECT COUNT(*) FROM Magazyn;
select COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'Lek';
select COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'Pracownik';
select COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'Klient';

SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_catalog = 'firmafarm' AND table_name = 'Pracownik';

UPDATE Zamowienie SET id_zamowienia = 2, id_klienta = 10, id_koszyka = 2, stan = 0, waga = 24.0, data_zlozenia = '2019-10-10' , data_realizacji = '' WHERE id_zamowienia = 2;

/*DROP DATABASE firmafarm;