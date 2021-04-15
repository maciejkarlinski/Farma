package klasy;

import klasy_glowne.Faktura;

/**
 * The type Faktura firma.
 */
public class FakturaFirma extends Faktura{
    /**
     * The Id dostawy.
     */
    int id_dostawy;

    /**
     * Instantiates a new Faktura firma.
     */
    public FakturaFirma() {
		super();
	}

    /**
     * Instantiates a new Faktura firma.
     *
     * @param id_faktury the id faktury
     * @param nr_faktury the nr faktury
     * @param id_dostawy the id dostawy
     */
    public FakturaFirma(int id_faktury, String nr_faktury, int id_dostawy) {
		super(id_faktury, nr_faktury);
		this.id_dostawy = id_dostawy;
	}

    /**
     * Gets id dostawy.
     *
     * @return the id dostawy
     */
    public int getId_dostawy() {
		return id_dostawy;
	}

    /**
     * Sets id dostawy.
     *
     * @param id_dostawy the id dostawy
     */
    public void setId_dostawy(int id_dostawy) {
		this.id_dostawy = id_dostawy;
	}
	@Override
	public String toString() {
		return "FakturaFirma [id_faktury=" + id_faktury + ", nr_faktury=" + nr_faktury + ", id_dostawy=" + id_dostawy
				+ "]";
	}

}
