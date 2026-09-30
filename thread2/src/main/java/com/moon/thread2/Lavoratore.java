package com.moon.thread2;

public class Lavoratore implements Runnable{

    Contatore contatoreMain = new Contatore(10);
    String nome;

    public Lavoratore(String nome, Contatore contatore){

        this.nome = nome;
        this.contatoreMain = contatore;
    }


    @Override
    public void run() {
        while (contatoreMain.incrementa(nome)) {
            
            try {
                Thread.sleep(100 + (int) (Math.random() * 401));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}