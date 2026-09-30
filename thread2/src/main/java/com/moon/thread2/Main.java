package com.moon.thread2;

public class Main {
    public static void main(String[] args) {
        
        Contatore contatore = new Contatore(10);
        Lavoratore lavoratore1 = new Lavoratore("gianni", contatore);
        Lavoratore lavoratore2 = new Lavoratore("rocco", contatore);
        Thread thread1 = new Thread(lavoratore1);
        Thread thread2 = new Thread(lavoratore2);

        thread1.start();
        thread2.start();

        try{

            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Il thread principale è stato interrotto");
        }

        System.out.println("Raggiunto valore massimo contatore");
    }
}

