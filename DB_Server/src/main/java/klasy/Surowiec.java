package klasy;

/**
 * The type Surowiec.
 */
public class Surowiec {
    /**
     * The Id surowca.
     */
    int id_surowca, /**
     * The Id dostawcy.
     */
    id_dostawcy, /**
     * The Pozycja na magazynie.
     */
    pozycja_na_magazynie;
    /**
     * The Nazwa.
     */
    String nazwa, /**
     * The Data przydatnosci.
     */
    data_przydatnosci;

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
     * Gets data przydatnosci.
     *
     * @return the data przydatnosci
     */
    public String getData_przydatnosci() {
		return data_przydatnosci;
	}

    /**
     * Sets data przydatnosci.
     *
     * @param data_przydatnosci the data przydatnosci
     */
    public void setData_przydatnosci(String data_przydatnosci) {
		this.data_przydatnosci = data_przydatnosci;
	}

    /**
     * Instantiates a new Surowiec.
     */
    public Surowiec() {
		super();
	}

    /**
     * Instantiates a new Surowiec.
     *
     * @param id_surowca           the id surowca
     * @param id_dostawcy          the id dostawcy
     * @param pozycja_na_magazynie the pozycja na magazynie
     * @param nazwa                the nazwa
     * @param data_przydatnosci    the data przydatnosci
     */
    public Surowiec(int id_surowca, int id_dostawcy, int pozycja_na_magazynie, String nazwa, String data_przydatnosci) {
		super();
		this.id_surowca = id_surowca;
		this.id_dostawcy = id_dostawcy;
		this.pozycja_na_magazynie = pozycja_na_magazynie;
		this.nazwa = nazwa;
		this.data_przydatnosci = data_przydatnosci;
	}
	@Override
	public String toString() {
		return "Surowiec [id_surowca=" + id_surowca + ", id_dostawcy=" + id_dostawcy + ", pozycja_na_magazynie="
				+ pozycja_na_magazynie + ", nazwa=" + nazwa + ", data_przydatnosci=" + data_przydatnosci + "]";
	}
	
}
