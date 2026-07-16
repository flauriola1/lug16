package edicola;

import java.util.Scanner;

public class Pubblicazione {
    private String nome;
    private int copieRicevute;
    private double prezzoCopertina; 
    private int aggio;           
    private int quantitaVenduta;
    private int quantitaResa;
    
    private Scanner inputTesti = new Scanner(System.in);
    private Scanner inputNumeri = new Scanner(System.in);

    public Pubblicazione() {
    }

    public Pubblicazione(String nome, int copieRicevute, double prezzoCopertina, int aggio, int quantitaVenduta) {
        setNome(nome);
        setCopieRicevute(copieRicevute);
        setPrezzoCopertina(prezzoCopertina);
        setAggio(aggio);
        setQuantitaVenduta(quantitaVenduta);
    }

    private void aggiornaReso() {
        this.quantitaResa = getCopieRicevute() - getQuantitaVenduta();
    }

    public void setNome(String nome) {
        boolean ancora = true;
        do {
            int lunghezza = nome.length();
            if (lunghezza >= 3) { 
                this.nome = nome;
                ancora = false;
            } else {

            	System.out.println("///// Errore Inserimento /////");
                System.out.println("Il nome deve essere almeno di tre caratteri, reinseriscilo:");
                nome = inputTesti.nextLine();
            }
        } while(ancora);
    }

    public void setCopieRicevute(int copieRicevute) {
        boolean ancora = true;
        do {
            if (copieRicevute >= 0) {
                this.copieRicevute = copieRicevute;
                ancora = false;
                aggiornaReso();
            } else {
            	System.out.println("///// Errore Inserimento /////");
                System.out.println("Le copie ricevute non possono essere negative, reinserisci:");
                copieRicevute = inputNumeri.nextInt();
            }
        } while(ancora);
    }

    public void setPrezzoCopertina(double prezzoCopertina) {
        boolean ancora = true;
        do {
            if (prezzoCopertina > 0) {
                this.prezzoCopertina = prezzoCopertina;
                ancora = false;
            } else {
            	System.out.println("///// Errore Inserimento /////");
                System.out.println("Il prezzo di copertina deve essere maggiore di zero, reinserisci:");
                prezzoCopertina = inputNumeri.nextDouble();
            }
        } while(ancora);
    }

    public void setAggio(int aggio) {
        boolean ancora = true;
        do {
            if (aggio >= 5 && aggio <= 20) {
                this.aggio = aggio;
                ancora = false;
            } else {

            	System.out.println("///// Errore Inserimento /////");
                System.out.println("L'aggio deve essere compreso tra 5% e 20%, reinserisci:");
                aggio = inputNumeri.nextInt();
            }
        } while(ancora);
    }

    public void setQuantitaVenduta(int quantitaVenduta) {
        boolean ancora = true;
        do {
            if (quantitaVenduta >= 0 && quantitaVenduta <= getCopieRicevute()) {
                this.quantitaVenduta = quantitaVenduta;
                ancora = false;
                aggiornaReso();
            } else {

            	System.out.println("///// Errore Inserimento /////");
                System.out.println("La quantità venduta deve essere compresa tra 0 e " + getCopieRicevute() + " (copie ricevute), reinserisci:");
                quantitaVenduta = inputNumeri.nextInt();
            }
        } while(ancora);
    }

    public void setQuantitaResa(int quantitaResa) {
        boolean ancora = true;
        do {
            if (quantitaResa >= 0 && quantitaResa <= getCopieRicevute()) {
                this.quantitaResa = quantitaResa;
                this.quantitaVenduta = getCopieRicevute() - quantitaResa;
                ancora = false;
            } else {

            	System.out.println("///// Errore Inserimento /////");
                System.out.println("La quantità resa deve essere compresa tra 0 e " + getCopieRicevute() + ", reinserisci:");
                quantitaResa = inputNumeri.nextInt();
            }
        } while(ancora);
    }

    public String getNome() {
        return nome;
    }

    public int getCopieRicevute() {
        return copieRicevute;
    }

    public double getPrezzoCopertina() {
        return prezzoCopertina;
    }

    public int getAggio() {
        return aggio;
    }

    public int getQuantitaVenduta() {
        return quantitaVenduta;
    }

    public int getQuantitaResa() {
        return quantitaResa;
    }

    public double calcolaIncassoLordo() {
        return getQuantitaVenduta() * getPrezzoCopertina();
    }

    public double calcolaGuadagnoEdicola() {
        return (calcolaIncassoLordo() * getAggio()) / 100.0;
    }
}