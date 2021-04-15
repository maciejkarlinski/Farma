package klasy;

/**
 * The type Magazyn.
 */
public class Magazyn {
    /**
     * The Pozycja na magazynie.
     */
    int pozycja_na_magazynie, /**
     * The Id surowca.
     */
    id_surowca, /**
     * The Ilosc.
     */
    ilosc;

    /**
     * Gets id surowca.
     *
     * @return the id surowca
     */
    public int getId_surowca() {
		return id_surowca;
	}

    /**
     * Sets id surowca.
     *
     * @param id_surowca the id surowca
     */
    public void setId_surowca(int id_surowca) {
		this.id_surowca = id_surowca;
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
     * Gets pozycja na magazynie.
     *
     * @return the pozycja na magazynie
     */
    public int getPozycja_na_magazynie() {
		return pozycja_na_magazynie;
	}

    /**
     * Sets pozycja na magazynie.
     *
     * @param pozycja_na_magazynie the pozycja na magazynie
     */
    public void setPozycja_na_magazynie(int pozycja_na_magazynie) {
		this.pozycja_na_magazynie = pozycja_na_magazynie;
	}

    /**
     * Instantiates a new Magazyn.
     */
    public Magazyn() {
		super();
	}

    /**
     * Instantiates a new Magazyn.
     *
     * @param pozycja_na_magazynie the pozycja na magazynie
     * @param id_surowca           the id surowca
     * @param ilosc                the ilosc
     */
    public Magazyn(int pozycja_na_magazynie,int id_surowca,int ilosc) {
		super();
		this.id_surowca = id_surowca;
		this.ilosc = ilosc;
		this.pozycja_na_magazynie = pozycja_na_magazynie;
	}
	public String toString() {
		return "Pozycja na magazynie [pozycja_na_magazynie=" + pozycja_na_magazynie + ", id_surowca=" + id_surowca + ", ilosc=" + ilosc + "]";
	}
	
}

