package klasy;

/**
 * The type Dostawa.
 */
public class Dostawa {
    /**
     * The Id dostawy.
     */
    int id_dostawy, /**
     * The Id surowca.
     */
    id_surowca, /**
     * The Id dostawcy.
     */
    id_dostawcy, /**
     * The Ilosc.
     */
    ilosc, /**
     * The Nr serii.
     */
    nr_serii;
    /**
     * The Data dostawy.
     */
    String data_dostawy;

    /**
     * Gets id dostawy.
     *
     * @return the id dostawy
     */
    public int getId_dostawy() {
		return id_dostawy;
	}

    /**
     * Sets id dostawy.
     *
     * @param id_dostawy the id dostawy
     */
    public void setId_dostawy(int id_dostawy) {
		this.id_dostawy = id_dostawy;
	}

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
     * Gets nr serii.
     *
     * @return the nr serii
     */
    public int getNr_serii() {
		return nr_serii;
	}

    /**
     * Sets nr serii.
     *
     * @param nr_serii the nr serii
     */
    public void setNr_serii(int nr_serii) {
		this.nr_serii = nr_serii;
	}

    /**
     * Gets data dostawy.
     *
     * @return the data dostawy
     */
    public String getData_dostawy() {
		return data_dostawy;
	}

    /**
     * Sets data dostawy.
     *
     * @param data_dostawy the data dostawy
     */
    public void setData_dostawy(String data_dostawy) {
		this.data_dostawy = data_dostawy;
	}

    /**
     * Instantiates a new Dostawa.
     */
    public Dostawa() {
		super();
	}

    /**
     * Instantiates a new Dostawa.
     *
     * @param id_dostawy   the id dostawy
     * @param id_surowca   the id surowca
     * @param id_dostawcy  the id dostawcy
     * @param ilosc        the ilosc
     * @param nr_serii     the nr serii
     * @param data_dostawy the data dostawy
     */
    public Dostawa(int id_dostawy, int id_surowca, int id_dostawcy, int ilosc, int nr_serii, String data_dostawy) {
		super();
		this.id_dostawy = id_dostawy;
		this.id_surowca = id_surowca;
		this.id_dostawcy = id_dostawcy;
		this.ilosc = ilosc;
		this.nr_serii = nr_serii;
		this.data_dostawy = data_dostawy;
	}
	@Override
	public String toString() {
		return "Dostawa [id_dostawy=" + id_dostawy + ", id_surowca=" + id_surowca + ", id_dostawcy=" + id_dostawcy
				+ ", ilosc=" + ilosc + ", nr_serii=" + nr_serii + ", data_dostawy=" + data_dostawy + "]";
	}
	
}
