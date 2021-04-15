package application;

/**
 * The type Dostawca fx.
 */
public class DostawcaFX {

    /**
     * Gets id dostawcy.
     *
     * @return the id dostawcy
     */
    public String getId_dostawcy() {
		return id_dostawcy;
	}

    /**
     * Sets id dostawcy.
     *
     * @param id_dostawcy the id dostawcy
     */
    public void setId_dostawcy(String id_dostawcy) {
		this.id_dostawcy = id_dostawcy;
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
     * Gets nip.
     *
     * @return the nip
     */
    public String getNip() {
		return nip;
	}

    /**
     * Sets nip.
     *
     * @param nip the nip
     */
    public void setNip(String nip) {
		this.nip = nip;
	}

    /**
     * Gets kraj.
     *
     * @return the kraj
     */
    public String getKraj() {
		return kraj;
	}

    /**
     * Sets kraj.
     *
     * @param kraj the kraj
     */
    public void setKraj(String kraj) {
		this.kraj = kraj;
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
     * Instantiates a new Dostawca fx.
     *
     * @param id_dostawcy the id dostawcy
     * @param nazwa       the nazwa
     * @param nip         the nip
     * @param kraj        the kraj
     * @param adres       the adres
     */
    public DostawcaFX(String id_dostawcy, String nazwa, String nip, String kraj, String adres) {
		this.id_dostawcy = id_dostawcy;
		this.nazwa = nazwa;
		this.nip = nip;
		this.kraj = kraj;
		this.adres = adres;
	}

    /**
     * The Id dostawcy.
     */
    String id_dostawcy, /**
     * The Nazwa.
     */
    nazwa, /**
     * The Nip.
     */
    nip, /**
     * The Kraj.
     */
    kraj, /**
     * The Adres.
     */
    adres;

	
}
