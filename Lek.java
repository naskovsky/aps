package finki.starter.com.lectures;

public class Lek {
	public int ima_nema;
	public int cena;
	public int broj_parcinja;
	
	public Lek(int ima_nema, int cena, int broj_parcinja) {
		this.ima_nema = ima_nema;
		this.cena = cena;
		this.broj_parcinja = broj_parcinja;
	}

	public int getIma_nema() {
		return ima_nema;
	}

	public void setIma_nema(int ima_nema) {
		this.ima_nema = ima_nema;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getBroj_parcinja() {
		return broj_parcinja;
	}

	public void setBroj_parcinja(int broj_parcinja) {
		this.broj_parcinja = broj_parcinja;
	}

	
}
