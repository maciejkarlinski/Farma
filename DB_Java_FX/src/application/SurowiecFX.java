package application;

/**
 * The type Surowiec fx.
 */
public class SurowiecFX {
    /**
     * The Id surowca.
     */
    String id_surowca, /**
     * The Nazwa.
     */
    nazwa, /**
     * The Pozycja na magazynie.
     */
    pozycja_na_magazynie, /**
     * The Data przydatnosci.
     */
    data_przydatnosci, /**
     * The Dostawca.
     */
    dostawca;

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
     * Gets data przydatnosci.
     *
     * @return the data przydatnosci
     */
    public String getData_przydatnosci() {
        return data_przydatnosci;
    }

    /**
     * Sets data przydatnosci.
     *
     * @param data_przydatnosci the data przydatnosci
     */
    public void setData_przydatnosci(String data_przydatnosci) {
        this.data_przydatnosci = data_przydatnosci;
    }

    /**
     * Gets dostawca.
     *
     * @return the dostawca
     */
    public String getDostawca() {
        return dostawca;
    }

    /**
     * Sets dostawca.
     *
     * @param dostawca the dostawca
     */
    public void setDostawca(String dostawca) {
        this.dostawca = dostawca;
    }

    /**
     * Instantiates a new Surowiec fx.
     */
    public SurowiecFX() {
        super();
    }

    /**
     * Instantiates a new Surowiec fx.
     *
     * @param id_surowca           the id surowca
     * @param nazwa                the nazwa
     * @param pozycja_na_magazynie the pozycja na magazynie
     * @param data_przydatnosci    the data przydatnosci
     * @param dostawca             the dostawca
     */
    public SurowiecFX(String id_surowca,String nazwa,String pozycja_na_magazynie,String data_przydatnosci,String dostawca) {
        super();
        this.id_surowca = id_surowca;
        this.nazwa = nazwa;
        this.pozycja_na_magazynie = pozycja_na_magazynie;
        this.data_przydatnosci = data_przydatnosci;
        this.dostawca = dostawca;
    }
    @Override
    public String toString() {
        return "Surowiec [id_surowca=" + id_surowca + ", nazwa=" + nazwa + ", pozycja_na_magazynie="
                + pozycja_na_magazynie + ", data_przydatnosci=" + data_przydatnosci + ", dostawca=" + dostawca + "]";
    }

}
