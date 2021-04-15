package application;

/**
 * The type Osoba fx.
 */
public class OsobaFX {
    /**
     * Instantiates a new Osoba fx.
     *
     * @param id_osoby     the id osoby
     * @param imie         the imie
     * @param nazwisko     the nazwisko
     * @param e_mail       the e mail
     * @param nr_tel       the nr tel
     * @param pesel        the pesel
     * @param haslo        the haslo
     * @param status_konta the status konta
     */
    public OsobaFX(String id_osoby,String imie, String nazwisko, String e_mail,String nr_tel,String pesel, String haslo,String status_konta) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.e_mail = e_mail;
		this.haslo = haslo;
		this.id_osoby = id_osoby;
		this.nr_tel = nr_tel;
		this.pesel = pesel;
		this.status_konta = status_konta;
	}

	private String imie;
	private String nazwisko;
	private String e_mail;
	private String haslo;
	private String id_osoby;
	private String nr_tel;
	private String pesel;

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
     * Gets e mail.
     *
     * @return the e mail
     */
    public String getE_mail() {
		return e_mail;
	}

    /**
     * Sets e mail.
     *
     * @param e_mail the e mail
     */
    public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

    /**
     * Gets haslo.
     *
     * @return the haslo
     */
    public String getHaslo() {
		return haslo;
	}

    /**
     * Sets haslo.
     *
     * @param haslo the haslo
     */
    public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

    /**
     * Gets id osoby.
     *
     * @return the id osoby
     */
    public String getId_osoby() {
		return id_osoby;
	}

    /**
     * Sets id osoby.
     *
     * @param id_osoby the id osoby
     */
    public void setId_osoby(String id_osoby) {
		this.id_osoby = id_osoby;
	}

    /**
     * Gets nr tel.
     *
     * @return the nr tel
     */
    public String getNr_tel() {
		return nr_tel;
	}

    /**
     * Sets nr tel.
     *
     * @param nr_tel the nr tel
     */
    public void setNr_tel(String nr_tel) {
		this.nr_tel = nr_tel;
	}

    /**
     * Gets pesel.
     *
     * @return the pesel
     */
    public String getPesel() {
		return pesel;
	}

    /**
     * Sets pesel.
     *
     * @param pesel the pesel
     */
    public void setPesel(String pesel) {
		this.pesel = pesel;
	}

    /**
     * Gets status konta.
     *
     * @return the status konta
     */
    public String getStatus_konta() {
		return status_konta;
	}

    /**
     * Sets status konta.
     *
     * @param status_konta the status konta
     */
    public void setStatus_konta(String status_konta) {
		this.status_konta = status_konta;
	}

	private String status_konta;
	

}
