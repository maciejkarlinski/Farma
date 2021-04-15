package klasy;

/**
 * The type Koszyk.
 */
public class Koszyk {
    /**
     * The Id koszyka.
     */
    int id_koszyka, /**
     * The Id oferty.
     */
    id_oferty, /**
     * The Ilosc.
     */
    ilosc, /**
     * The Id klienta.
     */
    id_klienta;
    /**
     * The Koszt.
     */
    double koszt;

    /**
     * Gets id koszyka.
     *
     * @return the id koszyka
     */
    public int getId_koszyka() {
		return id_koszyka;
	}

    /**
     * Get id klienta int.
     *
     * @return the int
     */
    public int getId_klienta(){
		return id_klienta;
	}

    /**
     * Sets id klienta.
     *
     * @param id_klienta the id klienta
     */
    public void setId_klienta(int id_klienta)
	{
		this.id_klienta=id_klienta;
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
     * Gets id oferty.
     *
     * @return the id oferty
     */
    public int getId_oferty() {
		return id_oferty;
	}

    /**
     * Sets id oferty.
     *
     * @param id_oferty the id oferty
     */
    public void setId_oferty(int id_oferty) {
		this.id_oferty = id_oferty;
	}

    /**
     * Gets ilosc.
     *
     * @return the ilosc
     */
    public int getIlosc() {
		return ilosc;
	}

    /**
     * Sets ilosc.
     *
     * @param ilosc the ilosc
     */
    public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

    /**
     * Gets koszt.
     *
     * @return the koszt
     */
    public double getKoszt() {
		return koszt;
	}

    /**
     * Sets koszt.
     *
     * @param koszt the koszt
     */
    public void setKoszt(double koszt) {
		this.koszt = koszt;
	}

    /**
     * Instantiates a new Koszyk.
     */
    public Koszyk() {
		super();
	}

    /**
     * Instantiates a new Koszyk.
     *
     * @param id_koszyka the id koszyka
     * @param id_oferty  the id oferty
     * @param id_klienta the id klienta
     * @param ilosc      the ilosc
     * @param koszt      the koszt
     */
    public Koszyk(int id_koszyka, int id_oferty,int id_klienta, int ilosc, double koszt) {
		super();
		this.id_koszyka = id_koszyka;
		this.id_oferty = id_oferty;
		this.id_klienta=id_klienta;
		this.ilosc = ilosc;
		this.koszt = koszt;
	}

	public String toString() {
		return id_koszyka + " " + id_oferty + " "+id_klienta+" " + ilosc + " " + koszt;
	}
}
