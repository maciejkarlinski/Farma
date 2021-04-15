package application;


/**
 * The type Pracownik fx.
 */
public class PracownikFX {
	private  String stanowisko,idosoby,wynagrodzenie,idpracownika,imie,nazwisko;

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
     * Gets idosoby.
     *
     * @return the idosoby
     */
    public String getIdosoby() {
		return idosoby;
	}

    /**
     * Sets idosoby.
     *
     * @param idosoby the idosoby
     */
    public void setIdosoby(String idosoby) {
		this.idosoby = idosoby;
	}

    /**
     * Gets wynagrodzenie.
     *
     * @return the wynagrodzenie
     */
    public String getWynagrodzenie() {
		return wynagrodzenie;
	}

    /**
     * Sets wynagrodzenie.
     *
     * @param wynagrodzenie the wynagrodzenie
     */
    public void setWynagrodzenie(String wynagrodzenie) {
		this.wynagrodzenie = wynagrodzenie;
	}

    /**
     * Gets idpracownika.
     *
     * @return the idpracownika
     */
    public String getIdpracownika() {
		return idpracownika;
	}

    /**
     * Sets idpracownika.
     *
     * @param idpracownika the idpracownika
     */
    public void setIdpracownika(String idpracownika) {
		this.idpracownika = idpracownika;
	}

    /**
     * Gets imie.
     *
     * @return the imie
     */
    public String getImie() {
		return imie;
	}

    /**
     * Gets nazwisko.
     *
     * @return the nazwisko
     */
    public String getNazwisko() {
		return nazwisko;
	}

    /**
     * Instantiates a new Pracownik fx.
     *
     * @param idpracownika  the idpracownika
     * @param idosoby       the idosoby
     * @param imie          the imie
     * @param nazwisko      the nazwisko
     * @param wynagrodzenie the wynagrodzenie
     * @param stanowisko    the stanowisko
     */
    public PracownikFX(String idpracownika, String idosoby, String imie, String nazwisko, String wynagrodzenie, String stanowisko) {
		this.stanowisko = stanowisko;
		this.idosoby = idosoby;
		this.wynagrodzenie = wynagrodzenie;
		this.idpracownika = idpracownika;
		this.imie=imie;
		this.nazwisko=nazwisko;
	}



	}


