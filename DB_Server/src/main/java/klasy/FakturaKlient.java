package klasy;

import klasy_glowne.Faktura;

/**
 * The type Faktura klient.
 */
public class FakturaKlient extends Faktura{
    /**
     * The Id klienta.
     */
    int id_klienta, /**
     * The Id zamowienia.
     */
    id_zamowienia;

    /**
     * Gets id klienta.
     *
     * @return the id klienta
     */
    public int getId_klienta() {
		return id_klienta;
	}

    /**
     * Sets id klienta.
     *
     * @param id_klienta the id klienta
     */
    public void setId_klienta(int id_klienta) {
		this.id_klienta = id_klienta;
	}

    /**
     * Gets id zamowienia.
     *
     * @return the id zamowienia
     */
    public int getId_zamowienia() {
		return id_zamowienia;
	}

    /**
     * Sets id zamowienia.
     *
     * @param id_zamowienia the id zamowienia
     */
    public void setId_zamowienia(int id_zamowienia) {
		this.id_zamowienia = id_zamowienia;
	}

    /**
     * Instantiates a new Faktura klient.
     */
    public FakturaKlient() {
		super();
	}

    /**
     * Instantiates a new Faktura klient.
     *
     * @param id_faktury    the id faktury
     * @param nr_faktury    the nr faktury
     * @param id_klienta    the id klienta
     * @param id_zamowienia the id zamowienia
     */
    public FakturaKlient(int id_faktury, String nr_faktury, int id_klienta, int id_zamowienia) {
		super(id_faktury, nr_faktury);
		this.id_klienta = id_klienta;
		this.id_zamowienia = id_zamowienia;
	}
	@Override
	public String toString() {
		return "FakturaKlient [id_faktury=" + id_faktury + ", nr_faktury=" + nr_faktury + ", id_klienta=" + id_klienta
				+ ", id_zamowienia=" + id_zamowienia + "]";
	}
	
}
