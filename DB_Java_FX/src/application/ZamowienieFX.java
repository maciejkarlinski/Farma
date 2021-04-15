package application;

/**
 * The type Zamowienie fx.
 */
public class ZamowienieFX {
    /**
     * Instantiates a new Zamowienie fx.
     *
     * @param id_zamowienia   the id zamowienia
     * @param id_klienta      the id klienta
     * @param id_koszyka      the id koszyka
     * @param waga            the waga
     * @param data_zlozenia   the data zlozenia
     * @param data_realizacji the data realizacji
     * @param stan            the stan
     */
    public ZamowienieFX(String id_zamowienia, String id_klienta, String id_koszyka, String waga, String data_zlozenia, String data_realizacji, String stan) {
		this.data_zlozenia = data_zlozenia;
		this.data_realizacji = data_realizacji;
		this.id_zamowienia = id_zamowienia;
		this.id_klienta = id_klienta;
		this.id_koszyka = id_koszyka;
		this.stan = stan;
		this.waga = waga;
	}

	private String data_zlozenia,data_realizacji,id_zamowienia,id_klienta,id_koszyka,stan,waga;

    /**
     * Gets data zlozenia.
     *
     * @return the data zlozenia
     */
    public String getData_zlozenia() {
		return data_zlozenia;
	}

    /**
     * Sets data zlozenia.
     *
     * @param data_zlozenia the data zlozenia
     */
    public void setData_zlozenia(String data_zlozenia) {
		this.data_zlozenia = data_zlozenia;
	}

    /**
     * Gets data realizacji.
     *
     * @return the data realizacji
     */
    public String getData_realizacji() {
		return data_realizacji;
	}

    /**
     * Sets data realizacji.
     *
     * @param data_realizacji the data realizacji
     */
    public void setData_realizacji(String data_realizacji) {
		this.data_realizacji = data_realizacji;
	}

    /**
     * Gets id zamowienia.
     *
     * @return the id zamowienia
     */
    public String getId_zamowienia() {
		return id_zamowienia;
	}

    /**
     * Sets id zamowienia.
     *
     * @param id_zamowienia the id zamowienia
     */
    public void setId_zamowienia(String id_zamowienia) {
		this.id_zamowienia = id_zamowienia;
	}

    /**
     * Gets id klienta.
     *
     * @return the id klienta
     */
    public String getId_klienta() {
		return id_klienta;
	}

    /**
     * Sets id klienta.
     *
     * @param id_klienta the id klienta
     */
    public void setId_klienta(String id_klienta) {
		this.id_klienta = id_klienta;
	}

    /**
     * Gets id koszyka.
     *
     * @return the id koszyka
     */
    public String getId_koszyka() {
		return id_koszyka;
	}

    /**
     * Sets id koszyka.
     *
     * @param id_koszyka the id koszyka
     */
    public void setId_koszyka(String id_koszyka) {
		this.id_koszyka = id_koszyka;
	}

    /**
     * Gets stan.
     *
     * @return the stan
     */
    public String getStan() {
		return stan;
	}

    /**
     * Sets stan.
     *
     * @param stan the stan
     */
    public void setStan(String stan) {
		this.stan = stan;
	}

    /**
     * Gets waga.
     *
     * @return the waga
     */
    public String getWaga() {
		return waga;
	}

    /**
     * Sets waga.
     *
     * @param waga the waga
     */
    public void setWaga(String waga) {
		this.waga = waga;
	}



	
}
