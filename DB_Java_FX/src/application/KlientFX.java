package application;

/**
 * The type Klient fx.
 */
public class KlientFX {
    /**
     * The Idklienta.
     */
    String idklienta, /**
     * The Idosoby.
     */
    idosoby, /**
     * The Telefon.
     */
    telefon, /**
     * The Nip.
     */
    nip;
    /**
     * The Imie.
     */
    String imie, /**
     * The Nazwisko.
     */
    nazwisko, /**
     * The Email.
     */
    email;

    /**
     * Instantiates a new Klient fx.
     *
     * @param idklienta the idklienta
     * @param idosoby   the idosoby
     * @param imie      the imie
     * @param nazwisko  the nazwisko
     * @param email     the email
     * @param telefon   the telefon
     * @param nip       the nip
     */
    public KlientFX(String idklienta,String idosoby, String imie, String nazwisko,String email,String telefon,String nip){
        this.idklienta=idklienta;
        this.idosoby=idosoby;
        this.telefon=telefon;
        this.nip=nip;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.email=email;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets imie.
     *
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * Gets nazwisko.
     *
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
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
     * Gets idosoby.
     *
     * @return the idosoby
     */
    public String getIdosoby() {
        return idosoby;
    }

    /**
     * Gets nip.
     *
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * Gets telefon.
     *
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }
}
