package klasy_glowne;

/**
 * The type Osoba.
 */
public class Osoba {
    /**
     * The Id osoby.
     */
    protected int id_osoby, /**
     * The Nr tel.
     */
    nr_tel, /**
     * The Pesel.
     */
    pesel, /**
     * The Status konta.
     */
    status_konta;
    /**
     * The Imie.
     */
    protected String imie, /**
     * The Nazwisko.
     */
    nazwisko, /**
     * The E mail.
     */
    e_mail, /**
     * The Haslo.
     */
    haslo;

    /**
     * Gets id osoby.
     *
     * @return the id osoby
     */
    public int getId_osoby() {
		return id_osoby;
	}

    /**
     * Gets haslo.
     *
     * @return the haslo
     */
    public String getHaslo()
	{
		return haslo;
	}

    /**
     * Set haslo.
     *
     * @param haslo the haslo
     */
    public void setHaslo(String haslo){
		this.haslo=haslo;
	}

    /**
     * Sets id osoby.
     *
     * @param id_osoby the id osoby
     */
    public void setId_osoby(int id_osoby) {
		this.id_osoby = id_osoby;
	}

    /**
     * Gets nr tel.
     *
     * @return the nr tel
     */
    public int getNr_tel() {
		return nr_tel;
	}

    /**
     * Sets nr tel.
     *
     * @param nr_tel the nr tel
     */
    public void setNr_tel(int nr_tel) {
		this.nr_tel = nr_tel;
	}

    /**
     * Gets pesel.
     *
     * @return the pesel
     */
    public int getPesel() {
		return pesel;
	}

    /**
     * Gets status konta.
     *
     * @return the status konta
     */
    public int getStatus_konta() {
		return status_konta;
	}

    /**
     * Sets status konta.
     *
     * @param status_konta the status konta
     */
    public void setStatus_konta(int status_konta) {
		this.status_konta = status_konta;
	}

    /**
     * Sets pesel.
     *
     * @param pesel the pesel
     */
    public void setPesel(int pesel) {
		this.pesel = pesel;
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
     * Instantiates a new Osoba.
     */
    public Osoba() {
		super();
	}

    /**
     * Instantiates a new Osoba.
     *
     * @param id_osoby the id osoby
     * @param nr_tel   the nr tel
     * @param pesel    the pesel
     * @param imie     the imie
     * @param nazwisko the nazwisko
     * @param e_mail   the e mail
     * @param haslo    the haslo
     * @param status   the status
     */
    public Osoba(int id_osoby, int nr_tel, int pesel, String imie, String nazwisko, String e_mail,String haslo, int status) {
		super();
		this.id_osoby = id_osoby;
		this.nr_tel = nr_tel;
		this.pesel = pesel;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.e_mail = e_mail;
		this.haslo=haslo;
		this.status_konta=status;
	}
	@Override
	public String toString() {
		return "Osoba [id_osoby=" + id_osoby + ", nr_tel=" + nr_tel + ", pesel=" + pesel + ", imie=" + imie
				+ ", nazwisko=" + nazwisko + ", e_mail=" + e_mail + ", status_konta=" + status_konta + "]";
	}
	
}
