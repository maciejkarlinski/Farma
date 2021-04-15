package application;

/**
 * The type Oferta fx.
 */
public class OfertaFX {
    /**
     * The Id oferty.
     */
    String id_oferty, /**
     * The Nazwa.
     */
    nazwa, /**
     * The Cena.
     */
    cena, /**
     * The Gramatura.
     */
    gramatura;

    /**
     * Gets id oferty.
     *
     * @return the id oferty
     */
    public String getId_oferty() {
        return id_oferty;
    }

    /**
     * Sets id oferty.
     *
     * @param id_oferty the id oferty
     */
    public void setId_oferty(String id_oferty) {
        this.id_oferty = id_oferty;
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
     * Sets cena.
     *
     * @param cena the cena
     */
    public void setCena(String cena) {
        this.cena = cena;
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
     * Instantiates a new Oferta fx.
     */
    public OfertaFX() {
        super();
    }

    /**
     * Instantiates a new Oferta fx.
     *
     * @param id_oferty the id oferty
     * @param nazwa     the nazwa
     * @param cena      the cena
     * @param gramatura the gramatura
     */
    public OfertaFX(String id_oferty, String nazwa, String cena, String gramatura) {
        this.id_oferty = id_oferty;
        this.nazwa = nazwa;
        this.cena = cena;
        this.gramatura = gramatura;
    }
    public String toString() {
        return "Oferta [id_oferty=" + id_oferty + ", nazwa=" + nazwa + ", cena=" + cena + ", gramatura="+gramatura+"]";
    }
}
