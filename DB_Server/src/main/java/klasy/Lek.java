package klasy;

/**
 * The type Lek.
 */
public class Lek {
    /**
     * The Id leku.
     */
    int id_leku, /**
     * The Gramatura.
     */
    gramatura;
    /**
     * The Nazwa.
     */
    String nazwa;

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
     * Gets gramatura.
     *
     * @return the gramatura
     */
    public int getGramatura() {
		return gramatura;
	}

    /**
     * Sets gramatura.
     *
     * @param gramatura the gramatura
     */
    public void setGramatura(int gramatura) {
		this.gramatura = gramatura;
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
     * Instantiates a new Lek.
     */
    public Lek() {
		super();
	}

    /**
     * Instantiates a new Lek.
     *
     * @param id_leku   the id leku
     * @param gramatura the gramatura
     * @param nazwa     the nazwa
     */
    public Lek(int id_leku, int gramatura, String nazwa) {
		super();
		this.id_leku = id_leku;
		this.gramatura = gramatura;
		this.nazwa = nazwa;
	}
	public String toString() {
		return id_leku + " " + nazwa+ " " + gramatura;
	}

}
