package klasy;

/**
 * The type Zamowienie.
 */
public class Zamowienie {
    /**
     * The Id zamowienia.
     */
    int id_zamowienia, /**
     * The Id klienta.
     */
    id_klienta, /**
     * The Id koszyka.
     */
    id_koszyka, /**
     * The Stan.
     */
    stan;
    /**
     * The Waga.
     */
    double waga;
    /**
     * The Data zlozenia.
     */
    String data_zlozenia, /**
     * The Data realizacji.
     */
    data_realizacji;

    /**
     * Gets id zamowienia.
     *
     * @return the id zamowienia
     */
    public int getId_zamowienia() {
		return id_zamowienia;
	}

    /**
     * Sets id zamowienia.
     *
     * @param id_zamowienia the id zamowienia
     */
    public void setId_zamowienia(int id_zamowienia) {
		this.id_zamowienia = id_zamowienia;
	}

    /**
     * Gets id klienta.
     *
     * @return the id klienta
     */
    public int getId_klienta() {
		return id_klienta;
	}

    /**
     * Sets id klienta.
     *
     * @param id_klienta the id klienta
     */
    public void setId_klienta(int id_klienta) {
		this.id_klienta = id_klienta;
	}

    /**
     * Gets id koszyka.
     *
     * @return the id koszyka
     */
    public int getId_koszyka() {
		return id_koszyka;
	}

    /**
     * Sets id koszyka.
     *
     * @param id_koszyka the id koszyka
     */
    public void setId_koszyka(int id_koszyka) {
		this.id_koszyka = id_koszyka;
	}

    /**
     * Gets stan.
     *
     * @return the stan
     */
    public int getStan() {
		return stan;
	}

    /**
     * Sets stan.
     *
     * @param stan the stan
     */
    public void setStan(int stan) {
		this.stan = stan;
	}

    /**
     * Gets waga.
     *
     * @return the waga
     */
    public double getWaga() {
		return waga;
	}

    /**
     * Sets waga.
     *
     * @param waga the waga
     */
    public void setWaga(double waga) {
		this.waga = waga;
	}

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
     * Instantiates a new Zamowienie.
     */
    public Zamowienie() {
		super();
	}

    /**
     * Instantiates a new Zamowienie.
     *
     * @param id_zamowienia   the id zamowienia
     * @param id_klienta      the id klienta
     * @param id_koszyka      the id koszyka
     * @param stan            the stan
     * @param waga            the waga
     * @param data_zlozenia   the data zlozenia
     * @param data_realizacji the data realizacji
     */
    public Zamowienie(int id_zamowienia, int id_klienta, int id_koszyka, int stan, double waga, String data_zlozenia,
					  String data_realizacji) {
		super();
		this.id_zamowienia = id_zamowienia;
		this.id_klienta = id_klienta;
		this.id_koszyka = id_koszyka;
		this.stan = stan;
		this.waga = waga;
		this.data_zlozenia = data_zlozenia;
		this.data_realizacji = data_realizacji;
	}
	@Override
	public String toString() {
		return id_zamowienia + " " + id_klienta + " "
				+ id_koszyka + " " + waga + " " + data_zlozenia + " " + data_realizacji
				+ " " + stan;
	}

}
