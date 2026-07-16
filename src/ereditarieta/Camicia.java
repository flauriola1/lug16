package ereditarieta;

public class Camicia extends Abbigliamento {
	// scrivere extends Abbigliamento è come scrivere qui tutto il codice della superclasse, ma occorre implementare i metodi abstract
	private char stile = 'U'; // E = elegante, S = sportivo
	
	// inizio incapsulamento
	public void setCodiceColore(char codiceColore) {
		// regola: caratteri consentiti R, G, B, W
		boolean ancora = true;
		
		do {
			
			switch(codiceColore) {
				case 'R':
				case 'G':
				case 'B':
				case 'W':
					this.codiceColore = codiceColore;
					ancora = false;
					break;
				default:
					System.out.print("Codici consentiti: R = red, G = green, B = blue, W = white; reinseriscilo: ");
					codiceColore = inputTesti.nextLine().toUpperCase().charAt(0); // non esiste nextChar()
			}
			
		} while(ancora);
		
	}
	
	public char getCodiceColore() {
		return codiceColore;
	}
	
	public void setStile(char stile) {
		// regola: E = elegante, S = sportivo
		boolean ancora = true;
		
		do {
			
			switch(stile) {
				case 'E':
				case 'S':
					this.stile = stile;
					ancora = false;
					break;
				default:
					System.out.print("Stili consentiti E = elegante, S = sportivo; reinserisci: ");
					stile = inputTesti.nextLine().toUpperCase().charAt(0);
			}
			
		} while (ancora);
		
	}
	
	public char getStile() {
		return stile;
	}
	// fine incapsulamento
	
	@Override
	public void display() { // metodo omonimo del display() di Abbigliamento = è in override
		System.out.println("ID della camicia: " + getID());
		System.out.println("Descrizione: " + getDescrizione());
		System.out.print("Colore: "); // mostro il colore anziché il codiceColore
		
		switch(getCodiceColore()) {
			case 'R':
				System.out.println("rossa");
				break;
			case 'G':
				System.out.println("verde");
				break;
			case 'B':
				System.out.println("blu");
				break;
			case 'W':
				System.out.println("bianca");
				break;
		}
		
		System.out.print("Stile: ");
		
		switch(getStile()) {
			case 'E':
				System.out.println("elegante");
				break;
			case 'S':
				System.out.println("sportivo");
				break;
		}
		
		System.out.println("Prezzo unitario: " + getPrezzo() + " euro");
		System.out.println("Quantità disponibile: " + getDisponibili());
		System.out.println("Quantità acquistata: " + getAcquistate());
		System.out.println("Prezzo totale: " + (getPrezzo()*getAcquistate()) + " euro");
	}
	
}