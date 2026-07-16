package ereditarieta;

public class Pantaloni extends Abbigliamento {
	public char genere; // U = da uomo, D = da donna
	
	// inizio incapsulamento
	public void setCodiceColore(char codiceColore) {
		// regola: caratteri consentiti J (jeans), P (pink), B (black)
		boolean ancora = true;
			
		do {
				
			switch(codiceColore) {
				case 'J':
				case 'P':
				case 'B':
					this.codiceColore = codiceColore;
					ancora = false;
					break;
				default:
					System.out.print("Codici consentiti: J = jeans, P = pink, B = black; reinseriscilo: ");
					codiceColore = inputTesti.nextLine().toUpperCase().charAt(0); // non esiste nextChar()
			}
				
		} while(ancora);
			
	}
		
	public char getCodiceColore() {
		return codiceColore;
	}
		
	public void setGenere(char genere) {
		// U = da uomo, D = da donna
		boolean ancora = true;
			
		do {
				
			switch(genere) {
				case 'U':
				case 'D':
					this.genere = genere;
					ancora = false;
					break;
				default:
					System.out.print("Generi consentiti U = da uomo, D = da donna; reinserisci: ");
					genere = inputTesti.nextLine().toUpperCase().charAt(0);
			}
				
		} while (ancora);
			
	}
		
	public char getGenere() {
		return genere;
	}
	// fine incapsulamento
		
	@Override
	public void display() { // metodo omonimo del display() di Abbigliamento = è in override
		System.out.println("ID dei pantaloni: " + getID());
		System.out.println("Descrizione: " + getDescrizione());
		System.out.print("Colore: "); // mostro il colore anziché il codiceColore
		
		switch(getCodiceColore()) {
			case 'J':
				System.out.println("jeans");
				break;
			case 'P':
				System.out.println("rosa");
				break;
			case 'B':
				System.out.println("nero");
				break;
		}
		
		System.out.print("Genere: ");
		
		switch(getGenere()) {
			case 'U':
				System.out.println("da uomo");
				break;
			case 'D':
				System.out.println("da donna");
				break;
		}
		
		System.out.println("Prezzo unitario: " + getPrezzo() + " euro");
		System.out.println("Quantità disponibile: " + getDisponibili());
		System.out.println("Quantità acquistata: " + getAcquistate());
		System.out.println("Prezzo totale: " + (getPrezzo()*getAcquistate()) + " euro");
	}
	
}