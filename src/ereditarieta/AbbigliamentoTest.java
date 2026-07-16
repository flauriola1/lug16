package ereditarieta;

import java.util.Scanner;

public class AbbigliamentoTest {

	public static void main(String[] args) {
		Scanner inputTesti = new Scanner(System.in);
		Scanner inputNumeri = new Scanner(System.in);
		boolean ancora = true;
		char scelta;
		double prezzoTotale = 0.0;
		
		do {
			System.out.print("Vuoi acquistare camicie (C) o pantaloni (P)?: ");
			scelta = inputTesti.nextLine().toUpperCase().charAt(0);
			
			switch(scelta) {
				case 'C':
					Camicia miaCamicia = new Camicia();
					System.out.println("Inserisci l'ID della camicia (4 cifre): ");
					miaCamicia.setID(inputNumeri.nextInt());
					
					System.out.println("Inserisci la descrizione (tra 8 e 20 caratteri): ");
					miaCamicia.setDescrizione(inputTesti.nextLine());
					
					System.out.println("Inserisci il codice colore (R = red, G = green, B = blue, W = white): ");
					miaCamicia.setCodiceColore(inputTesti.nextLine().toUpperCase().charAt(0));
					
					System.out.println("Definisci lo stile (E = elegante, S = sportivo)");
					miaCamicia.setStile(inputTesti.nextLine().toUpperCase().charAt(0));
					
					System.out.println("Inserisci il prezzo unitario (compreso tra 10,0 e 100,0): ");
					miaCamicia.setPrezzo(inputNumeri.nextDouble());
					
					System.out.println("Inserisci la quantità di camicie disponibili (almeno 1): ");
					miaCamicia.setDisponibili(inputNumeri.nextInt());
					
					System.out.println("Inserisci la quantità di camicie acquistate (almeno 1 al massimo " + miaCamicia.getDisponibili() + "): ");
					miaCamicia.setAcquistate(inputNumeri.nextInt());
					
					miaCamicia.display();
					prezzoTotale += miaCamicia.getPrezzo()*miaCamicia.getAcquistate(); // aggiungo il costo delle camicie al totale
					break;
				case 'P':
					Pantaloni mieiPantaloni = new Pantaloni();
					System.out.println("Inserisci l'ID dei pantaloni (4 cifre): ");
					mieiPantaloni.setID(inputNumeri.nextInt());
					
					System.out.println("Inserisci la descrizione (tra 8 e 20 caratteri): ");
					mieiPantaloni.setDescrizione(inputTesti.nextLine());
					
					System.out.println("Inserisci il codice colore (J = jeans, P = pink, B = black): ");
					mieiPantaloni.setCodiceColore(inputTesti.nextLine().toUpperCase().charAt(0));
					
					System.out.println("Definisci il genere (U = da uomo, D = da donna)");
					mieiPantaloni.setGenere(inputTesti.nextLine().toUpperCase().charAt(0));
					
					System.out.println("Inserisci il prezzo unitario (compreso tra 10,0 e 100,0): ");
					mieiPantaloni.setPrezzo(inputNumeri.nextDouble());
					
					System.out.println("Inserisci la quantità di pantaloni disponibili (almeno 1): ");
					mieiPantaloni.setDisponibili(inputNumeri.nextInt());
					
					System.out.println("Inserisci la quantità di pantaloni acquistati (almeno 1 al massimo " + mieiPantaloni.getDisponibili() + "): ");
					mieiPantaloni.setAcquistate(inputNumeri.nextInt());
					
					mieiPantaloni.display();
					prezzoTotale += mieiPantaloni.getPrezzo()*mieiPantaloni.getAcquistate(); // aggiungo il costo dei pantaloni al totale
					break;
				default:
					System.out.println("Immissione errata!");
			}
			
			System.out.print("Vuoi effettuare altri acquisti (S/N)? ");
			scelta = inputTesti.nextLine().toUpperCase().charAt(0);
			
			if (scelta == 'N') {
				ancora = false; // esco dal do/while
			}
		} while(ancora);
		
		System.out.println("Spesa complessiva: " + prezzoTotale + " euro");
		inputTesti.close();
		inputNumeri.close();
		System.exit(0);
	}

}