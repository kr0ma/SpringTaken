package be.vdab.entities;

public class Persoon  {
	private int persoonNr, aantalKinderen;
	private String voornaam, familienaam;	
	
	public Persoon(int persoonNr, int aantalKinderen, String voornaam, String familienaam) {
		super();
		this.persoonNr = persoonNr;
		this.aantalKinderen = aantalKinderen;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
	}
	
	public int getPersoonNr() {
		return persoonNr;
	}
	public int getAantalKinderen() {
		return aantalKinderen;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	
}
