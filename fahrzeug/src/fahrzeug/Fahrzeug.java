package fahrzeug;

public class Fahrzeug {
	
	private String name;
	private double zlg;
	private double kpreis;
	
	
	public Fahrzeug(String name, double zlg, double kpreis) {
		super();
		this.setName(name);;
		this.setZlg(zlg);;
		this.setKpreis(kpreis);;
	}
	
	public void drucken(){
		System.out.println(this.toString());
	}
	
	public double berechnePreis(double entfernung){
		return (entfernung*this.kpreis);
	}
	
	@Override
	public String toString() {
		return "Fahrzeug Name=" + name + ", max. Zuladungsgewicht (in kg)=" + zlg + ", Kilometerpreis (in €)=" + kpreis;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		if(name != null){
			this.name = name;
		}
	}
	
	public double getZlg() {
		return zlg;
	}
	
	public void setZlg(double zlg) {
		
		if(zlg >=0){
			this.zlg = zlg;
		}
	}
	
	public double getKpreis() {
		return kpreis;
	}
	
	public void setKpreis(double kpreis) {
		
		if(kpreis >=0){
			this.kpreis = kpreis;
		}
	}
}
