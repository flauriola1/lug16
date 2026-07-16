package edicola;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioneEdicola {

	public static void main(String[] args) {

        Scanner inputNumeri = new Scanner(System.in);
        Scanner inputTesti = new Scanner(System.in);
        ArrayList<Pubblicazione> listaPubblicazioni = new ArrayList<>();
        String risposta;

        System.out.println("BENVENUTO NEL GESTIONALE EDICOLA");

        do {
            System.out.println("\n--- Inserimento Nuova Pubblicazione ---");
            
            System.out.print("Nome pubblicazione: ");
            String nome = inputTesti.nextLine();

            System.out.print("Copie Ricevute: ");
            int ricevute = inputNumeri.nextInt();

            System.out.print("Prezzo di copertina(es. 1.50): ");
            double prezzo = inputNumeri.nextDouble();

            System.out.print("Percentuale di aggio: ");
            int aggio = inputNumeri.nextInt();

            System.out.print("Copie Vendute a fine giornata: ");
            int vendute = inputNumeri.nextInt();

            Pubblicazione pub = new Pubblicazione(nome, ricevute, prezzo, aggio, vendute);
            listaPubblicazioni.add(pub);

            System.out.print("\nVuoi inserire un'altra pubblicazione? (S/N): ");
            risposta = inputTesti.nextLine();

        } while (risposta.equalsIgnoreCase("S"));

        System.out.println("FINE GIORNATA DELL'EDICOLA RIASSUNTO");
        
        double guadagnoNettoComplessivo = 0;

        for (Pubblicazione p : listaPubblicazioni) {
            System.out.println("\nPubblicazione: " + p.getNome());
            System.out.println("Copie ricevute dal fornitore: " + p.getCopieRicevute());
            System.out.println("Copie vendute ai clienti   : " + p.getQuantitaVenduta());
            System.out.println("Copie rese al distributore  : " + p.getQuantitaResa());
            
            guadagnoNettoComplessivo += p.calcolaGuadagnoEdicola();
        }

        System.out.println("--------------------------------------------------");
        System.out.println("GUADAGNO NETTO COMPLESSIVO DI FINE GIORNATA: " + guadagnoNettoComplessivo + " €");
        
        inputTesti.close();
        inputNumeri.close();

	}

}
