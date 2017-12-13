package bank;

public class GiroKonto {

	private String inhaber;
	private String nummer;
	private double guthaben;
	

	
	public GiroKonto(String inhaber, double guthaben) {
		super();
		this.setInhaber(inhaber);;
		this.setGuthaben(guthaben);;
	}
	public GiroKonto(String inhaber, String nummer, double guthaben) {
		this(inhaber, guthaben);
		this.setNummer(nummer);;
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return nummer + "|" + inhaber + "|" + guthaben;
	}
	public String getInhaber() {
		return inhaber;
	}
	public void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}
	public String getNummer() {
		return nummer;
	}
	public void setNummer(String nummer) {
		this.nummer = nummer;
		while(nummer.length() < 10){
			this.nummer = "0"+nummer;
		}
	}
	public double getGuthaben() {
		return guthaben;
	}
	public void setGuthaben(double guthaben) {
		this.guthaben = guthaben;
	}
	public String getIBAN(String laenderkennung, String blz) {
		String BBAN = blz + nummer;
		laenderkennung.toUpperCase();
		int lk=0;
		for (int i = 0; i < laenderkennung.length(); i++) {
			//TODO fertigmachen
		}
		
		return null;
	}
	
	
	
}
