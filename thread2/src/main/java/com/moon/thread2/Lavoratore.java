package com.moon.thread2;

// La classe Lavoratore implementa Runnable
// e può quindi essere eseguita all'interno di un thread
public class Lavoratore implements Runnable {

    // Riferimento al contatore condiviso
    Contatore contatoreMain = new Contatore(10);

    // Nome del lavoratore
    String nome;

    // Costruttore della classe Lavoratore
    public Lavoratore(String nome, Contatore contatore) {

        // Memorizzazione del nome del lavoratore
        this.nome = nome;

        // Memorizzazione del riferimento al contatore condiviso
        this.contatoreMain = contatore;
    }

    // Metodo eseguito quando il thread viene avviato
    @Override
    public void run() {

        // Il lavoratore continua a incrementare il contatore
        // finché il metodo incrementa restituisce true
        while (contatoreMain.incrementa(nome)) {

            // Blocco try per gestire l'interruzione durante l'attesa
            try {

                // Sospensione del thread per un intervallo casuale
                // compreso tra 100 e 500 millisecondi
                Thread.sleep(100 + (int) (Math.random() * 401));

            // Gestione dell'interruzione del thread
            } catch (InterruptedException e) {

                // Stampa delle informazioni relative all'eccezione
                e.printStackTrace();
            }
        }
    }
}
