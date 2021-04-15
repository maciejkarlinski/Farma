package application;

/**
 * The type Oferty fx.
 */
public class OfertyFX {
    private String idoferty;
    private String idleku;
    private String cena;
    private String nazwa;

    /**
     * Instantiates a new Oferty fx.
     *
     * @param idoferty the idoferty
     * @param idleku   the idleku
     * @param nazwa    the nazwa
     * @param cena     the cena
     */
    public OfertyFX(String idoferty,String idleku,String nazwa,String cena){
        this.cena=cena;
        this.idleku=idleku;
        this.idoferty=idoferty;
        this.nazwa=nazwa;
    }

    /**
     * Gets cena.
     *
     * @return the cena
     */
    public String getCena() {
        return cena;
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
     * Gets idoferty.
     *
     * @return the idoferty
     */
    public String getIdoferty() {
        return idoferty;
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
