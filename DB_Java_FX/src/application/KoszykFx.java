package application;

/**
 * The type Koszyk fx.
 */
public class KoszykFx {
    private String idkoszyka;
    private String idoferty;
    private String idklienta;
    private String ilosc;
    private String koszt;

    /**
     * Instantiates a new Koszyk fx.
     *
     * @param idkoszyka the idkoszyka
     * @param idoferty  the idoferty
     * @param idklienta the idklienta
     * @param ilosc     the ilosc
     * @param koszt     the koszt
     */
    public KoszykFx(String idkoszyka,String idoferty,String idklienta,String ilosc,String koszt){
        this.idkoszyka=idkoszyka;
        this.idoferty=idoferty;
        this.idklienta=idklienta;
        this.ilosc=ilosc;
        this.koszt=koszt;
    }

    /**
     * Gets idkoszyka.
     *
     * @return the idkoszyka
     */
    public String getIdkoszyka() {
        return idkoszyka;
    }

    /**
     * Gets idklienta.
     *
     * @return the idklienta
     */
    public String getIdklienta() {
        return idklienta;
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
     * Gets ilosc.
     *
     * @return the ilosc
     */
    public String getIlosc() {
        return ilosc;
    }

    /**
     * Gets koszt.
     *
     * @return the koszt
     */
    public String getKoszt() {
        return koszt;
    }
}
