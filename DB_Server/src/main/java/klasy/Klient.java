package klasy;

import klasy_glowne.Osoba;

/**
 * The type Klient.
 */
public class Klient extends Osoba{
    /**
     * The Nip.
     */
    int nip;

    /**
     * Instantiates a new Klient.
     *
     * @param id       the id
     * @param nrtel    the nrtel
     * @param pesel    the pesel
     * @param imie     the imie
     * @param nazwisko the nazwisko
     * @param email    the email
     * @param nip      the nip
     * @param haslo    the haslo
     */
    public Klient(int id, int nrtel, int pesel, String imie, String nazwisko, String email, int nip,String haslo) {
		super(id, nrtel, pesel, imie, nazwisko, email,haslo,0);
		this.nip=nip;
	}
	
	public String toString() {
		return "Klient [ id_klienta=" + id_osoby + ", nr_tel=" + nr_tel + ", pesel=" + pesel + ", imie=" + imie
				+ ", nazwisko=" + nazwisko + ", e_mail=" + e_mail + ",nip=" + nip +"]";
	}

	
}
