package klasy;

/**
 * The type Oferta.
 */
public class Oferta {
    /**
     * The Id oferty.
     */
    int id_oferty, /**
     * The Id leku.
     */
    id_leku;
    /**
     * The Cena.
     */
    double cena;

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
     * Gets id leku.
     *
     * @return the id leku
     */
    public int getId_leku() {
		return id_leku;
	}

    /**
     * Sets id leku.
     *
     * @param id_leku the id leku
     */
    public void setId_leku(int id_leku) {
		this.id_leku = id_leku;
	}

    /**
     * Gets cena.
     *
     * @return the cena
     */
    public double getCena() {
		return cena;
	}

    /**
     * Sets cena.
     *
     * @param cena the cena
     */
    public void setCena(double cena) {
		this.cena = cena;
	}

    /**
     * Instantiates a new Oferta.
     */
    public Oferta() {
		super();
	}

    /**
     * Instantiates a new Oferta.
     *
     * @param id_oferty the id oferty
     * @param id_leku   the id leku
     * @param cena      the cena
     */
    public Oferta(int id_oferty, int id_leku, double cena) {
		this.id_oferty = id_oferty;
		this.id_leku = id_leku;
		this.cena = cena;
	}
	public String toString() {
		return id_oferty + " " + id_leku + " " + cena;
	}
}
