package klasy;

import klasy_glowne.Osoba;

/**
 * The type Pracownik.
 */
public class Pracownik extends Osoba{
    /**
     * The Idosoby.
     */
    int idosoby, /**
     * The Wynagrodzenie.
     */
    wynagrodzenie;
    /**
     * The Stanowisko.
     */
    String stanowisko;

    /**
     * Gets wynagrodzenie.
     *
     * @return the wynagrodzenie
     */
    public int getWynagrodzenie() {
		return wynagrodzenie;
	}

    /**
     * Sets wynagrodzenie.
     *
     * @param wynagrodzenie the wynagrodzenie
     */
    public void setWynagrodzenie(int wynagrodzenie) {
		this.wynagrodzenie = wynagrodzenie;
	}

    /**
     * Gets stanowisko.
     *
     * @return the stanowisko
     */
    public String getStanowisko() {
		return stanowisko;
	}

    /**
     * Sets stanowisko.
     *
     * @param stanowisko the stanowisko
     */
    public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

    /**
     * Instantiates a new Pracownik.
     */
    public Pracownik() {
		super();
	}

    /**
     * Instantiates a new Pracownik.
     *
     * @param id            the id
     * @param nrtel         the nrtel
     * @param pesel         the pesel
     * @param imie          the imie
     * @param nazwisko      the nazwisko
     * @param email         the email
     * @param idosoby       the idosoby
     * @param wynagrodzenie the wynagrodzenie
     * @param stanowisko    the stanowisko
     * @param haslo         the haslo
     */
    public Pracownik(int id, int nrtel, int pesel, String imie, String nazwisko, String email, int idosoby,
			int wynagrodzenie, String stanowisko,String haslo) {
		super(id, nrtel, pesel, imie, nazwisko, email,haslo,0);
		this.idosoby = idosoby;
		this.wynagrodzenie = wynagrodzenie;
		this.stanowisko = stanowisko;
	}
	
	public String toString() {
		return id_osoby + " " + idosoby + " " + wynagrodzenie + " " + stanowisko;
	}
}
