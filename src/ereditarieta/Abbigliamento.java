package ereditarieta;

import java.util.Scanner;

public abstract class Abbigliamento { // abstract perché contiene almeno un elemento astratto (setter e getter di codiceColore
	private int ID;
	private String descrizione = "-descrizione richiesta-";
	protected char codiceColore = 'U'; // protected rende la variabile globale accessibile dalle sottoclassi e da altre classi del medesimo package
	private double prezzo;
	private int disponibili;
	private int acquistate;
	Scanner inputNumeri = new Scanner(System.in); // scanner per i numeri
	Scanner inputTesti = new Scanner(System.in); // scanner per i testi
	
	// inizio incapsulamento
	public void setID(int ID) {
		// regola: gli ID sono di 4 cifre
		boolean ancora = true; // "interruttore" per restare o meno nel metodo
		
		do {
			
			if (ID > 999 && ID < 10000) { // ID del metodo "occulta" il campo omonimo globale
				this.ID = ID; // this permette di accedere all'ID globale omonimo dell'ID del metodo
				ancora = false;
			} else {
				System.out.print("L'ID deve essere di 4 cifre, reinseriscilo: ");
				ID = inputNumeri.nextInt();
			}
			
		} while(ancora);
		
	}
	
	public int getID() {
		return ID; // non occorre this.ID poiché non ho un ID locale
	}
	
	public void setDescrizione(String descrizione) {
		// regole: descrizione di almeno 8 caratteri e al massimo 20
		boolean ancora = true;
		
		do {
			
			if (descrizione.length() >= 8 && descrizione.length() <= 20) {
				this.descrizione = descrizione;
				ancora = false;
			} else {
				System.out.print("La descrizione dev'essere di almeno 8 caratteri e al massimo di 20, reinserirla: ");
				descrizione = inputTesti.nextLine();
			}
			
		} while(ancora);
		
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	// il codiceColore è specifico della sottoclasse (Camicia, Pantaloni, ecc...), quindi Abbigliamento non può validare gli input che arrivano
	public abstract void setCodiceColore(char codiceColore);
	
	public abstract char getCodiceColore();
	
	public void setPrezzo(double prezzo) {
		// regola: prezzo compreso tra 10.00 e 100.00 €
		boolean ancora = true;
		
		do {
			
			if (prezzo >= 10.0 && prezzo <= 100.0) {
				this.prezzo = prezzo;
				ancora = false;
			} else {
				System.out.print("Il prezzo deve essere tra 10,0 e 100,0 €; reinseriscilo: ");
				prezzo = inputNumeri.nextDouble();
			}
			
		} while(ancora);
		
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
			
		} while(ancora);
		
	}
	
	public int getDisponibili() {
		return disponibili;
	}
	
	public void setAcquistate(int acquistate) {
		// regola: almeno una acquistata e al massimo quante ce ne sono disponibili
		boolean ancora = true;
		
		do {
			
			if (acquistate > 0 && acquistate <= getDisponibili()) { // getDisponibili() perché disponibili è private, e l'unico private accessibile direttamente è quello che dà il nome al setter
				this.acquistate = acquistate;
				ancora = false;				
			} else {
				System.out.print("Occorre acquistare almeno una camicia e al massimo " + getDisponibili() + "; reinserisci il valore: ");
				acquistate = inputNumeri.nextInt();
			}
			
		} while(ancora);
		
	}
	
	public int getAcquistate() {
		return acquistate;
	}
	// fine incapsulamento
	
	public void display() {
		System.out.println("ID dell'elemento: " + getID());
		System.out.println("Descrizione: " + getDescrizione());		
		System.out.println("Prezzo unitario: " + getPrezzo() + " euro");
		System.out.println("Quantità disponibile: " + getDisponibili());
		System.out.println("Quantità acquistata: " + getAcquistate());
		System.out.println("Prezzo totale: " + (getPrezzo()*getAcquistate()) + " euro");
	}
	
}