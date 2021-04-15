package application;

/**
 * The type Magazyn fx.
 */
public class MagazynFX {
    /**
     * The Pozycja na magazynie.
     */
    String pozycja_na_magazynie, /**
     * The Id surowca.
     */
    id_surowca, /**
     * The Nazwa.
     */
    nazwa, /**
     * The Ilosc.
     */
    ilosc, /**
     * The Data.
     */
    data;

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
     * Gets pozycja na magazynie.
     *
     * @return the pozycja na magazynie
     */
    public String getPozycja_na_magazynie() {
        return pozycja_na_magazynie;
    }

    /**
     * Sets pozycja na magazynie.
     *
     * @param pozycja_na_magazynie the pozycja na magazynie
     */
    public void setPozycja_na_magazynie(String pozycja_na_magazynie) {
        this.pozycja_na_magazynie = pozycja_na_magazynie;
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
     * Gets data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Instantiates a new Magazyn fx.
     *
     * @param pozycja_na_magazynie the pozycja na magazynie
     * @param id_surowca           the id surowca
     * @param nazwa                the nazwa
     * @param ilosc                the ilosc
     * @param data                 the data
     */
    public MagazynFX(String pozycja_na_magazynie, String id_surowca, String nazwa, String ilosc, String data) {
        super();
        this.id_surowca = id_surowca;
        this.ilosc = ilosc;
        this.pozycja_na_magazynie = pozycja_na_magazynie;
        this.nazwa = nazwa;
        this.data = data;
    }
    public String toString() {
        return "Pozycja na magazynie [pozycja_na_magazynie=" + pozycja_na_magazynie + ", id_surowca=" + id_surowca + ", nazwa="+nazwa+", ilosc=" + ilosc + ", data=" +data+"]";
    }

}

