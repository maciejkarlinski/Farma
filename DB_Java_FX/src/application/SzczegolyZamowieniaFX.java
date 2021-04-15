package application;

/**
 * The type Szczegoly zamowienia fx.
 */
public class SzczegolyZamowieniaFX {
    private String idzamowienia;
    private String idklienta;
    private String waga;
    private String dataz;
    private String datar;
    private String stan;
    private String ilosc;
    private String koszt;
    private String nazwa;
    private String gramatura;

    /**
     * Instantiates a new Szczegoly zamowienia fx.
     *
     * @param idzamowienia the idzamowienia
     * @param idklienta    the idklienta
     * @param waga         the waga
     * @param dataz        the dataz
     * @param datar        the datar
     * @param stan         the stan
     * @param ilosc        the ilosc
     * @param koszt        the koszt
     * @param nazwa        the nazwa
     * @param gramatura    the gramatura
     */
    public SzczegolyZamowieniaFX(String idzamowienia,String idklienta,String waga,String dataz,String datar,String stan,String ilosc,String koszt, String nazwa, String gramatura){
        this.idzamowienia=idzamowienia;
        this.idklienta=idklienta;
        this.waga=waga;
        this.dataz=dataz;
        this.datar=datar;
        this.stan=stan;
        this.ilosc=ilosc;
        this.koszt=koszt;
        this.nazwa=nazwa;
        this.gramatura=gramatura;
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
     * Gets koszt.
     *
     * @return the koszt
     */
    public String getKoszt() {
        return koszt;
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
     * Gets ilosc.
     *
     * @return the ilosc
     */
    public String getIlosc() {
        return ilosc;
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
