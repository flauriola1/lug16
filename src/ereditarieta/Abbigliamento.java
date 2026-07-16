package ereditarieta;

import java.util.Scanner;

public abstract class Abbigliamento { // abstract perchè contiene almeno un elemento astratto ( setter e getter di codiceColore)

	// campi private perchè incapsulati , cioè non accessibili direttamente
	// dall'esterno alla classe
	private int ID;
	private String descrizione = "-descrizione richiesta-";
	private char codiceColore = 'U'; // colori consentiti R= red, G = green, B = blue, W = white
	private double prezzo;
	private int disponibili; // quante camicie ho in magazzino del tipo istanziato
	private int acquistate; // quante camicie si vogliono comprare
	Scanner inputNumeri = new Scanner(System.in);
	Scanner inputTesti = new Scanner(System.in);

	// inizio incapsulamento
	public void setID(int ID) {
		// regola: gli ID sono di 4 cifre,
		boolean ancora = true; // "interruttore" per restare o meno nel metodo
		do {
			if (ID > 999 && ID < 10000) { // ID del metodo "occula" il campo omonimo globale
				this.ID = ID; // this permette di accedere all'ID globale omonimo dell'ID del metodo

				ancora = false;
			} else {
				System.out.print("Gli ID deve essere di 4 cifre, reinseriscilo: ");
				ID = inputNumeri.nextInt();

			}

		} while (ancora);
	}

	public int getID() {
		return ID; // non occorre this.ID poichè non ho un ID locale

	}

	public void setDescrizione(String descrizione) {
		// regole: descrizione di almeno 8 caratteri e al massimo 20

		boolean ancora = true;
		do {
			if (descrizione.length() >= 8 && descrizione.length() <= 20) {
				this.descrizione = descrizione;
			} else {
				System.out.println("La descrizione deve essere di minimo 8 caratteri e massimo 20, reinseriscila:");
				descrizione = inputTesti.nextLine();

			}

		} while (ancora);

	}

	public String getDescrizione() {
		return descrizione;
	}

	// il codiceColore è specifico della stootclasse(Camicia, Pantaloni, ecc...) quindi Abbigliamento non può validare gli input che arrivano 
	public abstract void setCodiceColore(char codiceColore);

	public abstract char getCodiceColore();

	public void setPrezzo(double prezzo) {
		// regola: prezzo compreso tra 10.00 e 100.00 €

		boolean ancora = true;

		do {
			if (prezzo >= 10.0 && prezzo <= 100.0) {
				this.prezzo = prezzo;
			} else {
				System.out.println("Il prezzo deve essere tra 10,0 e 100,0 €; reinseriscilo: ");
				prezzo = inputNumeri.nextDouble();
			}

		} while (ancora);

	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setDisponibili(int disponibili) {
		// regola: almeno una
		boolean ancora = true;

		do {
			if (disponibili > 0) {
				this.disponibili = disponibili;
				ancora = false;

			} else {
				System.out.print("Dev'essere disponibile almeno una camicia; reinserisci il valore: ");
				disponibili = inputNumeri.nextInt();
			}

		} while (ancora);

	}

	public int getDisponibili() {
		return disponibili;
	}

	public void setAcquistate(int acquistate) {
		// regola: almeno una acquistata e al massimo quante ce ne sono disponibili

		boolean ancora = true;

		do {
			if (acquistate > 0 && acquistate <= getDisponibili()) // getDisponibili() perchè disponibili è private, e
																	// l'unico private accessibile direttamente è quello
																	// che dà il nome al setter
			{
				this.acquistate = acquistate;
				ancora = false;

			} else {
				System.out.print(
						"Occorre acquistare almeno una camicia e al massimo " + getDisponibili() + "; reinserisci:");
				acquistate = inputNumeri.nextInt();
			}
		} while (ancora);

	}

	public int getAcquistate() {
		return acquistate;
	}
	// fine incapsulamento

	public void display() {
		System.out.println("ID della camicia: " + getID());
		System.out.println("Descrizione: " + getDescrizione());
		System.out.print("Colore: "); // mostro il colore anzichè il codiceColore

		switch (getCodiceColore()) {
		case 'R':
			System.out.println(" rossa ");
			break;
		case 'G':
			System.out.println(" verde ");
			break;
		case 'B':
			System.out.println(" blu ");
			break;
		case 'W':
			System.out.println(" bianca ");
			break;
		}
		System.out.println("Prezzo unitario: " + getPrezzo() + " euro");
		System.out.println("Quantità disponibile: " + getDisponibili());
		System.out.println("Quantità acquistate:" + getAcquistate());
		System.out.println("Prezzo totale: " + (getPrezzo() * getAcquistate()) + " euro");

	}

}
