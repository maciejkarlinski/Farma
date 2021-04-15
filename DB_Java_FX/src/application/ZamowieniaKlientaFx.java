package application;

/**
 * The type Zamowienia klienta fx.
 */
public class ZamowieniaKlientaFx {
    private String idzamowienia;
    private String idklienta;
    private String idkoszyka;
    private String waga;
    private String dataz;
    private String datar;
    private String stan;

    /**
     * Instantiates a new Zamowienia klienta fx.
     *
     * @param idzamowienia the idzamowienia
     * @param idklienta    the idklienta
     * @param idkoszyka    the idkoszyka
     * @param waga         the waga
     * @param dataz        the dataz
     * @param datar        the datar
     * @param stan         the stan
     */
    public ZamowieniaKlientaFx(String idzamowienia,String idklienta,String idkoszyka,String waga,String dataz,String datar,String stan){
        this.idzamowienia=idzamowienia;
        this.idklienta=idklienta;
        this.idkoszyka=idkoszyka;
        this.waga=waga;
        this.dataz=dataz;
        this.datar=datar;
        this.stan=stan;
    }

    /**
     * Gets datar.
     *
     * @return the datar
     */
    public String getDatar() {
        return datar;
    }

    /**
     * Gets dataz.
     *
     * @return the dataz
     */
    public String getDataz() {
        return dataz;
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
     * Gets idkoszyka.
     *
     * @return the idkoszyka
     */
    public String getIdkoszyka() {
        return idkoszyka;
    }

    /**
     * Gets idzamowienia.
     *
     * @return the idzamowienia
     */
    public String getIdzamowienia() {
        return idzamowienia;
    }

    /**
     * Gets stan.
     *
     * @return the stan
     */
    public String getStan() {
        return stan;
    }

    /**
     * Gets waga.
     *
     * @return the waga
     */
    public String getWaga() {
        return waga;
    }

}
