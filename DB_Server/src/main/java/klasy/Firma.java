package klasy;

/**
 * The type Firma.
 */
public class Firma {
    /**
     * The Nip.
     */
    int nip, /**
     * The Regon.
     */
    regon;
    /**
     * The Nazwa.
     */
    String nazwa, /**
     * The Adres.
     */
    adres, /**
     * The Miasto.
     */
    miasto, /**
     * The Kod pocztowy.
     */
    kod_pocztowy, /**
     * The Data zalozenia.
     */
    data_zalozenia;

    /**
     * Instantiates a new Firma.
     *
     * @param nip            the nip
     * @param regon          the regon
     * @param nazwa          the nazwa
     * @param adres          the adres
     * @param miasto         the miasto
     * @param kod_pocztowy   the kod pocztowy
     * @param data_zalozenia the data zalozenia
     */
    public Firma(int nip, int regon, String nazwa, String adres, String miasto, String kod_pocztowy, String data_zalozenia) {
		super();
		this.nip = nip;
		this.regon = regon;
		this.nazwa = nazwa;
		this.adres = adres;
		this.miasto = miasto;
		this.kod_pocztowy = kod_pocztowy;
		this.data_zalozenia = data_zalozenia;
	}

    /**
     * Gets nip.
     *
     * @return the nip
     */
    public int getNip() {
		return nip;
	}

    /**
     * Sets nip.
     *
     * @param nip the nip
     */
    public void setNip(int nip) {
		this.nip = nip;
	}

    /**
     * Gets regon.
     *
     * @return the regon
     */
    public int getRegon() {
		return regon;
	}

    /**
     * Sets regon.
     *
     * @param regon the regon
     */
    public void setRegon(int regon) {
		this.regon = regon;
	}

    /**
     * Gets nazwa.
     *
     * @return the nazwa
     */
    public String getNazwa() {
		return nazwa;
	}

    /**
     * Sets nazwa.
     *
     * @param nazwa the nazwa
     */
    public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

    /**
     * Gets adres.
     *
     * @return the adres
     */
    public String getAdres() {
		return adres;
	}

    /**
     * Sets adres.
     *
     * @param adres the adres
     */
    public void setAdres(String adres) {
		this.adres = adres;
	}

    /**
     * Gets miasto.
     *
     * @return the miasto
     */
    public String getMiasto() {
		return miasto;
	}

    /**
     * Sets miasto.
     *
     * @param miasto the miasto
     */
    public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

    /**
     * Gets kod pocztowy.
     *
     * @return the kod pocztowy
     */
    public String getKod_pocztowy() {
		return kod_pocztowy;
	}

    /**
     * Sets kod pocztowy.
     *
     * @param kod_pocztowy the kod pocztowy
     */
    public void setKod_pocztowy(String kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}

    /**
     * Gets data zalozenia.
     *
     * @return the data zalozenia
     */
    public String getData_zalozenia() {
		return data_zalozenia;
	}

    /**
     * Sets data.
     *
     * @param data_zalozenia the data zalozenia
     */
    public void setData(String data_zalozenia) {
		this.data_zalozenia = data_zalozenia;
	}

    /**
     * Instantiates a new Firma.
     */
    public Firma() {
		super();
	}
	public String toString() {
		return "Firma [nip=" + nip + ", regon=" + regon + ", nazwa=" + nazwa + ", adres=" + adres + ", miasto=" + miasto
				+ ", kod_pocztowy=" + kod_pocztowy + ", data_zalozenia=" + data_zalozenia + "]";
	}
	
}
