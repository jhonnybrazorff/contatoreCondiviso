package com.moon.thread2;

public class Contatore {

private int contatore = 0;
private int valoreMassimo = 10;



public Contatore(int valoreMassimo) {
    this.valoreMassimo = valoreMassimo;
}



public int getContatore() {
    return contatore;
}



public int getValoreMassimo() {
    return valoreMassimo;
}



public void setValoreMassimo(int valoreMassimo) {
    this.valoreMassimo = valoreMassimo;
}



public synchronized boolean incrementa(String nomeThread){
    if (contatore<valoreMassimo) {
        contatore++;
        System.out.println(nomeThread + " ha incrementato a " + contatore);
        return true;
    }
    return false;
}



@Override
public String toString() {
    return "Contatore [contatore=" + contatore + ", valoreMassimo=" + valoreMassimo + "]";
}
}