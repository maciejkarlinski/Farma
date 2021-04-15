package application;

/**
 * The type Lek fx.
 */
public class LekFx {
    private String idleku;
    private String nazwa;
    private String gramatura;

    /**
     * Instantiates a new Lek fx.
     *
     * @param idleku    the idleku
     * @param nazwa     the nazwa
     * @param gramatura the gramatura
     */
    public LekFx(String idleku,String nazwa,String gramatura){
        this.gramatura=gramatura;
        this.idleku=idleku;
        this.nazwa=nazwa;
    }

    /**
     * Gets idleku.
     *
     * @return the idleku
     */
    public String getIdleku() {
        return idleku;
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
     * Gets nazwa.
     *
     * @return the nazwa
     */
    public String getNazwa() {
        return nazwa;
    }
}
