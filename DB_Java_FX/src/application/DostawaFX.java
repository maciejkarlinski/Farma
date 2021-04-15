package application;

/**
 * The type Dostawa fx.
 */
public class DostawaFX {
    /**
     * The Id dostawy.
     */
    String id_dostawy, /**
     * The Data dostawy.
     */
    data_dostawy, /**
     * The Id surowca.
     */
    id_surowca, /**
     * The Nazwasurowca.
     */
    nazwasurowca, /**
     * The Ilosc.
     */
    ilosc, /**
     * The Nr serii.
     */
    nr_serii, /**
     * The Id dostawcy.
     */
    id_dostawcy, /**
     * The Nazwadostawcy.
     */
    nazwadostawcy;

    /**
     * Gets id dostawy.
     *
     * @return the id dostawy
     */
    public String getId_dostawy() {
        return id_dostawy;
    }

    /**
     * Sets id dostawy.
     *
     * @param id_dostawy the id dostawy
     */
    public void setId_dostawy(String id_dostawy) {
        this.id_dostawy = id_dostawy;
    }

    /**
     * Gets id surowca.
     *
     * @return the id surowca
     */
    public String getId_surowca() {
        return id_surowca;
    }

    /**
     * Sets id surowca.
     *
     * @param id_surowca the id surowca
     */
    public void setId_surowca(String id_surowca) {
        this.id_surowca = id_surowca;
    }

    /**
     * Gets id dostawcy.
     *
     * @return the id dostawcy
     */
    public String getId_dostawcy() {
        return id_dostawcy;
    }

    /**
     * Sets id dostawcy.
     *
     * @param id_dostawcy the id dostawcy
     */
    public void setId_dostawcy(String id_dostawcy) {
        this.id_dostawcy = id_dostawcy;
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
     * Sets ilosc.
     *
     * @param ilosc the ilosc
     */
    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    /**
     * Gets nr serii.
     *
     * @return the nr serii
     */
    public String getNr_serii() {
        return nr_serii;
    }

    /**
     * Sets nr serii.
     *
     * @param nr_serii the nr serii
     */
    public void setNr_serii(String nr_serii) {
        this.nr_serii = nr_serii;
    }

    /**
     * Gets data dostawy.
     *
     * @return the data dostawy
     */
    public String getData_dostawy() {
        return data_dostawy;
    }

    /**
     * Sets data dostawy.
     *
     * @param data_dostawy the data dostawy
     */
    public void setData_dostawy(String data_dostawy) {
        this.data_dostawy = data_dostawy;
    }

    /**
     * Gets nazwasurowca.
     *
     * @return the nazwasurowca
     */
    public String getNazwasurowca() {
        return nazwasurowca;
    }

    /**
     * Sets nazwasurowca.
     *
     * @param nazwasurowca the nazwasurowca
     */
    public void setNazwasurowca(String nazwasurowca) {
        this.nazwasurowca = nazwasurowca;
    }

    /**
     * Gets nazwadostawcy.
     *
     * @return the nazwadostawcy
     */
    public String getNazwadostawcy() {
        return nazwadostawcy;
    }

    /**
     * Sets nazwadostawcy.
     *
     * @param nazwadostawcy the nazwadostawcy
     */
    public void setNazwadostawcy(String nazwadostawcy) {
        this.nazwadostawcy = nazwadostawcy;
    }

    /**
     * Instantiates a new Dostawa fx.
     */
    public DostawaFX() {
        super();
    }

    /**
     * Instantiates a new Dostawa fx.
     *
     * @param id_dostawy    the id dostawy
     * @param id_surowca    the id surowca
     * @param id_dostawcy   the id dostawcy
     * @param ilosc         the ilosc
     * @param nr_serii      the nr serii
     * @param data_dostawy  the data dostawy
     * @param nazwasurowca  the nazwasurowca
     * @param nazwadostawcy the nazwadostawcy
     */
    public DostawaFX(String id_dostawy, String id_surowca, String id_dostawcy, String ilosc, String nr_serii, String data_dostawy,String nazwasurowca, String nazwadostawcy) {
        super();
        this.id_dostawy = id_dostawy;
        this.id_surowca = id_surowca;
        this.id_dostawcy = id_dostawcy;
        this.ilosc = ilosc;
        this.nr_serii = nr_serii;
        this.data_dostawy = data_dostawy;
        this.nazwasurowca = nazwasurowca;
        this.nazwadostawcy = nazwadostawcy;
    }
    @Override
    public String toString() {
        return "Dostawa [id_dostawy=" + id_dostawy + ", id_surowca=" + id_surowca + ", id_dostawcy=" + id_dostawcy
                + ", ilosc=" + ilosc + ", nr_serii=" + nr_serii + ", data_dostawy=" + data_dostawy + ", nazwasurowca="+nazwasurowca+ ", nazwadostawcy="+nazwadostawcy+"]";
    }
}
