package klasy_glowne;

/**
 * The type Faktura.
 */
public class Faktura {
    /**
     * The Id faktury.
     */
    protected int id_faktury;
    /**
     * The Nr faktury.
     */
    protected String nr_faktury;

    /**
     * Gets id faktury.
     *
     * @return the id faktury
     */
    public int getId_faktury() {
		return id_faktury;
	}

    /**
     * Sets id faktury.
     *
     * @param id_faktury the id faktury
     */
    public void setId_faktury(int id_faktury) {
		this.id_faktury = id_faktury;
	}

    /**
     * Gets nr faktury.
     *
     * @return the nr faktury
     */
    public String getNr_faktury() {
		return nr_faktury;
	}

    /**
     * Sets nr faktury.
     *
     * @param nr_faktury the nr faktury
     */
    public void setNr_faktury(String nr_faktury) {
		this.nr_faktury = nr_faktury;
	}

    /**
     * Instantiates a new Faktura.
     */
    public Faktura() {
		super();
	}

    /**
     * Instantiates a new Faktura.
     *
     * @param id_faktury the id faktury
     * @param nr_faktury the nr faktury
     */
    public Faktura(int id_faktury, String nr_faktury) {
		super();
		this.id_faktury = id_faktury;
		this.nr_faktury = nr_faktury;
	}
}
