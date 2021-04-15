package application;

/**
 * The type Lek fx 1.
 */
public class LekFX1 {
    /**
     * The Id leku.
     */
    String id_leku, /**
     * The Gramatura.
     */
    gramatura, /**
     * The Nazwa.
     */
    nazwa;

    /**
     * Gets id leku.
     *
     * @return the id leku
     */
    public String getId_leku() {
        return id_leku;
    }

    /**
     * Sets id leku.
     *
     * @param id_leku the id leku
     */
    public void setId_leku(String id_leku) {
        this.id_leku = id_leku;
    }

    /**
     * Gets gramatura.
     *
     * @return the gramatura
     */
    public String getGramatura() {
        return gramatura;
    }

    /**
     * Sets gramatura.
     *
     * @param gramatura the gramatura
     */
    public void setGramatura(String gramatura) {
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
     * Instantiates a new Lek fx 1.
     */
    public LekFX1() {
        super();
    }

    /**
     * Instantiates a new Lek fx 1.
     *
     * @param id_leku   the id leku
     * @param gramatura the gramatura
     * @param nazwa     the nazwa
     */
    public LekFX1(String id_leku, String gramatura, String nazwa) {
        super();
        this.id_leku = id_leku;
        this.gramatura = gramatura;
        this.nazwa = nazwa;
    }

    public String toString() {
        return id_leku + " " + nazwa+ " " + gramatura;
    }
}
