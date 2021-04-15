package baza;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import klasy.*;
import klasy_glowne.*;
import Server.*;

/**
 * The type Baza danych.
 */
public class Baza_danych {
    /**
     * The constant driver.
     */
    public static final String driver="com.mysql.cj.jdbc.Driver";
    /**
     * The constant dburl.
     */
    public static final String dburl = "jdbc:mysql://localhost:3306/firmafarm?serverTimezone=UTC";

	private Connection conn;
	private Statement stat;

    /**
     * Instantiates a new Baza danych.
     */
    public Baza_danych() {
		try {
			Class.forName(Baza_danych.driver);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika jdbc");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(dburl,"root","1234");
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    /**
     * Insert boolean.
     *
     * @param zapytanie the zapytanie
     * @return the boolean
     */
    public boolean insert(String zapytanie) {//dodanie do bazy
		try {
			PreparedStatement prepstmt=conn.prepareStatement(zapytanie);
			prepstmt.execute();
			return true;
		}catch(SQLException e) {
			return false;
		}
	}

    /**
     * Find int.
     *
     * @param zapytanie the zapytanie
     * @return the int
     */
    public int find(String zapytanie) {//czy taki obiekt jest w bazie zwróci jego id lub 0
		try {
			PreparedStatement prepstmt=conn.prepareStatement(zapytanie);
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) return wynik.getInt(1);
			else return 0;
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return 0;
		}
	}

    /**
     * Get multi list.
     *
     * @param nazwatabeli the nazwatabeli
     * @return the list
     */
    public List<String> getMulti(String nazwatabeli){//pobranie wszystkich rekordow ze wskazanej tabeli
		List<String>lista=new ArrayList<String>();
		String str;
		int liczbakolumn=1;
		try {
			PreparedStatement prepstmt;
			ResultSet wynik;

			if(nazwatabeli.equals("Pracownik"))liczbakolumn=4;
			else if(nazwatabeli.equals("Klient"))liczbakolumn=3;
			else {
				prepstmt=conn.prepareStatement("select COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '"+nazwatabeli+"';");
				wynik=prepstmt.executeQuery();
				if(wynik.next())liczbakolumn=wynik.getInt(1);//pobranie liczby kolumn tabeli ktora chcemy wczytac
			}

			prepstmt=conn.prepareStatement("select * from "+nazwatabeli+";");
			wynik=prepstmt.executeQuery();
			int j;
			j = 1;
			while(wynik.next()) {
				str="";
				for(int i=1;i<=liczbakolumn;i++) {
					str+=""+wynik.getObject(i).toString()+" ";
				}
				lista.add(str);
				j++;
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			e.printStackTrace();
			return null;
		}
		return lista;
	}

    /**
     * Gets lek.
     *
     * @param id the id
     * @return the lek
     */
    public Lek getLek(int id) {
		int gramatura;
		String nazwa;
		Lek lek=new Lek();
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from lek where id_leku="+id+";");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				nazwa=wynik.getString("nazwa");
				gramatura=wynik.getInt("gramatura");
				lek=new Lek(id,gramatura,nazwa);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return lek;
	}

    /**
     * Gets oferty.
     *
     * @return the oferty
     */
    public List<String> getOferty() {
		int idleku,idoferty;
		double cena;
		String nazwa;
		Oferta of=new Oferta();
		List<String> wynik= new ArrayList<String>();
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select id_oferty,oferta.id_leku,lek.nazwa,cena from oferta inner join lek on oferta.id_leku=lek.id_leku;");
			ResultSet wyn=prepstmt.executeQuery();
			for(int i=0;i<ileRekordow("Oferta");i++){
				wyn.next();
				idoferty=wyn.getInt("id_oferty");
				idleku=wyn.getInt("id_leku");
				cena=wyn.getDouble("cena");
				nazwa=wyn.getString("nazwa");
				of=new Oferta(idoferty,idleku,cena);
				wynik.add(of.toString()+" "+nazwa);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			e.printStackTrace();
			return null;
		}
		return wynik;
	}

    /**
     * Gets oferta.
     *
     * @param id the id
     * @return the oferta
     */
    public Oferta getOferta(int id) {
		int idleku;
		double cena;
		Oferta of=new Oferta();
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Oferta where id_oferty="+id+";");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				idleku=wynik.getInt("id_leku");
				cena=wynik.getDouble("cena");
				of=new Oferta(id,idleku,cena);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			e.printStackTrace();
			return null;
		}
		return of;
	}

    /**
     * Insert koszyk boolean.
     *
     * @param idoferty  the idoferty
     * @param idklienta the idklienta
     * @param ilosc     the ilosc
     * @param koszt     the koszt
     * @return the boolean
     */
    public boolean insertKoszyk(int idoferty, int idklienta,int ilosc,double koszt) {
		try {
			PreparedStatement prepstmt=conn.prepareStatement("insert into Koszyk values (NULL,?,?,?,?);");
			prepstmt.setInt(1, idoferty);
			prepstmt.setInt(2,idklienta);
			prepstmt.setInt(3, ilosc);
			prepstmt.setDouble(4, koszt);
			prepstmt.execute();
		}catch(SQLException e) {
			System.err.println("Blad przy wpisywaniu nowego koszyka");
			return false;
		}
		return true;
	}

    /**
     * Gets koszyk.
     *
     * @param id the id
     * @return the koszyk
     */
    public Koszyk getKoszyk(int id) {
		int idoferty,ilosc,idkoszyka;
		double koszt;
		Koszyk kosz=new Koszyk();
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Koszyk where id_klienta="+id+" order by id_koszyka desc;");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				idoferty=wynik.getInt("id_oferty");
				idkoszyka=wynik.getInt("id_koszyka");
				ilosc=wynik.getInt("ilosc");
				koszt=wynik.getDouble("koszt");
				kosz=new Koszyk(idkoszyka,idoferty,id,ilosc,koszt);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return kosz;
	}

    /**
     * Insert zamowienie boolean.
     *
     * @param idklienta the idklienta
     * @param idkoszyka the idkoszyka
     * @param waga      the waga
     * @param dataz     the dataz
     * @param datar     the datar
     * @param stan      the stan
     * @return the boolean
     */
    public boolean insertZamowienie(int idklienta, int idkoszyka,double waga, String dataz, String datar, int stan) {
		try {
			PreparedStatement prepstmt=conn.prepareStatement("insert into Zamowienie values (NULL,?,?,?,?,?,?);");
			prepstmt.setInt(1, idklienta);
			prepstmt.setInt(2, idkoszyka);
			prepstmt.setDouble(3, waga);
			prepstmt.setDate(4, Date.valueOf(dataz));
			prepstmt.setDate(5, Date.valueOf(datar));
			prepstmt.setInt(6, stan);
			prepstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

    /**
     * Gets zamowienie.
     *
     * @param id the id
     * @return the zamowienie
     */
    public Zamowienie getZamowienie(int id) {
		int idklienta,idkoszyka,stan;
		double waga;
		String dataz,datar;
		Zamowienie zam=null;
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Zamowienie where id_zamowienia="+id+";");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				idklienta=wynik.getInt("id_klienta");
				idkoszyka=wynik.getInt("id_koszyka");
				waga=wynik.getDouble("waga");
				dataz=String.valueOf(wynik.getDate("data_zlozenia"));
				datar=String.valueOf(wynik.getDate("data_realizacji"));
				stan=wynik.getInt("stan");
				zam=new Zamowienie(id,idklienta,idkoszyka,stan,waga,dataz,datar);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return zam;
	}

    /**
     * Gets zamowienie.
     *
     * @param id_koszyka the id koszyka
     * @param id_klienta the id klienta
     * @return the zamowienie
     */
    public Zamowienie getZamowienie(int id_koszyka,int id_klienta) {
		int id_zamowienia,stan;
		double waga;
		String dataz,datar;
		Zamowienie zam=new Zamowienie();
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Zamowienie where id_klienta="+id_klienta+" and id_koszyka="+id_koszyka+";");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				id_zamowienia=wynik.getInt("id_zamowienia");
				waga=wynik.getDouble("waga");
				dataz=String.valueOf(wynik.getDate("data_zlozenia"));
				datar=String.valueOf(wynik.getDate("data_realizacji"));
				stan=wynik.getInt("stan");
				zam=new Zamowienie(id_zamowienia,id_klienta,id_koszyka,stan,waga,dataz,datar);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return zam;
	}

    /**
     * Gets szczegolowe zamowienie.
     *
     * @param id_zamowienia the id zamowienia
     * @param id_klienta    the id klienta
     * @return the szczegolowe zamowienie
     */
    public String getSzczegoloweZamowienie(int id_zamowienia,int id_klienta) {
		int stan,ilosc,gramatura;
		double waga,koszt;
		String dataz,datar,nazwa;
		String zam="";
		ResultSet wynik;

		try {
			if(id_klienta!=0)
			{
			PreparedStatement prepstmt=conn.prepareStatement("select id_zamowienia,zam.id_klienta,waga,data_zlozenia,data_realizacji,stan,ilosc,koszt,nazwa,gramatura from Zamowienie AS zam \n" +
					"INNER JOIN Koszyk AS kos ON zam.id_koszyka=kos.id_koszyka\n" +
					"INNER JOIN Oferta AS ofe ON kos.id_oferty=ofe.id_oferty\n" +
					"INNER JOIN Lek AS lek ON lek.id_leku=ofe.id_leku where id_zamowienia="+id_zamowienia+" and zam.id_klienta="+id_klienta+";");
			 wynik=prepstmt.executeQuery();}
			else
			{
				PreparedStatement prepstmt=conn.prepareStatement("select id_zamowienia,zam.id_klienta,waga,data_zlozenia,data_realizacji,stan,ilosc,koszt,nazwa,gramatura from Zamowienie AS zam \n" +
						"INNER JOIN Koszyk AS kos ON zam.id_koszyka=kos.id_koszyka\n" +
						"INNER JOIN Oferta AS ofe ON kos.id_oferty=ofe.id_oferty\n" +
						"INNER JOIN Lek AS lek ON lek.id_leku=ofe.id_leku where id_zamowienia="+id_zamowienia+";");
				 wynik=prepstmt.executeQuery();
			}
			if(wynik.next()) {
				id_klienta=wynik.getInt("id_klienta");
				waga=wynik.getDouble("waga");
				dataz=String.valueOf(wynik.getDate("data_zlozenia"));
				datar=String.valueOf(wynik.getDate("data_realizacji"));
				stan=wynik.getInt("stan");
				koszt=wynik.getDouble("koszt");
				nazwa=wynik.getString("nazwa");
				ilosc= wynik.getInt("ilosc");
				gramatura=wynik.getInt("gramatura");
				zam=id_zamowienia+" "+id_klienta+" "+waga+" "+dataz+" "+datar+" "+stan+" "+ilosc+" "+koszt+" "+nazwa+" "+gramatura;
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return "zleIdZamowienia";
		}
		return zam;
	}

    /**
     * Get wybrane zamowienia list.
     *
     * @param id_klienta the id klienta
     * @return the list
     */
    public List<String> getWybraneZamowienia(int id_klienta){//pobranie wybranyvh zamowien
		List<String>listazamowien=new ArrayList<String>();
		int idzamowienia,idklienta,idkoszyka,stan;
		double waga;
		String dataz,datar;
		Zamowienie zam=new Zamowienie();
		PreparedStatement prepstmt;
		try {
			if(id_klienta==0) prepstmt=conn.prepareStatement("select * from Zamowienie;");//pobierz wszystkie zamowienia
			else prepstmt=conn.prepareStatement("select * from Zamowienie where id_klienta="+id_klienta+";");//pobierz zamowienia klienta

			ResultSet wynik=prepstmt.executeQuery();
			while(wynik.next()) {
				idzamowienia=wynik.getInt("id_zamowienia");
				idklienta=wynik.getInt("id_klienta");
				idkoszyka=wynik.getInt("id_koszyka");
				waga=wynik.getDouble("waga");
				dataz=String.valueOf(wynik.getDate("data_zlozenia"));
				datar=String.valueOf(wynik.getDate("data_realizacji"));
				stan=wynik.getInt("stan");
				zam=new Zamowienie(idzamowienia,idklienta,idkoszyka,stan,waga,dataz,datar);
				listazamowien.add(zam.toString());
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return listazamowien;
	}

    /**
     * Get klienci list.
     *
     * @return the list
     */
    public List<String> getKlienci(){//pobranie wybranyvh zamowien
		List<String>listaklientow=new ArrayList<String>();
		int idklienta,idosoby,nip,telefon;
		String imie,nazwisko,email;
		PreparedStatement prepstmt;
		try {

			 prepstmt=conn.prepareStatement("select id_klienta, osoba.id_osoby, osoba.imie,osoba.nazwisko,osoba.e_mail,osoba.nr_tel,nip from Klient inner join osoba on klient.id_osoby=osoba.id_osoby ;");//pobierz zamowienia klienta

			ResultSet wynik=prepstmt.executeQuery();
			while(wynik.next()) {
				idosoby=wynik.getInt("id_osoby");
				idklienta=wynik.getInt("id_klienta");
				nip=wynik.getInt("nip");
				telefon=wynik.getInt("nr_tel");
				imie=wynik.getString("imie");
				nazwisko=wynik.getString("nazwisko");
				email=wynik.getString("e_mail");
				listaklientow.add(idklienta+" "+idosoby+" "+imie+" "+nazwisko+" "+email+" "+telefon+" "+nip);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return listaklientow;
	}

    /**
     * Usun koszyk boolean.
     *
     * @param idklienta the idklienta
     * @param idkoszyka the idkoszyka
     * @return the boolean
     */
    public boolean usunKoszyk(int idklienta,int idkoszyka) {
		try {
			PreparedStatement prepstmt=conn.prepareStatement("delete from Koszyk where id_klienta="+idklienta+" and id_koszyka="+idkoszyka+";");
			prepstmt.execute();
		}catch(SQLException e) {
			System.err.println("Blad przy usuwaniu zawartosci koszyka");
			return false;
		}
		return true;
	}

    /**
     * Insert osoba boolean.
     *
     * @param imie     the imie
     * @param nazwisko the nazwisko
     * @param email    the email
     * @param nrtel    the nrtel
     * @param pesel    the pesel
     * @param haslo    the haslo
     * @return the boolean
     */
    public boolean insertOsoba(String imie, String nazwisko, String email, int nrtel, int pesel,String haslo) {
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Osoba where imie='"+imie+"' and nazwisko='"+nazwisko+"' and e_mail='"+email+"';");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {//taka osoba jest juz w bazie
				return false;
			}

			prepstmt=conn.prepareStatement("insert into Osoba values (NULL,?,?,?,?,?,?,0);");
			prepstmt.setString(1, imie);
			prepstmt.setString(2, nazwisko);
			prepstmt.setString(3, email);
			prepstmt.setInt(4, nrtel);
			prepstmt.setInt(5, pesel);
			prepstmt.setString(6, haslo);
			prepstmt.execute();
		}catch(SQLException e) {
			System.err.println("Blad przy wpisywaniu osoby");
			e.printStackTrace();
			return false;
		}
		return true;
	}

    /**
     * Gets osoba.
     *
     * @param id the id
     * @return the osoba
     */
    public Osoba getOsoba(int id) {
		String imie,nazwisko,email,haslo;
		int nrtel,pesel,status;
		Osoba os=null;
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Osoba where id_osoby="+id+";");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				imie=wynik.getString("imie");
				nazwisko=wynik.getString("nazwisko");
				email=wynik.getString("e_mail");
				nrtel=wynik.getInt("nr_tel");
				pesel=wynik.getInt("pesel");
				haslo=wynik.getString("Haslo");
				status=wynik.getInt("status_konta");
				os=new Osoba(id,nrtel,pesel,imie,nazwisko,email,haslo,status);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return os;
	}

    /**
     * Insert klient boolean.
     *
     * @param imie     the imie
     * @param nazwisko the nazwisko
     * @param email    the email
     * @param nrtel    the nrtel
     * @param pesel    the pesel
     * @param nip      the nip
     * @param haslo    the haslo
     * @return the boolean
     */
    public boolean insertKlient(String imie, String nazwisko, String email, int nrtel, int pesel,int nip, String haslo) {//dodanie nowego klienta
		try {
			if(insertOsoba(imie, nazwisko, email, nrtel, pesel,haslo));//dodaj dane osoby
			else return false;

			int idosoby;//pobierz id dodanej osoby
			PreparedStatement prepstmt=conn.prepareStatement("select id_osoby from Osoba where imie='"+imie+"' AND nazwisko='"+nazwisko+"';");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				idosoby=wynik.getInt("id_osoby");
			}else return false;

			prepstmt=conn.prepareStatement("insert into Klient values (NULL,?,?);");//dodaj ja jako klienta
			prepstmt.setInt(1, idosoby);
			prepstmt.setInt(2, nip);
			prepstmt.execute();
		}catch(SQLException e) {
			System.err.println("Blad przy wpisywaniu klienta");
			e.printStackTrace();
			return false;
		}
		return true;
	}

    /**
     * Get single string.
     *
     * @param zapytanie the zapytanie
     * @return the string
     */
    public String getSingle(String zapytanie){//pobranie 1 komorki z 1 rekordu
		String str="";
		try {
			PreparedStatement prepstmt=conn.prepareStatement(zapytanie);
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				str+=wynik.getObject(1);
			}
			else return null;
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			e.printStackTrace();
			return null;
		}
		return str;
	}

    /**
     * Insert pracownik boolean.
     *
     * @param imie          the imie
     * @param nazwisko      the nazwisko
     * @param email         the email
     * @param nrtel         the nrtel
     * @param pesel         the pesel
     * @param wynagrodzenie the wynagrodzenie
     * @param stanowisko    the stanowisko
     * @param haslo         the haslo
     * @return the boolean
     */
    public boolean insertPracownik(String imie, String nazwisko, String email, int nrtel, int pesel,int wynagrodzenie, String stanowisko,String haslo) {
		try {
			if(insertOsoba(imie, nazwisko, email, nrtel, pesel,haslo));//dodaj dane osoby
			else return false;

			int idosoby;//pobierz id dodanej osoby
			PreparedStatement prepstmt=conn.prepareStatement("select id_osoby from Osoba where imie='"+imie+"' AND nazwisko='"+nazwisko+"';");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				idosoby=wynik.getInt("id_osoby");
			}else return false;

			prepstmt=conn.prepareStatement("insert into Pracownik values (NULL,?,?,?);");
			prepstmt.setInt(1, idosoby);
			prepstmt.setInt(2, wynagrodzenie);
			prepstmt.setString(3, stanowisko);
			prepstmt.execute();
		}catch(SQLException e) {
			System.err.println("Blad przy wpisywaniu pracownika");
			return false;
		}
		return true;
	}

    /**
     * Gets pracownik.
     *
     * @param id the id
     * @return the pracownik
     */
    public Pracownik getPracownik(int id) {
		Osoba os;
		int idosoby,wynagrodzenie;
		String stanowisko;
		Pracownik prac=null;
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Pracownik where id_pracownika="+id+";");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				idosoby=wynik.getInt("id_osoby");
				wynagrodzenie=wynik.getInt("wynagrodzenie");
				stanowisko=wynik.getString("stanowisko");

				//pobranie danych z tabeli osoba
				os=getOsoba(idosoby);
				prac=new Pracownik(id,os.getNr_tel(),os.getPesel(),os.getImie(),os.getNazwisko(),os.getE_mail(),idosoby,wynagrodzenie,stanowisko,os.getHaslo());
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return null;
		}
		return prac;
	}

    /**
     * Gets pracownicy.
     *
     * @return the pracownicy
     */
    public List<String> getPracownicy() {
		int idpracownika, idosoby, wynagrodzenie;
		String imie, nazwisko, stanowisko;
		Pracownik of = new Pracownik();
		Osoba os;
		List<String> wynik = new ArrayList<String>();
		try {
			PreparedStatement prepstmt = conn.prepareStatement("SELECT id_pracownika,pracownik.id_osoby,osoba.imie,osoba.nazwisko,wynagrodzenie,stanowisko from pracownik inner join osoba on pracownik.id_osoby=osoba.id_osoby;");
			ResultSet wyn = prepstmt.executeQuery();
			for (int i = 0; i < ileRekordow("pracownik"); i++) {
				wyn.next();
				idpracownika = wyn.getInt("id_pracownika");
				idosoby = wyn.getInt("id_osoby");
				wynagrodzenie = wyn.getInt("wynagrodzenie");
				stanowisko = wyn.getString("stanowisko");
				imie=wyn.getString("imie");
				nazwisko=wyn.getString("nazwisko");
				os=getOsoba(idosoby);
				of = new Pracownik(idpracownika,os.getNr_tel(),os.getPesel(),os.getImie(),os.getNazwisko(),os.getE_mail(),idosoby,wynagrodzenie,stanowisko,os.getHaslo());
				wynik.add(of.toString() + " " + imie+" "+nazwisko);
			}
		} catch (SQLException e) {//jesli nie ma rekordu zwroci null
			e.printStackTrace();
			return null;
		}
		return wynik;
	}

    /**
     * Delete boolean.
     *
     * @param nazwatabeli the nazwatabeli
     * @param id          the id
     * @return the boolean
     */
    public boolean delete(String nazwatabeli,int id) {//funkcja do usuwania rekordow
		try {
			ResultSet result=stat.executeQuery("SELECT * FROM "+nazwatabeli+" LIMIT 0;");//pobierz nazwe kolumny id
			List<String> columns = new ArrayList<String>();
			ResultSetMetaData mrs = result.getMetaData();
			for(int i = 1; i <= mrs.getColumnCount(); i++) {
				columns.add(mrs.getColumnLabel(i));
			}
			String nazwakolumny=columns.get(0);

			PreparedStatement prepstmt=conn.prepareStatement("delete from " + nazwatabeli + " where "+nazwakolumny+" = "+id+";");
			prepstmt.execute();
		}catch(SQLException e) {
			System.err.println("Blad przy usuwaniu");
			return false;
		}
		return true;
	}

    /**
     * Usun klienta boolean.
     *
     * @param id_osoby the id osoby
     * @return the boolean
     */
    public boolean usunKlienta(int id_osoby){
		try {
			PreparedStatement prepstmt=conn.prepareStatement("delete from Klient where id_osoby="+id_osoby+";");
			prepstmt.execute();
			prepstmt=conn.prepareStatement("delete from Osoba where id_osoby="+id_osoby+";");
			prepstmt.execute();
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return false;
		}
		return true;
	}

    /**
     * Update boolean.
     *
     * @param zapytanie the zapytanie
     * @return the boolean
     */
    public boolean update(String zapytanie) {//funkcja update
		try {
			PreparedStatement prepstmt = conn.prepareStatement(zapytanie);
			prepstmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad przy update");
			return false;
		}
		return true;
	}

    /**
     * Update boolean.
     *
     * @param nazwatabeli the nazwatabeli
     * @param o           the o
     * @return the boolean
     */
    public boolean update(String nazwatabeli,Object o) {
		try {
			ResultSet result=stat.executeQuery("SELECT * FROM "+nazwatabeli+" LIMIT 0;");//pobierz nazwe kolumny id
			List<String> columns = new ArrayList<String>();//lista do przechowania nazw kolumn
			ResultSetMetaData mrs = result.getMetaData();
			for(int i = 1; i <= mrs.getColumnCount(); i++) {//wczytanie nazw kolumn wskazanej tabeli do listy
				columns.add(mrs.getColumnLabel(i));
			}
			String nazwakolumny=columns.get(0);//pobierz 1 nazwe - kolumna id

			List <String>nazwy=new ArrayList<String>();//do przechowywania nazw kolumn do wpisania
			List <String>wartosci=new ArrayList<String>();//do przechowywania wartosci do wpisania

			String tostring=o.toString();//pobierz tostring dla danego obiektu - dzieki temu bedzie mozna wczytywac nazwy kolumn
			int i=0;//ustawiamy wskaznik na poczatkowej pozycji stringa

			while(tostring.charAt(i)!='[')i++;//przejdz poczatkowe znaki - od znaku '[' zaczynaja sie dane
			while(tostring.charAt(i)!=']') {//przejdz przez wszystkie dane do znaku ']' ktory konczy stringa
				i++;
				String nazwa="";//obiekt przechowujacy nazwe kolumny tabeli
				String wartosc="";//obiekt przechowujacy wartosc do kolumny tabeli
				while(tostring.charAt(i)!='=') {//wczytanie nazwy
					if(tostring.charAt(i)==' ') {//dla pustego znaku inkrementuj i i continue
						i++;
						continue;
					}
					nazwa+=tostring.charAt(i);//niepusty znak dodaj do nazwy
					i++;
				}
				i++;//omija znak =
				while(tostring.charAt(i)!=','&&tostring.charAt(i)!=']') {//wczytanie wartosci
					wartosc+=tostring.charAt(i);
					i++;
				}
				nazwy.add(nazwa);//dodaj nazwe do nazwy a wartosc do wartosci
				wartosci.add(wartosc);
			}

			String statement="UPDATE "+nazwatabeli+" SET ";//poczatek zapytania update do bazy danych

			List<Object>listapokonwersji=new ArrayList<Object>();//lista do przechowania przekonwertowanych wartosci
			for(i=0;i<wartosci.size();i++) {//konwersja stringow na typy do bazy danych
				try {//proba konwersji na typ int
					int j=Integer.parseInt(wartosci.get(i));
					statement+=nazwy.get(i)+" = "+wartosci.get(i);
					listapokonwersji.add(j);
				}catch(Exception e) {
					try {//jezeli konwersja na typ int sie nie powiodla to probujemy na typ Double
						double d=Double.parseDouble(wartosci.get(i));//proba konwersji na double
						statement+=nazwy.get(i)+" = "+wartosci.get(i);
						listapokonwersji.add(d);
					}catch(Exception e1) {
						try {//jezeli konwersja na typ double sie nie powiodla to probujemy na typ Date
							Date data=Date.valueOf(wartosci.get(i));
							statement+=nazwy.get(i)+" = '"+wartosci.get(i)+"'";
							listapokonwersji.add(data);
						}catch(Exception e2) {
							listapokonwersji.add(wartosci.get(i));//jesli nie typ int i nie typ double i nie date to dodaj stringa do listy
							statement+=nazwy.get(i)+" = '"+wartosci.get(i)+"'";
						}
					}
				}
				if(i<wartosci.size()-1) {//dodajemy przecinek
					statement+=", ";
				}
			}
			statement+=" WHERE "+nazwakolumny+" = "+wartosci.get(0)+";";//dodanie koncowki zapytania
			PreparedStatement prepstmt=conn.prepareStatement(statement);
			prepstmt.execute();
		}catch(SQLException e) {
			System.err.println("Blad przy update");//np nie ma takiego rekordu
			return false;
		}
		return true;
	}

    /**
     * Logowanie boolean.
     *
     * @param login the login
     * @param haslo the haslo
     * @return the boolean
     */
    public boolean logowanie(String login, String haslo) {//funkcja do logowania
		try {
			PreparedStatement prepstmt=conn.prepareStatement("select * from Osoba where e_mail='"+login+"';");
			ResultSet wynik=prepstmt.executeQuery();
			if(wynik.next()) {
				if(wynik.getInt("status_konta")!=0)return false;//konto zablokowane
				prepstmt=conn.prepareStatement("select haslo from Osoba where e_mail='"+login+"';");
				System.out.println("XVI");
				wynik=prepstmt.executeQuery();
				if(wynik.next()) {
					String haslo1 = wynik.getString("haslo");
					haslo1 = odszyfruj(haslo1);
					if (!haslo1.equals(haslo)) return false;
				}else return false;
			}
			else return false;
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			return false;
		}
		return true;
	}

    /**
     * Zmiana hasla boolean.
     *
     * @param id        the id
     * @param nowehaslo the nowehaslo
     * @return the boolean
     */
    public boolean zmianaHasla(int id, String nowehaslo) {//zmiana hasla konta
		try {
			nowehaslo=zaszyfruj(nowehaslo);
			PreparedStatement prepstmt=conn.prepareStatement("update Osoba set haslo='"+nowehaslo+"' WHERE id_osoby="+id+";");
			prepstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

    /**
     * Zablokuj odblokuj boolean.
     *
     * @param id    the id
     * @param akcja the akcja
     * @return the boolean
     */
    public boolean zablokujOdblokuj(int id, int akcja) {//zablokowanie lub odblokowanie uzytkownika
		try {
			PreparedStatement prepstmt=conn.prepareStatement("update Osoba set status_konta="+akcja+" WHERE id_osoby="+id+";");
			prepstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

    /**
     * Ile rekordow int.
     *
     * @param tabela the tabela
     * @return the int
     */
    public int ileRekordow(String tabela) {
		int ile=0;
		try {
			ResultSet result=stat.executeQuery("SELECT * from "+tabela+";");
			while(result.next())
				ile++;
		} catch (SQLException e) {
			System.out.println("B��d po��czenia z baz� danych! " + e.getMessage() + ": " + e.getErrorCode());
			System.exit(1);
		}
		return ile;
	}

    /**
     * Check if table exist boolean.
     *
     * @param nazwatabeli the nazwatabeli
     * @param id          the id
     * @return the boolean
     */
    public boolean checkIfTableExist(String nazwatabeli,int id) {//pobranie id klienta o podanym loginie
		int exist;
		try {
			ResultSet result=stat.executeQuery("SELECT * FROM "+nazwatabeli+" LIMIT 0;");//pobierz nazwe kolumny id
			List<String> columns = new ArrayList<String>();
			ResultSetMetaData mrs = result.getMetaData();
			for(int i = 1; i <= mrs.getColumnCount(); i++) {
				columns.add(mrs.getColumnLabel(i));
			}
			String nazwakolumny=columns.get(0);

			ResultSet result1=stat.executeQuery("SELECT * from " + nazwatabeli + " where "+nazwakolumny+" = "+id+";");

			if(result1.next()) exist=1;
			else return false;
		} catch (SQLException e) {
			exist=0;
			e.printStackTrace();
		}

		if(exist!=0)return true;
		else return false;
	}

    /**
     * Zaszyfruj string.
     *
     * @param s the s
     * @return the string
     */
    public static String zaszyfruj(String s) {
		String wynik="";
		Random rand=new Random();
		int klucz=rand.nextInt(9)+1;
		wynik+=klucz;
		char x[] = s.toCharArray();
		for(int i=0; i<x.length; i++){
			int n = x[i];
			n+=klucz;
			x[i]=(char)n;
			wynik+=x[i];
		}
		System.out.println(wynik);
		return wynik;
	}

    /**
     * Odszyfruj string.
     *
     * @param s the s
     * @return the string
     */
    public static String odszyfruj(String s) {
		String wynik="";
		char x[] = s.toCharArray();
		int klucz=Integer.parseInt(""+x[0]);//pobierz klucz
		for(int i=1; i<x.length; i++){
			int n = x[i];
			n-=klucz;
			x[i]=(char)n;
			wynik+=x[i];
		}
		return wynik;
	}

    /**
     * Get multi 1 list.
     *
     * @param zapytanie    the zapytanie
     * @param liczbakolumn the liczbakolumn
     * @return the list
     */
    public List<String> getMulti1(String zapytanie,int liczbakolumn){//Maciek - pomocniczo do list rozwijalnych
		List<String>lista=new ArrayList<String>();
		String str;
		try {
			PreparedStatement prepstmt=conn.prepareStatement(zapytanie);
			ResultSet wynik=prepstmt.executeQuery();

			wynik=prepstmt.executeQuery();
			while(wynik.next()) {
				str="";
				for(int i=1;i<=liczbakolumn;i++) {
					str+=""+wynik.getObject(i).toString()+" ";
				}
				lista.add(str);
			}
		}catch(SQLException e) {//jesli nie ma rekordu zwroci null
			e.printStackTrace();
			return null;
		}
		return lista;
	}

    /**
     * Close connection.
     */
    public void closeConnection() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.err.println("Problem z zamknieciem polaczenia");
			e.printStackTrace();
		}
	}
}
