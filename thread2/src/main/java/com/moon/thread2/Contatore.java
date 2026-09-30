package com.moon.thread2;

// Classe che rappresenta il contatore condiviso tra i thread
public class Contatore {

    // Valore attuale del contatore
    private int contatore = 0;

    // Valore massimo raggiungibile dal contatore
    private int valoreMassimo = 10;

    // Costruttore della classe Contatore
    public Contatore(int valoreMassimo) {

        // Impostazione del valore massimo ricevuto come parametro
        this.valoreMassimo = valoreMassimo;
    }

    // Metodo che restituisce il valore attuale del contatore
    public int getContatore() {
        return contatore;
    }

    // Metodo che restituisce il valore massimo del contatore
    public int getValoreMassimo() {
        return valoreMassimo;
    }

    // Metodo che modifica il valore massimo del contatore
    public void setValoreMassimo(int valoreMassimo) {
        this.valoreMassimo = valoreMassimo;
    }

    // Metodo sincronizzato per incrementare il contatore in modo sicuro
    // quando viene utilizzato da più thread
    public synchronized boolean incrementa(String nomeThread) {

        // Controllo che il contatore non abbia ancora raggiunto il valore massimo
        if (contatore < valoreMassimo) {

            // Incremento del contatore
            contatore++;

            // Stampa del nome del thread e del nuovo valore raggiunto
            System.out.println(nomeThread + " ha incrementato a " + contatore);

            // Restituzione di true per indicare che l'incremento è avvenuto
            return true;
        }

        // Restituzione di false quando il valore massimo è stato raggiunto
        return false;
    }

    // Metodo utilizzato per rappresentare l'oggetto sotto forma di stringa
    @Override
    public String toString() {

        // Restituzione dei valori contenuti nel contatore
        return "Contatore [contatore=" + contatore + ", valoreMassimo=" + valoreMassimo + "]";
    }
}
