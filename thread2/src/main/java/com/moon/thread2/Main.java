package com.moon.thread2;

// Classe principale dell'applicazione
public class Main {

    // Metodo principale da cui parte l'esecuzione del programma
    public static void main(String[] args) {

        // Creazione di un contatore con valore massimo pari a 10
        Contatore contatore = new Contatore(10);

        // Creazione del primo lavoratore associato al contatore
        Lavoratore lavoratore1 = new Lavoratore("gianni", contatore);

        // Creazione del secondo lavoratore associato allo stesso contatore
        Lavoratore lavoratore2 = new Lavoratore("rocco", contatore);

        // Creazione del primo thread usando il primo lavoratore
        Thread thread1 = new Thread(lavoratore1);

        // Creazione del secondo thread usando il secondo lavoratore
        Thread thread2 = new Thread(lavoratore2);

        // Avvio del primo thread
        thread1.start();

        // Avvio del secondo thread
        thread2.start();

        // Blocco try per gestire l'interruzione dei thread
        try {

            // Il thread principale attende la terminazione del primo thread
            thread1.join();

            // Il thread principale attende la terminazione del secondo thread
            thread2.join();

        // Gestione dell'eccezione in caso di interruzione
        } catch (InterruptedException e) {

            // Ripristino dello stato di interruzione del thread principale
            Thread.currentThread().interrupt();

            // Stampa del messaggio di errore
            System.out.println("Il thread principale è stato interrotto");
        }

        // Messaggio visualizzato quando entrambi i thread hanno terminato
        System.out.println("Raggiunto valore massimo contatore");
    }
}
