package klasy;

/**
 * The type Dostawca.
 */
public class Dostawca {
    /**
     * The Id dostawcy.
     */
    int id_dostawcy, /**
     * The Nip.
     */
    nip;
    /**
     * The Nazwa.
     */
    String nazwa, /**
     * The Kraj.
     */
    kraj, /**
     * The Adres.
     */
    adres;

    /**
     * Gets id dostawcy.
     *
     * @return the id dostawcy
     */
    public int getId_dostawcy() {
		return id_dostawcy;
	}

    /**
     * Sets id dostawcy.
     *
     * @param id_dostawcy the id dostawcy
     */
    public void setId_dostawcy(int id_dostawcy) {
		this.id_dostawcy = id_dostawcy;
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
     * Instantiates a new Dostawca.
     */
    public Dostawca() {
		super();
	}

    /**
     * Instantiates a new Dostawca.
     *
     * @param id_dostawcy the id dostawcy
     * @param nip         the nip
     * @param nazwa       the nazwa
     * @param kraj        the kraj
     * @param adres       the adres
     */
    public Dostawca(int id_dostawcy, int nip, String nazwa, String kraj, String adres) {
		super();
		this.id_dostawcy = id_dostawcy;
		this.nip = nip;
		this.nazwa = nazwa;
		this.kraj = kraj;
		this.adres = adres;
	}
	@Override
	public String toString() {
		return "Dostawca [id_dostawcy=" + id_dostawcy + ", nip=" + nip + ", nazwa=" + nazwa + ", kraj=" + kraj
				+ ", adres=" + adres + "]";
	}
	
}
