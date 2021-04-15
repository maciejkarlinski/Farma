package application;

/**
 * The type Faktura klient fx.
 */
public class FakturaKlientFX extends FakturaFX{
    /**
     * The Id zamowienia.
     */
    String id_zamowienia, /**
     * The Imie.
     */
    imie, /**
     * The Nazwisko.
     */
    nazwisko, /**
     * The Nip.
     */
    nip, /**
     * The Email.
     */
    email;

    /**
     * Gets id zamowienia.
     *
     * @return the id zamowienia
     */
    public String getId_zamowienia() {
        return id_zamowienia;
    }

    /**
     * Sets id zamowienia.
     *
     * @param id_zamowienia the id zamowienia
     */
    public void setId_zamowienia(String id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
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
     * Sets imie.
     *
     * @param imie the imie
     */
    public void setImie(String imie) {
        this.imie = imie;
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
     * Sets nazwisko.
     *
     * @param nazwisko the nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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
     * Sets nip.
     *
     * @param nip the nip
     */
    public void setNip(String nip) {
        this.nip = nip;
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
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Instantiates a new Faktura klient fx.
     */
    public FakturaKlientFX() {
        super();
    }

    /**
     * Instantiates a new Faktura klient fx.
     *
     * @param id_faktury    the id faktury
     * @param nr_faktury    the nr faktury
     * @param id_zamowienia the id zamowienia
     * @param imie          the imie
     * @param nazwisko      the nazwisko
     * @param nip           the nip
     * @param email         the email
     */
    public FakturaKlientFX(String id_faktury, String nr_faktury, String id_zamowienia, String imie, String nazwisko, String nip, String email) {
        super(id_faktury, nr_faktury);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nip = nip;
        this.email = email;
        this.id_zamowienia = id_zamowienia;
    }
    @Override
    public String toString() {
        return "FakturaKlient [id_faktury=" + id_faktury + ", nr_faktury=" + nr_faktury + ", id_zamowienia=" + id_zamowienia
                + ", imie=" + imie + ", nazwisko=" + nazwisko + ", nip=" + nip + ", email=" + email + "]";
    }

}
